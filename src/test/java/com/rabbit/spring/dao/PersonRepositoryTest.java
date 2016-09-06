package com.rabbit.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

}
