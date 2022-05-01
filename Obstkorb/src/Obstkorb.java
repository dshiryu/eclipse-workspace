
public class Obstkorb {
	private int totalAvailable = 0;
	private int totalSold = 0;
	int [] price = new int[totalAvailable];
	
	public Obstkorb(int maximumBasketSize) {
		this.totalAvailable = maximumBasketSize;
		this.price = new int[maximumBasketSize+1];
		this.totalSold = 0;
		for (int i = 1; i < price.length; i++) {
			price[i] = i;
		}
	}
	
	public void verkaufe(int quantity, int type) {
		
		if (quantity <= totalAvailable && totalAvailable > 0) {
			this.totalAvailable -= quantity;
			this.totalSold += price[quantity];
			System.out.println("Sold " + quantity + " fruits from type " + type);
		} else {
			System.out.println("Nicht genug Obst.");
		}
	}

	public void printUmsatz() {
		System.out.println("Total profit " + this.totalSold);
	}

	public void neuerPreis(int type, int newPrice) {
		for (int i = 1; i < price.length; i++) {
			price[i] = newPrice;
		}
		System.out.println("Price from type " + type + " changed to " + newPrice);
		
	}

}
