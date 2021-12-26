package com.chen.designPattern.command;

public class LightOnCommand implements Command {

	Light light;
	
	public LightOnCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void excuted() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
