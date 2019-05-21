package com.programing.designPatterns.J2EE.InterceptingFilter;

public class Client {

	FilterManager filterManager;

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(String request) {
		filterManager.filterRequest(request);
	}
}
