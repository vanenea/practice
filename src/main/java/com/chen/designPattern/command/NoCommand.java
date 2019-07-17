package com.chen.designPattern.command;

/**
 * null object, do nothing
 * @author Administrator
 *
 */
public class NoCommand implements Command {

	@Override
	public void excuted() {
		System.out.println("no command");
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
