import playground.*;

public class TestLevel extends GameLoop {
	@Override
	public void defineLevels() {
	    this.levels = new Playground[1];
	    this.levels[0] = new Testing();
	}
	public static void main(String[] args) {
		TestLevel pg = new TestLevel();
		pg.runGame(args);
	}

}
