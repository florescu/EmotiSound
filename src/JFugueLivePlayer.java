import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.jfugue.Player;

import java.io.FileNotFoundException;
import java.util.LinkedList;
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
        JavaSoundRecorder.recordSound();

        while (true)
        {
            EmotivReading reading = EmotivReadingFactory.CreateReading(eEvent, eState, userID);

            mc.AddReading(reading);

            EmotivReading currentReading = mc.GetNextReading();
            final String noteExcitementShortTerm = BasicJFugueSamplePlayer.PlayExcitementShortTerm(currentReading);
            final String noteExcitementLongTerm = BasicJFugueSamplePlayer.PlayExcitementLongTerm(currentReading);
            final String noteEngagementBoredom = BasicJFugueSamplePlayer.PlayEngagementBoredom(currentReading);
            final String noteFrustration = BasicJFugueSamplePlayer.PlayFrustration(currentReading);
            final String noteMeditation = BasicJFugueSamplePlayer.PlayMeditation(currentReading);
            final String noteSmile = BasicJFugueSamplePlayer.PlaySmile(currentReading);
            final String noteClench = BasicJFugueSamplePlayer.PlayClench(currentReading);
            final String noteEyebrowRaise = BasicJFugueSamplePlayer.PlayEyebrowRaise(currentReading);

            List<String> notesList = new LinkedList<String>(){{
                add(noteExcitementShortTerm);
                add(noteExcitementLongTerm);
                add(noteEngagementBoredom);
                add(noteFrustration);
                add(noteMeditation);
                add(noteSmile);
                add(noteClench);
                add(noteEyebrowRaise);
            }};

            String notesAndVoices = MusicalStringComposer.AppendVoice(notesList);

            player.play(notesAndVoices);
        }


    }
}
