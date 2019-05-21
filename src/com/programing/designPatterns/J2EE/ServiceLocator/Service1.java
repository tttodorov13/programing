package com.programing.designPatterns.J2EE.ServiceLocator;

public class Service1 implements Service {

	public void execute() {
		System.out.println("Executing Service1");
	}

	@Override public String getName() {
		return "Service1";
	}
}
