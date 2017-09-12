package com.headfirstjava.code.my_practice;

public class ClockTest {
	public static void main(String[] args) {
		
		Clock c = new Clock();
		
		c.setTime("123456");
		String tod = c.getTime();
		System.out.println("time: " + tod);
	}
}
