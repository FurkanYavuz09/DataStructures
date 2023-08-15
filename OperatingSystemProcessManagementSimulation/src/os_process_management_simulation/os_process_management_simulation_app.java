package os_process_management_simulation;

import processes.Process;
import processes.ProcessCreation;
import simulations.Simulation;
import simulations.SimulationConnector;
import computations.Computation;
import computations.ComputationCreation;
import computations.PriorityComputationQueue;
import listADT.*;

public class os_process_management_simulation_app {

	public static void main(String[] args) {
		int[] numOfSimulations = {3,5,10};
		SimulationConnector simulations = new SimulationConnector(numOfSimulations);
		Simulation currentSimulation = simulations.getStarterSimulation();
		SimulationReport report = new SimulationReport();
		for (int i=0;i<(numOfSimulations.length);i++) {
			report.printAllReport(currentSimulation);
			currentSimulation=currentSimulation.getNext();
		}
		
	}
}

