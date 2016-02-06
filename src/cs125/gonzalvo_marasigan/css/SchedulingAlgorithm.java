package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;

public abstract class SchedulingAlgorithm {
	private ArrayList<Process> processes;
	public SchedulingAlgorithm(ArrayList<Process> processes){
		this.processes = processes;
	}
}
