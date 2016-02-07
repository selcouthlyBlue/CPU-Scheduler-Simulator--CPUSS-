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
		ArrayList<Process> queue = new ArrayList<Process>();
		Collections.sort(processes, new Process());
		Process currentProcess = processes.get(0);
		
	}
}
