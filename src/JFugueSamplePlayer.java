import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class JFugueSamplePlayer {

    private static Logger logger = Logger.GetInstance();

    public static void main(String[] args)
    {
        String filename = "sample1.txt";

        try {
            List<EmotivReading> readings = EmotivReadingSampleDeserializer.DeserializeFileIntoReadingList(filename);

            MindToMusicController mc = MindToMusicController.GetInstance();

            mc.AddCompleteSample(readings);


            while(mc.HasReadings())
            {
                EmotivReading currentReading = mc.GetNextReading();
                BasicJFugueSamplePlayer.PlayOne(currentReading);
            }


        } catch (FileNotFoundException e) {
            logger.LogException(e);
        }
    }
}
