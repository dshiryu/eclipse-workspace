package playground;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;

import collider.RectCollider;
import controller.EgoController;
import controller.ReboundController;
import gameobjects.EgoObject;
import gameobjects.FallingStar;
import gameobjects.GameObject;
import gameobjects.RectObject;

public class BreakoutLevel extends Playground {

	protected GameObject ball = null, ego = null ;

	public BreakoutLevel() {
	    super() ;
	    this.canvasX = this.preferredSizeX();
	    this.canvasY = this.preferredSizeY();

	  }
	@Override
	public int preferredSizeX() {
		// TODO Auto-generated method stub
		return 700;
	}

	@Override
	public int preferredSizeY() {
		// TODO Auto-generated method stub
		return 700;
	}
	
	void actionIfBallHitsBrick(GameObject ball, GameObject brick) {
		if(ball.getVY() == 170) {
			ball.setVY(-170);
		} else {
			ball.setVY(170);
		}
		deleteObject(brick.getId());
		
	}
	  
	  
	void actionIfBallHitsEgo(GameObject ball, GameObject ego) {
		ball.setVY(-170);
	}

	@Override
	public void applyGameLogic() {
	  
	  LinkedList<GameObject> bricks = this.collectObjects("brick", true) ;
	    
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
		ArrayList <RectObject> brickList = new ArrayList<RectObject>();
		String brickNr = "brick";
		for(int x = 40; x < 700; x = x + 60) {
			for(int y = 40; y < 130; y = y + 30) {
				brickNr = "brick" + x + y;
				brickList.add(new RectObject(brickNr, this, x, y, 0, 0, 60, 30, Color.GREEN));
			}
		}
		
		for(int i = 0; i < brickList.size(); i++) {
			RectCollider recCol = new RectCollider("brick", brickList.get(i), 60, 30);
			brickList.get(i).addCollider(recCol);
			this.addObject(brickList.get(i));
		}
			
		ego = new RectObject("ego", this, 350, 600, 0, 0, 80, 10, Color.BLUE);
		RectCollider shooterCol = new RectCollider("ego", ego, 80, 10);
		EgoController shooterControl = new EgoController(gameTime);
		ego.setController(shooterControl);
		ego.addCollider(shooterCol);
		this.addObject(ego);
		
		ball = new FallingStar("ball", this, 350, 350, 170, 170, Color.RED, 5);
		ReboundController ballControl = new ReboundController();
		ball.setController(ballControl);
		this.addObject(ball);
		
		updateObjects();
	}
	
	

}
