package com.test.service;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class HelloService {

    String createHelloMessage(String name) {
        return "Hello " + name + "!";
    }

}
