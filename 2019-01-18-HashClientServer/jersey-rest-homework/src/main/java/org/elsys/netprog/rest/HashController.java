package org.elsys.netprog.rest;

import java.util.Base64;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.json.JSONObject;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import org.json.JSONException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//RESOURCES: https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
//RESOURCES: https://stackoverflow.com/questions/5683206/how-to-create-an-array-of-20-random-bytes

@Path("/")
public class HashController {
	
	private static int length = 3;
	private static byte[] input = new byte[length];
	private static String hash;
	
	@POST
	@Path("/post") 
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response sendInput(@FormParam("hash") String clientHash,@FormParam("input") String clientInput) throws URISyntaxException, NoSuchAlgorithmException {
		System.out.println("Server");
		System.out.println("Hash: " + clientHash);
		System.out.println("Input: " + clientInput);
		if (Base64.getUrlEncoder().encodeToString(input).equals(clientInput) && hash.equals(clientHash)) {
			generateHash();
			return Response.status(200).build();
		}
		return Response.status(406).build();
	}
	
	@GET
	@Path("/get")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response randomBytes() throws NoSuchAlgorithmException, JSONException {
		generateHash();
		
		JSONObject myJsonObject = new JSONObject();
		myJsonObject.put("HASH", hash);
		myJsonObject.put("LENGTH", length);
		
		return Response.status(200).entity(myJsonObject.toString()).build();
	}
	
	private void generateHash() throws NoSuchAlgorithmException {
		new Random().nextBytes(input);
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] h = md.digest(input);
		hash = Base64.getUrlEncoder().encodeToString(h);
	}
		
}
