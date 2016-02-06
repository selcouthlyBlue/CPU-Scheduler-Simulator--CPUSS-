package cs125.gonzalvo_marasigan.css;

public class Process implements Comparable<Process>{
	private int iProcessId;
	private int iArrivalTime;
	private int iBurstTime;
	private int iPriority;
	private int iWaitingTime;
	private int iTurnaroundTime;
	
	public Process(int iProcessId, int iArrivalTime, int iBurstTime, int iPriority){
		this.setProcessId(iProcessId);
		this.setArrivalTime(iArrivalTime);
		this.setBurstTime(iBurstTime);
		this.setPriority(iPriority);
	}
	
	@Override
	public int compareTo(Process process) {
		return 0;
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
}
