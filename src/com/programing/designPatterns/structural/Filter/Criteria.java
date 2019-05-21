package com.programing.designPatterns.structural.Filter;

import java.util.List;

public interface Criteria {

	List<Person> meetCriteria(List<Person> persons);
}
