package com.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class HelloMock {

	public Hello returnOne(){
		return new Hello(1L, "name 1", "description 1");
	}
	
	public List<Hello> returnMultiple(){
		List<Hello> list = new ArrayList<Hello>();
		list.add(new Hello(1L, "name 1", "description 1"));
		list.add(new Hello(2L, "name 2", "description 2"));
		list.add(new Hello(3L, "name 3", "description 3"));
		list.add(new Hello(4L, "name 4", "description 4"));
		return list;
	}
}
