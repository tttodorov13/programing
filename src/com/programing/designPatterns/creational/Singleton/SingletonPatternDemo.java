package com.programing.designPatterns.creational.Singleton;

public class SingletonPatternDemo {

	public static void main(String[] args) {

		// Illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// SingletonClass singletonClass = new SingletonClass();

		// Get the only singletonClass available
		SingletonClass singletonClass = SingletonClass.getInstance();

		// show the message
		singletonClass.showMessage();

		// Get the only singletonClass available
		SingletonEnum singletonEnum = SingletonEnum.INSTANCE;

		System.out.println(singletonEnum.value);
	}
}
