package com.programing.designPatterns.J2EE.ServiceLocator;

public class Service2 implements Service {

	public void execute() {
		System.out.println("Executing Service2");
	}

	@Override public String getName() {
		return "Service2";
	}
}
