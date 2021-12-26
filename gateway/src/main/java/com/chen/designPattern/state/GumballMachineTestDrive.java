package com.chen.designPattern.state;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gm = new GumballMachine(8);
		gm.insertQuarter();
		gm.turnCrank();
		
		gm.insertQuarter();
		gm.insertQuarter();
		gm.ejectQuarter();
	}
}
