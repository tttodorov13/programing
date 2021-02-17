package com.programing.designPatterns.J2EE.FrontController;

public class FrontControllerPatternDemo {

	public static void main(String[] args) {

		FrontController frontController = new FrontController();
		frontController.dispatchRequest("HOME");
		frontController.dispatchRequest("STUDENT");
	}
}
