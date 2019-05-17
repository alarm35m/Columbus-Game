package ChrisColumGame;


import java.awt.Point;
import java.util.Random;

/*
 * Grid Key:
 * 
 * 0 - Ocean
 * 1 - Island
 * 2 - Pirate
 * 3 - Columbus
 * 4 - Quadrant 1
 * 5 - Quadrant 2
 * 6 - Quadrant 3
 * 7 - Quadrand 4
 * 8 - Treasure
 */

public class OceanMap {

	public int[][] oceanGrid;
	int dimension, islandCount;
	private static OceanMap uniqueMap;
	
	public OceanMap(/*int dimensions, int islandCount*/) {
		//createGrid = new int[10][10];
		oceanGrid = new int[40][40];
		//createGrid[5][5] = 2;
		oceanGrid[20][20] = 2;
		setQuadrants();
		placeIslands();
	}
	
	public int[][] getMap() {
		return oceanGrid;
	}
	
	public static OceanMap getInstance() {
		if (uniqueMap == null)
			synchronized(OceanMap.class) {
				if(uniqueMap == null)
					uniqueMap = new OceanMap();
			}
		return uniqueMap;
	}
	
	public Point getShipLocation(Ship ship) {
		return new Point(ship.getShipLocation());
	}
	
	public Point getShipLocation(PirateShip pirateShip) {
		return new Point(pirateShip.getShipLocation());
	}
	public void setPirateShipLocation(int i, int j) {
		oceanGrid[i][j] = 2;
	}
	public void setColumbusLocation(int x, int y) {
		oceanGrid[x][y] = 3;
	}
	public void setOceanTile(int x, int y) {
		if (x < 20 && y < 20) {
			oceanGrid[x][y] = 4; // quadrant 1
		}
		else if (x >= 20 && y < 20) {
			oceanGrid[x][y] = 5; //quadrant 2
		}
		else if (x < 20 && y >= 20) {
			oceanGrid[x][y] = 6; //quadrant 3
		}
		else if (x >= 20 && y >= 20) {
			oceanGrid[x][y] = 7; //quadrant 4
		}
	}
	
	public void setTreasureLocation(int i, int j) {
		oceanGrid[i][j] = 8;
	}
	
	private void setQuadrants() {
		setQuadrant1();
	}
	
	private void setQuadrant1() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				oceanGrid[i][j] = 4;
			}
		}
	}
	
	public void placeTreasure() {
		Random rand = new Random();
		Point point = new Point(rand.nextInt(40), rand.nextInt(40));
		for(int i = 0; i < 1; i++) {
//			while(oceanGrid[point.x][point.y] != 0 || oceanGrid[point.x][point.y] != 40) {
//				rand = new Random();
//				point = new Point(rand.nextInt(40), rand.nextInt(40));
//			}
			oceanGrid[point.x][point.y] = 8;
			point = new Point(rand.nextInt(40), rand.nextInt(40));
		}
	}
	
	public void placeIslands() {
		Random rand = new Random();
		Point point = new Point(rand.nextInt(40), rand.nextInt(40));
		for(int i = 0; i < 20; i++) {
//			while(oceanGrid[point.x][point.y] != 0 || oceanGrid[point.x][point.y] != 40) {
//				rand = new Random();
//				point = new Point(rand.nextInt(40), rand.nextInt(40));
//			}
			oceanGrid[point.x][point.y] = 1;
			point = new Point(rand.nextInt(40), rand.nextInt(40));
		}
	}
}
