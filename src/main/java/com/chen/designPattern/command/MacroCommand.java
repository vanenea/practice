package com.chen.designPattern.command;

public class MacroCommand implements Command {
	
	private Command[] command;
	
	public MacroCommand(Command[] command) {
		this.command = command;
	}
	
	@Override
	public void excuted() {
		for(int i=0; i<command.length; i++) {
			command[i].excuted();
		}
	}

	@Override
	public void undo() {
		for(int i=command.length-1; i>=0; i--) {
			command[i].undo();
		}
	}

}
