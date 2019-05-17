package ChrisColumGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class EnemyShip {
	
	abstract Circle getCircle();
	abstract void setX(int x);
	abstract void setY(int y);
	abstract int getX();
	abstract int getY();
	abstract public void setLineColor(Circle circle, Color color);
	abstract public void setPositionX(int x);
	abstract public void setPositionY(int y);
}