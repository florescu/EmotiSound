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

        } catch (FileNotFoundException e) {
            logger.LogException(e);
        }
    }
}
