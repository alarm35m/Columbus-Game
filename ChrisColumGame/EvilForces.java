package ChrisColumGame;

import javafx.scene.layout.Pane;

public class EvilForces {
	PirateShipFactory factory;
	GhostShip ghost;
	Thread ghostThread;
	final int scalingFactor = 17;
	Pane root;
	
	public EvilForces(PirateShipFactory factory) {
		this.factory = factory;
		ghost = new GhostShip(scalingFactor);
		ghost.addToPane(root.getChildren());
		
		ghostThread = new Thread(ghost);
		ghostThread.start();
	}
	
	public EnemyShip summonEvil(String type) {
		EnemyShip enemy;
		
		//enemy = factory.createShip(type);
		return null;
		//return enemy;
	}
	
	@SuppressWarnings("deprecation")
	public void stop() {
		ghostThread.stop();
	}

}