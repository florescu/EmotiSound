import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class MindMusic {
	
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
    	float maxScore;
    	int lowerFaceAction;
    	int upperFaceAction;
    	
    	userID = new IntByReference(0);
    	
		if (Edk.INSTANCE.EE_EngineConnect("Emotiv Systems-5") != EdkErrorCode.EDK_OK.ToInt()) {
			System.out.println("Emotiv Engine start up failed.");
			return;
		}
		
		//Start recording
		JavaSoundRecorder.recordSound();

		IMindMusicController musicController = new MindMusicController();
		
		while (true) 
		{
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
					{
						MusicPlayer.playDrum();
						System.out.println("Blink");
					}
					if (EmoState.INSTANCE.ES_ExpressivIsLeftWink(eState) == 1)
					{
						System.out.println("LeftWink");
						MusicPlayer.playBass();
					}
					if (EmoState.INSTANCE.ES_ExpressivIsRightWink(eState) == 1)
					{
						System.out.println("RightWink");
						MusicPlayer.playFlute();
					}
					if (EmoState.INSTANCE.ES_ExpressivIsLookingLeft(eState) == 1)
					{
						System.out.println("LookingLeft");
						MusicPlayer.playBass2();
					}
					if (EmoState.INSTANCE.ES_ExpressivIsLookingRight(eState) == 1)
					{
						System.out.println("LookingRight");
						MusicPlayer.playGuitar();
					}
					
					//Upper face actions: Raise brow, Furrow brow
					upperFaceAction = EmoState.INSTANCE.ES_ExpressivGetUpperFaceAction(eState);
					if (upperFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_EYEBROW.ToInt())
					{
						System.out.println("Raise brow");
						eyebrowExtent = EmoState.INSTANCE.ES_ExpressivGetEyebrowExtent(eState);
						System.out.println("Eyebrow (raise): " + eyebrowExtent);
						MusicPlayer.playHarp(eyebrowExtent);
					}
					
					if (upperFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_FURROW.ToInt())
					{
						System.out.println("Furrow brow");	
					}
					
					//Lower face actions: Smile, Smirk left, Smirk Right, Clench, Laugh.
					lowerFaceAction = EmoState.INSTANCE.ES_ExpressivGetLowerFaceAction(eState);
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMILE.ToInt())
					{
						System.out.println("Smile");
						smileExtent = EmoState.INSTANCE.ES_ExpressivGetSmileExtent(eState);
						System.out.println("Smile: " + smileExtent);
						MusicPlayer.playTrumpet(smileExtent);
					}
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_CLENCH.ToInt())
					{
						System.out.println("Clench");
						clenchExtent = EmoState.INSTANCE.ES_ExpressivGetClenchExtent(eState);
						System.out.println("Clench: " + clenchExtent);
						MusicPlayer.playViolin(clenchExtent);
					}
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_LAUGH.ToInt())
					{
						System.out.println("Laugh");
						MusicPlayer.playPiano();
					}
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMIRK_LEFT.ToInt())
					{
						System.out.println("SmirkLeft");
						MusicPlayer.playCello();
					}
					
					if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMIRK_RIGHT.ToInt())
					{
						System.out.println("SmirkRight");
						MusicPlayer.playTriangle();
					}

					excitementShortTerm = EmoState.INSTANCE.ES_AffectivGetExcitementShortTermScore(eState);
					excitementLongTerm = EmoState.INSTANCE.ES_AffectivGetExcitementLongTermScore(eState);
					engagementBoredom = EmoState.INSTANCE.ES_AffectivGetEngagementBoredomScore(eState);
					frustration = EmoState.INSTANCE.ES_AffectivGetFrustrationScore(eState);
					meditation = EmoState.INSTANCE.ES_AffectivGetMeditationScore(eState);
					
					if (excitementShortTerm > 0 ) 
					{
						//MusicPlayer.playBeat1(excitementShortTerm);
					}
						
					
					if (excitementLongTerm > 0)
					{
						MusicPlayer.playBeat2(excitementLongTerm);
						Thread.sleep(1000); //1 second
					}
					
					
					if (engagementBoredom > 0)
					{
						MusicPlayer.playBeat3(engagementBoredom);
						Thread.sleep(800);
					}
					
					
					if (frustration > 0)
					{
						MusicPlayer.playBeat4(frustration);
						Thread.sleep(2000); 
					}
					
					if (meditation > 0)
					{
						MusicPlayer.playBeat5(meditation);
						Thread.sleep(1000);
					}
					
					EmotivReading myReading = new EmotivReading();
					 
				}
			}
			else if (state != EdkErrorCode.EDK_NO_EVENT.ToInt()) {
				System.out.println("Internal error in Emotiv Engine!");
				break;
			}
		}
    	 
    	Edk.INSTANCE.EE_EngineDisconnect();
    	System.out.println("Disconnected!");	
    }//main	 
	 
} //class
