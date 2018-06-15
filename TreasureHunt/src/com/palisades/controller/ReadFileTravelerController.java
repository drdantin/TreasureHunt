package com.palisades.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*ReadStoreMapDirectionsController represents the business logic of getting the data from a file.
 *It is used as a dependency to MakeTravelerController.
 */
public class ReadFileTravelerController {
	
	private ArrayList<String> travelStringList;
	private FileReader in;
	private BufferedReader br;
	private String textFile;
	private String absolutePath = "";
	private int count;
	
	/*Takes in the textfile.
	 * travelStringList is set to have no more than 10 direction instances.
	 */
	public ReadFileTravelerController(String textFile) {
		
		this.textFile = textFile;
		travelStringList = new ArrayList<String>(10);
		}
	
	/*readStoreFile reads traveler direction instances through BufferedReader(FileReader(textFile)))
	 * Each line is fed into the travelStringList ArrayList. The count represents the number of 
	 * traveler direction instances or traveler objects which will be created. 
	 */
	public void readStoreFile() {
		try {
			String tsList = null;
			in = new FileReader(absolutePath + textFile);
			br = new BufferedReader(in);
			while((tsList = br.readLine()) != null) {
				travelStringList.add(tsList);
			}
			in.close();
			}catch(Exception e) {
				e.fillInStackTrace();
			}
		this.count = travelStringList.size();
	}
	
	public ArrayList<String> getTravelStringList() {
		return travelStringList;
	}
	
	public void setAbsolutePath(String absolute) {
		this.absolutePath = absolute;
	}
	
	public int getCount() {
		return this.count;
	}
}
