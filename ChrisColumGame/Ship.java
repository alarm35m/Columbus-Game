package ChrisColumGame;


import java.util.List;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.events.EventException;

import javafx.scene.shape.Rectangle;

@SuppressWarnings("deprecation")
public class Ship extends Observable{
	
	public Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	
	public Ship(OceanMap oceanMap) {
		setCurrentLocation(5,5);
	}
	
	public void setCurrentLocation(int i, int j){
		currentLocation = new Point(i,j);
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}
	
	public void goEast(int[][] islandMap) throws EventException {
		Point shipLoc = getShipLocation();
		try {
			if(shipLoc.getX() == 40 || islandMap[shipLoc.x+1][shipLoc.y] == 1) throw new NullPointerException();
			else if (islandMap[shipLoc.x + 1][shipLoc.y] == 2) { //checks collision with pirates
				System.out.println("Columbus Died");
			}
			else if (islandMap[shipLoc.x + 1][shipLoc.y] == 1) { //checks collision with treasure
				System.out.println("Columbus Won");
			}
			else {
				oceanMap.setOceanTile(shipLoc.x, shipLoc.y);
				setCurrentLocation(shipLoc.x+1,shipLoc.y);
				setChanged();
				notifyObservers(currentLocation);
				oceanMap.setColumbusLocation(shipLoc.x, shipLoc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go right!");
		}
	}
	public void goWest(int[][] islandMap) {
		Point shipLoc = getShipLocation();
		try {
			if(shipLoc.getX() == 0 || islandMap[shipLoc.x-1][shipLoc.y] == 1) throw new NullPointerException();
			else if (islandMap[shipLoc.x - 1][shipLoc.y] == 2) { // collision
				System.out.println("Columbus Died");
			}
			else if (islandMap[shipLoc.x - 1][shipLoc.y] == 1) { //checks collision with treasure
				System.out.println("Columbus Won");
			}
			else {
				oceanMap.setOceanTile(shipLoc.x, shipLoc.y);
				setCurrentLocation(shipLoc.x-1,shipLoc.y);
				setChanged();
				notifyObservers(currentLocation);
				oceanMap.setColumbusLocation(shipLoc.x, shipLoc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go left!");
		}
	}
	public void goNorth(int[][] islandMap) {
		Point shipLoc = getShipLocation();
		try {
			if(shipLoc.getY() == 0 || islandMap[shipLoc.x][shipLoc.y-1] == 1) throw new NullPointerException();
			else if (islandMap[shipLoc.x][shipLoc.y - 1] == 2) { //collision
				System.out.println("Columbus Died");
			}
			else if (islandMap[shipLoc.x][shipLoc.y - 1] == 1) { //checks collision with treasure
				System.out.println("Columbus Won");
			}
			else {
				oceanMap.setOceanTile(shipLoc.x, shipLoc.y);
				setCurrentLocation(shipLoc.x,shipLoc.y-1);
				setChanged();
				notifyObservers(currentLocation);
				oceanMap.setColumbusLocation(shipLoc.x, shipLoc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go up!");
		}
	}
	public void goSouth(int[][] islandMap) {
		Point shipLoc = getShipLocation();
		try {
			if(shipLoc.getY() == 40 || islandMap[shipLoc.x][shipLoc.y+1] == 1) throw new NullPointerException();
			else if (islandMap[shipLoc.x][shipLoc.y + 1] == 2) { //collision
				System.out.println("Columbus Died");
			}
			else if (islandMap[shipLoc.x][shipLoc.y + 1] == 1) { //checks collision with treasure
				System.out.println("Columbus Won");
			}
			else {
				oceanMap.setOceanTile(shipLoc.x, shipLoc.y);
				setCurrentLocation(shipLoc.x,shipLoc.y+1);
				setChanged();
				notifyObservers(currentLocation);
				oceanMap.setColumbusLocation(shipLoc.x, shipLoc.y);
			}
		}
		catch (NullPointerException e) {
			//System.out.println("Can't go down!");
		}
	}
}
