package cs125.gonzalvo_marasigan.css;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

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
	
	public double getAverageTurnaroundTime() {
		return dAverageTurnaroundTime;
	}
	
	public void generateResult(String sOutputFile) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(sOutputFile, false));
		PrintWriter pw = new PrintWriter(bw);
		for(Process process : processes){
			StringBuilder sb = new StringBuilder();
			sb.append(process.getProcessId());
			sb.append(",");
			sb.append(process.getArrivalTime());
			sb.append(",");
			sb.append(process.getBurstTime());
			sb.append(",");
			sb.append(process.getPriority());
			sb.append(",");
			sb.append(process.getWaitingTime());
			sb.append(",");
			sb.append(process.getTurnaroundTime());
			pw.println(sb.toString());
		}
		pw.println(getAverageWaitingTime());
		pw.println(getAverageTurnaroundTime());
		bw.close();
	}
	
	public void getAverage(){
		Collections.sort(processes);
		for(Process process: processes){
			dAverageWaitingTime += process.getWaitingTime();
			dAverageTurnaroundTime += process.getTurnaroundTime();
		}
		dAverageWaitingTime = dAverageWaitingTime/processes.size();
		dAverageTurnaroundTime = dAverageTurnaroundTime/processes.size();
	}
	
	public abstract void performScheduling();
}
