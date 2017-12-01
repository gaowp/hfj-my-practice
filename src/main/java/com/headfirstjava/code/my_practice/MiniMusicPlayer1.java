package com.headfirstjava.code.my_practice;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {
	public static void main(String[] args) {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();// 创建并打开队列

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();// 创建队列并track

			for (int i = 5; i < 61; i += 4) {// 创建一堆连续的音符事件
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(128, 1, i, 100, i + 2));// 调用makeEvent()方法来产生信息和事件，然后把他们加到track上
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(200);
			sequencer.start();// 开始播放
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {	}
		return event;
	}
}
