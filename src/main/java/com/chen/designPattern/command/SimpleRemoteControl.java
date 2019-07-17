package com.chen.designPattern.command;

public class SimpleRemoteControl {
	Command[] onCommand;
	Command[] offCommand;
	
	public SimpleRemoteControl() {
		onCommand = new Command[7];
		offCommand = new Command[7];
		
		NoCommand noCommand = new NoCommand();
		for(int i=0; i<7; i++) {
			onCommand[i] = noCommand;
			offCommand[i] = noCommand;
		}
	}
	
	public void setCommand(int solt , Command on, Command off) {
		onCommand[solt] = on;
		offCommand[solt] = off;
	}
	
	public void onButtonWasPressed(int solt) {
		onCommand[solt].excuted();
	}
	
	public void offButtonWasPressed(int solt) {
		offCommand[solt].excuted();
	}
	
}
