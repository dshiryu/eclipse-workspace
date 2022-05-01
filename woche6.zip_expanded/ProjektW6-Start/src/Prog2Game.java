
import playground.ExperimentierLevel6;
import playground.Playground;

public class Prog2Game extends GameLoop {

	public static void main(String[] args) {
		Prog2Game pg2 = new Prog2Game();
		pg2.runGame(args);
	}
	
	@Override
	public void defineLevels() {
		this.levels = new Playground[1];
		this.levels[0] = new ExperimentierLevel6();
		
	}
}
