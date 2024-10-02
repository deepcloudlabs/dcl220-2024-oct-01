package com.example.exercises;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

public class Exercise02 {

	public static void main(String[] args) {
		var employees = List.of(
		   new Employee("1", "jack bauer", 100_000, "TR1", false, List.of(Department.HR, Department.SALES),1956),
		   new Employee("2", "kate austen", 200_000, "TR2", true, List.of(Department.IT, Department.SALES),1995),
		   new Employee("3", "ben linus", 300_000, "TR3", true, List.of(Department.HR, Department.SALES),2002),
		   new Employee("4", "james sawyer", 400_000, "TR4", false, List.of(Department.IT, Department.ACCOUNTING),1986),
		   new Employee("5", "jin kwon", 500_000, "TR5", true, List.of(Department.IT),1978)
		);
		// Marker Interface
		// Functional Interface: Single Abstract Method (SAM)
//		Predicate<Employee> ITEmployee = (Employee employee) -> {
//			return employee.departments().contains(Department.IT);
//		};
		Predicate<Employee> ITEmployee = employee -> employee.departments().contains(Department.IT);
//		Predicate<Employee> fulltimeEmployee = new Predicate<Employee>() {
//			
//			@Override
//			public boolean test(Employee employee) {
//				return employee.fulltime();
//			}
//			
//		};
//		Predicate<Employee> fulltimeEmployee = employee -> employee.fulltime();
		Predicate<Employee> fulltimeEmployee = Employee::fulltime;
		// Higher-Order Function: filter, mapToDouble 
		// Pure Function: i. lambda expression ii. method reference
		var totalSalary = 
		employees.stream()
		         .filter(ITEmployee.and(fulltimeEmployee))
		         .mapToDouble(Employee::salary)
		         .sum();
		System.out.println("Total salary of fulltime IT employees: %f".formatted(totalSalary));
	}

}

interface AAA {}

class B implements Serializable {}