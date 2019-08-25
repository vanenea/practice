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
	
	/**
	 * 投钞票
	 */
	public void insertQuarter() {
		if(state == SOLD_OUT) {
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if(state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if(state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter");
		} else if(state == SOLD) {
			System.out.println("Please wait, we're already giving you a gumball");
		}
	}
	
	/**
	 * 退钱
	 */
	public void ejectQuarter() {
		if(state == SOLD_OUT) {
			System.out.println("you can't eject, you haven't inserted a quarter yet");
		} else if(state == NO_QUARTER) {
			System.out.println("you don't inserted quarter");
		} else if(state == HAS_QUARTER) {
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if(state == SOLD) {
			System.out.println("Sorry, you already turned the crank");
		}
	}
	
	/**
	 * 摇动手柄
	 */
	public void turnCrank() {
		if(state == SOLD) {
			System.out.println("Turning twice doesn't get you another gumball!");
		} else if(state == NO_QUARTER) {
			System.out.println("You turned but there's no quarter");
		} else if(state == SOLD_OUT) {
			System.out.println("You turned but there's no quarter");
		} else if(state == HAS_QUARTER) {
			System.out.println("You turned...");
			state  = SOLD;
			dispense();
		}
	}
	
	public void dispense() {
		if(state == SOLD) {
			System.out.println("A gumball comes rolling out the solt");
			count -= 1;
			if(count == 0) {
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		} else if(state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if(state == NO_QUARTER) {
			System.out.println("You need to pay first");
		} else if(state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}
}
