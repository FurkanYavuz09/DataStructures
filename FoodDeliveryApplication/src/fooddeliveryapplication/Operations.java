package fooddeliveryapplication;



import java.math.RoundingMode;
import java.text.DecimalFormat;

import queue.Queue;


public class Operations {
	 
	ObjectCreation objects;
	Restaurant [] restaurants;
	Food [] foods;
	Binarysearchtree<Restaurant> ratingBST ;
	Binarysearchtree<Restaurant>  deliveryBST;
	Binarysearchtree<Food> priceBST ;
	Binarysearchtree<Food> stockBST;
	DecimalFormat df2;
	public Operations() {
		df2 = new DecimalFormat("##.##");
		df2.setRoundingMode(RoundingMode.HALF_UP);
		this.objects=new ObjectCreation();
		this.restaurants=objects.getRestaurants();
		this.foods=objects.getFoods();
		this.ratingBST = new Binarysearchtree<>( new Restaurantcomparator(0));
		this.deliveryBST= new Binarysearchtree<>( new Restaurantcomparator(1));
		this.priceBST = new Binarysearchtree<>( new Foodcomparator(0));
		this.stockBST = new Binarysearchtree<>( new Foodcomparator(1));
		bstFiller();
	}

	
	private void bstFiller(){
		int size=restaurants.length;
		for (int i=0;i<size;i++) {
			 if (restaurants[i]!=null) {
				 ratingBST.add(restaurants[i]);				
				 deliveryBST.add(restaurants[i]);
			 }
			priceBST.add(foods[i]);                                                                      
			stockBST.add(foods[i]);
		}
		ratingBST.setIterator(new BSTIterator(ratingBST.getRoot()));
		priceBST.setIterator(new BSTIterator(priceBST.getRoot()));
		deliveryBST.setIterator(new BSTIterator(deliveryBST.getRoot()));
		stockBST.setIterator(new BSTIterator(stockBST.getRoot()));
		
	}
	private void operation1() {
		while (true) {
			Restaurant tempReturn=ratingBST.descInOrder();
			if (tempReturn==null) {
				break;
			}
			
			if (tempReturn!=null) {
				System.out.printf("%-30s%7s%n",tempReturn.getName(),tempReturn.getRating());
			}
			
		}
	}
	
	private void operation2() {
		while (true) {
			Food tempReturn=priceBST.ascInOrder();
			if (tempReturn==null) {
				break;
			}
			if (tempReturn!=null) {
				System.out.printf("%-23s%-11s%-15s%n",tempReturn.getName(),(df2.format(tempReturn.getPrice())),(int)(tempReturn.getStock()) );
			}
			
		}
	}
	private void operation3() {
		
		while (true) {
			Restaurant pizza=deliveryBST.ascInOrder();
			if (pizza!=null) {
				
				 if (pizza.getCuisine().equals(" Pizza")) {
					System.out.printf("%-23s%-20s%n",pizza.getName(),pizza.getDeliveryTime());

					break;
				}
			}
			else {
				break;
			}
			
		}
	}
	private void operation4() {
		int i=0;
		while (i<20) {
			Food coffee=stockBST.descInOrder();
			if (coffee==null) {
				break;
			}
			else if(coffee.getRestaurant().getCuisine().equals(" Coffee")){
				System.out.println(coffee.getName()+"              "+(int)coffee.getStock());
				break;
			}
			System.out.println(coffee.getStock());
			System.out.println(coffee.getRestaurant().getName());
			i++;
		
		}
	}
	private void operation5() {
		Queue<Food> expensiveFoods=new Queue<Food>();
		while(true) {
			Food tempFood=priceBST.descInOrder();
			if (tempFood==null) {
				break;
			}
			else if (tempFood.getPrice()>80) {
				System.out.printf("%-23s%-8s%-20s%n",tempFood.getName(),tempFood.getPrice(),"removed");
				expensiveFoods.enqueue(tempFood);
			}
			else {
				break;
			}
		}
		while (!expensiveFoods.isEmpty()) {
			Food removedFood= expensiveFoods.dequeue();
			priceBST.remove(removedFood);
			stockBST.remove(removedFood);
		}
		
	}
	private void operation6() {
		Queue<Restaurant> removedRestaurants=new Queue<Restaurant>();
		while(true) {
			Restaurant tempRestaurant=ratingBST.ascInOrder();
			if (tempRestaurant==null) {
				break;
			}
			else if (tempRestaurant.getRating()<8) {
				System.out.printf("%-23s%-8s%-20s%n",tempRestaurant.getName(),tempRestaurant.getRating(),"removed");
				removedRestaurants.enqueue(tempRestaurant);
			}
			else {
				break;
			}
		}
		while (!removedRestaurants.isEmpty()) {
			Restaurant removedR= removedRestaurants.dequeue();
			ratingBST.remove(removedR);
			deliveryBST.remove(removedR);
		}
	}
	private void operation7() {
		priceBST.setIterator(new BSTIterator(priceBST.getRoot()));
		while (true) {
			Food tempFood=priceBST.ascInOrder();
			if (tempFood==null) {
				break;
			}
			else {
				tempFood.updatePrice(tempFood.getPrice()*1.2);
			}
		}
		System.out.println("Prices in FoodBSTs are updated.");
	}
	private void operation8() {
		stockBST.setIterator(new BSTIterator(stockBST.getRoot()));
		while (true) {
			Food tempFood=stockBST.ascInOrder();
			if (tempFood==null) {
				break;
			}
			else {
				tempFood.updateStock(tempFood.getStock()*0.5);
			}
		}
		System.out.println("Stocks in FoodBSTs are updated.");
	}
	private void operation9() {
		ratingBST.setIterator(new BSTIterator(ratingBST.getRoot()));
		operation1();
	}
	private void operation10() {
		priceBST.setIterator(new BSTIterator(priceBST.getRoot()));
		operation2();
	}
	public void executeOrder66() {
		System.out.println("----------------- 1 -----------------");
		operation1();
		System.out.println("----------------- 2 -----------------");
		operation2();
		System.out.println("----------------- 3 -----------------");
		operation3();
		System.out.println("----------------- 4 -----------------");
		operation4();
		System.out.println("----------------- 5 -----------------");
		operation5();
		System.out.println("----------------- 6 -----------------");
		operation6();
		System.out.println("----------------- 7 -----------------");
		operation7();
		System.out.println("----------------- 8 -----------------");
		operation8();
		System.out.println("----------------- 9 -----------------");
		operation9();
		System.out.println("----------------- 10 -----------------");
		operation10();
	
	}
	
}
