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
	private boolean dirty = false;
	
	Process(){
		
	}
	
	public Process(int iProcessId, int iArrivalTime, int iBurstTime, int iPriority){
		this.setProcessId(iProcessId);
		this.setArrivalTime(iArrivalTime);
		this.setBurstTime(iBurstTime);
		this.setPriority(iPriority);
		this.setRemainingBTime(iBurstTime);
	}
	
	public int getBurstTime() {
		return iBurstTime;
	}

	public void setBurstTime(int iBurstTime) {
		this.iBurstTime = iBurstTime;
	}

	public int getArrivalTime() {
		return iArrivalTime;
	}

	public void setArrivalTime(int iArrivalTime) {
		this.iArrivalTime = iArrivalTime;
	}

	public int getPriority() {
		return iPriority;
	}

	public void setPriority(int iPriority) {
		this.iPriority = iPriority;
	}

	public int getProcessId() {
		return iProcessId;
	}

	public void setProcessId(int iProcessId) {
		this.iProcessId = iProcessId;
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

	public void setStartTime(int iStartTime) {
		this.iStartTime = iStartTime;
	}

	public int getEndTime() {
		return iEndTime;
	}

	public void setEndTime(int iEndTime) {
		this.iEndTime = iEndTime;
	}

	public int getRemainingBTime() {
		return iRemainingBTime;
	}

	public void setRemainingBTime(int iRemainingBTime) {
		this.iRemainingBTime = iRemainingBTime;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
}
