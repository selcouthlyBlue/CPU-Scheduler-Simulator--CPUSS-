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
		ArrayList<Process> queue = new ArrayList<Process>();
		HashMap<Integer, Process> processMap = new HashMap<>();
		for(Process process : processes){
			processMap.put(process.getProcessId(), process);
		}
		Collections.sort(processes, new Process());
		Process currentProcess = processes.get(0);
		for(int t = 0; ; t++){
			for(int i = 1; i < processes.size(); i++){
				if(t == processes.get(i).getArrivalTime()){
					if(currentProcess.getRemainingBTime() > processes.get(i).getRemainingBTime()){
						//modify waiting time, start time, remaining burst time, 
						//and end time values of currentProcess
						if(currentProcess.getRemainingBTime() != 0){
							queue.add(currentProcess);
						}
						processMap.replace(currentProcess.getProcessId(), currentProcess);
						currentProcess = processes.get(i);
					}
				}
			}
			Collections.sort(queue, burstOrder);
			currentProcess.setiRemainingBTime(currentProcess.getiRemainingBTime() - 1);
		}
	}
}
