package com.chen.designPattern.command;

public class LightCommand implements Command {

	Light light;
	
	public LightCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void excuted() {
		light.on();
	}

}
