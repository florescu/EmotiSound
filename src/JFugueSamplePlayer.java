import java.io.FileNotFoundException;
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
                String noteExcitementShortTerm = BasicJFugueSamplePlayer.PlayExcitementShortTerm(currentReading);
                String noteExcitementLongTerm = BasicJFugueSamplePlayer.PlayExcitementLongTerm(currentReading);
                String noteEngagementBoredom = BasicJFugueSamplePlayer.PlayEngagementBoredom(currentReading);
                String noteFrustration = BasicJFugueSamplePlayer.PlayFrustration(currentReading);
                String noteMeditation = BasicJFugueSamplePlayer.PlayMeditation(currentReading);
                String noteSmile = BasicJFugueSamplePlayer.PlaySmile(currentReading);
                String noteClench = BasicJFugueSamplePlayer.PlayClench(currentReading);
                String noteEyebrowRaise = BasicJFugueSamplePlayer.PlayEyebrowRaise(currentReading);

                Player player = new Player();
                String emotiSong = noteExcitementShortTerm + "+" + noteExcitementLongTerm; /* + "+" + noteEngagementBoredom
                                + "+" + noteFrustration + "+" + noteMeditation + "+" + noteSmile + "+" + noteClench
                                + "+" + noteEyebrowRaise;*/
                player.play(emotiSong);
            }

        } catch (FileNotFoundException e) {
            logger.LogException(e);
        }
    }
}
