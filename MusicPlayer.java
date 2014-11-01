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
	
	public static void playDrum() throws Exception
	{
		 File source = new File("drum2.wav");
		 Line.Info lineInfo = new Line.Info(Clip.class);
		 Line line = AudioSystem.getLine(lineInfo);
		 drumClip = (Clip) line;
		 AudioInputStream input = AudioSystem.getAudioInputStream(source);
		 drumClip.open(input);
		 float decibels = -10;
		 setVolume(drumClip, decibels);
		 //setPitch(drumClip, 1);
		 drumClip.start();
	}
}
