import org.jfugue.Player;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class JFugueSamplePlayer {

    private static Logger logger = Logger.GetInstance();

    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {
        String filename = "sample2.txt";

            List<EmotivReading> readings = EmotivReadingSampleDeserializer.DeserializeFileIntoReadingList(filename);

            MindToMusicController mc = MindToMusicController.GetInstance();

            mc.AddCompleteSample(readings);

            Player player = new Player();

            while(mc.HasReadings())
            {
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
