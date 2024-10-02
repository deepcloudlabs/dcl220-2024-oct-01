package com.example.exercises;

import java.util.List;

public class Exercise01 {

	public static void main(String[] args) {
		var employees = List.of(
		   new Employee("1", "jack bauer", 100_000, "TR1", false, List.of(Department.HR, Department.SALES),1956),
		   new Employee("2", "kate austen", 200_000, "TR2", true, List.of(Department.IT, Department.SALES),1995),
		   new Employee("3", "ben linus", 300_000, "TR3", true, List.of(Department.HR, Department.SALES),2002),
		   new Employee("4", "james sawyer", 400_000, "TR4", false, List.of(Department.IT, Department.ACCOUNTING),1986),
		   new Employee("5", "jin kwon", 500_000, "TR5", true, List.of(Department.IT),1978)
		); 
		var totalSalary = 0.0;
		for (var employee : employees) { // for-each: external loop
			if (!employee.fulltime()) continue;
			if (!employee.departments().contains(Department.IT)) continue;
			var salary = employee.salary();
			totalSalary += salary;
		}
		System.out.println("Total salary of fulltime IT employees: %f".formatted(totalSalary));
	}

}

record Employee(String identity,String fullname,double salary,String iban,boolean fulltime,List<Department> departments,int birthYear) {}

enum Department { HR, SALES, IT, FINANCE, ACCOUNTING }