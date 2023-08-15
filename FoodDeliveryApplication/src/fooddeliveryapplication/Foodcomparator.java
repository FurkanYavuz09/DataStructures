package fooddeliveryapplication;

public class Foodcomparator implements Comparator<Food> {
	
	int type;
	
	

	public Foodcomparator(int type) {
		this.type=type;
	}
	@Override
	public double compare(Food first,Food second) {
		if (this.type==0) {
			return first.getPrice()-second.getPrice();
		}
		else {
			return first.getStock()-second.getStock();
		}	
	}
}
