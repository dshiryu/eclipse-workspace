package playground;

import java.util.LinkedList;
import collider.Collider;
import controller.FallingStarController;
import controller.ObjectController;
import controller.ZickZackController;
import gameobjects.AnimatedGameobject;
import gameobjects.FallingStar;
import gameobjects.GameObject;
import collider.*;


/**
 * Class that realizes all the game logic of a very simple game level. The level contains for now
 * only two objects that are {@link GameObject} subclasses: {@link FallingStar} and {@link Student}.
 * Functions performed by this class are:
 * <ul>
 * <li>initially set up the level, spawn all object etc., in method {@link #prepareLevel}
 * <li>React to keyboard commands in method {@link #processInputs}
 * <li>define basic object movement rules for all objects in the level in the various
 * ObjectController subclasses: {@link StudentController} and {@link FallingStarController}.
 * </ul>
 */


/** Aliens move in zigzag! */
public class Level3 extends SpaceInvadersLevel {

  public Level3() {
    super();
  }


  // kleiner Tipp!
  @Override
  protected String getStartupMessage() {
    return "Get ready for level 3!!!";
  }


  @Override
  protected GameObject createSingleEnemy(String name, double x_enemy, double y_enemy,
      double vx_enemy, double vy_enemy, ObjectController enemyController, double gameTime) {
    ObjectController zzController = new ZickZackController(gameTime, 0.5);
    GameObject go = new AnimatedGameobject(name, this, x_enemy, y_enemy, vx_enemy, vy_enemy,
        ENEMYSCALE, this.enemyAnim, this.getGameTime(), "loop").setController(zzController)
            .generateColliders();

    return go.generateColliders();
  }



}
