package ChrisColumGame;


import static org.junit.Assert.*;

import java.awt.Point; 

import org.junit.Test;

public class shipTesting {

	
	
	
	// Testing the getLocation of the Ship
	@Test
	public void testingShipLocation() {
		//Ship test = new Ship(new OceanMap(2, 2));
		Ship test = new Ship(OceanMap.getInstance());
		Point result = new Point(5,5);
		Point output = test.getShipLocation();
		assertEquals(result, output);
		
	}
	
	
	
	//Testing the currentLocation of the ship
	
	@Test
	public void testingShipCurrentLocation(){
		int first = 0; 
		int second = 0;
		//Ship test = new Ship(new OceanMap(2, 2));
		Ship test = new Ship(OceanMap.getInstance());
		test.setCurrentLocation(first, second);
		
	}
	
	//Testing the movement (North, South, West, and East)
	
	
	@Test 
	public void west() {
		
		int [][] islandMap = null;
		//Ship test = new Ship(new OceanMap(2,2));
		Ship test = new Ship(OceanMap.getInstance());
		test.goWest(islandMap);
	}
	
	@Test 
	public void east() {
		
		int [][] islandMap = null;
		//Ship test = new Ship(new OceanMap(2,2));
		Ship test = new Ship(OceanMap.getInstance());
		test.goEast(islandMap);
	}
	
	
	@Test 
	public void north() {
		
		int [][] islandMap = null;
		//Ship test = new Ship(new OceanMap(2,2));
		Ship test = new Ship(OceanMap.getInstance());
		test.goNorth(islandMap);
	}
	
	
	@Test 
	public void south() {
		
		int [][] islandMap = null;
		//Ship test = new Ship(new OceanMap(2,2));
		Ship test = new Ship(OceanMap.getInstance());
		test.goSouth(islandMap);
	}

	

}
