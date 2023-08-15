package processes;

import listADT.List;

public class ProcessCreation {
	private List<Process> processObjects = new List<Process>();
	private int numOfProcess;

	public ProcessCreation(int numOfProcess) {
		this.numOfProcess = numOfProcess;
		processAdd();
	}
	
	private void processAdd() {
		for(int i=0;i<numOfProcess;i++) {
			Process tempProcess = new Process();
			processObjects.add(tempProcess);
		}
	}
	
	public List<Process> getProcessList(){
		return processObjects;
	}
	
	
	public void printAll() {
		for(int i=0;i<processObjects.size();i++) {
			System.out.println(((Process) processObjects.get(i)).getType());
			System.out.println(((Process) processObjects.get(i)).getPriority());
		}
	}
}
