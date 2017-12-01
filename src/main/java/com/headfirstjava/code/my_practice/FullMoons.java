/*
 * full moon on Fri Feb 06 04:09:35 MST 2004
 * full moon on Sat Mar 06 16:38:23 MST 2004
 * full moon on Mon Apr 05 06:07:11 MST 2004
 * */

package com.headfirstjava.code.my_practice;

import static java.lang.System.out;
import java.util.*;

class FullMoons {
	static int DAY_IM = 1000 * 60 * 60 * 24;

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		c.set(2004, 0, 7, 15, 40);
		
		long day1 = c.getTimeInMillis();
		
		for (int x = 0; x < 3; x++) {
			day1 += (DAY_IM * 29.52);
			c.setTimeInMillis(day1);
			out.println(String.format("full moon on %tc", c));
		}
	}
}
