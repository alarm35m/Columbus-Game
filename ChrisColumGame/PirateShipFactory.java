package ChrisColumGame;


import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class PirateShipFactory {
	
	public QuadrantPirates createShip(String type, int x, int y, int scalingFactor) {
		QuadrantPirates newShip = null;
	
		if (type.equals("q1")) {
			newShip = new Quad1PirateSprite(x, y, scalingFactor, new Quadrant1Strategy()); //creates a new Quadrant 1 Pirate
		}
		else if (type.equals("q2")) {
			newShip = new Quad2PirateSprite(x, y, scalingFactor, new Quadrant2Strategy());
		}
		else if (type.equals("q3")) {
			
		}
		else if (type.equals("q4")) {
			
		}
		return newShip;
	}
}
