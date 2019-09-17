```
$ mvn clean install
$ cd trigger-engine-core
$ mvn spring-boot:run -Dspring-boot.run.profiles=local -s settings.xml
$ mvn spring-boot:run -Dspring-boot.run.profiles=local -s settings.xml # we need to run it twice for issue to occur
```


Following issue occurs on the 2nd run:

```
2019-09-17 15:44:43.817  INFO 89373 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: trigger-pu
	...]
2019-09-17 15:44:43.897  INFO 89373 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.7.Final-redhat-00001}
2019-09-17 15:44:43.898  INFO 89373 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2019-09-17 15:44:44.041  INFO 89373 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final-redhat-00001}
2019-09-17 15:44:44.185  INFO 89373 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2019-09-17 15:44:44.208  INFO 89373 --- [           main] o.h.e.j.e.i.LobCreatorBuilderImpl        : HHH000422: Disabling contextual LOB creation as connection was null
2019-09-17 15:44:44.386  INFO 89373 --- [           main] org.hibernate.orm.beans                  : HHH10005002: No explicit CDI BeanManager reference was passed to Hibernate, but CDI is available on the Hibernate ClassLoader.
2019-09-17 15:44:44.815  WARN 89373 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "
    create table Suggestion (
       id bigint not null,
        primary key (id)
    )" via JDBC Statement

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "
    create table Suggestion (
       id bigint not null,
        primary key (id)
    )" via JDBC Statement
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67) ~[hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.applySqlString(AbstractSchemaMigrator.java:559) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.applySqlStrings(AbstractSchemaMigrator.java:504) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.createTable(AbstractSchemaMigrator.java:277) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.internal.GroupedSchemaMigratorImpl.performTablesMigration(GroupedSchemaMigratorImpl.java:71) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.performMigration(AbstractSchemaMigrator.java:207) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.internal.AbstractSchemaMigrator.doMigration(AbstractSchemaMigrator.java:114) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:183) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:72) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:310) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:467) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:939) [hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) [spring-orm-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) [spring-orm-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:390) [spring-orm-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:377) [spring-orm-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) [spring-orm-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1821) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1758) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:593) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:515) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) [spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1105) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:867) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:549) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:142) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:775) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at com.reproducer.trigger.Application.main(Application.java:10) ~[classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_222]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_222]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_222]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_222]
	at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run(AbstractRunMojo.java:558) ~[na:na]
	at java.lang.Thread.run(Thread.java:748) ~[na:1.8.0_222]
Caused by: org.h2.jdbc.JdbcSQLException: Table "SUGGESTION" already exists; SQL statement:

    create table Suggestion (
       id bigint not null,
        primary key (id)
    ) [42101-197]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:357) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.message.DbException.get(DbException.java:179) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.message.DbException.get(DbException.java:155) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.command.ddl.CreateTable.update(CreateTable.java:86) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.command.CommandContainer.update(CommandContainer.java:102) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.command.Command.executeUpdate(Command.java:261) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.jdbc.JdbcStatement.executeInternal(JdbcStatement.java:233) ~[h2-1.4.197.jar:1.4.197]
	at org.h2.jdbc.JdbcStatement.execute(JdbcStatement.java:205) ~[h2-1.4.197.jar:1.4.197]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:95) ~[HikariCP-3.2.0.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-3.2.0.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54) ~[hibernate-core-5.3.7.Final-redhat-00001.jar:5.3.7.Final-redhat-00001]
	... 40 common frames omitted
  ```
