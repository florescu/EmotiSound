import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;


public class TestReading {
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
		EmotivReadingSampler sampler = EmotivReadingSampler.GetInstance();
		int counter = 0;
		while (counter < 40) 
		{
			EmotivReading reading = EmotivReadingFactory.CreateReading(eEvent, eState, userID);
			
			mc.AddReading(reading);
			Thread.sleep(500);
			counter++;
		}
		
		List<EmotivReading> emotivReadings = mc.GetAllReadings(); 
		sampler.CreateSampleFile("sample3.txt", emotivReadings);
    	 
    	Edk.INSTANCE.EE_EngineDisconnect();
    	System.out.println("Disconnected!");	
    }//main	 

}
