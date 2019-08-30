package com.chen.designPattern.state.version1;

public class GumballMachine {

	private State noQuarterState;
	private int count;
	
	public GumballMachine(int num) {
		noQuarterState = new NoQuarterState(this);
	}
	
}
