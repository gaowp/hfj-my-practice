package com.headfirstjava.code.my_practice;

import javax.swing.*;

import java.awt.*;

public class SimpleAnimation {
	int x = 70;
	int y = 70;// 在主要的GUI中创建两个实例变量用来代表圆形的坐标
	
	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	
	private void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawpanel = new MyDrawPanel();// 此处创建出frame上的widget
		
		frame.getContentPane().add(drawpanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for (int i = 0; i < 130; i++) {
			x++;
			y++;// 递增坐标值
			
			drawpanel.repaint();// 要求重新绘制面板
			
			try {
				Thread.sleep(50);
			} catch (Exception ex) {	}
		}
	}// 关闭go方法
	
	class MyDrawPanel extends JPanel {
		private void painComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);// 使用外部坐标值来更新
		}
	}// 关闭内部类
}// 关闭外部类
