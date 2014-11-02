import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import java.util.List;

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

        MindToMusicController mc = MindToMusicController.GetInstance();

        //Start recording
        Thread soundRecorder = new Thread(new JavaSoundRecorder());
        soundRecorder.start();

        while (true) {
            EmotivReading reading = EmotivReadingFactory.CreateReading(eEvent, eState, userID);

            mc.AddReading(reading);

            EmotivReading currentReading = mc.GetNextReading();

            ReadingMusicPlayer.PlayBasic(currentReading);
        }
    	 	
    }//main	 
	 
} //class
