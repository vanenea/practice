package com.chen.designPattern.state.version1;

/**
 * 状态接口类
 * @author Administrator
 *
 */
public interface State {

	void insertQuarter();
	
	void ejectQuarter();
	
	void turnCrank();
	
	void dispense();
}
