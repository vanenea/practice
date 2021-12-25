package com.chen.algorithms;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		Scanner sca = new Scanner("( 1 + ( ( 2 + 3 )  * ( 4 * 5 ) ) )");
		while (sca.hasNext()) {
			String str = sca.next();
			if("(".equals(str)) {
				
			} else if ("+".equals(str)) {
				ops.push("+");
			} else if("-".equals(str)) {
				ops.push("-");
			} else if("*".equals(str)) {
				ops.push("*");
			} else if("/".equals(str)) {
				ops.push("/");
			} else if(")".equals(str)) {
				double v1 = vals.pop();
				double v2 = vals.pop();
				String op = ops.pop();
				double v = 0;
				if("+".equals(op)) v = v1+v2;
				else if("-".equals(op)) v = v2-v1;
				else if("*".equals(op)) v = v2*v1;
				else if("/".equals(op)) v = v2/v1;
				vals.push(v);
			}else {
				vals.push(Double.parseDouble(str));
			}
		}
		sca.close();
		System.out.println(vals.pop());
	}
}
