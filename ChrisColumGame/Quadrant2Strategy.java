package ChrisColumGame;


public class Quadrant2Strategy implements MovementStrategy{
	boolean goingAcross = true; //sets whether ship goes up or down
	int counter = 0; //counter to determine how far to go in a direction
	
	public void move(PirateSprites pSprite) {
		int xMove; //x-axis movement
		if (counter == 19) {
			goingAcross = flipMovement(goingAcross);
			counter = 0;
		}
			
		//goes down y-axis
		if (goingAcross) {
			xMove = pSprite.getX() + 1;
			pSprite.setX(xMove);
			counter++;
		}
		//goes up y-axis
		else if (!goingAcross) {
			xMove = pSprite.getX() - 1;
			pSprite.setX(xMove);
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
