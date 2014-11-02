import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.jfugue.Player;

import java.util.List;

/**
 * Created by blabla on 01/11/2014.
 */
public class JFugueLivePlayer {
    public static void main(String[] args) throws Exception {

        MindToMusicController mc = MindToMusicController.GetInstance();

        Player player = new Player();

        Pointer eEvent			= Edk.INSTANCE.EE_EmoEngineEventCreate();
        Pointer eState			= Edk.INSTANCE.EE_EmoStateCreate();
        IntByReference userID 	= null;

        userID = new IntByReference(0);

        if (Edk.INSTANCE.EE_EngineConnect("Emotiv Systems-5") != EdkErrorCode.EDK_OK.ToInt()) {
            System.out.println("Emotiv Engine start up failed.");
            return;
        }

        //Start recording
        Thread soundRecorder = new Thread(new JavaSoundRecorder());
        soundRecorder.start();

        while (true)
        {
            EmotivReading reading = EmotivReadingFactory.CreateReading(eEvent, eState, userID);

            mc.AddReading(reading);

            EmotivReading currentReading = mc.GetNextReading();

            List<String> notesList = BasicJFugueSamplePlayer.GenerateMusicalStrings(currentReading);
            String notesAndVoices = MusicalStringComposer.AppendVoice(notesList);
            try {
                player.play(notesAndVoices);
            }
            catch (Exception e){
                System.out.println(e);
            }

            //String musicString = AdvancedJFugueSamplePlayer.ProcessReadingMethodOne(currentReading);
            //player.play(musicString);
        }
    }


}
