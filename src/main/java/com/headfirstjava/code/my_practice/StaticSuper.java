package com.headfirstjava.code.my_practice;

class StaticSuper {
	static {
		System.out.println("super static block.");
	}
	
	StaticSuper() {
		System.out.println("super constructor.");
	}
}