package com.headfirstjava.code.my_practice;

import java.util.*;

class V2Radiator {
	V2Radiator(ArrayList list) {
		for (int x = 0; x < 5; x++) {
			list.add(new SimUnit("V2Radiator"));
		}
	}
}

class V3Radiator {
	V3Radiator(ArrayList lglist) {
		super();
		for (int g = 0; g < 10; g++) {
			lglist.add(new SimUnit("V3Radiator"));
		}
	}
}

class RetentionBot {
	RetentionBot(ArrayList rlist) {
		rlist.add(new SimUnit("RetentionBot"));
	}
}

public class TestLifeSupportSim {
	public static void main(String[] args) {
		ArrayList aList = new ArrayList();
		V2Radiator v2 = new V2Radiator(aList);
		V3Radiator v3 = new V3Radiator(aList);
		for (int z = 0; z < 20; z++) {
			RetentionBot ret = new RetentionBot(aList);
		}
	}
}

class SimUnit {
	String botType;
	SimUnit (String type){
		botType = type;
		System.out.println(botType);
	}
	int powerUse() {
		if ("RetentionBot".equals(botType)) {
			return 2;
		} else {
			return 4;
		}
	}
}