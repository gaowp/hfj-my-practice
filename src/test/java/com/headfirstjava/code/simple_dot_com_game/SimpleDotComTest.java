package com.headfirstjava.code.simple_dot_com_game;

public class SimpleDotComTest {
	public static void main(String[] args) {
		
		SimpleDotCom dot = new SimpleDotCom();// 初始化一个SimpleDotCom对象
		
		int[] locations = { 2, 3, 4 };// 创建带有dot com位置的数组
		
		dot.setLocationsCells(locations);// 调用dot com的setter
		
		String userGuess = "3";// 假的猜测
		
		String result = dot.checkYourself(userGuess);// 调用被测方法并传入假的数据
		
		String testResult = "failed";
		
		if (result.equals("hit")) {
			testResult = "passed";// 测试应该返回"hit"才算成功
		}
		
		System.out.println(testResult);// 列出测试结果
	}
}
