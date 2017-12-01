package com.headfirstjava.code.my_practice;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener {
	
	JTextArea text;
	
	public static void main(String[] args) {
		TextArea1 gui = new TextArea1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Click It");
		button.addActionListener(this);
		text = new JTextArea(10, 20);// 代表10行高，20字宽
		text.setLineWrap(true);//启动自动换行
		
		JScrollPane scroller = new JScrollPane(text);// 将text赋值给新创建的JScrollPane
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);// 指定只使用垂直滚动条
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);// 指定只使用垂直滚动条
		
		panel.add(scroller);// 这很重要，加入的是带有文本域的滚动条，而不是文本域
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		frame.setSize(350, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		text.append("button clicked \n ");// 在按下按钮时插入一个换行字符，不然的话都会粘到一起
	}
}
