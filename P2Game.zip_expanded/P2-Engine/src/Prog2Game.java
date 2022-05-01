import playground.BreakoutLevel;
import playground.Playground;

public class Prog2Game extends GameLoop {
	@Override
	public void defineLevels() {
	    this.levels = new Playground[1];
	    this.levels[0] = new BreakoutLevel();
	}
	
	
	
	public static void main(String[] args) {
		Prog2Game pg = new Prog2Game();
		pg.runGame(args);
	}

}
