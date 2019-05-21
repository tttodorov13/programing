package com.programing.designPatterns.J2EE.BusinessDelegate;

public class JMSService implements BusinessService {

	@Override public void doProcessing() {
		System.out.println("Processing task by invoking JMS Service");
	}
}
