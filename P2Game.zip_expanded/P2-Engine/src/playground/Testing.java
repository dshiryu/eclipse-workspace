package playground;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;

import collider.*;
import controller.*;
import gameobjects.*;

public class Testing extends Playground {
	ArrayList <RectObject> brickList = new ArrayList<RectObject>(); /////////////////////////////////////////
	protected GameObject ball = null, ego1 = null, ego2 = null, ego3 = null ;
	protected Animation enemyAnim = null;
	protected AnimatedGameobject ago = null;
	
	
	public Testing() {
		super() ;
	    this.canvasX = this.preferredSizeX();
	    this.canvasY = this.preferredSizeY();
	}
	@Override
	public int preferredSizeX() {
		// TODO Auto-generated method stub
		return 1800;
	}

	@Override
	public int preferredSizeY() {
		// TODO Auto-generated method stub
		return 1000;
	}
	
	void actionIfBallHitsBrick(GameObject ball, GameObject brick) { // negativo cima/ esquerda, positivo pra baixo / direita
		double ballX = ball.getVX();
		double ballY = ball.getVY();
		String enemyName = "enemy";
		if(brick.id == "lowerBorder" || brick.id == "upperBorder") { //horizontal
			ball.setVY(-ballY);
			enemyName += 1;
		      
		} else if(brick.id == "leftBorder" || brick.id == "rightBorder" || brick.id == "firstWall" || brick.id == "secondWall") { //vertical
			ball.setVX(ballX * -1);
			ago = new AnimatedGameobject(enemyName, this, Math.random() * this.canvasX, Math.random() * this.canvasY, 200, 200,
				      1, this.enemyAnim, gameTime, "forward");
		      this.addObject(ago);
		}
		
		//deleteObject(brick.getId());
	}
	  
	  
	void actionIfBallHitsEgo(GameObject ball, GameObject ego) {
		ball.setVY(-170);
	}

	@Override
	public void applyGameLogic() {
		//LinkedList<GameObject> bricks = this.collectObjects("brick", true) ;
	    
		  for (GameObject brick : brickList) {//bricks
		    if (this.ball.collisionDetection(brick)) {
		      this.actionIfBallHitsBrick(this.ball, brick) ;
		      
		    }
		  }
		    
		  if (ego1.collisionDetection(ball)) {
		    actionIfBallHitsEgo(this.ball, this.ego1) ;
		  }
		
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean levelFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void redrawLevel(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareLevel(String level) {
		//ArrayList <RectObject> brickList = new ArrayList<RectObject>();
		String brickNr = "brick";
		
		// lower border
		brickList.add(new RectObject("lowerBorder", this, 0, 710, 0, 0, 3620, 10, Color.BLACK));
		RectCollider lowerCol = new RectCollider("brick", brickList.get(0), 3620, 30);
		brickList.get(0).addCollider(lowerCol);
		// upper border
		brickList.add(new RectObject("upperBorder", this, 0, 200, 0, 0, 3620, 10, Color.BLACK));
		RectCollider upperCol = new RectCollider("brick", brickList.get(1), 3620, 30);
		brickList.get(1).addCollider(upperCol);
		// left border
		brickList.add(new RectObject("leftBorder", this, 0, 0, 0, 0, 10, 1800, Color.BLACK));
		RectCollider leftCol = new RectCollider("brick", brickList.get(2), 10, 1800);
		brickList.get(2).addCollider(leftCol);
		// left border
		brickList.add(new RectObject("rightBorder", this, 1785, 0, 0, 0, 10, 1800, Color.BLACK));
		RectCollider rightCol = new RectCollider("brick", brickList.get(3), 10, 1800);
		brickList.get(3).addCollider(rightCol);
		// first wall
		brickList.add(new RectObject("firstWall", this, 600, 0, 0, 0, 10, 900, Color.BLACK));
		RectCollider firstWallCol = new RectCollider("brick", brickList.get(4), 10, 900);
		brickList.get(4).addCollider(firstWallCol);
		// second wall
		brickList.add(new RectObject("secondWall", this, 1200, 0, 0, 0, 10, 900, Color.BLACK));
		RectCollider secondWallCol = new RectCollider("brick", brickList.get(5), 10, 900);
		brickList.get(5).addCollider(secondWallCol);
		
		// green block of bricks
		/*for(int x = 40; x < 700; x = x + 60) {
			for(int y = 40; y < 130; y = y + 30) {
				brickNr = "brick" + x + y;
				brickList.add(new RectObject(brickNr, this, x, y, 0, 0, 60, 30, Color.GREEN));
			}
		}*/
		
		// add brick colliders
		for(int i = 0; i < brickList.size(); i++) {
			//RectCollider recCol = new RectCollider("brick", brickList.get(i), 60, 30);
			//brickList.get(i).addCollider(recCol);
			this.addObject(brickList.get(i));
		}
		///////////		 ego 	////////////////	
		ego1 = new RectObject("ego1", this, 0, 0, 0, 0, 80, 10, Color.BLUE);
		RectCollider shooterCol1 = new RectCollider("ego1", ego1, 80, 10);
		EgoController shooterControl1 = new EgoController(gameTime);
		ego1.setController(shooterControl1);
		ego1.addCollider(shooterCol1);
		this.addObject(ego1);
		
		/*ego2 = new RectObject("ego2", this, 350, 600, 0, 0, 80, 10, Color.BLUE);
		RectCollider shooterCol2 = new RectCollider("ego2", ego2, 80, 10);
		//EgoController shooterControl2 = new EgoController(gameTime);
		ego2.setController(shooterControl1);
		ego2.addCollider(shooterCol2);
		this.addObject(ego2);
		
		ego3 = new RectObject("ego3", this, 100, 800, 0, 0, 80, 10, Color.BLUE);
		RectCollider shooterCol3 = new RectCollider("ego3", ego3, 80, 10);
		//EgoController shooterControl3 = new EgoController(gameTime);
		ego3.setController(shooterControl1);
		ego3.addCollider(shooterCol3);
		processKeyEvents(getKeyEvents());
		this.addObject(ego3);*/
		
		//////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		ball = new FallingStar("ball", this, 110, 110, 1000, 1000, Color.RED, 5);
		ReboundController ballControl = new ReboundController();
		ball.setController(ballControl);
		this.addObject(ball);
		
		if (this.enemyAnim == null) {
		      String dateiName = "./video/sweetAlien.txt";
		      this.enemyAnim = new Animation(dateiName);
	    }
		
		ago = new AnimatedGameobject("ago", this, 100, 100, 200, 200,
			      1, this.enemyAnim, gameTime, "forward");
		//this.addObject(ago);
		
		updateObjects();
		
	}

}
