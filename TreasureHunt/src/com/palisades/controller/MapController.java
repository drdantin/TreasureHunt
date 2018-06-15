package com.palisades.controller;

import java.util.ArrayList;

import com.palisades.model.Map;
import com.palisades.model.Traveler;
/*MapController(MC) represents the business logic that orients itself around the map class. MC
 * is dependent upon MakeTravelerController.getTravelerPojoList and Map. Firstly it uses the tpl
 * to put the proper data towards total minutes and direction- in relation to the map. 
 */
public class MapController {
	
	private ArrayList<Traveler> travelerPojoList;
	private Map map;
	
	/*MC takes in tpl and map. 
	 * When the information needed is recieved it calls setTravelerParameters().
	 */
	public MapController(ArrayList<Traveler> travelerPojoList, Map map) {
		this.travelerPojoList = travelerPojoList;
		this.map = map;
		setMapController_TimeMphDirection();
	}
	/*Walk is 3 mph. setMapController_TimeMphDirection(smc) takes in total minutes for this Walk
	 * travel instance, mph, and direction. The data uses some arithmetic to relate the speed with
	 * total minutes. Considering the a specification was move towards the treasure in a general
	 * direction ... I rounded up. Lastly, the resulting walkmiles and direction is sent to 
	 * setMapDistance. setMapDistance than calls map to put in the information so that map may
	 * change the multi dim array to its proper setting.  
	 */
	private void setWalk(int timeMinutes, int mph, String direction) {
		double walkMiles = 0;
		walkMiles = (walkMiles + (double)timeMinutes/60) * 3;
		long miles = Math.round(walkMiles);
		int walk_miles = (int)miles;
		setMapDistance(walk_miles,direction);
	}
	
	//mph 6
	private void setRun(int timeMinutes, int mph, String direction) {
		double runMiles = 0;
		runMiles = (runMiles + (double)timeMinutes/60) * 6;
		long miles = Math.round(runMiles);
		int run_miles = (int)miles;
		setMapDistance(run_miles,direction);
	}
	
	//mph 4
	private void setHorseTrot(int timeMinutes, int mph, String direction) {
		double horseTrotMiles = 0;
		horseTrotMiles = (horseTrotMiles + (double)timeMinutes/60) * 4;
		long miles = Math.round(horseTrotMiles);
		int horseTrot_miles = (int)miles;
		setMapDistance(horseTrot_miles,direction);
	}
	
	//mph 15
	private void setHorseGallop(int timeMinutes, int mph, String direction) {
		double horseGallopMiles = 0;
		horseGallopMiles = (horseGallopMiles + (double)timeMinutes/60) * 15;
		long miles = Math.round(horseGallopMiles);
		int horseGallop_miles = (int)miles;
		setMapDistance(horseGallop_miles,direction);
	}
	
	//mph 6
	private void setElephantRide(int timeMinutes, int mph, String direction) {
		double elephantRideMiles = 0;
		elephantRideMiles = (elephantRideMiles + (double)timeMinutes/60) * 6;
		long miles = Math.round(elephantRideMiles);
		int elephantRide_miles = (int)miles;
		setMapDistance(elephantRide_miles,direction);
	}
	
	/*setMapController_TimeMphDirection (smc) is a void method used in the MapController 
	 * constructor to begin configuring the traveler instance data with the map. The Traveler
	 * Object totalMinutes, mph, and direction are given off to the Map Controller to be 
	 * prepared for the map.
	 */
	private void setMapController_TimeMphDirection() {
		
		for(int i = 0; i < travelerPojoList.size(); i++) {
			if(travelerPojoList.get(i).getTravelBy().equals("Walk")) {
				setWalk(travelerPojoList.get(i).getTotalMinutes(),travelerPojoList.get(i).getMph(),
						travelerPojoList.get(i).getDirection());
			}
			else if(travelerPojoList.get(i).getTravelBy().equals("Run")) {
				setRun(travelerPojoList.get(i).getTotalMinutes(),travelerPojoList.get(i).getMph(),
						travelerPojoList.get(i).getDirection());
			}
			else if(travelerPojoList.get(i).getTravelBy().equals("Horse trot")) {
				setHorseTrot(travelerPojoList.get(i).getTotalMinutes(),travelerPojoList.get(i).getMph(),
						travelerPojoList.get(i).getDirection());
			}
			else if(travelerPojoList.get(i).getTravelBy().equals("Horse gallop")) {
				setHorseGallop(travelerPojoList.get(i).getTotalMinutes(),travelerPojoList.get(i).getMph(),
						travelerPojoList.get(i).getDirection());
			}
			else if(travelerPojoList.get(i).getTravelBy().equals("Elephant ride")) {
				setElephantRide(travelerPojoList.get(i).getTotalMinutes(),travelerPojoList.get(i).getMph(),
						travelerPojoList.get(i).getDirection());
			}
		}
	}
	
	/*setMapDistance is the last step to configuring the time and direction to map. It takes in
	 * the total miles and direction for map to use its method to move the traveler direction on 
	 * the map through a multi dim array.
	 */
	private void setMapDistance(int miles, String direction) {
		if(direction.equals(" N ")) {
			map.northMiles(miles);
		}
		if(direction.equals(" S ") || direction.equals(" S")) {
			map.southMiles(miles);
		}
		if(direction.equals(" W") || direction.equals(" W ")) {
			map.westMiles(miles);
		}
		if(direction.equals(" E ")) {
			map.eastMiles(miles);
		}
		if(direction.equals(" NW ")) {
			map.northWestMiles(miles);
		}
		if(direction.equals(" NE ")) {
			map.northEastMiles(miles);
		}
		if(direction.equals(" SW ")) {
			map.southWestMiles(miles);
		}
		if(direction.equals(" SE ")) {
			map.southEastMiles(miles);
		}
	}
}

