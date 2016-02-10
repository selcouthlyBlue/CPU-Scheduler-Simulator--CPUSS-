package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;

public class RR extends SchedulingAlgorithm {
	
	private int iQuantum;

	public RR(ArrayList<Process> processes, int iQuantum) {
		super(processes);
		this.iQuantum = iQuantum;
	}

	@Override
	public void performScheduling() {
		// TODO Auto-generated method stub
	}

	public int getQuantum() {
		return iQuantum;
	}

}
