package playground;

import controller.FallingStarController;
import gameobjects.FallingStar;
import gameobjects.GameObject;


/**
 * Another almost-dummy level.
 */
public class Level2 extends SpaceInvadersLevel {

  public Level2() {
    super();
  }


  // kleiner Tipp!
  @Override
  protected String getStartupMessage() {
    return "Get ready for level 2!";
  }



}
