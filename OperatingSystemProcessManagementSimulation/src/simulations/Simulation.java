package simulations;

import computations.ComputationCreation;
import processes.*;

public class Simulation {

	private Simulation next = null;
	private int numOfSteps;
	private ComputationCreation computations;
	private ProcessCreation processes;
	private int simulationNumber;
	public Simulation(Simulation next,int numOfSteps,int simulationNumber) {
		this.simulationNumber = simulationNumber;
        this.next = null;
		this.numOfSteps = numOfSteps;
		this.processes =new ProcessCreation(this.numOfSteps);
		this.computations = new ComputationCreation(processes.getProcessList());
	}

	public ComputationCreation getComputations() {
		return computations;
	}

	public ProcessCreation getProcesses() {
		return processes;
	}
	
	public void setNext(Simulation nextSimulation) {
		this.next = nextSimulation;
	}
	public Simulation getNext() {
		return next;
	}
	
	public int getSimulationNumber() {
		return simulationNumber;
	}
	
	public void setSimulationName(int simulationNumber) {
		this.simulationNumber = simulationNumber;
	}
}