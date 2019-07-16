package com.chen.designPattern.command;

public class SimpleRemoteControl {
	Command solt;
	
	public SimpleRemoteControl() {}
	
	public void setCommand(Command solt) {
		this.solt = solt;
	}
	
	public void buttonPressed() {
		solt.excuted();
	}
}
