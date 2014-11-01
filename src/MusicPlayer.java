import javax.sound.sampled.*;
import java.io.*;

public class MusicPlayer {
	
	private static final int DB_MULTIPLIER = 70;
	private static final float MAX_DB_ALLOWED = 6;
	
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
	
	public static void playDrum(float extent) throws Exception
	{
		File source = new File("PlayList/drum2.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playGuitar() throws Exception
	{
		File source = new File("PlayList/guitar.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playGuitar(float extent) throws Exception
	{
		File source = new File("PlayList/guitar.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playBass() throws Exception
	{
		File source = new File("PlayList/bass.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playBass(float extent) throws Exception
	{
		File source = new File("PlayList/bass.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playBass2() throws Exception
	{
		File source = new File("PlayList/bass2.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playBass2(float extent) throws Exception
	{
		File source = new File("PlayList/bass2.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playFlute() throws Exception
	{
		File source = new File("PlayList/flute.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playHarp(float extent) throws Exception
	{
		File source = new File("PlayList/harp.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playPiano() throws Exception
	{
		File source = new File("PlayList/piano.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playTrumpet(float extent) throws Exception
	{
		File source = new File("PlayList/trumpet.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playViolin(float extent) throws Exception
	{
		File source = new File("PlayList/violin.wav");
		float decibels;
		if (extent < 0.5)
			decibels = -DB_MULTIPLIER * extent;
		else
			decibels = MAX_DB_ALLOWED * extent;
		playSound(source, decibels);
	}
	
	public static void playCello() throws Exception
	{
		File source = new File("PlayList/cello.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playTriangle() throws Exception
	{
		File source = new File("PlayList/triangle.wav");
		float decibels = 0;
		playSound(source, decibels);
	}
	
	public static void playHouseBeat(float score) throws Exception
	{
		File source = new File("PlayList/house.wav");
		float decibels;
		if (score < 0.5)
			decibels = -DB_MULTIPLIER * score * 2;
		else
			decibels = MAX_DB_ALLOWED * score / 3;
		playSound(source, decibels);
	}
	
}
