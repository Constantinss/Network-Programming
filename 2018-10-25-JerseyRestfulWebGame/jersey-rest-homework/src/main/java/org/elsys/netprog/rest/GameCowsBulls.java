package org.elsys.netprog.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//REFERENCE SOURCE: https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/

public class GameCowsBulls {
	
	private String gameid_;
	private Integer turnsCount_;
	private boolean success_;
	private Integer secret_;
//	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	
	public GameCowsBulls() {
		generateGameId();
		this.turnsCount_ = 0;
		this.success_ = Boolean.FALSE;
		generateSecret();
	}
	
	private void generateSecret() {
		Random random = new Random();
		this.secret_ = random.nextInt(9999);
		System.out.println(this.secret_);	    
	}

//REFERENCE SOURCE: https://dzone.com/articles/generate-random-alpha-numeric

//	private String generateGameId() {
//		
//			int count = 32;
//			StringBuilder builder = new StringBuilder();
//
//			while (count-- != 0) {
//
//			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
//
//			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
//
//			}
//			
//		return builder.toString();
//	}

	
//REFERENCE SOURCE: https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string/41762#41762
	
	void generateGameId() {
		String uuid = UUID.randomUUID().toString();
		gameid_ =  uuid;
	}
	
	public String getGameid() {
		return this.gameid_;
	}
	
	public Integer getTurnsCount() {
		return this.turnsCount_;
	}
	
	public boolean isSuccess() {
		return this.success_;
	}

	public Object getSecret() {
		if(this.isSuccess()) {
			return Integer.toString(this.secret_);
		}
		return "****";
	}

	public List<Integer> Prediction(String hypothesis){
		int bulls = 0;
		int cows = 0;
		int hyp = Integer.parseInt(hypothesis);
		int secret = this.secret_;
		
		if(this.secret_ == hyp) {
			this.success_ = true;
		}else if(hypothesis.length() != 4 || !hasAllUniqueDigits(hyp) || hypothesis.charAt(0)== '0') {
			return null;
		}
		
		while(hyp != 0) {
			if(hyp % 10 == secret % 10)bulls++;
			hyp/=10;
			secret/=10;
		}
		
		char hypArray[] = hypothesis.toCharArray();
		char secretArray[] = Integer.toString(this.secret_).toCharArray();
		
		for(int x=0;x < hypArray.length;x++) {
			
			for(int y=0;y< hypArray.length;y++) {
				
				if(hypArray[x] == secretArray[y] && x!=y) {
					System.out.println(hypArray[x]);
					System.out.println(secretArray[y]);
					cows++;
				}
				
			}
			
		}
		
		this.turnsCount_++;
		
		ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(bulls,cows));
		return result;
	}
	
//REFERENCE SOURCE: https://stackoverflow.com/a/26748946/7680845

	private boolean hasAllUniqueDigits(int number) {
		int numMask = 0;
		int numDigits = (int) Math.ceil(Math.log10(number+1));
		for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
			int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
			int digitMask = (int)Math.pow(2, curDigit);             
			if ((numMask & digitMask) > 0) return false;
			numMask = numMask | digitMask;
		}
		return true;
	}
}
