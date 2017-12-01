package beatbox_app;

import javax.sound.midi.*;

public class MiniMiniMusicApp {
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		if (args.length < 2) {
			System.out.println("Don't forget the instrument and note args");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}// 关闭main

	public void play(int instrument, int note) {
		try {
			Sequencer player = MidiSystem.getSequencer();// 取得sequencer
			player.open();// 打开sequencer

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();// 要求取得track
			
			/*
			 * 对Track加入几个MidiEvent，要注意的是setMessage()的参数，以及MidiEvent的constructor
			 */
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);
			
			ShortMessage a = new ShortMessage();// 在第一拍启动a这个Message
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);// 将MidiEvent放到Track中

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			player.setSequence(seq);// 将sequence送到sequencer上

			player.start();// 开始播放
		} catch (Exception ex) {
			ex.printStackTrace();
		}// 关闭播放
	}// 关闭播放
}// 关闭类
