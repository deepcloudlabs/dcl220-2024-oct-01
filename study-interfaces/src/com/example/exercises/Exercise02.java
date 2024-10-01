package com.example.exercises;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		I ref = new E();
		if (ref instanceof E e) {
			
		}
		if (ref instanceof F f) {
			
		}
		
	}

}

interface I {}
interface K {}
class E implements I, K {}
class F {}