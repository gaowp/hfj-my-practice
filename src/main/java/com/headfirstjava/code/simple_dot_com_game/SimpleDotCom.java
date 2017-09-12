package com.headfirstjava.code.simple_dot_com_game;

public class SimpleDotCom {

	int[] locationCells;
	int numOfHits = 0;

	public void setLocationsCells(int[] locs) {
		locationCells = locs;
	}

	public String checkYourself(String stringGuess) {

		int guess = Integer.parseInt(stringGuess);// 把字符串转换成int

		String result = "miss";// 创建出保存返回结果的变量，以miss作为默认值

		for (int cell : locationCells) {// 以循环对每个格子重复执行
			if (cell == guess) {// 比较格子与猜测值
				result = "hit";// 命中
				numOfHits++;
				break;// 离开循环，需继续判断是否击沉
			}
		}

		if (numOfHits == locationCells.length) {// 离开循环，需继续判断是否击沉
			result = "kill";
		}

		System.out.println(result);// 显示结果
		return result;// 将结果返回给调用方
	}

	public static void main(String[] args) {
		
		int numOfGuesses = 0;//此变量记录玩家猜测数目
		
		GameHelper helper = new GameHelper();
		
		SimpleDotCom theDotCom = new SimpleDotCom();

		int randomNum = (int)(Math.random() * 5);
		int[] locations = {randomNum, randomNum+1, randomNum+2};//用随机数产生第一格的位置，然后以此制作出数组
		
		theDotCom.setLocationsCells(locations);//赋值位置
		
		boolean isAlive = true;//创建出记录游戏是否继续进行的Boolean变量，这会在while循环中
		
		while (isAlive == true) {
			String guess = helper.getUserInput("enter a number");//取得玩家输入的字符串
			String result = theDotCom.checkYourself(guess);//检查玩家的猜测，并将结果存储在String中
			numOfGuesses++;
			if (result.equals("kill")) {//是否击沉，若击沉,则设定iaAlive为false并印出猜测次数，并跳出while循环
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
			
		}
	}
}
