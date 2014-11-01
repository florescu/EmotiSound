import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import org.jfugue.Pattern;
import org.jfugue.Player;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class JFugueSamplePlayer {

    private static Logger logger = Logger.GetInstance();

    public static void main(String[] args)
    {
        String filename = "sample2.txt";

        try {
            List<EmotivReading> readings = EmotivReadingSampleDeserializer.DeserializeFileIntoReadingList(filename);

            MindToMusicController mc = MindToMusicController.GetInstance();

            mc.AddCompleteSample(readings);


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

                Player player = new Player();
                String emotiSong = noteExcitementShortTerm + "+" + noteExcitementLongTerm + "+" + noteEngagementBoredom
                                + "+" + noteFrustration + "+" + noteMeditation + "+" + noteSmile + "+" + noteClench
                                + "+" + noteEyebrowRaise;

                player.play(notesAndVoices);
            }

        } catch (FileNotFoundException e) {
            logger.LogException(e);
        }
    }
}
