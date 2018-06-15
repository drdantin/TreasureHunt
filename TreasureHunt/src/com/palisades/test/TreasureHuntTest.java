package com.palisades.test;
import com.palisades.controller.MakeTravelerController;
import com.palisades.controller.MapController;
import com.palisades.controller.ReadFileTravelerController;
import com.palisades.model.Map;
import com.palisades.model.Traveler;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreasureHuntTest {
	
	ReadFileTravelerController readStoreControllerA;
	MakeTravelerController makeTravelerControllerA;
	ReadFileTravelerController readStoreControllerB;
	MakeTravelerController makeTravelerControllerB;
	ReadFileTravelerController readStoreControllerC;
	MakeTravelerController makeTravelerControllerC;
	MapController mapControllerC;
	Map map;
	ReadFileTravelerController readStoreControllerD;
	MakeTravelerController makeTravelerControllerD;
	MapController mapControllerD;
	Map mapD;
	
	
	@BeforeEach
	void setUp() throws Exception {
	readStoreControllerA = new ReadFileTravelerController("mapdir.txt");
	readStoreControllerA.setAbsolutePath("/Users/rebstock/Documents/");
	
	readStoreControllerB = new ReadFileTravelerController("mapdir.txt");
	readStoreControllerB.setAbsolutePath("/Users/rebstock/Documents/");
	readStoreControllerB.readStoreFile();
	makeTravelerControllerB = new MakeTravelerController(readStoreControllerB);
	
	readStoreControllerC = new ReadFileTravelerController("mapdir.txt");
	readStoreControllerC.setAbsolutePath("/Users/rebstock/Documents/");
	readStoreControllerC.readStoreFile();
	makeTravelerControllerC = new MakeTravelerController(readStoreControllerC);
	map = new Map(100,100,50,50);
	mapControllerC = new MapController(makeTravelerControllerC.getTravelerPojoList(),map);
	
	readStoreControllerD = new ReadFileTravelerController("mapdirB.txt");
	readStoreControllerD.setAbsolutePath("/Users/rebstock/Documents/");
	readStoreControllerD.readStoreFile();
	makeTravelerControllerD = new MakeTravelerController(readStoreControllerD);
	mapD = new Map(100,100,50,50);
	mapControllerD = new MapController(makeTravelerControllerD.getTravelerPojoList(),mapD);
	}
	
	@AfterEach
	void cleanUp() throws Exception{
		readStoreControllerA = null;
		readStoreControllerB = null;
		makeTravelerControllerB = null;
		readStoreControllerC = null;
		makeTravelerControllerC = null;
		map = null;
		readStoreControllerD = null;
		makeTravelerControllerD = null;
		mapD = null;
		mapControllerD = null;
	}

	@Test
	void testReadFileTravelerController() {
		readStoreControllerA.readStoreFile();
		assertEquals(readStoreControllerA.getTravelStringList().get(0), "Walk, 20 mins, N");
		assertEquals(readStoreControllerA.getTravelStringList().get(1), "Run, 1 hour, E");
		assertEquals(readStoreControllerA.getTravelStringList().get(2), "Horse trot, 3 hours, NW");
		assertEquals(readStoreControllerA.getTravelStringList().get(3), "Elephant ride, 1 hour 30 mins, SE");
	
	}
//	Walk, 20 mins, N
//	Run, 1 hour, E
//	Horse trot, 3 hours, NW
//	Elephant ride, 1 hour 30 mins, SE
//	Horse gallop, 20 mins, SE
//	Walk, 30 mins, SW
//	Horse trot, 1 hour 1 min, W
	@Test
	void testMakeTravelerController() {

		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(0).getTravelBy(), "Walk");
		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(1).getDirection(), " E ");
		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(2).getTime(), "3 hours");
		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(3).getTotalMinutes(), 90);
		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(4).getMinutes(), 20);
		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(5).getDirection(), " SW ");
		assertEquals(makeTravelerControllerB.getTravelerPojoList().get(6).getTotalMinutes(), 61);
	
	}
	
	@Test
	void testMap() {
		assertEquals(map.getDistanceToTreasure(), "The treasure is South: 47 miles West: 52 miles ");
		assertEquals(mapD.getDistanceToTreasure(), "The treasure is South: 24 miles West: 33 miles ");
		
	}

}
