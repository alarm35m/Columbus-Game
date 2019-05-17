package ChrisColumGame;

import java.util.Random;

import org.w3c.dom.events.EventException;

import javafx.scene.shape.Rectangle;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer{
	Point currentLocation;
	Point pLoc;
	int[][] islandMap;
	Random rand = new Random();
	OceanMap seaMap = OceanMap.getInstance();

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Ship) {
			Ship ship = (Ship)o;
			Point ShipLocation = (Point)arg;
			while(true) {
				/*if(currentLocation.x < ship.getShipLocation().x) {
					if(currentLocation.x != 40 && islandMap[currentLocation.x+1][currentLocation.y] != 1) {
						goEast(islandMap);
						break;
					}
				}
				if(currentLocation.x > ship.getShipLocation().x) {
					if(currentLocation.x != 0 && islandMap[currentLocation.x-1][currentLocation.y] != 1) {
						goWest(islandMap);
						break;
					}
				}
				if(currentLocation.y > ship.getShipLocation().y) {
					if(currentLocation.y != 0 && islandMap[currentLocation.x][currentLocation.y-1] != 1) {
						goNorth(islandMap);
						break;
					}
				}
				if(currentLocation.y < ship.getShipLocation().y) {
					if(currentLocation.y != 40 && islandMap[currentLocation.x][currentLocation.y+1] != 1) {
						goSouth(islandMap);
						break;
					}
				}*/
				if (rand.nextInt(2) == 1)
				{
					if (pLoc.x - ship.getShipLocation().x < 0) {
						if (islandMap[pLoc.x + 1][pLoc.y] != 1) {
							goEast(islandMap);
							//currentLocation.x++;
							break;
						}
						else if (islandMap[pLoc.x][pLoc.y + 1] != 1) {
							goNorth(islandMap);
							break;
						}
						else{
							goSouth(islandMap);
							break;
						}
					}
					else if (pLoc.x - ship.getShipLocation().x > 0){
						if (islandMap[pLoc.x - 1][pLoc.y] != 1) {
							goWest(islandMap);
							//currentLocation.x--;
							break;
						}
						else if (islandMap[pLoc.x][pLoc.y + 1] != 1) {
							goNorth(islandMap);
							break;
						}
						else{
							goSouth(islandMap);
							break;
						}
					}
					else if (pLoc.y - ship.getShipLocation().y < 0) {
						if (islandMap[pLoc.x][pLoc.y - 1] != 1) {
							goSouth(islandMap);
							//currentLocation.y++;
							break;
						}
						else if (islandMap[pLoc.x + 1][pLoc.y] != 1) {
							goEast(islandMap);
							break;
						}
						else{
							goWest(islandMap);
							break;
						}
					 }
					else {
						if (islandMap[pLoc.x][pLoc.y + 1] != 1) {
							goNorth(islandMap);
							//currentLocation.y--;
							break;
						}
						else if (islandMap[pLoc.x + 1][pLoc.y] != 1) {
							goEast(islandMap);
							break;
						}
						else{
							goWest(islandMap);
							break;
						}
					}
				}
			}
		}
	}
	
	public void getMap(int[][] map) {
		islandMap = map;
	}
	
	public PirateShip(OceanMap oceanMap) {
		Random rand = new Random();
		Point point = new Point(rand.nextInt(40), rand.nextInt(40));
		while(oceanMap.oceanGrid[point.x][point.y] != 0) {
			rand = new Random();
			point = new Point(rand.nextInt(40), rand.nextInt(40));
		}
		setPirateShip(point.x, point.y, oceanMap);
	}
	public void setPirateShip(int i, int j, OceanMap oceanMap) {
		pLoc = new Point(i, j);
		oceanMap.setPirateShipLocation(i, j);
	}
	public void setCurrentLocation(int i, int j) {
		pLoc = new Point(i,j);
	}
	public Point getShipLocation() {
		return pLoc;
	}
	public void goEast(int[][] islandMap) throws EventException {
		Point loc = getShipLocation();
		try {
			if(loc.getX() == 40 || islandMap[loc.x+1][loc.y] == 1 || islandMap[loc.x + 1][loc.y] == 2) throw new NullPointerException(); //checks collisions with other pirates
			else if (seaMap.oceanGrid[loc.x + 1][loc.y] == 3) { //checks collision with columbus
				System.out.println("Columbus Died");
			}
			else {
				seaMap.setOceanTile(loc.x,loc.y);
				setCurrentLocation(loc.x+1,loc.y);
				seaMap.setPirateShipLocation(loc.x,loc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go right");
		}
	}
	public void goWest(int[][] islandMap) {
		Point loc = getShipLocation();
		try {
			if(loc.getX() == 0 || islandMap[loc.x-1][loc.y] == 1 || islandMap[loc.x - 1][loc.y] == 2) throw new NullPointerException();
			else if (seaMap.oceanGrid[loc.x - 1][loc.y] == 3) {
				System.out.println("Columbus Died");
			}
			else {
				seaMap.setOceanTile(loc.x, loc.y);
				setCurrentLocation(loc.x-1,loc.y);
				seaMap.setPirateShipLocation(loc.x, loc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go left");
		}
	}
	public void goNorth(int[][] islandMap) {
		Point loc = getShipLocation();
		try {
			if(loc.getY() == 0 || islandMap[loc.x][loc.y-1] == 1 || islandMap[loc.x][loc.y - 1] == 2) throw new NullPointerException();
			else if (seaMap.oceanGrid[loc.x][loc.y - 1] == 3) {
				System.out.println("Columbus Died");
			}
			else {
				seaMap.setOceanTile(loc.x, loc.y);
				setCurrentLocation(loc.x,loc.y-1);
				seaMap.setPirateShipLocation(loc.x, loc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go right");
		}
	}
	public void goSouth(int[][] islandMap) {
		Point loc = getShipLocation();
		try {
			if(loc.getY() == 40 || islandMap[loc.x][loc.y+1] == 1 || islandMap[loc.x][loc.y + 1] == 2) throw new NullPointerException();
			else if (seaMap.oceanGrid[loc.x][loc.y + 1] == 3) {
				System.out.println("Columbus Died");
			}
			else {
				seaMap.setOceanTile(loc.x, loc.y);
				setCurrentLocation(loc.x,loc.y+1);
				seaMap.setPirateShipLocation(loc.x, loc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go right");
		}
	}
}
