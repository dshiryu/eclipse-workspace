package playground;

import gameobjects.* ;
import rendering.* ;
import java.util.LinkedList ;

import java.awt.Graphics2D;
import java.awt.Color ;
import controller.* ;
import collider.* ;

public class BreakoutLevel1 extends Playground {
  
  protected GameObject ball = null, ego = null ;

  public BreakoutLevel1() {
    super() ;
    // TODO Auto-generated constructor stub
    this.canvasX = this.preferredSizeX();
    this.canvasY = this.preferredSizeY();

  }
  
  @Override
  public boolean gameOver() {
    return false ;
  }
  
  
  @Override
  public boolean levelFinished() {
    return false ;
  }
  
  
  @Override
  public boolean resetRequested() {
    return false ;
  }
  
  
  @Override
  public void redrawLevel(Graphics2D g2) {
    
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
  }
  
  
  void actionIfBallHitsEgo(GameObject ball, GameObject ego) {

  }

  @Override
  public void applyGameLogic() {
    // TODO Auto-generated method stub
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
  
  
  int calcNrBricksX() {
    return 10 ;
  }

  
  int calcNrBricksY() {
    return 3 ;
  }
  
  
  void createEgoObject() {
    // your code here!

  }
  
  void createBall() {
    // your code here!
  }
  
  @Override
  public void prepareLevel(String level) {
    // your code here!
    
    
    
    

  }

}
