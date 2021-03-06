package com.rabbit.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.rabbit.spring.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	@Test
	public void testSave() {
		Person person = new Person();
		person.setAge(11);
		person.setName("zhangsan");
		person.setMan(true);
		personRepository.save(person);
	}
	
	@Test
	public void testFindOne(){
		Person person = personRepository.findOne(1L);
		System.out.println(JSONObject.toJSONString(person));
	}
	
	@Test
	public void testBatchSave(){
		List<Person> persons = new ArrayList<Person>();
		for(int i=0; i<100; i++){
			Person person = new Person();
			person.setAge(i);
			person.setMan(i%2 == 0);
			person.setName("zhangsan" + i);
			persons.add(person);
		}
		personRepository.save(persons);
	}
	
	@Test
	public void testFindAllPage(){
		Pageable pageable = new PageRequest(0, 10);
		Page<Person> per = personRepository.findAll(pageable);
		
		System.out.println(JSONObject.toJSONString(per.getContent()));
	}
	
	@Test
	public void testFindAllSort(){
		Sort sort = new Sort("man");
		List<Person> list = personRepository.findAll(sort);
		System.out.println(JSONObject.toJSONString(list));
	}
	
	@Test
	public void testFindByMan(){
		Pageable pageable = new PageRequest(0, 10);
		Page<Person> per = personRepository.findByMan(true, pageable);
		
		System.out.println(JSONObject.toJSONString(per));
	}
	
	@Test
	public void testFindByExample(){
		Person person = new Person();
//		person.setName("zhangsan2");
		person.setMan(false);
		Example<Person> example = Example.of(person);
		List<Person> list = personRepository.findAll(example);
		System.out.println(JSONObject.toJSONString(list));
	}
	
	@Test
	public void testFindByExample2(){
		Person person = new Person();
		person.setName("zhangsan");
		person.setMan(false);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("man");
		Example<Person> example = Example.of(person, matcher);
		List<Person> list = personRepository.findAll(example);
		System.out.println(JSONObject.toJSONString(list));
	}
	
	@Test
	public void testFindPersons(){
		List<Person> list = personRepository.findPersons(90);
		System.out.println(JSONObject.toJSONString(list));
	}

}
