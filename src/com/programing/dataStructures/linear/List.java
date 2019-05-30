package com.programing.dataStructures.linear;

public interface List {
	void add(Object item);
	boolean contains(Object item);
	Object get(int index);
	boolean isEmpty();
	int remove(Object item);
	Object remove(int index);
	int indexOf(Object item);
}
