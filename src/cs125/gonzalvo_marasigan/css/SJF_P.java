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
		Collections.sort(this.processes, new Process());
		Process currentProcess = this.processes.remove(0);
		currentProcess.setStartTime(0);
		int t = 0;
		while(!this.processes.isEmpty()){
			Process nextProcess = this.processes.get(0);
			if(t == nextProcess.getArrivalTime() || nextProcess.isDirty()){
				if(currentProcess.getRemainingBTime() == 0){
					currentProcess.setWaitingTime(currentProcess.getWaitingTime() - 
							currentProcess.getArrivalTime());
					currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() 
							+ currentProcess.getBurstTime());
					finished.add(currentProcess);
					for(int i = 0; i < this.processes.size(); i++){
						if(currentProcess.getProcessId() == this.processes.get(i).getProcessId()){
							this.processes.remove(i);
							break;
						}
					}
					currentProcess = nextProcess;
				}
				Process earlyProcess = Collections.min(this.processes, burstOrder);
				if(currentProcess.getRemainingBTime() > earlyProcess.getRemainingBTime() && earlyProcess.getArrivalTime() <= t){
					boolean found = false;
					for(Process process : this.processes){
						if(process.equals(currentProcess)){
							found = true;
							break;
						}
					}
					if(!found){
						currentProcess.setEndTime(t);
						this.processes.add(currentProcess);
					}
					earlyProcess.setWaitingTime(earlyProcess.getWaitingTime() + t - earlyProcess.getEndTime());
					earlyProcess.setStartTime(t);
					currentProcess = earlyProcess;
					nextProcess = this.processes.remove(0);
					if(!nextProcess.isDirty()){
						nextProcess.setDirty(true);
						this.processes.add(nextProcess);
					}
				}
				else if(currentProcess.getRemainingBTime() > nextProcess.getRemainingBTime()){
					currentProcess.setEndTime(t);
					currentProcess.setDirty(true);
					this.processes.add(currentProcess);
					nextProcess = this.processes.remove(0);
					nextProcess.setWaitingTime(nextProcess.getWaitingTime() + t - nextProcess.getEndTime());
					nextProcess.setStartTime(t);
					currentProcess = nextProcess;
				}
			}
			currentProcess.setRemainingBTime(currentProcess.getRemainingBTime() - 1);
			t++;
		}
		finished.add(currentProcess);
		Collections.sort(finished);
		this.processes = finished;
	}
}
