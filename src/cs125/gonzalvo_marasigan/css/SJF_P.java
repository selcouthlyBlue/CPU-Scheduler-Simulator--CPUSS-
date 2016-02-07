package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SJF_P extends SchedulingAlgorithm{
	
	private Comparator<Process> burstOrder = new Comparator<Process>(){
		@Override
		public int compare(Process p1, Process p2) {
			return p1.getRemainingBTime() - p2.getRemainingBTime();
		}
	};

	public SJF_P(ArrayList<Process> processes) {
		super(processes);
	}

	@Override
	public void performScheduling() {
		ArrayList<Process> finished = new ArrayList<Process>();
		Collections.sort(processes, new Process());
		Process currentProcess = processes.remove(0);
		currentProcess.setStartTime(0);
		int t = 0;
		while(!processes.isEmpty()){
			Process nextProcess = processes.get(0);
			if(t == nextProcess.getArrivalTime() || nextProcess.isDirty()){
				nextProcess = processes.remove(0);
				if(currentProcess.getRemainingBTime() == 0){
					currentProcess.setWaitingTime(currentProcess.getWaitingTime() - 
							currentProcess.getArrivalTime());
					currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() 
							+ currentProcess.getBurstTime());
					finished.add(currentProcess);
					currentProcess = nextProcess;
				}
				if(currentProcess.getRemainingBTime() > nextProcess.getRemainingBTime()){
					currentProcess.setEndTime(t);
					currentProcess.setDirty(true);
					processes.add(currentProcess);
					nextProcess.setWaitingTime(nextProcess.getWaitingTime() + t);
					nextProcess.setStartTime(t);
					currentProcess = nextProcess;
				}
				Collections.sort(processes, new Process());
			}
			currentProcess.setRemainingBTime(currentProcess.getRemainingBTime() - 1);
			t++;
		}
		this.processes = finished;
	}
}
