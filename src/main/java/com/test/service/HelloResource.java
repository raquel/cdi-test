package com.test.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class HelloResource {

	@Inject
	HelloMock mock;

    public Hello getByID(Long id) {
        return mock.returnOne();
    }
    
    public List<Hello> getAll(){
    	return mock.returnMultiple();
    }
    
    public Hello save(Hello hello){
    	return mock.returnOne();
    }
    
    public Hello update(Hello hello){
    	return mock.returnOne();
    }
    
    public void delete(Long id){
    }

}
