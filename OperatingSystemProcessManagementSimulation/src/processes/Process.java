package processes;



public class Process implements IProcess{
	
	private String type;
	private int priority;
		

	public Process() {
		randType();
	}

	public void randType() {
		int tempType =(int) Math.floor(Math.random()*(3)+1);
		setPriority(tempType);
		if(tempType ==1) {setType("High");}
		else if(tempType ==2) {setType("Normal");}
		else {setType("Low");}
	}
	
	public String getType() {		
		return type;
	}

	public int getPriority() {
		return priority;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
