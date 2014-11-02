import org.jfugue.Player;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class JFugueSamplePlayer {

    private static Logger logger = Logger.GetInstance();

    public static void main(String[] args) throws Exception {
        String filename = "sample3.txt";

            List<EmotivReading> readings = EmotivReadingSampleDeserializer.DeserializeFileIntoReadingList(filename);

            MindToMusicController mc = MindToMusicController.GetInstance();

            mc.AddCompleteSample(readings);

            Player player = new Player();

            //Start recording
            //Thread soundRecorder = new Thread(new JavaSoundRecorder());
            //soundRecorder.start();

            while(mc.HasReadings())
            {
                EmotivReading currentReading = mc.GetNextReading();

                BasicJFugueSamplePlayer.PlayReading(player, currentReading);

                //String musicalString = AdvancedJFugueSamplePlayer.ProcessReadingMethodOne(currentReading);
                //player.play(musicalString);

            }
            //soundRecorder.interrupt();

    }
}
