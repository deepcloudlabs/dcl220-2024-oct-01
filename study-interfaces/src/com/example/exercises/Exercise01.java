package com.example.exercises;

public class Exercise01 {

	public static void main(String[] args) {
		A ref = new B();
		if (ref instanceof B b) {
			
		}
		// Error
		/*
		if (ref instanceof C c) {
			
		}
		*/
	}

}

abstract class A {}
class B extends A {}
class C {}