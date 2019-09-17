package com.reproducer.trigger.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @formatter:off
@EnableJpaRepositories(entityManagerFactoryRef = "triggerEMF", transactionManagerRef = "triggerTM", basePackages = {
		"com.reproducer.trigger.repository" })
// @formatter:on
@Configuration
@EnableTransactionManagement
public class TriggerDSConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(TriggerDSConfig.class);

	@Autowired
	private Environment env;

	@Value("${trigger.schema:public}")
	private String schema;

	@Primary
	@Bean(name = "triggerDS")
	@ConfigurationProperties("trigger.datasource")
	public DataSource dataSource() {

		DataSource ds = DataSourceBuilder.create().build();

		if (ds instanceof com.zaxxer.hikari.HikariDataSource && StringUtils.isNotEmpty(schema)) {
			LOGGER.info("Setting Default Schema : {}", schema);
			((com.zaxxer.hikari.HikariDataSource) ds).setConnectionInitSql("SET search_path to " + schema);
		}

		return ds;

	}

	@Primary
	@Bean(name = "triggerTM")
	public PlatformTransactionManager psqlTransactionManager(
			@Qualifier("triggerEMF") EntityManagerFactory customerEntityManagerFactory) {
		return new JpaTransactionManager(customerEntityManagerFactory);

	}

	@Primary
	@Bean(name = "triggerEMF")
	public LocalContainerEntityManagerFactoryBean psqlEntityManager(EntityManagerFactoryBuilder builder)
			throws SQLException {
		Map<String, String> props = new HashMap<String, String>();
		props.put("hibernate.hbm2ddl.auto", env.getProperty("trigger.hbm2ddl"));
		props.put("hibernate.dialect", env.getProperty("trigger.dialect"));
		props.put("hibernate.default_schema", env.getProperty("trigger.schema"));

		DataSource ds = dataSource();
		ds.getConnection(); // eager connection pool init

		return builder.dataSource(ds) //
				.packages("com.reproducer.trigger.model.entity") //
				.persistenceUnit("trigger-pu") //
				.properties(props) //
				.build(); //

	}

}
