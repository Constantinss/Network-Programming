package wolfpack;
import java.net.URISyntaxException;


import javax.ws.rs.core.Application;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class WolfPackController extends Application{
	public static Packs packs = new Packs();
	public static Wolves wolves = new Wolves();
	
	
	
	/**
	 * Test request
	 * @return string 
	 */
	@GET
	@Path("/sayHelloToWolfPack")
	public String getHelloMsg() throws Exception{
		return "Hello, Wolf Pack!";
	}
	
	
	
	/**
	 * Example: 
	 * http://localhost:8080/wolfpack/createWolf/John/male/20:11:2019/@65.432,43.210/
	 *   
	 * @param name
	 * @param gender
	 * @param birthdate
	 * @param location
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Path("/createWolf/{name}/{gender}/{birthdate}/{location}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response createWolf(@PathParam("name") String name, @PathParam("gender") String gender, @PathParam("birthdate") String birthdate, @PathParam("location") String location) throws Exception{
		
		if(name == null || gender == null || birthdate == null || location == null) {
			return Response.status(404).build();
		}		
		
		
		Wolf wolf = new Wolf();
		wolf.setName(name);
		wolf.setGender(gender);		
		wolf.setBirthdate(birthdate);
		
		String lat = location.substring(location.indexOf("@") + 1, location.indexOf(","));
		String lgn = location.substring(location.indexOf(",") + 1);
		Location loc = new Location((Double.parseDouble(lat)), Double.parseDouble(lgn));
		
		wolf.setLocation(loc);

		if(wolves.addWolf(wolf)) {
			System.out.println("add new [" + wolves.size() + "] wolf");
		}else {
			System.out.println("error: wolf exists");
		}
				
		return Response.ok().entity(wolf).build();
	}
	
	
	
	/**
	 * Example: 
	 * http://localhost:8080/wolfpack/createPack/alfaPack
	 * 
	 * @param name
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Path("/createPack/{name}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response createPack(@PathParam("name") String name) throws Exception{
		
		if(name == null) {
			return Response.status(404).build();
		}
		
		Pack pack = new Pack();
		pack.setName(name);
		pack.setWolves(wolves);
		packs.addPack(pack);
		wolves = new Wolves();
		
		System.out.println("new pack");
		
		return Response.ok().entity(pack).build();
	}	

	
	
	/**
	 * 
	 * Example: 
	 * http://localhost:8080/wolfpack/getAllWolves
	 *
	 *
	 * @return list of wolves
	 */	
	@GET
	@Path("/getAllWolves")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getAllWolves() throws Exception{
		
		Wolves currentWolves = new Wolves();
		
		for(Pack pack : packs.getPacks()) {
			for(Wolf wolf : pack.getWolves().getWolves()) {
				currentWolves.addWolf(wolf);
			}
		}	
		
		
		if(currentWolves.getWolves().isEmpty()) {
			return Response.status(404).build();
		}
		
		return Response.ok().entity(currentWolves).build();
	}
	
	
	
	/**
	 * 
	 * Example: 
	 * http://localhost:8080/wolfpack/getWolfByName/John
	 * 
	 * 
	 * @return list of packs
	 */	
	@GET
	@Path("/getWolfByName/{name}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getWolf(@PathParam("name") String name) throws Exception{
				
		if(name == null) {
			return Response.status(404).build();
		}
		
		Wolf wolf = new Wolf();
		Wolves currentWolves = new Wolves();
		
		for(Pack pack : packs.getPacks()) {
			for(Wolf w : pack.getWolves().getWolves()) {
				currentWolves.addWolf(w);
			}
		}
		
		wolf = currentWolves.getWolfByName(name);
		
		return Response.ok().entity(wolf).build();
	}
	
	

	/**
	 * 
	 * Example: 
	 * http://localhost:8080/wolfpack/getAllPacks
	 * 
	 * 
	 * @return list of packs
	 */	
	@GET
	@Path("/getAllPacks")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getAllPacks() throws Exception{
				
		if(packs.getPacks().isEmpty()) {
			return Response.status(404).build();
		}
		
		return Response.ok().entity(packs).build();
	}
	
	
	/**
	 * 
	 * Example: 
	 * http://localhost:8080/wolfpack/getPackByName/alfaPack
	 * 
	 * 
	 * @return pack
	 */	
	@GET
	@Path("/getPackByName/{name}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getPackByName(@PathParam("name") String name) throws Exception{
				
		if(name == null) {
			return Response.status(404).build();
		}
		
		Pack pack = new Pack();
		pack = packs.getPackByName(name);
		
		return Response.ok().entity(pack).build();
	}

}

