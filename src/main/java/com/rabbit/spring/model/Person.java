package com.rabbit.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * person model
 * @author rabbit
 * 2016年9月4日
 */

@Entity
public class Person {
	@Id
    @GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean man;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getMan() {
		return man;
	}
	public void setMan(Boolean man) {
		this.man = man;
	}
}
