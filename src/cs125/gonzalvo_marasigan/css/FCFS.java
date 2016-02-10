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
		int t = 0;
		for(Process process: processes){
			t += prevTurnaroundTime - process.getArrivalTime();
			process.start(t);
			process.destroy(t);
			prevTurnaroundTime = process.getTurnaroundTime();
		}
		getAverage();
	}
}
