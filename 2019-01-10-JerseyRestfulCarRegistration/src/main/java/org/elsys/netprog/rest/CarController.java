package org.elsys.netprog.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

//import org.json.JSONObject;


@Path("/")
public class CarController {
	public static CarsContainer c = new CarsContainer(); 
	@POST
	@Path("/createCarReg")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response startGame() throws URISyntaxException{
		CarRegister car = new CarRegister();
		boolean added = false;
		while(!added) {
			added = c.addCar(car);
			if(!added) {
				car.generateCarReg();
			}
		}
		System.out.println(car.getCarReg());
		return Response.created(new URI("/")).entity(car.getCarReg()).build();
	}
	
	@PUT
	@Path("/{zone}/{carReg}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response guess(@PathParam("zone") String zone, @PathParam("carReg") String registration) throws Exception{
		CarRegister car = c.getCarByReg(registration);
		if(car == null) {
			return Response.status(404).build();
		}
		
		if(zone.equals("blue")) {
			if(car.isActive() == false) {
				car.setActive(true);
				car.setDue();
				car.setLastAction();
			}
			car.incrementHour();
			int h = car.getHour();
			car.setAdditionalHourOfZone(h);			
			System.out.println("adding hour");
		}else if(zone.equals("green")) {
			
			if(car.isActive() == false) {
				car.setActive(true);
				car.setDue();
				car.setLastAction();
			}
			car.incrementDay();
			int d = car.getDay();
			car.setAdditionalDayOfZone(d);	
			System.out.println("adding day");
		}else {
			
			return Response.status(404).build();
		
		}
		System.out.println(zone);
		System.out.println(car.getCarReg());
		return Response.created(new URI("/")).entity(zone + " " + car.getCarReg()).build();
	}
	
	@GET
	@Path("/{carReg}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getGames(@PathParam("carReg") String registration) throws Exception{
		CarRegister car = c.getCarByReg(registration);
		if(car == null) {
			return Response.status(404).build();
		}
		
		JSONObject json = new JSONObject();
		json.put("carReg", car.getCarReg());
		json.put("active", car.isActive());
		json.put("due", car.getDue());
		json.put("lastAction", car.getLastAction());
		
	return  Response.ok().entity(json).build();

	}
}
