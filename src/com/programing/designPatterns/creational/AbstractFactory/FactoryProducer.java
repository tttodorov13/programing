package com.programing.designPatterns.creational.AbstractFactory;

public class FactoryProducer {

	public static AbstractFactory getRoundedFactory(boolean rounded) {
		if (rounded) {
			return new RoundedShapeFactory();
		} else {
			return new ShapeFactory();
		}
	}
}
