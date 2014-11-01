import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class MindMusic {
	
	public static void main(String[] args) throws Exception
	{
    	Pointer eEvent			= Edk.INSTANCE.EE_EmoEngineEventCreate();
    	Pointer eState			= Edk.INSTANCE.EE_EmoStateCreate();
    	IntByReference userID 	= null;
    	
    	userID = new IntByReference(0);
    	
		if (Edk.INSTANCE.EE_EngineConnect("Emotiv Systems-5") != EdkErrorCode.EDK_OK.ToInt()) {
			System.out.println("Emotiv Engine start up failed.");
			return;
		}
		
		//Start recording
		JavaSoundRecorder.recordSound();
		
		while (true) 
		{
			EmotivReading reading = EmotivReadingFactory.CreateReading(eEvent, eState, userID);
			ReadingMusicPlayer.PlayBasic(reading);
		}
    	 	
    }//main	 
	 
} //class
