package iztechea;
import java.util.Random;
import java.util.Scanner;

import factory_line.*;
import workers.*;

public class ManufacturingAndOrderingSystem {
	
	public static void main(String[] args) {
		MarketingAnalyst marketingAnalyst=new MarketingAnalyst();
		StorageChief storageChief=new StorageChief();
		Customer customer=new Customer();
	    FactoryLine factoryLine=new FactoryLine(); 
		
		Scanner sc=new Scanner(System.in);
		System.out.printf("Enter the number of random request cycles: ");
		int cycleNum=sc.nextInt();
		sc.close();
		System.out.println();
		for (int i=0;i<cycleNum;i++) {
			Random rand = new Random();
			int roleNum =rand.nextInt(3);
			System.out.printf(String.valueOf(i+1)+"     ");
			if (roleNum==0){
				marketingAnalyst.randomProduct(factoryLine);	
			}
			else if (roleNum==1){
				storageChief.storeFurniture(factoryLine);
			}
			else if (roleNum==2){
				customer.buyFurniture(storageChief);
			}
			
		}
		if (!storageChief.sofaWarehouse.isEmpty()&&storageChief.sofaWarehouse.peek()!=null) {
			System.out.println("Sofa Warehouse is Manufactured"+storageChief.sofaWarehouse.peek().isManufactured());
			System.out.println("Sofa Warehouse is sold"+storageChief.sofaWarehouse.peek().isSold());
			System.out.println("Sofa Warehouse is Stored"+storageChief.sofaWarehouse.peek().isStored());
		}
		
		System.out.println();
		System.out.println("REPORT:");
		marketingAnalyst.reportFactoryLine(factoryLine);
		storageChief.reportWarehouses();
		storageChief.reportSoldFurnitures();
}
}
