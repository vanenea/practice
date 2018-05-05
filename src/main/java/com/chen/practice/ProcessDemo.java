package com.chen.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ProcessDemo {

	public static void command(String command) {
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),System.getProperty("sun.jnu.encoding")));
			String s;
			while((s = reader.readLine())!=null) {
				System.out.println(s);
			}
			BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream(),System.getProperty("sun.jnu.encoding")));
			while((s = error.readLine())!=null) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			if(!command.startsWith("CMD /C")) {
				command("CMD /C "+command);
			}else {
				new RuntimeException();
			}
		}
	}
	
	public static void main(String[] args) {
		command("java");
		System.out.println(Charset.forName(System.getProperty("sun.jnu.encoding")));
		System.out.println(System.getProperty("sun.jnu.encoding"));
	}
}
