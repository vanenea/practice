package com.chen.designPattern.state;

public class GumballMachine {

	public final static int SOLD_OUT = 0;
	public final static int NO_QUARTER = 1;
	public final static int HAS_QUARTER = 2;
	public final static int SOLD = 3;
	
	int state = SOLD_OUT;
	int count = 0;
	public GumballMachine(int count) {
		this.count = count;
		if(count > 0) {
			state = NO_QUARTER;
		}
	}
}
