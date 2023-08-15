package computations;

import processes.*;
public class Computation {

	private String id;
	private IProcess process;
	private int occupation;
	
	public Computation(IProcess process,String id) {
		this.process = process;
		this.id = id;
		randOccupationTime();
	}
	
	public void randOccupationTime() {
		setOccupation((int) Math.floor(Math.random()*(10)+1));
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public int getProcessPriority() {
		return process.getPriority();
	}
	
	public String getProcessType() {
		return process.getType();
	}
	
	public void setProcess(IProcess process) {
		this.process = process;
	}
	
	public int getOccupation() {
		return occupation;
	}
	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}
	
	public String getString() {
		return id + ","+ getProcessType()+","+ getOccupation()+"ns";
	}
	
}
