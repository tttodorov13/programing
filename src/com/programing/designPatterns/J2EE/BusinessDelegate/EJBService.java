package com.programing.designPatterns.J2EE.BusinessDelegate;

public class EJBService implements BusinessService {

	@Override public void doProcessing() {
		System.out.println("Processing task by invoking EJB Service");
	}
}
