package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		ArrayList<Process> queue = new ArrayList<Process>();
		Collections.sort(processes, new Process());
		Process currentProcess = processes.remove(0);
		currentProcess.setStartTime(0);
		int t = 0;
		while(!processes.isEmpty()){
			Process nextProcess = processes.get(0);
			if(t == nextProcess.getArrivalTime()){
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
					queue.add(currentProcess);
					nextProcess.setWaitingTime(currentProcess.getBurstTime() 
							- currentProcess.getRemainingBTime());
					nextProcess.setStartTime(t);
					currentProcess = nextProcess;
				}
			}
			Collections.sort(processes, new Process());
			currentProcess.setRemainingBTime(currentProcess.getRemainingBTime() - 1);
			t++;
		}
		Collections.sort(queue, burstOrder);
		while(!queue.isEmpty()){
			Process nextProcess = queue.get(0);
			if(currentProcess.getRemainingBTime() == 0){
				currentProcess.setWaitingTime(currentProcess.getWaitingTime() - 
						currentProcess.getArrivalTime());
				currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() 
						+ currentProcess.getBurstTime());
				finished.add(currentProcess);
				nextProcess = queue.remove(0);
				currentProcess = nextProcess;
			}
			if(currentProcess.getRemainingBTime() > nextProcess.getRemainingBTime()){
				currentProcess.setEndTime(t);
				queue.add(currentProcess);
				nextProcess = queue.remove(0);
				nextProcess.setWaitingTime(nextProcess.getWaitingTime() + t);
				nextProcess.setStartTime(t);
				currentProcess = nextProcess;
			}
			Collections.sort(queue, burstOrder);
			currentProcess.setRemainingBTime(currentProcess.getRemainingBTime() - 1);
			t++;
		}
		finished.add(currentProcess);
		Collections.sort(finished);
		this.processes = finished;
	}
}
