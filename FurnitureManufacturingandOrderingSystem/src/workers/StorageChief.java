package workers;
import warehouse.*;
import factory_line.*;
import factory.*;

public class StorageChief {
		
	public Warehouse<Sofa> sofaWarehouse=new Warehouse("Sofa");
	Warehouse<Bed> bedWarehouse=new Warehouse("Bed");
	Warehouse<Chair> chairWarehouse=new Warehouse("Chair");
	Warehouse<Dresser> dresserWarehouse=new Warehouse("Dresser");
	Warehouse<Table> tableWarehouse=new Warehouse("Table");
	Warehouse<Bookcase> bookcaseWarehouse=new Warehouse("Bookcase");
	
	Warehouse<Sofa> soldSofa=new Warehouse("Sofa");
	Warehouse<Bed> soldBed=new Warehouse("Bed");
	Warehouse<Chair> soldChair=new Warehouse("Chair");
	Warehouse<Dresser> soldDresser=new Warehouse("Dresser");
	Warehouse<Table> soldTable=new Warehouse("Table");
	Warehouse<Bookcase> soldBookcase=new Warehouse("Bookcase");
	
	
	public void StorageChief() {	
	}
	
	
	public void storeFurniture(FactoryLine queue) {
		boolean storeResult = false;
		if (queue.isEmpty()) {
			queue.dequeue();
		}
		
		else {
			 String productType=queue.getFrontName();
			 
			 if (productType.equals("Sofa")){
				 Sofa sofa=(Sofa)queue.dequeue();
				 storeResult =sofaWarehouse.push(sofa);
				 if(storeResult) {
					 sofa.setStored(true);
				 }
			 }
			 
			 else if (productType.equals("Bed")){
				 Bed bed=(Bed)queue.dequeue();
				 storeResult =bedWarehouse.push(bed);
				 if(storeResult) {
					 bed.setStored(true);
				 }
			 }
			 
			 else if (productType.equals("Chair")){
				 Chair chair=(Chair)queue.dequeue();
				 storeResult =chairWarehouse.push(chair);
				 if(storeResult) {
					 chair.setStored(true);
				 }
			 }
			 
			 else if (productType.equals("Dresser")){
				 Dresser dresser=(Dresser)queue.dequeue();
				 storeResult =dresserWarehouse.push(dresser);
				 if(storeResult) {
					 dresser.setStored(true);
				 }
			 }
			 
			 else if (productType.equals("Table")){
				 Table table=(Table)queue.dequeue();
				 storeResult =tableWarehouse.push(table);
				 if(storeResult) {
					 table.setStored(true);
				 }
			 }
			 
			 else if (productType.equals("Bookcase")){
				 Bookcase bookcase=(Bookcase)queue.dequeue();
				 storeResult =bookcaseWarehouse.push(bookcase);
				 if(storeResult) {
					 bookcase.setStored(true);
				 }
			 }
		}	
	}
	
	public void sellFurniture(int productNum) {
		boolean sellResult = false;
		if (productNum==0) {
			 Sofa soldSofaF =sofaWarehouse.pop();
			 if(soldSofaF!=null) {
				 sellResult = soldSofa.push(soldSofaF);
				 if(sellResult) {
					 soldSofaF.setSold(true);
				 }
			 }
				 
		}
		
		else if (productNum==1) {
			Bed soldBedF= bedWarehouse.pop();
			 if(soldBedF!=null) {
				 soldBed.push(soldBedF);
				 if(sellResult) {
					 soldBedF.setSold(true);
				 }
			 }
		}
		
		else if (productNum==2) {
			Chair soldChairF = chairWarehouse.pop();
			 if(soldChairF!=null) {
				 soldChair.push(soldChairF);
				 if(sellResult) {
					 soldChairF.setSold(true);
				 }
			 }
		}
		
		else if (productNum==3) {
			Dresser soldDresserF = dresserWarehouse.pop();
			 if(soldDresserF!=null) {
				 soldDresser.push(soldDresserF);
				 if(sellResult) {
					 soldDresserF.setSold(true);
				 }
			 }
		}
		
		else if (productNum==4) {
			Table soldTableF = tableWarehouse.pop();
			 if(soldTableF!=null) {
				 soldTable.push(soldTableF);
				 if(sellResult) {
					 soldTableF.setSold(true);
				 }
			 }
		}
		
		else if (productNum==5) {
			Bookcase soldBookcaseF =bookcaseWarehouse.pop();
			 if(soldBookcaseF!=null) {
				 soldBookcase.push(soldBookcaseF);
				 if(sellResult) {
					 soldBookcaseF.setSold(true);
				 }
			 }
		}
	}
	
	public void reportWarehouses() {
		System.out.println();
		sofaWarehouse.reportWarehouse();
		bedWarehouse.reportWarehouse();
		chairWarehouse.reportWarehouse();
		dresserWarehouse.reportWarehouse();
		tableWarehouse.reportWarehouse();
		bookcaseWarehouse.reportWarehouse();
	}
	
	public void reportSoldFurnitures() {
		System.out.println();
		soldSofa.reportSoldFurniture();
		soldBed.reportSoldFurniture();
		soldChair.reportSoldFurniture();
		soldDresser.reportSoldFurniture();
		soldTable.reportSoldFurniture();
		soldBookcase.reportSoldFurniture();
	}
}
