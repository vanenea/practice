package com.chen.designPattern.command;

/**
 * turn off the light
 * @author Administrator
 *
 */
public class LightOffCommand implements Command {
	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void excuted() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

	
}
