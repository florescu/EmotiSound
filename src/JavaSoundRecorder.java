import javax.sound.sampled.*;
import java.io.*;

public class JavaSoundRecorder {
	public static TargetDataLine line;
	
	public static AudioFormat getAudioFormat()
	{
		float sampleRate = 16000;
		int sampleSizeInBits = 8;
		int channels = 2;
		boolean signed = true;
		boolean bigEndian = true;
		AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
		return format;
	}
	
	public static void saveFile() throws Exception
	{
		File destinationFile = new File("PlayList/result.wav");
		AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
		
		AudioFormat format = getAudioFormat();
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		line = (TargetDataLine) AudioSystem.getLine(info);
		line.open(format);
		line.start();
		AudioInputStream ais = new AudioInputStream(line);
		AudioSystem.write(ais, fileType, destinationFile);
	}
	
	public static void recordSound() throws Exception
	{
		Thread stopper = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(18000); //3 minutes
				}
				catch (InterruptedException ex){
					ex.printStackTrace();
				}
				line.stop();
				line.close();
			}
		});
		stopper.start();
		JavaSoundRecorder.saveFile();
	}
}
