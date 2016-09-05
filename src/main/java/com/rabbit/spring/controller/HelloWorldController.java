package com.rabbit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rabbit.spring.dao.PersonRepository;
import com.rabbit.spring.model.Person;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/person")
	@ResponseBody
	public String hello(String name){
		Person person = new Person();
		person.setAge(11);
		person.setName(name);
		person.setMan(true);
		return JSONObject.toJSONString(person);
	}
	
	@RequestMapping("/db/person")
	@ResponseBody
	public String helloDB(String name){
		Person person = personRepository.findByName(name);
		return JSONObject.toJSONString(person);
	}
}
