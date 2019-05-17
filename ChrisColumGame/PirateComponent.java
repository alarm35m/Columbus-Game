package ChrisColumGame;


public interface PirateComponent{
	public void startStrategy();
	public void addPirates(PirateSprites pirates);
	public void removePirates(PirateSprites pirates);
	public PirateSprites getChild(int index);
}
