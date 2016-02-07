package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;

public abstract class SchedulingAlgorithm {
	protected ArrayList<Process> processes;
	protected double dAverageWaitingTime;
	protected double dAverageTurnaroundTime;
	
	public SchedulingAlgorithm(ArrayList<Process> processes){
		this.processes = processes;
	}
	
	public ArrayList<Process> getResults(){
		return this.processes;
	}
	
	public double getAverageWaitingTime() {
		return dAverageWaitingTime;
	}
	
	public void setAverageWaitingTime(int iAverageWaitingTime) {
		this.dAverageWaitingTime = iAverageWaitingTime;
	}
	
	public double getAverageTurnaroundTime() {
		return dAverageTurnaroundTime;
	}
	
	public void setAverageTurnaroundTime(int iAverageTurnaroundTime) {
		this.dAverageTurnaroundTime = iAverageTurnaroundTime;
	}
	
	public abstract void performScheduling();
}
