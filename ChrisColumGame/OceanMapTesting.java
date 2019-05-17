package ChrisColumGame;


import static org.junit.Assert.*;
import java.awt.Point;

import org.junit.Test;

public class OceanMapTesting {

	@Test
	public void GetLocationTesting() {
		
		
		//OceanMap test =  new OceanMap(2,2);
		OceanMap test =  OceanMap.getInstance();
		Ship ship = new Ship(test);
		Point result = new Point(ship.getShipLocation());
		Point output = test.getShipLocation(ship);
		assertEquals(result, output);
		
	}
	
	@Test
	public void pirateShipTesting(){
		//OceanMap test = new OceanMap(2, 2);
		OceanMap test =  OceanMap.getInstance();
		PirateShip pirateship = new PirateShip(test);
		Point result = new Point(pirateship.getShipLocation());
		Point output = test.getShipLocation(pirateship);
		assertEquals(result, output); 
	}
	
	
	@Test
	public void placeIslands(){
		
		//OceanMap test = new OceanMap(3,3);
		OceanMap test =  OceanMap.getInstance();
		test.placeIslands();
		
	}
	
	@Test 
	public void setPirateShiplocation(){
		
		
		int x = 0;
		int y = 0;
		
		//OceanMap test = new OceanMap(3,3);
		OceanMap test =  OceanMap.getInstance();
		test.setPirateShipLocation(x,y);
	}

}
