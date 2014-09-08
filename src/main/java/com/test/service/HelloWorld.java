package com.test.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
@RequestScoped
public class HelloWorld {
    @Inject
    HelloService helloService;

    @GET
    @Produces({ "application/json" })
    public Response getHelloWorldJSON() {
    	String res = helloService.createHelloMessage("World");
    	return Response.ok(res).build();
    }

}
