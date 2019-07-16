package com.chen.designPattern.command;

public class RemoteControlTest {

	public static void main(String[] args) {
		Light light = new Light();
		LightCommand lightCommand = new LightCommand(light);
		SimpleRemoteControl src = new SimpleRemoteControl();
		src.setCommand(lightCommand);
		src.buttonPressed();
		
	}
}
