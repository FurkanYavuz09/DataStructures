package workers;

import java.util.Random;

public class Customer {
	private int numOfProduct=6;
	public Customer() {
		
	}
	public void buyFurniture(StorageChief storageChief) {
		Random rand = new Random();
		int num =rand.nextInt(numOfProduct);
		storageChief.sellFurniture(num);
		
	}
}
