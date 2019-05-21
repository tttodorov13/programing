package com.programing.designPatterns.behavioral.Visitor;

public interface ComputerPart {

	void accept(ComputerPartVisitor computerPartVisitor);
}
