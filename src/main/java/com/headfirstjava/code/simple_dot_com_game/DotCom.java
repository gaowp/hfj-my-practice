package com.headfirstjava.code.simple_dot_com_game;

import java.util.*;

public class DotCom {

	// DotCom的实例变量：--保存位置的ArrayList,--DotCom名称
	private ArrayList<String> locationCells;
	private String name;

	// 更新DotCom位置的setter方法
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}

	// 更新DotCom名称的setter方法
	public void setName(String n) {
		name = n;
	}

	public String checkYourself(String userInput) {

		String result = "miss";
		int index = locationCells.indexOf(userInput);// 使用indexOf方法，如果玩家猜中，这个方法会返回他的位置，如果没有的话会返回-1

		if (index >= 0) {// 如果索引值>=0,则命中
			locationCells.remove(userInput);// 删除已经命中的格子

			if (locationCells.isEmpty()) {// 用这个方法判断是否击沉
				result = "kill";
				System.out.println("Ouch! You sunk " + name + " : ( ");//列出击沉的信息
			} else {
				result = "hit";
			}
		}
		return result;
	}
}
