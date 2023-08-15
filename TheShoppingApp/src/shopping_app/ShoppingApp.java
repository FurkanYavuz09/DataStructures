package shopping_app;

import storage.*;
import item.*;
import java.util.Scanner;

import file_io.FileIO;

public class ShoppingApp {

	public static void main(String[] args) {
	
		ItemCreation items = new ItemCreation();
		Item[] itemsArray =items.ItemInitialization();
		
		Storage shoppingBasket = new Storage(2000);			//Storage objects are initialized with weight limits.
		Storage vegetablesAndFruitsComp = new Storage(3000);
		Storage meatsComp = new Storage(5000);
		Storage beveragesComp = new Storage(4000);
		Storage snacksComp = new Storage(2000);
		
		Scanner myObj = new Scanner(System.in);
		
		int leastWeight = itemsArray[0].getItem_weight();
		for (int i =0;i<itemsArray.length;i++) {
			if (leastWeight>itemsArray[i].getItem_weight()) {
				leastWeight = itemsArray[i].getItem_weight();
			}
		}
		
		int iterationCount = 0;
		
		System.out.println("Welcome to The Shopping App!");
		boolean vegetablesAndFruitsStat = true;
		boolean meatsStat = true;
		boolean beveragesStat = true;
		boolean snacksStat = true;
		boolean statusOfApp = true;
		while(statusOfApp){
			
			System.out.println("Please select an option:");
			System.out.println("[1]Go to shopping");
			System.out.println("[2]See the status of the fridge");
			System.out.println("[3]Exit");
			
			String selection = myObj.nextLine();
			if (selection.equals("1")){
				boolean statusOfShopping = true;
				String option ="";

				while(statusOfShopping) {
					boolean possibleAdd = leastWeight>shoppingBasket.remainingWeightCapacity();
					if (possibleAdd) {
						System.out.println("You do not have enough space to buy anymore item!!!");
						option = "3";}
					if (option.equals("")) {
						System.out.println("[1]Add an item to the basket");
						System.out.println("[2]See the basket");
						System.out.println("[3]Finish shopping");
						option = myObj.nextLine(); 
					}
					if (option.equals("1")) {
						for(int i =0; i<itemsArray.length;i++ ) {
							System.out.println("["+(i+1)+"]"+itemsArray[i].getItem_name());
						}
						int addOption = Integer.valueOf(myObj.nextLine());
						if ( 0 < addOption && addOption <= itemsArray.length) {
							option ="";
							boolean addResult = shoppingBasket.add(itemsArray[addOption-1]);
							if(!addResult) {
								System.out.println("This item exceeds remaining weight limit! "
											+"Please pick something lighter or finish shopping.");
							}
							else if (addResult){
								System.out.println("successfully added ");
							}
						}
						else {
							
							System.out.println("You have entered an Invalid number, try again please.");
							option ="";
						}
					}
					else if (option.equals("2")) {
						System.out.println("Shopping Basket");
						shoppingBasket.displayItems();
						option ="";
					}
					else if(option.equals("3")) {
						Item[] arrayShoppingBasket = (Item[]) shoppingBasket.toArray();
						int itemCount = shoppingBasket.getItemCount();
						for(int i=0;i<itemCount;i++) {
							Item transferedItem = arrayShoppingBasket[i];
							String goalComp = transferedItem.getItem_compartment();

							if(goalComp.equals("vegetables and fruits")) {
								if(vegetablesAndFruitsComp.remainingWeightCapacity()>=leastWeight) {
									shoppingBasket.transferTo(vegetablesAndFruitsComp, transferedItem);
								}
								else {
									shoppingBasket.remove(transferedItem);
									vegetablesAndFruitsStat=false;
									
								}
							}
							else if(goalComp.equals("meats")){
								if(meatsComp.remainingWeightCapacity()>=leastWeight) {
									shoppingBasket.transferTo(meatsComp, transferedItem);
								}
								else {
									shoppingBasket.remove(transferedItem);
									meatsStat=false;}
							}
							else if(goalComp.equals("beverages")){
								if(beveragesComp.remainingWeightCapacity()>=leastWeight) {
									shoppingBasket.transferTo(beveragesComp, transferedItem);
								}
								else {
									shoppingBasket.remove(transferedItem);
									beveragesStat=false;}
							}
							else {
								if(snacksComp.remainingWeightCapacity()>=leastWeight) {
									shoppingBasket.transferTo(snacksComp, transferedItem);
								}
								else {
									shoppingBasket.remove(transferedItem);
									snacksStat=false;}
							}							
						}
						if (!vegetablesAndFruitsStat&&!meatsStat&&!beveragesStat&&!snacksStat) {
							System.out.println("All compartments are full, the app will be closed. Hope you come back soon!");
							statusOfApp = false;
						}
						else if (!vegetablesAndFruitsStat) {
							System.out.println("Vegetables And Fruits compartment is full, exceeded items will be removed!");
						}
						else if (!meatsStat) {
							System.out.println("Meats compartment is full, exceeded items will be removed!");
						}
						else if (!beveragesStat) {
							System.out.println("Beverages compartment is full, exceeded items will be removed!");
						}
						else if (!snacksStat) {
							System.out.println("Snacks compartment is full, exceeded items will be removed!");
						}
						statusOfShopping = false;
						
					}
					else {
						System.out.println("You have entered an invalid option, try again please.");
					}
					
					iterationCount++;					
				}
					
			}
			else if(selection.equals("2")) {
				System.out.println("Vegetables and Fruits");
				vegetablesAndFruitsComp.displayItems();
				System.out.println("Meats");
				meatsComp.displayItems();
				System.out.println("Beverages");
				beveragesComp.displayItems();
				System.out.println("Snacks");
				snacksComp.displayItems();
			}
			else if(selection.equals("3")) {
				System.out.println("Thank you for being an Shopping App customer. We sincerely "
						+"appreciate your business and hope you come back soon!");
				statusOfApp=false;
			}
			else {
				System.out.println("You have entered an invalid option, try again please.");
			}
			
		}
	}
}
	
