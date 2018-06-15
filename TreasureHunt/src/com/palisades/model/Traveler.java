package com.palisades.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Traveler implements TravelInterface. Traveler has -travel- means(walk, run, horse trot, horse gallop,
 * horse trot, Elephant ride), -time- it takes for each travel means, -direction-, and -speed-. Traveler
 * represents an instance of a type of travel. Each instance is stored within an ArraylList of Travelers
 * through the ReadStoreMapDirectionsController.
 */
public class Traveler implements TravelInterface{
	
	private int minutes;
	private int hours;
	private int totalMinutes;
	private String travelBy;
	private String direction;
	private int mph;
	private String time;
	
	public Traveler() {}
	
	public Traveler(String travelBy, String time, String direction) {
		super();
		this.travelBy = travelBy;
		this.direction = direction;
		this.time = time;
		refineTime();
		setSpeed();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getTotalMinutes() {
		return totalMinutes;
	}

	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public String getTravelBy() {
		return travelBy;
	}

	public void setTravelBy(String travelBy) {
		this.travelBy = travelBy;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getMph() {
		return mph;
	}

	public void setMph(int mph) {
		this.mph = mph;
	}
	
	private void refineTime() {
		
		if(time.charAt(0) == ' ') {
		String newTime = time.replaceFirst(" ", "");
		this.time = newTime;
		
		}
		ArrayList<String> getFirstSecNumb = new ArrayList<String>();
		Pattern patHourSingle = Pattern.compile("hour");
		Pattern patMinSingle = Pattern.compile("min");
		Pattern patHourDouble = Pattern.compile("hour");
		Pattern patMinDouble = Pattern.compile("min");
		Pattern patNumb = Pattern.compile("\\d+");
		Matcher matHourSingle = patHourSingle.matcher(this.time);
		Matcher matMinSingle = patMinSingle.matcher(this.time);
		Matcher matHourDouble = patHourSingle.matcher(this.time);
		Matcher matMinDouble = patMinSingle.matcher(this.time);
		Matcher matNumb = patNumb.matcher(this.time);
		int firstNumber = 0;
		int secondNumber = 0;
		int totalMinutes = 0;
		
		while(matNumb.find()) {
			getFirstSecNumb.add(matNumb.group());
		}
	
		if(matHourDouble.find() && matMinDouble.find()) {
			firstNumber = Integer.parseInt(getFirstSecNumb.get(0));
			secondNumber = Integer.parseInt(getFirstSecNumb.get(1));
			setHours(firstNumber);
			setMinutes(secondNumber);
			totalMinutes = (firstNumber * 60) + secondNumber;
			setTotalMinutes(totalMinutes);
			}
		
		else if(matHourSingle.find()) {
			firstNumber = Integer.parseInt(getFirstSecNumb.get(0));
			setHours(firstNumber);
			setTotalMinutes(firstNumber * 60);
		}
		else if(matMinSingle.find()) {
			firstNumber = Integer.parseInt(getFirstSecNumb.get(0));
			setMinutes(firstNumber);
			setTotalMinutes(firstNumber);
		}
	}
	
	private void setSpeed() {
		int walk = 3;
		int run = 6;
		int horseTrot = 4;
		int horseGallop = 15;
		int elephantRide = 6;
		
		if(this.getTravelBy() != null) {
			if(this.getTravelBy().equals("Walk")) {
				setMph(walk);
			}
			else if(this.getTravelBy().equals("Run")) {
				setMph(run);
			}
			else if(this.getTravelBy().equals("Horse trot")) {
				setMph(horseTrot);
			}
			else if(this.getTravelBy().equals("Horse gallop")) {
				setMph(horseGallop);
			}
			else if(this.getTravelBy().equals("Elephant ride")) {
				setMph(elephantRide);
			}
		}
	}
}
