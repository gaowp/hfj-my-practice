package com.headfirstjava.code.my_practice;

import javax.swing.*;

import java.awt.*;

public class Panel1 {
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);// 让面板变成深灰色以便观察。
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));// 把布局管理器换掉，它的构造函数需要知道要管理哪个组件以及使用哪个轴。
		
		JButton button = new JButton("shock me");
		JButton button2 = new JButton("bliss");
		
		panel.add(button);
		panel.add(button2);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	
}
