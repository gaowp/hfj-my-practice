package com.headfirstjava.code.my_practice;

/*
 * 取得sequencer对象
 * */

import javax.sound.midi.*;

public class MusicTest1 {

	public void play() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();// 把有风险的程序放在try块中
			System.out.println( "Successfully got a sequencer");
		} catch (MidiUnavailableException ex) {
			System.out.println("Bummer");// 用catch块摆放异常状况的程序
			ex.printStackTrace();
		}
		System.out.println("We got a sequencer");// 这个对象的作用是将MIDI信息组合成“乐曲”。
	}// 关闭播放

	public static void main(String[] args) {
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}// 关闭main
}// 关闭类
