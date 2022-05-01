public class Konto {
	private double totalMoney;

	public Konto () {  
    	this.totalMoney = 0;
    }
	
    public Konto (double summe) {  
    	this.totalMoney = summe;
    }

    public void einzahlen (double summe) { 
    	this.totalMoney += summe; 
    }
    
    public void abheben (double summe) {  
    	if (this.totalMoney < summe) {
    		this.totalMoney = this.totalMoney - summe - 5;
    	} else {
    		this.totalMoney -= summe;
    	}
    }

    public double abfragen() { return this.totalMoney; } 
}
