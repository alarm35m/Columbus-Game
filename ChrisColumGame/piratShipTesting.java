package ChrisColumGame;


import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.Test;

public class piratShipTesting {

	
	//Test to check the updates. 
	@Test
	public void test() {
		
		Observable ob = null;
		Object o = null;
		//PirateShip test = new PirateShip(new OceanMap (3,3));
		PirateShip test = new PirateShip(OceanMap.getInstance());
		test.update(ob, o);
	}
	
	//Testing getMap of the pirateShip.
	@Test 
	public void getMap() {
		int [][] maps = null;
		PirateShip test = new PirateShip(OceanMap.getInstance());
		test.getMap(maps);
	}

}
