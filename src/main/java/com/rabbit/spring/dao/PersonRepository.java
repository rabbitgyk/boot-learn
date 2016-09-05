package com.rabbit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rabbit.spring.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByName(String name);
	
	public Person findByNameAndAge(String name, Integer age);
	
	@Query("from Person u where u.name=:name")
	public Person findPerson(@Param("name") String name);
}
