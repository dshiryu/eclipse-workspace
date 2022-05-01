package playground;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

import controller.*;
import gameobjects.*;

public class BreakoutLevel2 extends BreakoutLevel1 {

	protected GameObject ball = null, ego = null ;
	ArrayList<GameObject> bricks = new ArrayList<GameObject>() ;
	
	public BreakoutLevel2() {
	    super() ;
	    this.canvasX = this.preferredSizeX();
	    this.canvasY = this.preferredSizeY();
	  }   
	
	@Override
	void actionIfBallHitsBrick(GameObject ball, GameObject brick) {
		this.deleteObject(brick.getId());
	    ball.setVY(ball.getVY()*-1);
	    
	    String expFragName = "";
	    
	    for(int i = 0; i < 20; i++) {
	    	double randomSX = Math.random() * 240;
			double randomSY = Math.random() * 240;
			int randomVX = (int)randomSX;
			int randomVY = (int)randomSY;
	    	expFragName = "fragment" + brick.getX()+i + brick.getY()+i;
	    	GameObject fr = new FallingStar(expFragName, this, brick.getX(),brick.getY(), randomVX, randomVY, Color.RED, 1) ;
	    	fr.setController(new ReboundController())   ;
	    	LimitedTimeController tc = new LimitedTimeController(gameTime, 2);
	    	fr.setController(tc);
	    	addObject(fr);
	    }
	    
	    
	    
	    
	    
	}
	
	@Override
	void actionIfBallHitsEgo(GameObject ball, GameObject ego) {
	    if(ball.getVX() > 0 && ball.getVY() > 0) { // ball coming from the left
	    	if(ball.getX() < ego.getX()) {
	    		ball.setVX(ball.getVX()*-1);
	    	}
	    } else if(ball.getVX() < 0 && ball.getVY() > 0) { // ball coming from the right
	    	if(ball.getX() > ego.getX()) {
	    		ball.setVX(ball.getVX()*-1);
	    	}
		}
	    ball.setVY(ball.getVY()*-1);
	}
	
	  @Override
	  public void applyGameLogic() {
	    LinkedList<GameObject> bricks = collectObjects("brick", false) ;
	    
	    for (GameObject brick : bricks) {
	      if (this.ball.collisionDetection(brick)) {
	        this.actionIfBallHitsBrick(this.ball, brick) ;
	      }
	    }
	    
	    if (ego.collisionDetection(ball)) {
	      actionIfBallHitsEgo(this.ball, this.ego) ;
	    }    
	  }
	
	@Override
	public double getBrickSizeX() {
		return 60;
	}

	@Override
	public double getBrickSizeY() {
		return 30;
	}

	@Override
	public double getBrickStartX() {
		return 20;
	}

	@Override
	public double getBrickStartY() {
		return 20;
	}

	@Override
	public int calcNrBricksX() {
		return 6;
	}

	@Override
	public int calcNrBricksY() {
		return 5;
	}
	
	@Override
	public GameObject createEgoObject() {
		System.out.println("prepare");
	    RectObject ro = new RectObject("ego", this, 350, 550, 0, 0, 60,10, Color.BLUE) ;
	    ro.generateColliders() ;
	    //EgoController ec = new EgoController(30) ;
	    BreakoutController ec = new BreakoutController(30);
	    ro.setController(ec) ;
	    return ro ;
	}
	
	public GameObject createBall() {
	    GameObject co = new FallingStar("ball1", this, 300,300, 270, 270, Color.RED, 5) ;
	    co.setController(new ReboundController())   ;
	    return co ;
	}

	@Override
	public GameObject createBrick(int row, int column) {
		String brickNr = "brick" + row + column;
		double x = 20 + row * getBrickSizeX() * 2; 
		double y = 20 + column * getBrickSizeY() * 2;
		
		/*
		double randomRed = Math.random() * 255;
		double randomGreen = Math.random() * 255;
		double randomBlue = Math.random() * 255;
		int randomR = (int)randomRed;
		int randomG = (int)randomGreen;
		int randomB = (int)randomBlue;
		Color colorName = new Color(randomR, randomG, randomB);
		*/

		double randomColor = Math.random();
		Color colorName = new Color(255, 0, 0);
		if(randomColor <= 0.25) colorName = new Color(255, 0, 0); //red
		else if(randomColor < 0.50) colorName = new Color(0, 0, 255); //blue
		else if(randomColor >= 0.50) colorName = new Color(255,255,0);//yellow
		else if(randomColor >= 0.75) colorName = new Color(0, 255, 0);//green
		
		bricks.add(new RectObject(brickNr, this, x, y, 0, 0, getBrickSizeX(), getBrickSizeY(), colorName));
		return bricks.get(bricks.size()-1);
	}
	
	@Override
	  public void prepareLevel(String level) {
	    
	    for (int y = 0; y < this.calcNrBricksY(); y++ ) {
	      for (int x = 0; x < this.calcNrBricksX(); x++ ) {
	        GameObject tmp = this.createBrick(x,y) ;
	        this.addObject(tmp) ;  
	        tmp.generateColliders() ;
	      }
	    }
	    this.ego = this.createEgoObject() ;
	    this.ball = this.createBall() ;
	    this.addObject(this.ego) ;
	    this.addObject(this.ball) ;
	}  
}
