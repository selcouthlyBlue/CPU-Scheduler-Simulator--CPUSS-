package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;

public abstract class SchedulingAlgorithm {
	protected ArrayList<Process> processes;
	protected int iAverageWaitingTime;
	protected int iAverageTurnaroundTime;
	
	public SchedulingAlgorithm(ArrayList<Process> processes){
		this.processes = processes;
	}
	
	public ArrayList<Process> getResults(){
		return this.processes;
	}
	
	public int getAverageWaitingTime() {
		return iAverageWaitingTime;
	}
	
	public void setAverageWaitingTime(int iAverageWaitingTime) {
		this.iAverageWaitingTime = iAverageWaitingTime;
	}
	
	public int getAverageTurnaroundTime() {
		return iAverageTurnaroundTime;
	}
	
	public void setAverageTurnaroundTime(int iAverageTurnaroundTime) {
		this.iAverageTurnaroundTime = iAverageTurnaroundTime;
	}
	
	public abstract void performScheduling();
}
