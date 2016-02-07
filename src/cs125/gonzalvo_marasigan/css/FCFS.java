package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;
import java.util.Collections;

public class FCFS extends SchedulingAlgorithm{

	public FCFS(ArrayList<Process> processes) {
		super(processes);
	}

	@Override
	public void performScheduling() {
		Collections.sort(processes, new Process());
		int prevTurnaroundTime = 0;
		for(Process process: processes){
			if(prevTurnaroundTime != 0){
				process.setWaitingTime(prevTurnaroundTime - process.getArrivalTime());
			} else {
				process.setWaitingTime(0);
			}
			process.setTurnaroundTime(process.getBurstTime() + process.getWaitingTime());
			prevTurnaroundTime = process.getTurnaroundTime();
		}
		for(Process process: processes){
			dAverageWaitingTime += process.getWaitingTime();
			dAverageTurnaroundTime += process.getTurnaroundTime();
		}
		dAverageWaitingTime = dAverageWaitingTime/processes.size();
		dAverageTurnaroundTime = dAverageTurnaroundTime/processes.size();
		Collections.sort(processes);
		
	}
}
