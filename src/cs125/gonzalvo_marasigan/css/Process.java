package cs125.gonzalvo_marasigan.css;

public class Process implements Comparable<Process>{
	private int iProcessId;
	private int iArrivalTime;
	private int iBurstTime;
	private int iPriority;
	
	public Process(int iProcessId, int iArrivalTime, int iBurstTime, int iPriority){
		this.setiProcessId(iProcessId);
		this.setiArrivalTime(iArrivalTime);
		this.setiBurstTime(iBurstTime);
		this.setiPriority(iPriority);
	}
	
	@Override
	public int compareTo(Process process) {
		return 0;
	}

	public int getiBurstTime() {
		return iBurstTime;
	}

	public void setiBurstTime(int iBurstTime) {
		this.iBurstTime = iBurstTime;
	}

	public int getiArrivalTime() {
		return iArrivalTime;
	}

	public void setiArrivalTime(int iArrivalTime) {
		this.iArrivalTime = iArrivalTime;
	}

	public int getiPriority() {
		return iPriority;
	}

	public void setiPriority(int iPriority) {
		this.iPriority = iPriority;
	}

	public int getiProcessId() {
		return iProcessId;
	}

	public void setiProcessId(int iProcessId) {
		this.iProcessId = iProcessId;
	}
}
