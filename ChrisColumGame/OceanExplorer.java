package ChrisColumGame;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	int[][] treasureMap;
	int[][] islandMap;
	Pane root;
	final int dimensions = 40;
	final int islandCount = 20;
	final int scalingFactor = 17;
	Image shipImage;
	Image pirateShipImage1;
	Image pirateShipImage2;
	Image islandImage;
	Image treasureImage;
	ImageView shipImageView;
	ImageView pirateShipImageView1;
	ImageView pirateShipImageView2;
	ImageView islandImageView;
	ImageView treasureImageVIew;
	
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	
	PirateShip pirateShip1;
	PirateShip pirateShip2;
	Monster monster;
	Thread monstersThread;
	
	PirateShipFactory factory;
	EvilForces evil;
	EnemyShip enemy;
	GhostShip ghost;
	Thread ghostThread;
	Treasure treasure;
	
	Thread quad1PirateThread;
	VerticalGhostShip verticalGhostShip;
	
	Thread quad2PirateThread;
	HorizontalGhostShip horizontalGhostShip;
	
	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = OceanMap.getInstance();
		islandMap = oceanMap.getMap();
		treasureMap = oceanMap.getMap();
		
		root = new AnchorPane();
		drawMap();
		
		//gameStatus = new GameStatus(YouWin);
		//gameStatus = new GameStatus(YouLose);
		
		ship = new Ship(oceanMap);
		pirateShip1 = new PirateShip(oceanMap);
		pirateShip2 = new PirateShip(oceanMap);
		loadShipImage(ship);
		loadPirateShipImage1(pirateShip1);
		loadPirateShipImage2(pirateShip2);
		treasure = new Treasure(oceanMap);
		
		pirateShip1.getMap(islandMap);
		pirateShip2.getMap(islandMap);
		ship.addObserver(pirateShip1);
		ship.addObserver(pirateShip2);
		
		
		verticalGhostShip = new VerticalGhostShip(scalingFactor); //creates a new composite quadPirate for quadrant 1
		verticalGhostShip.addToPane(root.getChildren()); //adds the images to pane
		
		quad1PirateThread = new Thread(verticalGhostShip); //creates the new thread for the quadPirate1
		quad1PirateThread.start(); //starts the thread
		
		horizontalGhostShip = new HorizontalGhostShip(scalingFactor);
		horizontalGhostShip.addToPane(root.getChildren());
		
		quad2PirateThread = new Thread(horizontalGhostShip);
		quad2PirateThread.start();
		
		monster = new Monster(scalingFactor);
		monster.addToPane(root.getChildren());
		
		monstersThread = new Thread(monster);
		monstersThread.start();
		
		//factory = new PirateShipFactory();
		//evil = new EvilForces(factory);
		//enemy = evil.summonEvil("g");
		
		ghost = new GhostShip(scalingFactor);
		ghost.addToPane(root.getChildren());
		
		ghostThread = new Thread(ghost);
		ghostThread.start();
		
		scene = new Scene(root,680,680);
		oceanStage.setTitle("Christopher Columbus Sails the Ocean Blue");
		oceanStage.setScene(scene);
		oceanStage.show();
		System.out.println(treasure.getTreasureLocation());
		startSailing(islandMap);
	}
	
	public void loadShipImage(Ship ship) {
		Image shipImage = new Image("file:///Users/michaelalarcon/Documents/SE_350/Labs_Homework/src/ChrisColumGame/ship.png", 17, 17, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation(ship).x*scalingFactor);
		shipImageView.setY(oceanMap.getShipLocation(ship).y*scalingFactor);
		root.getChildren().add(shipImageView);
	}
	
	public void loadPirateShipImage1(PirateShip pirateShip) {
		Image pirateShipImage = new Image("file:///Users/michaelalarcon/Documents/SE_350/Labs_Homework/src/ChrisColumGame/pirateShip.png", 17, 17, true, true);
		pirateShipImageView1 = new ImageView(pirateShipImage);
		pirateShipImageView1.setX(oceanMap.getShipLocation(pirateShip).x*scalingFactor);
		pirateShipImageView1.setY(oceanMap.getShipLocation(pirateShip).y*scalingFactor);
		root.getChildren().add(pirateShipImageView1);
	}
	
	public void loadPirateShipImage2(PirateShip pirateShip) {
		Image pirateShipImage = new Image("file:///Users/michaelalarcon/Documents/SE_350/Labs_Homework/src/ChrisColumGame/pirateShip.png", 17, 17, true, true);
		pirateShipImageView2 = new ImageView(pirateShipImage);
		pirateShipImageView2.setX(oceanMap.getShipLocation(pirateShip).x*scalingFactor);
		pirateShipImageView2.setY(oceanMap.getShipLocation(pirateShip).y*scalingFactor);
		root.getChildren().add(pirateShipImageView2);
	}
	
	private void startSailing(int[][] islandMap) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
				case RIGHT:
					ship.goEast(islandMap);
					break;
				case LEFT:
					ship.goWest(islandMap);
					break;
				case UP:
					ship.goNorth(islandMap);
					break;
				case DOWN:
					ship.goSouth(islandMap);
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipLocation().y*scalingFactor);
				
				pirateShipImageView1.setX(pirateShip1.getShipLocation().x*scalingFactor);
				pirateShipImageView1.setY(pirateShip1.getShipLocation().y*scalingFactor);
				
				pirateShipImageView2.setX(pirateShip2.getShipLocation().x*scalingFactor);
				pirateShipImageView2.setY(pirateShip2.getShipLocation().y*scalingFactor);
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void stop() {
		monstersThread.stop();
		quad1PirateThread.stop();
		quad2PirateThread.stop();
		ghostThread.stop();
	}
	
	public void drawMap() {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scalingFactor, y*scalingFactor, scalingFactor, scalingFactor);
				rect.setStroke(Color.BLACK);
				if(islandMap[x][y] == 1) {
					//rect.setFill(Color.GREEN);
					islandImage = new Image("file:///Users/michaelalarcon/Documents/SE_350/Labs_Homework/src/ChrisColumGame/island.jpg", 17, 17, true, true);
					rect.setFill(new ImagePattern(islandImage));
				}
				else if(treasureMap[x][y] == 8) {
					treasureImage = new Image("file:///Users/michaelalarcon/Documents/SE_350/Labs_Homework/src/ChrisColumGame/Treasure.jpeg", 17, 17, true, true);
					rect.setFill(new ImagePattern(treasureImage));
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
				}
				root.getChildren().add(rect);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
