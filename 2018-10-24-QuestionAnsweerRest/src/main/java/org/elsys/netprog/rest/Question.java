package org.elsys.netprog.rest;

import java.util.ArrayList;
import java.util.List;

public class Question {
	String word;
	String name;
	List<Answer> answers;
	
	public Question(String name) {
		word = "question";
		this.name = name;
		answers = new ArrayList<Answer>();
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> listAnswers) {
		this.answers = listAnswers;
	}

	public String getWord() {
		return word;
	}

	public String getName() {
		return name;
	}
	
	

}
