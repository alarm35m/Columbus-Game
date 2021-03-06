package ChrisColumGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public interface PirateSprites {

	Circle getCircle();
	void setX(int x);
	void setY(int y);
	int getX();
	int getY();
	public void setLineColor(Circle circle, Color color);
	public void setPositionX(int x);
	public void setPositionY(int y);
}
