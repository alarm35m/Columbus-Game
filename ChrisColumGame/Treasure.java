package ChrisColumGame;


import java.awt.Point;
import java.util.Random;

public class Treasure {
	Point currentLocation;
	int[][] islandMap;
	
	public void getMap(int[][] map) {
		islandMap = map;
	}
	
	public Treasure(OceanMap oceanMap) {
		Random rand = new Random();
		Point point = new Point(rand.nextInt(40), rand.nextInt(40));
		while(oceanMap.oceanGrid[point.x][point.y] != 0) {
			rand = new Random();
			point = new Point(rand.nextInt(40), rand.nextInt(40));
		}
		setTreasure(point.x, point.y, oceanMap);
	}
	public void setTreasure(int i, int j, OceanMap oceanMap) {
		currentLocation = new Point(i, j);
		oceanMap.setTreasureLocation(i, j);
	}
	public void setCurrentLocation(int i, int j) {
		currentLocation = new Point(i,j);
	}
	public Point getTreasureLocation() {
		return currentLocation;
	}
}
