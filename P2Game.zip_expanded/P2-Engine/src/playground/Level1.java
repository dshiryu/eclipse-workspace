package playground;

import controller.FallingStarController;
import gameobjects.FallingStar;
import gameobjects.GameObject;


/**
 * Dummy Level.
 *
 */
public class Level1 extends SpaceInvadersLevel {

  public Level1() {
    super();
  }


  // kleiner Tipp!
  @Override
  protected String getStartupMessage() {
    return "Get ready for level 1!";
  }


}
