package fooddeliveryapplication;

public class Restaurant {
	
		private String name;
		private double rating;
		private String cuisine;
		private double deliveryTime; 
		
		public Restaurant(String name, double rating, String cuisine, double deliveryTime) {
			
			this.name = name;
			this.rating = rating;
			this.cuisine = cuisine;
			this.deliveryTime = deliveryTime;
			
		}
		
		public void updateCuisine(String category) {
			this.cuisine=category;
		}
		public void updateRating(double score) {
			this.rating =score;
		}
		
		public void updateDeliveryTime(double deliveryTime) {
			this.deliveryTime=deliveryTime;
		}
		 public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getRating() {
			return rating;
		}
		
		public String getCuisine() {
			return cuisine;
		}
		
		public double getDeliveryTime() {
			return deliveryTime;
		}
	}

