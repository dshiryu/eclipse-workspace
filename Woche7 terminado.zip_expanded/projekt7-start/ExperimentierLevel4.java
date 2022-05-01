package playground;

import gameobjects.* ;
import java.awt.Color ;

public class ExperimentierLevel4 extends SpaceInvadersLevel {
  
  public ExperimentierLevel4() {
    super();
  }


  // kleiner Tipp!
  @Override
  protected String getStartupMessage() {
    return "Get ready for experimental level 4!";
  }
  
  
  @Override
  public void prepareLevel(String id) {
    super.prepareLevel(id);
    RectObject ro = new RectObject("staticObj", this, 350,100,0,0,700,200, Color.RED ) ;
    this.addObject(ro);
  }  
}
