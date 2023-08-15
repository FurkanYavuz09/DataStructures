package os_process_management_simulation;

import computations.ComputationCreation;
import simulations.Simulation;

public class SimulationReport {

	private Simulation simulation;
	public SimulationReport() {
	}

	public void printAllReport(Simulation simulation) {
		this.simulation = simulation;
		printSimulationNumber();
		printComputationQueue();
		ComputationCreation computations = this.simulation.getComputations();
		computations.printComputationReport();
	}
	
	private void printSimulationNumber() {
		System.out.println("Simulation Number: "+simulation.getSimulationNumber());
	}
	
	private void printComputationQueue() {
		System.out.println(simulation.getComputations().getString());
	}	
}



 
 
 
 