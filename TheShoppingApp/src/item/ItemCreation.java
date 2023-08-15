package item;

import file_io.FileIO;

public class ItemCreation {
	
	FileIO file;
	Item[] itemarray;
	
	public ItemCreation() {
		file = new FileIO();
	}

	public Item[] ItemInitialization() {
		String[][] nItems = file.readInventory();
		itemarray = new Item[nItems.length];
		for (int i = 0;i<nItems.length;i++) {
			String itemName = nItems[i][0];
			String compartmentName = nItems[i][1];
			int itemWeight = Integer.parseInt(nItems[i][2]);
			itemarray[i] = new Item(itemName,compartmentName,itemWeight); 
		}
		return itemarray;
	}	
}