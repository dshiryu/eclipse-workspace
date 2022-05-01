package playground;

import java.awt.Color;

import collider.RectCollider;
import controller.LimitedTimeController;
import controller.ReboundController;
import gameobjects.GameObject;
import gameobjects.RectObject;
import gameobjects.TextObject;

public class ExperimentierLevel6 extends SpaceInvadersLevel {
	@Override
	public void prepareLevel(String id) {
		super.prepareLevel(id);
		
		// enemy 1
		RectObject fly1 = new RectObject("fly_enemy1", this, 300, 300, 170, 70, 30, 30, Color.BLUE);
		ReboundController wtv1 = new ReboundController();
		fly1.setController(wtv1);
		RectCollider col1 = new RectCollider(id, fly1, 30, 30);
		fly1.addCollider(col1);
		this.addObject(fly1);
		
		// enemy 2
		RectObject fly2 = new RectObject("fly_enemy2", this, 200, 200, 50, 70, 30, 30, Color.GREEN);
		ReboundController wtv2 = new ReboundController();
		fly2.setController(wtv2);
		RectCollider col2 = new RectCollider(id, fly2, 30, 30);
		fly2.addCollider(col2);
		this.addObject(fly2);
		
		updateObjects();
	}
	
	@Override
	void actionIfEgoCollidesWithEnemy(GameObject enemy, GameObject ego) {
		super.actionIfEgoCollidesWithEnemy(enemy, ego);
		GameObject auaObj = this.getObject("AUA-EGO");

	    if (auaObj == null) {
	      addObject(new TextObject("AUA-EGO", this, ego.getX(), ego.getY() - 20, ego.getVX(),
	          ego.getVY(), "AUA", 10, Color.RED)
	              .setController(new LimitedTimeController(gameTime, BONUS_DURATION)));
	    }
		
		if (ego.collisionDetection(this.getObject("fly_enemy1")) || ego.collisionDetection(this.getObject("fly_enemy2")) /*collision with fly1 or fly2*/) {
			getGlobalFlag("egoLives");
			setGlobalFlag("egoLives", 0);
		} 
		
	}
	
	@Override
	void actionIfEnemyIsHit(GameObject e, GameObject shot) {
		//super.actionIfEnemyIsHit(e, shot);
		
		double gameTime = this.getGameTime();
	    
	    
		// delete enemy
		if(e.getId() == "fly_enemy1") {
			Music.music(smash);
			deleteObject(this.getObject("fly_enemy1").getId());
			createExplosion(gameTime, this.getObject("fly_enemy1"), "shard", DYING_INTERVAL, Color.RED);
			deleteObject(shot.getId());
			Integer pts = (Integer) getGlobalFlag("points");
		    setGlobalFlag("points", pts + 200);
		} else if(e.getId() == "fly_enemy2") {
			Music.music(smash);
			deleteObject(this.getObject("fly_enemy2").getId());
			createExplosion(gameTime, this.getObject("fly_enemy2"), "shard", DYING_INTERVAL, Color.RED);
			deleteObject(shot.getId());
			// add to points counter
		    Integer pts = (Integer) getGlobalFlag("points");
		    setGlobalFlag("points", pts + 200);
		}
	    
	}
	
	/*
	@Override
	protected String getStartupMessage() {
	    return "Experiment!";
	}*/
}
