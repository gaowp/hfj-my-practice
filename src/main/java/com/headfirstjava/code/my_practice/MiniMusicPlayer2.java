package com.headfirstjava.code.my_practice;

import java.awt.Event;

import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener {// 我们必须要监听ControllerEvent，因此实现了这个接口
	public static void main(String[] args) {
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}

	public void go() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			int[] eventsIWant = { 127 };
			sequencer.addControllerEventListener(this, eventsIWant);// 向sequencer注册事件。注册的方法取用监听者与代表想要监听的事件的int数组，我们只需要127事件。

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for (int i = 5; i < 60; i += 4) {
				track.add(makeEvent(144, 1, i, 100, i));

				track.add(makeEvent(176, 1, 127, 0, i));// 插入事件编号为127的自定义的ControllerEvent（176），他不会做任何事情，
														// 只是让我们知道有音符被播放,因为他的tick跟NOTE
														// ON是同时进行的。

				track.add(makeEvent(128, 1, i, 100, i + 2));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void controlChange(ShortMessage event) {// 获知事件时在命令打印出字符串的事件处理程序
		System.out.println("la");
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {	}
		return event;
	}
}
