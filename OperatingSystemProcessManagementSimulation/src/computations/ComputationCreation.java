package computations;

import listADT.List;
import node.QNode;
import processes.IProcess;
import processes.Process;

public class ComputationCreation {

	private PriorityComputationQueue<Computation> computationQueue = new PriorityComputationQueue<>();
	private int totalNumOfComputations = 0;
	private int highNumOfComputations = 0;
	private int normalNumOfComputations = 0;
	private int lowNumOfComputations = 0;
	private int highWaitingTime = 0;
	private int normalWaitingTime = 0;
	private int lowWaitingTime = 0;
	private int numOfProcesses;
	private double averageHigh=0;
	private double averageNormal=0;
	private double averageLow=0;
	
	public ComputationCreation(List<Process> processObjects) {
		processAdd(processObjects);
		updateCounters();
		calcAverages();
	}
	
	private void processAdd(List<Process> processObjects) {	
		this.numOfProcesses = processObjects.size();
		for(int i=0;i<numOfProcesses;i++) {
			Computation tempComputation = new  Computation((IProcess) processObjects.get(i),"P"+(i+1));		
			computationQueue.enqueue(tempComputation);
		}
	}
	
	public PriorityComputationQueue<Computation> getComputationQueue(){
		return computationQueue;
	}
	
	public String getString() {
		String result = "Computation Queue: ";
		QNode front =getComputationQueue().getFront();
		boolean truth = true;
		while(truth) {
			result += ((Computation) front.getKey()).getString()+" <- ";
			front = (QNode) front.getNext();
			if(front.getNext()==(null)) {truth = false;}
		}
		result +=((Computation) front.getKey()).getString();
		return result;
	}
	
	public void updateCounters() {
		QNode tempNext =getComputationQueue().getFront();
		Computation tempFront = (Computation)tempNext.getKey();
		//tempNext =tempNext.getNext().getKey();
		for(int i=0;i<numOfProcesses;i++) {
			totalNumOfComputations++;
			if(tempFront.getProcessPriority()==1) {
				highNumOfComputations++;
				if(tempNext.getNext()==null) {
					break;
				}
				else if(((Computation)tempNext.getNext().getKey()).getProcessPriority()==1 ) {
					highWaitingTime+=tempFront.getOccupation();
				}
				else if (((Computation)tempNext.getNext().getKey()).getProcessPriority()==2) {
					normalWaitingTime+=highWaitingTime+tempFront.getOccupation();
				}
				else if (((Computation)tempNext.getNext().getKey()).getProcessPriority()==3) {
					lowWaitingTime+=highWaitingTime+tempFront.getOccupation();
				}
			}
			else if(tempFront.getProcessPriority()==2) {
				normalNumOfComputations++;
				if(tempNext.getNext()==null) {
					break;
				}
				else if(((Computation)tempNext.getNext().getKey()).getProcessPriority()==2 ) {
					normalWaitingTime+=tempFront.getOccupation();
				}
				else if (((Computation)tempNext.getNext().getKey()).getProcessPriority()==3) {
					lowWaitingTime+=normalWaitingTime+tempFront.getOccupation();
				}
			}
			else if(tempFront.getProcessPriority()==3) {
				lowNumOfComputations++;
				if(tempNext.getNext()==null) {
					break;
				}
				else if(((Computation)tempNext.getNext().getKey()).getProcessPriority()==3) {
					lowWaitingTime+=tempFront.getOccupation();
				}
			}
			tempFront = ((Computation)tempNext.getNext().getKey());
			tempNext = tempNext.getNext();
			
		}			
	}
	
	private double getTotalTime() {
		if(lowWaitingTime!=0) {
			return (double)lowWaitingTime;
		}
		else if(normalWaitingTime!=0) {
			return (double)normalWaitingTime;
		}
		else {
			return (double)highWaitingTime;
		}
	}
	
	private void calcAverages() {
		if(this.highNumOfComputations!=0) {this.averageHigh=(double)this.highWaitingTime/(double)this.highNumOfComputations;}
		if(this.normalNumOfComputations!=0) {this.averageNormal=(double)this.normalWaitingTime/(double)this.normalNumOfComputations;}
		if(this.lowNumOfComputations!=0) {this.averageLow=(double)this.lowWaitingTime/(double)this.lowNumOfComputations;}
	}
	
	public void printComputationReport() {
		System.out.println("Total numbers of computations : "+this.totalNumOfComputations);
		System.out.println();
		System.out.println("Total waiting time: "+getTotalTime());
		System.out.println("Average waiting time:"+(getTotalTime()/this.totalNumOfComputations));
		System.out.println();
		System.out.println("Total number of computations for High: "+this.highNumOfComputations);
		System.out.println("Total number of computations for Normal: "+this.normalNumOfComputations);
		System.out.println("Total number of computations for Low: "+this.lowNumOfComputations);
		System.out.println();
		System.out.println("Total waiting time for High: "+this.highWaitingTime);
		System.out.println("Average waiting time for High: "+averageHigh);
		System.out.println();
		System.out.println("Total waiting time for Normal: "+this.normalWaitingTime);
		System.out.println("Average waiting time for Normal: "+averageNormal);
		System.out.println();
		System.out.println("Total waiting time for Low: "+this.lowWaitingTime);
		System.out.println("Average waiting time for Low: "+averageLow);
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
}


