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
	    	int lowerFaceAction;
	    	int upperFaceAction;
	    	
	    	userID = new IntByReference(0);
	    	
			if (Edk.INSTANCE.EE_EngineConnect("Emotiv Systems-5") != EdkErrorCode.EDK_OK.ToInt()) {
				System.out.println("Emotiv Engine start up failed.");
				return;
			}
			
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
							System.out.println("LeftWink");
						if (EmoState.INSTANCE.ES_ExpressivIsRightWink(eState) == 1)
							System.out.println("RightWink");
						if (EmoState.INSTANCE.ES_ExpressivIsLookingLeft(eState) == 1)
							System.out.println("LookingLeft");
						if (EmoState.INSTANCE.ES_ExpressivIsLookingRight(eState) == 1)
							System.out.println("LookingRight");
						
						//Upper face actions: Raise brow, Furrow brow
						upperFaceAction = EmoState.INSTANCE.ES_ExpressivGetUpperFaceAction(eState);
						if (upperFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_EYEBROW.ToInt())
							System.out.println("Raise brow");
						if (upperFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_FURROW.ToInt())
							System.out.println("Furrow brow");	
						
						//Lower face actions: Smile, Smirk left, Smirk Right, Clench, Laugh.
						lowerFaceAction = EmoState.INSTANCE.ES_ExpressivGetLowerFaceAction(eState);
						if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMILE.ToInt())
							System.out.println("Smile");
						if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_CLENCH.ToInt())
							System.out.println("Clench");
						if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_LAUGH.ToInt())
							System.out.println("Laugh");
						if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMIRK_LEFT.ToInt())
							System.out.println("SmirkLeft");
						if (lowerFaceAction == EmoState.EE_ExpressivAlgo_t.EXP_SMIRK_RIGHT.ToInt())
							System.out.println("SmirkRight");
						
						clenchExtent = EmoState.INSTANCE.ES_ExpressivGetClenchExtent(eState);
						System.out.println("Clench: " + clenchExtent);
						eyebrowExtent = EmoState.INSTANCE.ES_ExpressivGetEyebrowExtent(eState);
						System.out.println("Eyebrow: " + eyebrowExtent);
						smileExtent = EmoState.INSTANCE.ES_ExpressivGetSmileExtent(eState);
						System.out.println("Smile: " + smileExtent);
						
						System.out.print("ExcitementShortTerm: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetExcitementShortTermScore(eState));
						System.out.print("ExcitementLongTerm: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetExcitementLongTermScore(eState));
						System.out.print("EngagementBoredom: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetEngagementBoredomScore(eState));	
						System.out.print("Frustration: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetFrustrationScore(eState));
						System.out.print("Meditation: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetMeditationScore(eState));
						
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
