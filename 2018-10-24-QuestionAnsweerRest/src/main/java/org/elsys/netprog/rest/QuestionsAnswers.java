package org.elsys.netprog.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm
import org.json.simple.JSONObject;

@Path("/Servlet")
public class QuestionsAnswers {
	List<Question> questions;
	
	public List<Answer> createAnswers(List<String> answersNames, List<Boolean>corrects){
		List<Answer> list = new ArrayList<Answer>();
		
		int index = 0;
		
		for(String name : answersNames) {
			list.add(new Answer(name, corrects.get(index)));
			index++;
		}
		
		return list;
	}
	
	public List<Question> createQuestions(List<String> questionsNames){
		List<Question> questions = new ArrayList<Question>();
		
		for(String name : questionsNames) {
			questions.add(new Question(name));
		}
		
		return questions;
	}
	
	public QuestionsAnswers() {
		questions = new ArrayList<Question>(this.createQuestions(Arrays.asList("Are you good at Math?","5+2=?","22%7=?","2*3=?","13^2=?","2*12=?","49%7=?","Where are you studying?","Do you like pizza?","54*2=?")));
		questions.get(0).setAnswers(createAnswers(Arrays.asList("Yes","No"), Arrays.asList(true, false)));
		questions.get(1).setAnswers(createAnswers(Arrays.asList("3","7","6","10"), Arrays.asList(false, true, false, false)));
		questions.get(2).setAnswers(createAnswers(Arrays.asList("3","3.14","6","7"), Arrays.asList(false, true, false, false)));
		questions.get(3).setAnswers(createAnswers(Arrays.asList("3","5","6","2"), Arrays.asList(false, false, true, false)));
		questions.get(4).setAnswers(createAnswers(Arrays.asList("196","169","121","256"), Arrays.asList(false, true, false, false)));
		questions.get(5).setAnswers(createAnswers(Arrays.asList("26","42","24","22"), Arrays.asList(false, false, true, false)));
		questions.get(6).setAnswers(createAnswers(Arrays.asList("8","5","7","2"), Arrays.asList(false, false, true, false)));
		questions.get(7).setAnswers(createAnswers(Arrays.asList("Yes","No"), Arrays.asList(true, false)));
		questions.get(8).setAnswers(createAnswers(Arrays.asList("Yes","No"), Arrays.asList(true, false)));
		questions.get(9).setAnswers(createAnswers(Arrays.asList("208","108","104","100"), Arrays.asList(false, true, false, false)));
		
	}
	
	private Object getRandomQuestion(List<Question> questions) {
		
		Random number = new Random();
		
		int index = number.nextInt(questions.size());
		
		return questions.toArray()[index];
		
	}
	
	@GET
	@Path("/random")
	@Produces(value={MediaType.APPLICATION_JSON})
	public String getQuestionAndAnswers() {
		Question randomQuestion = (Question) getRandomQuestion(questions);
		JSONObject result = new JSONObject();
		JSONObject answers = new JSONObject();
		
		result.put(randomQuestion.getWord(), randomQuestion.getName());
		
		for(Answer a : randomQuestion.getAnswers()) {
			JSONObject answerJson = new JSONObject();
			
			answerJson.put(a.getWord(), a.getValue());
			answerJson.put("correct", a.isCorrect());
			
			answers.putAll(answerJson);
			
		}
		result.put("answers", answers);
		
		String formattedResult = System.lineSeparator() + result.toString() + System.lineSeparator();
		return formattedResult;
	}
	
}
