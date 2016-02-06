package cs125.gonzalvo_marasigan.css;

import java.util.ArrayList;

public class RR extends SchedulingAlgorithm {
	
	private int iQuantum;

	public RR(ArrayList<Process> processes) {
		super(processes);
	}

	@Override
	public void performScheduling() {
		// TODO Auto-generated method stub
	}

	public void setQuantum(int iQuantum) {
		this.iQuantum = iQuantum;
	}

}
