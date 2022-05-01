import playground.BreakoutLevel2;
import playground.Playground;

public class Prog2Game extends GameLoop {

	@Override
	public void defineLevels() {
		this.levels = new Playground[1];
		this.levels[0] = new BreakoutLevel2();
	}

	public static void main(String[] args) {
		Prog2Game ng = new Prog2Game();
		ng.runGame(args);
	}

}
