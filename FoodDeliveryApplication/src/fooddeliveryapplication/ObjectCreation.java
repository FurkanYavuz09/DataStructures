package fooddeliveryapplication;




public class ObjectCreation {
	
	private String[][] fileArray;
	private Restaurant[] restaurants;
	private Food[] foods;
	private Readfile file;
	public ObjectCreation() {
		 this.file=new Readfile();
		 objectInitialization();
	}

	public Restaurant[] getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurant[] restaurants) {
		this.restaurants = restaurants;
	}

	public Food[] getFoods() {
		return foods;
	}

	public void setFoods(Food[] foods) {
		this.foods = foods;
	}
	public boolean contains(Restaurant object) {
		for (int i=0;i<this.restaurants.length;i++) {
			if (this.restaurants[i]!=null) {
				if (object.getName().equals(this.restaurants[i].getName())) {
					return true;
				}
				
			}
			
			
		}
		return false;
	}

	public void objectInitialization() {
		int notnull=0;
		this.fileArray=this.file.read();
		this.restaurants = new Restaurant[fileArray.length];
		this.foods= new Food[fileArray.length];
		for (int i = 0;i<fileArray.length;i++) {
			
			Restaurant tempRestaurant=new Restaurant(fileArray[i][3],Double.parseDouble(fileArray[i][4]),fileArray[i][5],Double.parseDouble(fileArray[i][6]));
			if (!contains(tempRestaurant)) {
				restaurants[notnull]=tempRestaurant;
				
				foods[i] = new Food(fileArray[i][0],Double.parseDouble(fileArray[i][1]),Double.parseDouble(fileArray[i][2]),restaurants[notnull]); 
				notnull++;
			}
			else {
				
				foods[i] = new Food(fileArray[i][0],Double.parseDouble(fileArray[i][1]),Double.parseDouble(fileArray[i][2]),tempRestaurant); 
			}
			
			
			}
			
		}	
	}	
	

