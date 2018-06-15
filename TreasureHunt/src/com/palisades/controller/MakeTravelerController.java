package com.palisades.controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

import com.palisades.model.Traveler;
/*MakeTravelerController(mtc) is a class which is dependent upon ReadFileTravelerController(rftc). The data
 * is recieved by rftc and rftc is used by mtc to create an Array of Traveler Objects. The traveler
 * Objects are present to attest to a model, controller, and view design pattern and in additionally
 * allow api operations if need. 
 */
public class MakeTravelerController {
	
	ReadFileTravelerController readSetController;
	ArrayList<Traveler> travelerPojoList;
	
	/*MTC takes in rtfc and separates the rtfc list through separateTravelList and than uses
	 * separateTravelList as a dependency to setTravObjArray(stoa). stoa makes the Traveler Pojo
	 * Array.
	 */
	public MakeTravelerController(ReadFileTravelerController readSetController) {
		this.readSetController = readSetController;
		String str[] = separateTravelList(readSetController.getTravelStringList());
		travelerPojoList = setTravObjArray(str, readSetController.getCount());
	}
	
	/*separateTravelList adds commas where needed to use a Pattern class to split using
	 * the commas as a means of proper separation. str[] results in a clean separation of
	 * the traveler instances
	 */
	private String[] separateTravelList(ArrayList<String> travelStringList) {
		StringBuffer appendTravelString = new StringBuffer();
		for(int i = 0; i < travelStringList.size(); i++) {
			if(travelStringList.get(i) == travelStringList.get(0)) {
				appendTravelString.append(travelStringList.get(i));
			}else {
				appendTravelString.append(" ," + travelStringList.get(i));
			}
		}
		
		Pattern pat = Pattern.compile("[,]");
		String str[] = pat.split(appendTravelString);
		
		return str;
	}
	
	/*setTravObjArray takes in the str[] created through separateTravelList and count. count is to
	 * know the number of traveling instances as Walk, Run, Horse trot, etc- count is what knows
	 * how many traveler objects to create. Through each iteration of creating a Traveler, a linkedlist
	 * pops off the parameters which the Traveler class needs to be instantiated. 
	 */
	private ArrayList<Traveler> setTravObjArray(String [] str, int count){
		ArrayList<Traveler> travArray = new ArrayList<Traveler>();
		LinkedList<String> linkedList = new LinkedList<String>();
		
		for(int i = 0; i < str.length; i++) {
			linkedList.add(str[i]);
		}
		
		for(int i = 0; i < count; i++) {
			Traveler travTemp = new Traveler(linkedList.pop(),linkedList.pop(), linkedList.pop());
			travArray.add(travTemp);
			}
		
		return travArray;
	}
	
	public ArrayList<Traveler> getTravelerPojoList(){
		return travelerPojoList;
	}
}
