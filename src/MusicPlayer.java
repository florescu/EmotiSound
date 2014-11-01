import javax.sound.sampled.*;

import java.io.*;
import java.util.*;

public class MusicPlayer {
	public static Clip drumClip; 
	
	public static void main(String[] args) throws Exception
	{
		playDrum();
		System.in.read();		
	}
	
	public static void setVolume(Clip musicClip, float decibels)
	{
		FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(decibels);	
	}
	
	public static void setPitch(Clip musicClip, float pitch)
	{
		FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.SAMPLE_RATE);
		float frequency = musicClip.getFormat().getSampleRate();
		gainControl.setValue(frequency * pitch);	
	}
	
	public static void playSound(File source, float decibels) throws Exception
	{
		 Line.Info lineInfo = new Line.Info(Clip.class);
		 Line line = AudioSystem.getLine(lineInfo);
		 Clip musicClip = (Clip) line;
		 AudioInputStream input = AudioSystem.getAudioInputStream(source);
		 musicClip.open(input);
		 setVolume(musicClip, decibels);
		 musicClip.start();
	}
	
	public static void playDrum() throws Exception
	{
		 File source = new File("PlayList/drum2.wav");
		 float decibels = -10;
		 playSound(source, decibels);
	}
	
	public static void playGuitar() throws Exception
	{
		File source = new File("PlayList/guitar.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playBass() throws Exception
	{
		File source = new File("PlayList/bass.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playBass2() throws Exception
	{
		File source = new File("PlayList/bass2.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playFlute() throws Exception
	{
		File source = new File("PlayList/flute.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playHarp() throws Exception
	{
		File source = new File("PlayList/harp.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playPiano() throws Exception
	{
		File source = new File("PlayList/piano.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playSax() throws Exception
	{
		File source = new File("PlayList/sax.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playViolin() throws Exception
	{
		File source = new File("PlayList/violin.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
}
