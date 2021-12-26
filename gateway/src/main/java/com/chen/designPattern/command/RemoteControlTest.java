package com.chen.designPattern.command;

public class RemoteControlTest {

	public static void main(String[] args) {
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		SimpleRemoteControl src = new SimpleRemoteControl();
		
		src.setCommand(0, lightOnCommand, lightOffCommand);
		src.onButtonWasPressed(0);
		src.offButtonWasPressed(0);
	
		
		System.out.println("====================");
		Command[] command = {lightOnCommand, lightOffCommand};
		MacroCommand macroCommand = new MacroCommand(command);
		src.setCommand(0, macroCommand, null);
		src.onButtonWasPressed(0);
		
		src.undo();
	}
}
