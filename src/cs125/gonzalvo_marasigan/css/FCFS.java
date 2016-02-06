package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;
import java.util.Collections;

public class FCFS extends SchedulingAlgorithm{

	public FCFS(ArrayList<Process> processes) {
		super(processes);
	}

	@Override
	public void performScheduling() {
		Collections.sort(processes);
		int prevBurstTime = 0;
		for(Process process: processes){
			if(prevBurstTime != 0){
				process.setWaitingTime(prevBurstTime - process.getArrivalTime());
			} else {
				process.setWaitingTime(0);
			}
			process.setTurnaroundTime(process.getBurstTime() - process.getArrivalTime());
			prevBurstTime = process.getBurstTime();
		}
	}

}
