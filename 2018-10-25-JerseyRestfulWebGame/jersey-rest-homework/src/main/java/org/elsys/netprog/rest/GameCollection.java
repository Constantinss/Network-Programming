package org.elsys.netprog.rest;

import java.util.ArrayList;
import java.util.List;

public class GameCollection {
	public List<GameCowsBulls> games_ = new ArrayList<GameCowsBulls>();
	
	public boolean addNewGameCowsBulls(GameCowsBulls game) {
		if(!findGameCowsBulls(game.getGameid())) {
			this.games_.add(game);
			return true;
		}
		return false;
	}

	private boolean findGameCowsBulls(String id) {
		for(int x = 0; x < games_.size(); x++) {
			if(games_.get(x).getGameid().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public List<GameCowsBulls> getGames() {
		return this.games_;
	}
	
	public GameCowsBulls getGame(String id) {
		for(GameCowsBulls game : this.games_) {
			if(game.getGameid().equals(id)) {
				return game;
			}
		}
		return null;
	}
}
