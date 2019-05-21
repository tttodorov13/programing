package com.programing.designPatterns.behavioral.Visitor;

public class Mouse implements ComputerPart {

	@Override public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}
