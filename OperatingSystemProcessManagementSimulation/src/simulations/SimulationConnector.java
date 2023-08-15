package simulations;

public class SimulationConnector {
	private Simulation starterSimulation;
	
	public SimulationConnector(int[] numOfSteps) {
		this.starterSimulation = new Simulation(null,numOfSteps[0], 1);
		Simulation nextSimulation = starterSimulation;
	    for (int i=1;i<(numOfSteps.length);i++) {
	    	Simulation tempSimulation = new Simulation(null,numOfSteps[i], i+1);
	    	nextSimulation.setNext(tempSimulation);
	    	nextSimulation = tempSimulation;
	    }
	}
	
	public Simulation getStarterSimulation() {
		return starterSimulation;
	}
	
}

