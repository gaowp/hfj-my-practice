package com.headfirstjava.code.my_practice;

import javax.swing.*;
import java.awt.event.*;// import 进ActionListener和ActionEvent所在的包

public class SimpleGui1B implements ActionListener {// 实现此接口。这表示SimpleGui1B是个ActionListener（事件只会通知有实现ActionListener的类）
	JButton button;
	
	public static void main(String[] args) {
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("click me");
		
		button.addActionListener(this);// ***向按钮注册***
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {// 实现interface的方法，这是真正处理事件的方法。
		button.setText("I've been clicked!");// 按钮会以ActionEvent对象作为参数来调用此方法。
	}
}
