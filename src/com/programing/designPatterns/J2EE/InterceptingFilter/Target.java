package com.programing.designPatterns.J2EE.InterceptingFilter;

public class Target {

	public void execute(String request) {
		System.out.println("Executing request: " + request);
	}
}
