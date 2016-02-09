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
	public void performScheduling(){
		ArrayList<Process> finished = new ArrayList<Process>();
		ArrayList<Process> queue = new ArrayList<Process>();
		Collections.sort(processes, new Process());
		Process currentProcess = processes.remove(0);
		int t = 0;
		for(Process process : processes){
			if(!queue.isEmpty()){
				if(currentProcess == null){
					currentProcess = queue.remove(queue.indexOf(Collections.min(queue, burstOrder)));
				}
				else if(currentProcess.getRemainingBTime() > Collections.min(queue, burstOrder).getRemainingBTime()){
					currentProcess.setEndTime(t);
					queue.add(currentProcess);
					currentProcess = queue.remove(queue.indexOf(Collections.min(queue, burstOrder)));
					currentProcess.setStartTime(t);
					currentProcess.setWaitingTime(currentProcess.getWaitingTime() + t - currentProcess.getEndTime());
				}
			}
			while(t != process.getArrivalTime() || currentProcess.getRemainingBTime() == 0){
				if(currentProcess.getRemainingBTime() == 0){
					currentProcess.setWaitingTime(currentProcess.getWaitingTime() - 
							currentProcess.getArrivalTime());
					currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() 
							+ currentProcess.getBurstTime());
					finished.add(currentProcess);
					currentProcess = null;
					break;
				}
				currentProcess.setRemainingBTime(currentProcess.getRemainingBTime() - 1);
				t++;
			}
			if(currentProcess != null && currentProcess.getRemainingBTime() > process.getBurstTime()){
				currentProcess.setEndTime(t);
				queue.add(currentProcess);
				currentProcess = process;
				currentProcess.setStartTime(t);
				currentProcess.setWaitingTime(currentProcess.getWaitingTime() + t - currentProcess.getEndTime());
			} else if(currentProcess == null) {
				currentProcess = process;
			} else {
				queue.add(process);
			}
		}
		while(!queue.isEmpty()){
			while(!queue.isEmpty() && currentProcess.getRemainingBTime() < Collections.min(queue, burstOrder).getRemainingBTime()){
				if(currentProcess.getRemainingBTime() == 0){
					currentProcess.setWaitingTime(currentProcess.getWaitingTime() - 
							currentProcess.getArrivalTime());
					currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() 
							+ currentProcess.getBurstTime());
					finished.add(currentProcess);
					currentProcess = queue.remove(queue.indexOf(Collections.min(queue, burstOrder)));
					currentProcess.setStartTime(t);
					currentProcess.setWaitingTime(currentProcess.getWaitingTime() + t - currentProcess.getEndTime());
				}
				currentProcess.setRemainingBTime(currentProcess.getRemainingBTime() - 1);
				t++;
			}
			if(currentProcess.getEndTime() != 0){
				currentProcess.setEndTime(t);
			}
			queue.add(currentProcess);
			currentProcess = queue.remove(queue.indexOf(Collections.min(queue, burstOrder)));
			currentProcess.setStartTime(t);
			currentProcess.setWaitingTime(currentProcess.getWaitingTime() + t - currentProcess.getEndTime());
		}
		currentProcess.setWaitingTime(currentProcess.getWaitingTime() + t - currentProcess.getEndTime());
		currentProcess.setWaitingTime(currentProcess.getWaitingTime() - 
				currentProcess.getArrivalTime());
		currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() 
				+ currentProcess.getBurstTime());
		finished.add(currentProcess);
		Collections.sort(finished);
		processes = finished;
		getAverage();
	}
}
