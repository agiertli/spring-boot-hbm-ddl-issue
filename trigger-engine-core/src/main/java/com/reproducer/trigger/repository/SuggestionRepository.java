package com.reproducer.trigger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reproducer.trigger.model.entity.Suggestion;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

	@Query(value = "select count(*) from information_schema.tables", nativeQuery = true)
	public Long getNumberOfTables();

}
