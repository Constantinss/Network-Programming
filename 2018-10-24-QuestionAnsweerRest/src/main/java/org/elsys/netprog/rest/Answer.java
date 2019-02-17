package org.elsys.netprog.rest;

public class Answer {
	String word;
	String value;
	boolean isCorrect;
	
	public Answer(String value, boolean correctStatement) {
		word = "answer";
		this.value = value;
		isCorrect = correctStatement;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}


}
