package com.chen.practice;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreatAnalyzer {
	static String threatData =
		    "58.27.82.161@02/10/2005\n" +
		    "204.45.234.40@02/11/2005\n" +
		    "58.27.82.161@02/11/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "[Next log section with different data format]";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(threatData);
		String reg = "(\\d+\\.\\d+\\.\\d+\\.\\d+)@(\\d+/\\d+/\\d+)";
		Matcher m = Pattern.compile(reg).matcher(threatData);
		while(scanner.hasNext(reg)) {
			scanner.next(reg);
			MatchResult ma = scanner.match();
			String ip = ma.group(1);
			String date = ma.group(2);
			System.out.format("ip:%S,date:%S\n", ip,date);
			
		}
		scanner.close();
	}
}
