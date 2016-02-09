package cs125.gonzalvo_marasigan.css;

import java.util.Comparator;

public class Process implements Comparable<Process>, Comparator<Process>{
	private int iProcessId;
	private int iArrivalTime;
	private int iBurstTime;
	private int iPriority;
	private int iWaitingTime = 0;
	private int iTurnaroundTime = 0;
	private int iRemainingBTime;
	private int iStartTime;
	private int iEndTime;
	
	Process(){
		
	}
	
	public Process(int iProcessId, int iArrivalTime, int iBurstTime, int iPriority){
		this.iProcessId = iProcessId;
		this.iArrivalTime = iArrivalTime;
		this.iBurstTime = iBurstTime;
		this.iPriority = iPriority;
		this.iRemainingBTime = iBurstTime;
	}
	
	public int getBurstTime() {
		return iBurstTime;
	}

	public int getArrivalTime() {
		return iArrivalTime;
	}

	public int getPriority() {
		return iPriority;
	}

	public int getProcessId() {
		return iProcessId;
	}

	public int getWaitingTime() {
		return iWaitingTime;
	}

	public void setWaitingTime(int iWaitingTime) {
		this.iWaitingTime = iWaitingTime;
	}

	public int getTurnaroundTime() {
		return iTurnaroundTime;
	}

	public void setTurnaroundTime(int iTurnaroundTime) {
		this.iTurnaroundTime = iTurnaroundTime;
	}

	@Override
	public int compareTo(Process process) {
		return Integer.compare(this.iProcessId, process.iProcessId);
	}

	@Override
	public int compare(Process p1, Process p2) {
		return Integer.compare(p1.iArrivalTime, p2.iArrivalTime);
	}

	public int getStartTime() {
		return iStartTime;
	}

	public int getEndTime() {
		return iEndTime;
	}

	public int getRemainingBTime() {
		return iRemainingBTime;
	}
	
	public void run(){
		this.iRemainingBTime--;
	}
	
	public void start(int time){
		this.iStartTime = time;
		this.iWaitingTime += time - iEndTime;
	}
	
	public void stop(int time){
		this.iEndTime = time;
	}
	
	public void destroy(){
		this.iWaitingTime -= this.iArrivalTime;
		this.iTurnaroundTime = this.iWaitingTime + this.iBurstTime;
	}
}
