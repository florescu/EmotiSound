import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class MindMusic {
	 public static void main(String[] args) 
	    {
	    	Pointer eEvent			= Edk.INSTANCE.EE_EmoEngineEventCreate();
	    	Pointer eState			= Edk.INSTANCE.EE_EmoStateCreate();
	    	IntByReference userID 	= null;
	    	short composerPort		= 1726;
	    	int state  				= 0;
	    	float clenchExtent;
	    	
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
						
						if (EmoState.INSTANCE.ES_ExpressivIsBlink(eState) == 1)
							System.out.println("Blink");
						if (EmoState.INSTANCE.ES_ExpressivIsLeftWink(eState) == 1)
							System.out.println("LeftWink");
						if (EmoState.INSTANCE.ES_ExpressivIsRightWink(eState) == 1)
							System.out.println("RightWink");
						if (EmoState.INSTANCE.ES_ExpressivIsLookingLeft(eState) == 1)
							System.out.println("LookingLeft");
						if (EmoState.INSTANCE.ES_ExpressivIsLookingRight(eState) == 1)
							System.out.println("LookingRight");
						if (EmoState.INSTANCE.ES_)
						clenchExtent = EmoState.INSTANCE.ES_ExpressivGetClenchExtent(eState);
						
						System.out.print("ExcitementShortTerm: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetExcitementShortTermScore(eState));
						System.out.print("ExcitementLongTerm: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetExcitementLongTermScore(eState));
						System.out.print("EngagementBoredom: ");
						System.out.println(EmoState.INSTANCE.ES_AffectivGetEngagementBoredomScore(eState));					
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
