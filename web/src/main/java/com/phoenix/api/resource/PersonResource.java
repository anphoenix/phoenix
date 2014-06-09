package com.phoenix.api.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.phoenix.api.RESTApplication;
import com.phoenix.controller.PersonManager;


@Path("/persons")
public class PersonResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersonInfo(@Context HttpServletRequest req) {
		JsonArray personArray = PersonManager.getAllPersons() ;
		try{
			return Response.ok().entity(personArray).build();
		} catch(Exception e) {
			e.printStackTrace();
			JsonObject response = new JsonObject();
			response.addProperty(RESTApplication.ERRORCODE, "S001");
			response.addProperty(RESTApplication.MESSAGE, "Error occurs when get all persons info");
			return Response.serverError().entity(response).type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonInfoByID(@Context HttpServletRequest req, @PathParam("id") String id) {
		JsonObject person = PersonManager.getPersoninfobyID(id);
		try{
			return Response.ok().entity(person.toString()).type(MediaType.APPLICATION_JSON).build();
		} catch(Exception e) {
			e.printStackTrace();
			JsonObject response = new JsonObject();
			response.addProperty(RESTApplication.ERRORCODE, "S001");
			response.addProperty(RESTApplication.MESSAGE, "Error occurs when get person info by id");
			return Response.serverError().entity(response).type(MediaType.APPLICATION_JSON).build();
		}
	}

}

