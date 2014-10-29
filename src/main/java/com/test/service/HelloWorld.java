package com.test.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/hello")
@RequestScoped
public class HelloWorld {

	@Inject
    HelloResource resource;
	
    @GET // RETURN ALL
    @Produces({ "application/json" })
    public Response read(){
    	List<Hello> list = resource.getAll();
    	GenericEntity<List<Hello>> res = new GenericEntity<List<Hello>>(list) {};
    	return Response.ok(res)
    			.header("Access-Control-Allow-Origin", "*")
    			.allow("OPTIONS","GET", "POST", "DELETE", "PUT")
    			.build();
    }

    @GET // RETURN SINGLE
    @Path("/{id}")
    @Produces({ "application/json" })
    public Response read(@PathParam("id") Long id){
    	Hello res = new Hello();
    	try {
    		res = resource.getByID(id);
		} catch (WebApplicationException e) {
			Response.status(Status.NOT_FOUND);
		}
    	return Response.ok(res).build();
    }

    @POST // SAVE ONE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Hello hello){
    	Hello createdHello = resource.save(hello);
    	return Response.ok(createdHello).build();
    }
    
    @PUT // UPDATE ONE - CAN BE BETTER
    @Path("{id}/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateName(@PathParam("id") Long id, @PathParam("name") String name){
    	Hello hello = new Hello();
    	hello.setId(id);
    	hello.setName(name);
    	resource.update(hello);
    	return Response.ok(hello).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
    	resource.delete(id);
    	return Response.ok().build();
    }
}

//	@GET
//	@Path("{id}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Response getPodcastById(@PathParam("id") Long id, @QueryParam("detailed") boolean detailed)
//			throws IOException,	AppException {
//		Podcast podcastById = podcastService.getPodcastById(id);
//		return Response.ok() //200
//				.entity(podcastById, detailed ? new Annotation[]{PodcastDetailedView.Factory.get()} : new Annotation[0])
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//				.allow("OPTIONS").build();
//	}
