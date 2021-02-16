package com.programing.designPatterns.structural.Composite;

public class CompositePatternDemo {

    public static void main(String[] args) {

        Employee CEO = new Employee("John", "CEO", 30000);

        Employee headSales = new Employee("Robert", "Head Sales", 20000);

        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        Employee salesExecutive1Assistant1 = new Employee("Sally", "Sales", 10000);
        Employee salesExecutive1Assistant2 = new Employee("Ashly", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        salesExecutive1.add(salesExecutive1Assistant1);
        salesExecutive1.add(salesExecutive1Assistant2);

        // Print all employees of the organization
        System.out.println(CEO);

        // Print Robert and Michael
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);

            // Prints Richard, Bob, Laura and Bob
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);

                // Prints Sally and Ashly
                for (Employee employeeAssistant : employee.getSubordinates()) {
                    System.out.println(employeeAssistant);
                }
            }
        }
    }
}
