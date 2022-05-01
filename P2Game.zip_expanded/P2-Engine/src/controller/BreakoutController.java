package controller;

import java.awt.event.KeyEvent;

import gameobjects.GameObject;

public class BreakoutController extends EgoController {

	public BreakoutController(double egoRad) {
		super(egoRad);
	}
	
	@Override
	public void onUp(KeyEvent kc, GameObject ego) {}
	
	@Override
	public void onDown(KeyEvent kc, GameObject ego) {}
	
	@Override
	public void onSpace(KeyEvent e, GameObject ego) {}
}
