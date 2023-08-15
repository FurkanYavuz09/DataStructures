package factory;

public class Dresser implements IProduct{
	private boolean manufactured=false;
	private boolean stored=false;
	private boolean sold=false;
	
	public void setManufactured(boolean manufactured) {
		this.manufactured = manufactured;
	}
	public void setStored(boolean stored) {
		this.stored = stored;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public boolean isManufactured() {
		return manufactured;
	}
	public boolean isStored() {
		return stored;
	}
	public boolean isSold() {
		return sold;
	}
	public String getName() {
		return "Dresser";
	}
}
