package ChrisColumGame;


import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

class GhostShipSprite extends EnemyShip {
	Image ghostShip;
	int x;
	int y;
	Circle circle;
	int scalingFactor;
	int radius = 10;
	
	GhostShipSprite(int x, int y, int scalingFactor){
		this.x = x;
		this.y = y;
		circle= new Circle();
		setPositionX(x);
		setPositionY(y);
		circle.setRadius(radius);
		this.scalingFactor = scalingFactor;
	}
	@Override
	Circle getCircle() {
		return circle;
	}
	@Override
	void setX(int x) {
		this.x = x;
		setPositionX(x);
	}
	@Override
	void setY(int y) {
		this.y = y;
		setPositionY(y);
	}
	@Override
	int getX() {
		return x;
	}
	@Override
	int getY() {
		return y;
	}
	@Override
	public void setLineColor(Circle circle, Color color) {
		circle.setStroke(color);
		circle.setFill(color);
	}
	@Override
	public void setPositionX(int x) {
		circle.setCenterX(x*scalingFactor + (scalingFactor/2));
	}
	@Override
	public void setPositionY(int y) {
		circle.setCenterY(y*scalingFactor + (scalingFactor/2));
	}
}

public class GhostShip implements Runnable {
	
	Boolean running = true;
	int radius;
	Random random = new Random();
	int scalingFactor;
	GhostShipSprite[] ghostSprites = new GhostShipSprite[2];
	public GhostShip(int scalingFactor){
		for(int j = 0; j < 2; j++){
			int x = random.nextInt(40);
			int y = random.nextInt(40);	
			ghostSprites[j] = new GhostShipSprite(x,y,scalingFactor);
		}
		this.radius = 10;
		this.scalingFactor = scalingFactor;
	}
	
	public void addToPane(ObservableList<Node> sceneGraph){
		for(GhostShipSprite ghostSprite: ghostSprites){
			
			Circle circle = ghostSprite.getCircle();
			//System.out.println("Adding circle to pane: " + circle.getCenterX() + " " + circle.getCenterY() + " " + radius);
			sceneGraph.add(circle);
			Image monsterImage = new Image("\\ghostShip.jpg", 17, 17, true, true);
			circle.setFill(new ImagePattern(monsterImage));
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			for(GhostShipSprite ghostSprite: ghostSprites){
				// Move X
				int xMove = ghostSprite.getX() + random.nextInt(6)-2;
				if (xMove >=0 && xMove <= 40)
					ghostSprite.setX(xMove);
				// Move Y
				int yMove = ghostSprite.getY() + random.nextInt(6)-2;
				if (yMove >=0 && yMove <=40)
					ghostSprite.setY(yMove);
			}
		}
		      
	}	
}