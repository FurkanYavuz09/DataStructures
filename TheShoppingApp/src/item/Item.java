package item;

public class Item {

	private String item_name;
	private String item_compartment;
	private int item_weight; //grams
	
	
	public Item(String item_name, String item_compartment, int item_weight) {
		
		
		
		this.item_name = item_name;
		this.item_compartment = item_compartment;
		this.item_weight = item_weight;
	}
	
	
	
	public String getItem_name() {
		return item_name;
	}
	
	
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	
	public String getItem_compartment() {
		return item_compartment;
	}
	
	
	public void setItem_compartment(String item_compartment) {
		this.item_compartment = item_compartment;
	}
	
	
	public int getItem_weight() {
		return item_weight;
	}
	public void setItem_weight(int item_weight) {
		this.item_weight = item_weight;
	}
	
	
	@Override
	public String toString() {
		return "Item [item_name=" + item_name + ", item_compartment=" + item_compartment + ", item_weight=" + item_weight + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item_compartment == null) {
			if (other.item_compartment != null)
				return false;
		} else if (!item_compartment.equals(other.item_compartment))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (item_weight != other.item_weight)
			return false;
		return true;
	}



}