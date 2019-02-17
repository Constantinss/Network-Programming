package org.elsys.netprog.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@Path("/game")
public class GameController {
	//ToDo: Create new collection of games
	public static GameCollection gameCollection_= new GameCollection();
	
	@POST
	@Path("/startGame")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response startGame() throws URISyntaxException{
		GameCowsBulls game = new GameCowsBulls();
		boolean added = false;
		while(!added) {
			added = gameCollection_.addNewGameCowsBulls(game);
			if(!added) {
				game.generateGameId();
			}
		}
		/*
		JSONObject g = new JSONObject();
		g.put("gameId", game.getGameid());
		g.put("turnsCount", game.getTurnsCount());
		g.put("secret", game.getSecret());
		g.put("success", game.isSuccess());
		g.put("bullsNumber", myGuess.get(0));
		g.put("cowsNumber", myGuess.get(1));
		*/
		return Response.created(new URI("/games")).entity(game.getGameid()).build();
	}
	
	
	@PUT
	@Path("/guess/{id}/{guess}")
	@Produces(value={MediaType.APPLICATION_JSON})
	@SuppressWarnings("unchecked")
	public Response guess(@PathParam("id") String gameId, @PathParam("guess") String guess) throws Exception{
		GameCowsBulls game = new GameCowsBulls();
		
		List<Integer> myGuess = game.Prediction(guess);
		if(myGuess == null) {
			return Response.status(404).build();
		}
		JSONObject g = new JSONObject();
		g.put("gameId", game.getGameid());
		g.put("turnsCount", game.getTurnsCount());
		g.put("secret", game.getSecret());
		g.put("success", game.isSuccess());
		g.put("bullsNumber", myGuess.get(0));
		g.put("cowsNumber", myGuess.get(1));		
		return Response.ok().entity(g).build();
	}
	
	@GET
	@Path("/games")
	@Produces(value={MediaType.APPLICATION_JSON})
	@SuppressWarnings("unchecked")
	public Response getGames() {
		JSONArray response = new JSONArray();
		for(GameCowsBulls game : gameCollection_.getGames()) {
			JSONObject g = new JSONObject();
			g.put("gameId", game.getGameid());
			g.put("turnsCount", game.getTurnsCount());
			g.put("secret", game.getSecret());
			g.put("success", game.isSuccess());
			response.add(g);
		}
		return Response.status(Response.Status.OK).entity(response).build();
	}
}
