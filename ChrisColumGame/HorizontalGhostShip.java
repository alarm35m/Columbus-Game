package ChrisColumGame;

import java.awt.Point;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class HorizontalGhostShip implements PirateComponent, Runnable{
	
	PirateShipFactory pShipFactory = new PirateShipFactory();
	ArrayList<Quad2PirateSprite> quad2List = new ArrayList<Quad2PirateSprite>();
	Boolean running = true;
	int radius, scalingFactor;
	
	public HorizontalGhostShip(int scalingFactor) {
		int x = 20;
		int y = 0;
		for (int i = 0; i < 5; i++) {
			quad2List.add((Quad2PirateSprite) pShipFactory.createShip("q2", x, y, scalingFactor));
			y += 5;
		}
		this.radius = 10;
		this.scalingFactor = scalingFactor;
	}
	
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
	
	@Override
	public void startStrategy() {
		for (Quad2PirateSprite pSprites : quad2List) {
			pSprites.startMovement(pSprites);
		}
	}
	
	@Override
	public void addPirates(PirateSprites pirates) {
		quad2List.add((Quad2PirateSprite) pirates);
	}
	
	@Override
	public void removePirates(PirateSprites pirates) {
		quad2List.remove((Quad2PirateSprite) pirates);
	}
	
	@Override
	public PirateSprites getChild(int index) {
		return quad2List.get(index);
	}
	
	public void addToPane(ObservableList<Node> sceneGraph) {
		for (Quad2PirateSprite pSprites : quad2List) {
			Circle circle = pSprites.getCircle();
			
			sceneGraph.add(circle);
			Image pirateImg = new Image("\\pirateShip.png", 17, 17, true, true);
			circle.setFill(new ImagePattern(pirateImg));
		}
	}
}

class Quad2PirateSprite extends QuadrantPirates implements PirateSprites{
	int x, y, scalingFactor;
	Circle circle;
	int radius = 10;
	MovementStrategy strategy;
	
	//creates the ships
	Quad2PirateSprite(int x, int y, int scalingFactor, MovementStrategy strategy){
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
	public void startMovement(Quad2PirateSprite pSprite) {
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
