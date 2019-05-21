package com.programing.designPatterns.J2EE.InterceptingFilter;

public class DebugFilter implements Filter {

	public void execute(String request) {
		System.out.println("request log: " + request);
	}
}
