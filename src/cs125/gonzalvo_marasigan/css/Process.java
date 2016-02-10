package cs125.gonzalvo_marasigan.css;

import java.util.Comparator;

public class Process implements Comparable<Process>, Comparator<Process>{
	private int iProcessId;
	private int iArrivalTime;
	private int iBurstTime;
	private int iPriority;
	private int iWaitingTime;
	private int iTurnaroundTime;
	private int iRemainingBTime;
	private int iCurrentPriority;
	private int iStartTime;
	private int iEndTime;
	
	Process(){
		
	}
	
	public Process(int iProcessId, int iArrivalTime, int iBurstTime, int iPriority){
		this.iProcessId = iProcessId;
		this.iArrivalTime = iArrivalTime;
		this.iBurstTime = iBurstTime;
		this.iPriority = iPriority;
		this.iRemainingBTime = this.iBurstTime;
		this.iCurrentPriority = this.iPriority;
	}
	
	public Process(int processId, int startTime, int endTime) {
		this.iProcessId = processId;
		this.iStartTime = startTime;
		this.iEndTime = endTime;
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

	public int getStartTime() {
		return iStartTime;
	}

	public int getEndTime() {
		return iEndTime;
	}

	public int getRemainingBTime() {
		return iRemainingBTime;
	}
	
	public int getCurrentPriority() {
		return iCurrentPriority;
	}

	public void age() {
		this.iCurrentPriority++;
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
	
	public void destroy(int time){
		this.iEndTime = time + this.iRemainingBTime;
		this.iWaitingTime -= this.iArrivalTime;
		this.iTurnaroundTime = this.iWaitingTime + this.iBurstTime;
	}
	
	public void reset(){
		this.iRemainingBTime = this.iBurstTime;
		this.iCurrentPriority = this.iPriority;
		this.iWaitingTime = 0;
		this.iTurnaroundTime = 0;
		this.iStartTime = 0;
		this.iEndTime = 0;
	}

	@Override
	public int compareTo(Process process) {
		return Integer.compare(this.iProcessId, process.iProcessId);
	}

	@Override
	public int compare(Process p1, Process p2) {
		return Integer.compare(p1.iArrivalTime, p2.iArrivalTime);
	}
}
