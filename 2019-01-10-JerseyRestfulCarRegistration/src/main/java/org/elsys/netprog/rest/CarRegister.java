package org.elsys.netprog.rest;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CarRegister {
	private String carReg;
	private int hour;
	private int day;
	private boolean active;
	private String due;
	private String lastAction;
	private static final String symbols = "ETYOPAHKXCBM";
	private final Random random = new SecureRandom();
	

	public CarRegister() {
		super();
		hour = 0;
		day = 0;
		carReg = generateCarReg();
		active = false;
		due = generateDate();
		lastAction = generateDate();
	}

	private String generateDate() {
		
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();   
		
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String date = df.format(today);
		
		return date;
	}

	public void setAdditionalHourOfZone(int hours) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date today = Calendar.getInstance().getTime(); 
		
		// Adds one hour
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(today);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    today =  calendar.getTime();
	
		
		String date = df.format(today);
		lastAction = date;
	}
	
	public void setAdditionalDayOfZone(int days) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date today = Calendar.getInstance().getTime(); 
		
		// Adds one hour
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(today);
	    calendar.add(Calendar.DATE, days);
	    today =  calendar.getTime();
	
		
		String date = df.format(today);
		lastAction = date;
	}
	
	
	
	public String generateCarReg() {
		  StringBuilder s = new StringBuilder();
		    
		  	// Create first two random symbols
		  	for (int i = 0; i < 2; i++) {
		        char ch = (char) (symbols.charAt(random.nextInt(symbols.length())));
		        s.append(ch);
		    }
		  	
		  	// Create next four digits
		    for (int i = 0; i < 4; i++) {
		        char digit1 = (char) (Math.random() * 10 + '0');
		        s.append(digit1);
		    }
		    
		    // Create last two random symbols
		    for (int i = 0; i < 2; i++) {
		        char ch = (char) (symbols.charAt(random.nextInt(symbols.length())));
		        s.append(ch);
		    }
		return s.toString();
	}

	public int getHour() {
		return hour;
	}

	public void incrementHour() {
		this.hour = hour + 1;
	}
	
	public int getDay() {
		return day;
	}

	public void incrementDay() {
		this.day = day + 1;
	}
	
	public String getCarReg() {
		return carReg;
	}
	
	public void setCarReg(String carReg) {
		this.carReg = carReg;
	}
	
	public boolean isActive() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();   
		String currentDate = df.format(today);
		
		if(currentDate.compareTo(this.lastAction) > 0) {
			this.active = false;
		}
		
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getDue() {
		return due;
	}
	
	public void setDue() {
		this.due = generateDate();
	}
	
	public String getLastAction() {
		return lastAction;
	}
	
	public void setLastAction() {
		this.lastAction = generateDate();
	}
	
}
