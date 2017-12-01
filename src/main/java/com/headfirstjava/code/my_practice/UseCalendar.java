package com.headfirstjava.code.my_practice;

import java.util.Calendar;

public class UseCalendar {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		c.set(2004, 1, 7, 15, 40); // 将时间设定为：2004-1-7 15：40，注意月份是零基
		System.out.println(c.getTime());
		
		long day1 = c.getTimeInMillis(); // 将目前时间转换为以millisecond表示
		day1 += 1000 * 60 * 60;
		
		c.setTimeInMillis(day1); // 在c的时间上加一个小时
		System.out.println("new hour : " + c.get(Calendar.HOUR_OF_DAY));
		
		c.add(c.DATE, 35); // 加上35天，所以c已经到了2月
		System.out.println("add 35 days : " + c.getTime());
		
		c.roll(c.DATE, 35);// 滚动35天，注意：只有日期字段会动，月份不会动
		System.out.println("roll 35 days : " + c.getTime());
		
		c.set(c.DATE, 1);// 直接设定DATE的值
		System.out.println("set to 1 : " + c.getTime());
	}
}
