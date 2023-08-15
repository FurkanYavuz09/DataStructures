package workers;

import java.util.Random;
import factory.*;
import factory_line.*;

public class MarketingAnalyst {
	private int numOfProduct=6;
	
	
	public MarketingAnalyst() {
		
	}
	public void randomProduct(FactoryLine queue ) {
		Random rand = new Random();
		int num =rand.nextInt(numOfProduct);
		boolean result;
		if (num==0) {
			Sofa product =new Sofa();
			result = queue.enqueue(product);
			if(result==true)
				product.setManufactured(true);
		}
		else if (num==1) {
			Bed product =new Bed();
			result = queue.enqueue(product);
			if(result==true)
				product.setManufactured(true);
		}
		else if (num==2) {
			Chair product =new Chair();
			result=queue.enqueue(product);
			if(result==true)
				product.setManufactured(true);
		}
		else if (num==3) {
			Dresser product =new Dresser();
			result=queue.enqueue(product);
			if(result==true)
				product.setManufactured(true);
		}
		else if (num==4) {
			Table product =new Table();
			result= queue.enqueue(product);
			if(result==true)
				product.setManufactured(true);
		}
		else if(num==5){
			Bookcase product =new Bookcase();
			result=queue.enqueue(product);
			if(result==true)
				product.setManufactured(true);
		}	
	}
	
	public void reportFactoryLine(FactoryLine queue) {
		queue.reportLine();
	}
}
