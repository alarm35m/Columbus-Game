package ChrisColumGame;


import java.awt.Point;
import java.util.Observable;
import java.util.Random;

import org.w3c.dom.events.EventException;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Pirates extends EnemyShip {
	Image ghostImage;
	int x;
	int y;
	Circle circle;
	int scalingFactor;
	int radius = 10;
	Pirates(int x, int y, int scalingFactor){
		this.x = x;
		this.y = y;
		circle= new Circle();
		setPositionX(x);
		setPositionY(y);
		circle.setRadius(radius);
		this.scalingFactor = scalingFactor;
	}
	
	Circle getCircle(){
		return circle;
	}
	
	void setX(int x){
		this.x = x;
		setPositionX(x);
	}
	
	void setY(int y){
		this.y = y;
		setPositionY(y);
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
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
