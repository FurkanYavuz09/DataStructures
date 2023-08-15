package fooddeliveryapplication;

public class Restaurantcomparator implements Comparator<Restaurant> {
	
	int type;
	
	public Restaurantcomparator(int type) {
		this.type=type;
	}
	@Override
	public double compare(Restaurant first,Restaurant second) {
		if (this.type==0) {
			return first.getRating()-second.getRating();
		}
		else {
			return first.getDeliveryTime()-second.getDeliveryTime();
		}	
	}
	
}

		
		
	
