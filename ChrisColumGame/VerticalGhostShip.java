package ChrisColumGame;


import java.util.ArrayList;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.awt.Point;

public class VerticalGhostShip implements PirateComponent, Runnable{
	
	PirateShipFactory pShipFactory = new PirateShipFactory();
	ArrayList<Quad1PirateSprite> quad1List = new ArrayList<Quad1PirateSprite>();
	Boolean running = true;
	int radius, scalingFactor;
	
	/*pirates of quadrant 1
	 * 
	 * starts every 4th tile in quadrant and does a simple up down pattern to look for columbus
	 * created similarly to how the monster and ghost ships were created
	 */
	public VerticalGhostShip(int scalingFactor) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 5; i++) {
			quad1List.add((Quad1PirateSprite) pShipFactory.createShip("q1", x, y, scalingFactor)); //uses the pirate factory
			x += 5;
		}
		this.radius = 10;
		this.scalingFactor = scalingFactor;
	}

	//adds Quadrant Pirates (leaves) to the composite
	@Override
	public void addPirates(PirateSprites pirates) {
		quad1List.add((Quad1PirateSprite) pirates);
	}

	//removes Quadrant Pirates from the composite
	@Override
	public void removePirates(PirateSprites pirates) {
		quad1List.remove((Quad1PirateSprite) pirates);
	}

	//returns the requested child of the composite
	@Override
	public Quad1PirateSprite getChild(int index) {
		return quad1List.get(index);
	}
	
	//runs the thread
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			startStrategy();
		}
	}

	//starts the movement of the sprites
	@Override
	public void startStrategy() {
		
		for (Quad1PirateSprite pSprites : quad1List) {
			pSprites.startMovement(pSprites);
		}
	}
	
	//adds the images to the game
	public void addToPane(ObservableList<Node> sceneGraph) {
		for (Quad1PirateSprite pSprites : quad1List) {
			Circle circle = pSprites.getCircle();
			
			sceneGraph.add(circle);
			Image pirateImg = new Image("\\pirateShip.png", 17, 17, true, true);
			circle.setFill(new ImagePattern(pirateImg));
		}
	}
}

//similar to monster and ghostship creates the sprites
class Quad1PirateSprite extends QuadrantPirates implements PirateSprites{
	int x, y, scalingFactor;
	Circle circle;
	int radius = 10;
	MovementStrategy strategy;
	boolean goingDown = true;
	int counter = 0;
	
	//creates the ships
	Quad1PirateSprite(int x, int y, int scalingFactor, MovementStrategy strategy){
		this.x = x;
		this.y = y;
		this.scalingFactor = scalingFactor;
		this.strategy = strategy;
		circle = new Circle();
		setPositionX(this.x);
		setPositionY(this.y);
		circle.setRadius(radius);
	}
	
	//does the actual movement of the ships based on strategy
	public void startMovement(Quad1PirateSprite pSprite) {
		strategy.move(pSprite);
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public void setX(int x) {
		this.x = x;
		setPositionX(x);
	}
	
	public void setY(int y){
		this.y = y;
		setPositionY(y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Point getPoint() {
		return new Point(getX(), getY());
	}
	
	public void setLineColor(Circle circle, Color color){
		circle.setStroke(color);
		circle.setFill(color);
	}
	
	public void setPositionX(int x){
		circle.setCenterX(x*scalingFactor + (scalingFactor/2));
	}
	
	public void setPositionY(int y){
		circle.setCenterY(y*scalingFactor + (scalingFactor/2));
	}
}