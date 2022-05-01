import java.lang.reflect.Method;

public class CDPlayer {

	int currentMusic = 0;
	static String music[] = {
			"Master Blaster (Jammin’) by Stevie Wonder (1980)",
			"Super Trouper by Abba (1980)",
			"Don’t Stop Believin’ by Journey (1981)"
	};
	/*
	public static void main(String[] args) {
		Radio r = new Radio();
		//System.out.println(r.getVolume());
		//System.out.println(r.play());
		
	}
	*/
	public void louder() {
		Bordcomputer b = new Bordcomputer();
		b.louder(1);
	}
	
	public void quieter() {
		Bordcomputer b = new Bordcomputer();
		b.quieter(1);
	}
	
	public int getVolume() {
		Bordcomputer b = new Bordcomputer();
		return b.volume;
	}
	
	public void next() {
		currentMusic++;
		if(currentMusic == music.length) {
			currentMusic = 0;
		}
		//play();
	}
	
	public void prev() {
		currentMusic--;
		if(currentMusic < 0) currentMusic = music.length-1;
		//play();
	}
	
	public String play() {
		return "Playing: " + music[currentMusic];
	}
	
	public String getInfoText() {
		Bordcomputer b = new Bordcomputer();
		int res = b.playingDevice;
		
		switch(res) {
			case 0:
				return "Radio";
			case 1:
				return "CDPlayer";
			case 2:
				return "USB";
		}
		
		return "";
	}
	
	public String[] getOptions() {
		Bordcomputer bc = new Bordcomputer();
		Class c = bc.getClass();
		Method[] m = c.getDeclaredMethods();
		
		String[] output = null;
		
		for(int i = 0; i < m.length; i++) {
			output[i] = (m[i].toString());
		}
		
		return output ;
	}
	
	public void chooseOption(String opt) {
		Bordcomputer b = new Bordcomputer();
		System.out.println();
	}

}
