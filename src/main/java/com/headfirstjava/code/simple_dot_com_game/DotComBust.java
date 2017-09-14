package com.headfirstjava.code.simple_dot_com_game;

import java.util.*;

public class DotComBust {

	// 声明并初始化变量
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;

	// 私有化方法
	private void setUpGame() {
		// first make some dot coms and give them locations.
		// Create three DotCom objects, 并赋予名称和加入到ArrayList中
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		// 列出简短的提示
		System.out.println("Your goal is to sink " + dotComsList.size() + " dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");

		// 对list中的每个DotCom重复一次
		for (DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);// 要求DotCom的位置
			dotComToSet.setLocationCells(newLocation);// 调用DotCom的setter方法来指派刚取得的位置
		}
	}

	private void startPlaying() {
		while (!dotComsList.isEmpty()) {// 判断DotCom的list是否为空
			String userGuess = helper.getUserInput("Enter a guess");// 取得玩家输入
			checkUserGuess(userGuess);// 调用checkUserGuess方法
		}
		finishGame();//调用finishGame方法
	}

	private void checkUserGuess(String userGuess) {

		numOfGuesses++;// 递增玩家的猜测次数
		String result = "miss";// 先假设没有命中

		for (DotCom dotComToTest : dotComsList) {// 对list中的所有DotCom重复
			result = dotComToTest.checkYourself(userGuess);// 要求DotCom检查是否命中或击沉
			if (result.equals("hit")) {
				break;// 提前跳出循环
			}
			if (result.equals("kill")) {
				dotComsList.remove(dotComToTest);// 这家伙挂掉了
				break;
			}
		}
		System.out.println(result);// 列出结果
	}
	
	//列出玩家成绩
	private void finishGame() {
		System.out.println("All Dot Coms are dead! You stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses!");
			System.out.println(" You got out before your options sank.");
		}else {
			System.out.println("Took you long enough. "+ numOfGuesses +"guesses" );
			System.out.println("Fish are dancing with your options.");
		}
	}
	
	public static void main(String[] args) {
		DotComBust game = new DotComBust();//创建游戏对象
		game.setUpGame();//要求游戏对象启动
		game.startPlaying();//要求游戏启动游戏的主要循环
	}
}
