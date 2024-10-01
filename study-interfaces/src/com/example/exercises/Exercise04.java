package com.example.exercises;

public class Exercise04 {

	public static void main(String[] args) {
	
	}

}

sealed interface S permits AA, CC {}
non-sealed class AA implements S {}
// Error
/*
class BB implements S {}
 */
final class CC implements S {}