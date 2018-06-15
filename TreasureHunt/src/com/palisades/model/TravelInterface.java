package com.palisades.model;

public interface TravelInterface {
	
	public int getMinutes();

	public void setMinutes(int minutes);

	public int getHours();

	public void setHours(int hours);

	public int getTotalMinutes();

	public void setTotalMinutes(int totalMinutes);

	public String getTravelBy();

	public void setTravelBy(String travelBy);

	public String getDirection();

	public void setDirection(String direction);

	public int getMph();

	public void setMph(int mph);
}
