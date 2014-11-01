import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;


public class TestReading {
	public static void main(String[] args) throws Exception
	{
		Pointer eEvent			= Edk.INSTANCE.EE_EmoEngineEventCreate();
    	Pointer eState			= Edk.INSTANCE.EE_EmoStateCreate();
    	IntByReference userID 	= null;
    	int state  				= 0;
    	float clenchExtent;
    	float eyebrowExtent;
    	float smileExtent;
    	float excitementShortTerm;
    	float excitementLongTerm;
    	float engagementBoredom;
    	float frustration;
    	float meditation;
    	int lowerFaceAction;
    	int upperFaceAction;
    	
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
			
			EmotivReading myReading = new EmotivReading();
			state = Edk.INSTANCE.EE_EngineGetNextEvent(eEvent);

			// New event needs to be handled
			if (state == EdkErrorCode.EDK_OK.ToInt()) {

				int eventType = Edk.INSTANCE.EE_EmoEngineEventGetType(eEvent);
				Edk.INSTANCE.EE_EmoEngineEventGetUserId(eEvent, userID);

				// Log the EmoState if it has been updated
				if (eventType == Edk.EE_Event_t.EE_EmoStateUpdated.ToInt()) {

					Edk.INSTANCE.EE_EmoEngineEventGetEmoState(eEvent, eState);
					
					//Eye states
					if (EmoState.INSTANCE.ES_ExpressivIsBlink(eState) == 1)
						myReading.Blink = true;
					
					if (EmoState.INSTANCE.ES_ExpressivIsLeftWink(eState) == 1)
						myReading.WinkLeft = true;
					
					if (EmoState.INSTANCE.ES_ExpressivIsRightWink(eState) == 1)
						myReading.WinkRight = true;
					
					if (EmoState.INSTANCE.ES_ExpressivIsLookingLeft(eState) == 1)
						myReading.LookingLeft = true;
					
					if (EmoState.INSTANCE.ES_ExpressivIsLookingRight(eState) == 1)
						myReading.LookingRight = true;
					
					//Upper face actions: Raise brow, Furrow brow
					upperFaceAction = EmoState.INSTANCE.ES_ExpressivGetUpperFaceAction(eState);
					if (upperFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_EYEBROW.ToInt())
					{
						eyebrowExtent = EmoState.INSTANCE.ES_ExpressivGetEyebrowExtent(eState);
						myReading.EyebrowRaise = eyebrowExtent;
					}
					
					if (upperFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_FURROW.ToInt())
						myReading.FurrowBrow = true;
					
					//Lower face actions: Smile, Smirk left, Smirk Right, Clench, Laugh.
					lowerFaceAction = EmoState.INSTANCE.ES_ExpressivGetLowerFaceAction(eState);
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMILE.ToInt())
					{
						smileExtent = EmoState.INSTANCE.ES_ExpressivGetSmileExtent(eState);
						myReading.Smile = smileExtent;
					}
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_CLENCH.ToInt())
					{
						clenchExtent = EmoState.INSTANCE.ES_ExpressivGetClenchExtent(eState);
						myReading.Clench = clenchExtent;
					}

					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_LAUGH.ToInt())
						myReading.Laugh = true;
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMIRK_LEFT.ToInt())
						myReading.SmirkLeft = true;
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMIRK_RIGHT.ToInt())
						myReading.SmirkRight = true;

					excitementShortTerm = EmoState.INSTANCE.ES_AffectivGetExcitementShortTermScore(eState);
					excitementLongTerm = EmoState.INSTANCE.ES_AffectivGetExcitementLongTermScore(eState);
					engagementBoredom = EmoState.INSTANCE.ES_AffectivGetEngagementBoredomScore(eState);
					frustration = EmoState.INSTANCE.ES_AffectivGetFrustrationScore(eState);
					meditation = EmoState.INSTANCE.ES_AffectivGetMeditationScore(eState);
					
					myReading.ExcitementShortTerm = excitementShortTerm;
					myReading.ExcitementLongTerm = excitementLongTerm;
					myReading.EngagementBoredom = engagementBoredom;
					myReading.Frustration = frustration;
					myReading.Meditation = meditation;
					

				}
				
			}
			else if (state != EdkErrorCode.EDK_NO_EVENT.ToInt()) {
				System.out.println("Internal error in Emotiv Engine!");
				break;
			}
			
			mc.AddReading(myReading);
			Thread.sleep(500);
			counter++;
		}
		
		List<EmotivReading> emotivReadings = mc.GetAllReadings(); 
		sampler.CreateSampleFile("sample3.txt", emotivReadings);
    	 
    	Edk.INSTANCE.EE_EngineDisconnect();
    	System.out.println("Disconnected!");	
    }//main	 
}
