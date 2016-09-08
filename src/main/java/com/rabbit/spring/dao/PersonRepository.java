package com.rabbit.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rabbit.spring.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByName(String name);
	
	public Person findByNameAndAge(String name, Integer age);
	
	@Query("from Person u where u.name=:name")
	public Person findPerson(@Param("name") String name);
	
	@Query("from Person u where u.age>:age")
	public List<Person> findPersons(@Param("age") Integer age);
	
	public Page<Person> findByMan(Boolean man, Pageable pageable);
}
