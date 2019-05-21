package com.programing.designPatterns.behavioral.Visitor;

public class VisitorPatternDemo {

	public static void main(String[] args) {

		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}
