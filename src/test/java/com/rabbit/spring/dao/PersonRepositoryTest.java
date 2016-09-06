package com.rabbit.spring.dao;

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

}
