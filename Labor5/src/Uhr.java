
public class Uhr {
	private int hour = 0;
	private int mode = 0; // 0: 0-23h --- 1: 1-12h
	private int summer = 0;
	private int winter = 1;
	
	
	public void tick(){
		
		if (mode == 1 && hour > 12) { //12h
			hour = 1;
		} else if (mode == 0 && hour > 24) { //24h
			hour = 0;
		} else {
			hour++;
		}
		
		
		
		
	}
     
	public void status() {
		 System.out.println("Die Uhr zeigt " + hour);
	}
     
    public int switchMode() {
    	
    	if (mode == 0) { //24h
    		mode++;
    		
    		if (hour > 12) {
    			hour = hour % 12;
    		} else if (hour == 0) {
    			hour = 12;
    		}
    		
    	} else { //12h
    		mode--;
    		hour = (hour * 2) + 1;
    		if (hour > 24) {
    			hour = hour % 24;
    		}
    	}
    	
    	
    	 return mode;
    }
     
    public void sommerzeit() {
    	tick();
    	if (mode == 0 && hour == 24) {
    		hour = 0;
    	} else if (summer == 0) {
	    	summer++;
	    	winter--;
    	}  
    }
     
    public void winterzeit() {
    	
    	if (summer == 1) {
	    	summer--;
	    	winter++;
    	} else if (mode == 1 && hour < 1) { //12h
			hour = 12;
		} else if (mode == 0 && hour < 0) { //24h
			hour = 23;
		} else {
			hour--;
		}
    }

}
