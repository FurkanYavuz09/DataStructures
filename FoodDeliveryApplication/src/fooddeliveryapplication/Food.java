package fooddeliveryapplication;

public class Food implements  Orderable{
	private String name;
	private double price;
	private double stock;
	private Restaurant restaurant;

	
	
	public Food(String name, double price, double stock, Restaurant restaurant) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.restaurant = restaurant;
		
	}
	
	

	public void updatePrice(double price) {
		this.price=price;
	}
	public void updateStock(double stock) {
		this.stock=stock;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public double getStock() {
		return stock;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
