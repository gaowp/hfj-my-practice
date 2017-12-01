package com.headfirstjava.code.my_practice;

/*
 * if input yes,output : thaws
 * if input no, output : throws
 * */
class MyEx extends Exception {
}

public class ExTestDrive {
	public static void main(String[] args) {
		String test = "yes";
		try {
			System.out.print("t");
			doRiaky(test);
			System.out.print("o");
		} catch (MyEx e) {
			System.out.print("a");
		} finally {
			System.out.print("w");
		}
		System.out.print("s");
	}

	static void doRiaky(String t) throws MyEx {
		System.out.print("h");
		if ("yes".equals(t)) {
			throw new MyEx();
		}
		System.out.print("r");
	}
}
