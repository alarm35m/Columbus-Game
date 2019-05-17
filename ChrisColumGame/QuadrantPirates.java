package ChrisColumGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class QuadrantPirates{
	Image img;
	ImageView imgView;
	MovementStrategy strategy;
	
	public QuadrantPirates() {
		
	}
	
	public QuadrantPirates(MovementStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void startMovement() {
		
	}
}
