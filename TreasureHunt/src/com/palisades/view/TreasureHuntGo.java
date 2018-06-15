package com.palisades.view;

import com.palisades.controller.MakeTravelerController;
import com.palisades.controller.MapController;
import com.palisades.controller.ReadFileTravelerController;
import com.palisades.model.Map;

public class TreasureHuntGo {
	public static void main(String []args) {
		ReadFileTravelerController rsmd = new ReadFileTravelerController("mapdirB.txt");
		rsmd.setAbsolutePath("/Users/rebstock/Documents/");
		rsmd.readStoreFile();
		MakeTravelerController make = new MakeTravelerController(rsmd);
		Map map = new Map(100,100,50,50);
		MapController mapCon = new MapController(make.getTravelerPojoList(), map);
		System.out.println(map.getDistanceToTreasure());
		
	}

}
