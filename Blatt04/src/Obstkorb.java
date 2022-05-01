
public class Obstkorb {
	
	private int count = 0;
	private int weight = 0;
	
	public void apfelRein(int x) {
		
		if ((x >= 100 && x <= 200) && count < 10) {
			//System.out.println(x + "gr Apfel reinlegen");
			weight = weight + x;
			count++;
			if (count == 10) {
			System.out.println("zu viele Aepfel");
			}
		} else if (x > 200){
			System.out.println("zu schwer"); // + "\n kein Apfel rein"
		} else if (x < 100) {
			System.out.println("zu leicht"); // + "\n kein Apfel rein"
		}
		
		
	}
	
	public int obstGesamt() {
		return count;
	}
	
	public int gewichtGesamt() {
		return weight;
	}

}
