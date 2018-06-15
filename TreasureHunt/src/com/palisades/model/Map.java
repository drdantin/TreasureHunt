package com.palisades.model;

/*Map has an 2D multi array called mapMatrix[][]. Map takes in data from MapController to manipulate
 * the array to represent the traveling instances of the Traveler Objects. 
 */
public class Map {
	
	private int mapMatrix[][];
	private int rowMapSize;
	private int columnMapSize;
	private int startColumn;
	private int startRow;
	private int count = 1;
	
	public Map() {}
	
	/*@Require rowMapSize <= 500, columnMapSize <= 500, startRow > 100, startColumn > 100
	 * It creates a new mapMatrix and sets the map to the startRow startColumn setting
	 */
	public Map (int rowMapSize, int columnMapSize, int startRow, int startColumn) {
		this.rowMapSize = rowMapSize;
		this.columnMapSize = columnMapSize;
		this.startRow = startRow;
		this.startColumn = startColumn;
		
		mapMatrix = new int[rowMapSize][columnMapSize];
		mapMatrix[startRow][startColumn] = count;
	}
	
	/*northMiles and ... take in miles from MapController setMapDistance from a traveling instance
	 * and with those miles sets the mapMatrix in miles and direciton. 
	 */
	public void northMiles(int northMiles) {
		this.startRow = this.startRow + northMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public void southMiles(int southMiles) {
		this.startRow = this.startRow - southMiles;
		mapMatrix[startRow][startColumn] = count++;
		}
	
	public void westMiles(int westMiles) {
		this.startColumn = this.startColumn - westMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public void eastMiles(int eastMiles) {
		this.startColumn = this.startColumn + eastMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public void northWestMiles(int northWestMiles) {
		this.startColumn = this.startColumn - northWestMiles;
		this.startRow = this.startRow + northWestMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public void northEastMiles(int northEastMiles) {
		this.startColumn = this.startColumn + northEastMiles;
		this.startRow = this.startRow + northEastMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public void southWestMiles(int southWestMiles) {
		this.startColumn = this.startColumn - southWestMiles;
		this.startRow = this.startRow - southWestMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public void southEastMiles(int southEastMiles) {
		this.startColumn = this.startColumn + southEastMiles;
		this.startRow = this.startRow - southEastMiles;
		mapMatrix[startRow][startColumn] = count++;
	}
	
	public int[][] getMapMatrix() {
		return mapMatrix;
	}

	public void setMapMatrix(int[][] mapMatrix) {
		this.mapMatrix = mapMatrix;
	}

	public int getRowMapSize() {
		return rowMapSize;
	}

	public void setRowMapSize(int rowInit) {
		this.rowMapSize = rowInit;
	}

	public int getColumnMapSize() {
		return columnMapSize;
	}

	public void setColumnMapSize(int columnInit) {
		this.columnMapSize = columnInit;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	/*This is the ending call which outputs the answer to the general direction of where the 
	 * treasure is from the initial data provided through the textfile. 
	 */
	public String getDistanceToTreasure() {
		StringBuffer getTreasure = new StringBuffer("The treasure is ");
		int nsDirection = 0;
		int weDirection = 0;
		int north = 0;
		int south = 0;
		int west = 0;
		int east = 0;
		
		for(int i = 0; i < rowMapSize; i++ ) {
			for(int j = 0; j < columnMapSize; j++) {
				if(mapMatrix[i][j] == count) {
					nsDirection = i;
					weDirection = j;
				}
			}
		}
		
		if(startRow > nsDirection) {
			south = startRow - nsDirection;
			String southMark = "South: ";
			getTreasure.append(southMark + south + " miles ");
		}else {
			north = nsDirection - startRow;
			String northMark = "North: ";
			getTreasure.append(northMark + north + " miles ");
		}
		if(startColumn > weDirection) {
			west = startColumn - weDirection;
			String westMark = "West: ";
			getTreasure.append(westMark + west + " miles ");
		}else {
			east = weDirection - startColumn;
			String eastMark = "East: ";
			getTreasure.append(eastMark + east + " miles ");
		}
		String XMarksTheSpot = getTreasure.toString();
		
		return XMarksTheSpot;
	}
}
