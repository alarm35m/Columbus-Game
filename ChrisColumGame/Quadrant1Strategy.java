package ChrisColumGame;


public class Quadrant1Strategy implements MovementStrategy{
	boolean goingDown = true; //sets whether ship goes up or down
	int counter = 0; //counter to determine how far to go in a direction
	OceanMap oceanMap = OceanMap.getInstance();
	
	public void move(PirateSprites pSprite) {
		int yMove; //y-axis movement
		int xMove;
		if (counter == 20) {
			goingDown = flipMovement(goingDown);
			counter = 0;
		}
			
		//goes down y-axis
		if (goingDown) {
			yMove = pSprite.getY() + 1;
			xMove = pSprite.getX() + 1;
			if (oceanMap.oceanGrid[pSprite.getX()][pSprite.getY()] == 1) {
				pSprite.setX(xMove);
			}
			else {
				pSprite.setY(yMove);
			}
			
			counter++;
		}
		//goes up y-axis
		else if (!goingDown) {
			yMove = pSprite.getY() - 1;
			xMove = pSprite.getX() + 1;
			pSprite.setY(yMove);
			counter++;
		}
	}
	
	//flips the direction of travel
	private boolean flipMovement(boolean direction) {
		if (direction)
			return false;
		else
			return true;
	}
}
