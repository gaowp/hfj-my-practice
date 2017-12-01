package com.headfirstjava.code.my_practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Change Colors");
		button.addActionListener(this);// 把监听加到按钮上

		MyDrawPanel drawpanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, button);// 依照指定区域，把weiget放上去
		frame.getContentPane().add(BorderLayout.CENTER, drawpanel);// 依照指定区域，把weiget放上去
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		frame.repaint();// 当用户按下按钮时，就要求frame重新绘制
	}
}
