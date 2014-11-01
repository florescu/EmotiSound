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
        String filename = "sample3.txt";

            List<EmotivReading> readings = EmotivReadingSampleDeserializer.DeserializeFileIntoReadingList(filename);

            MindToMusicController mc = MindToMusicController.GetInstance();

            mc.AddCompleteSample(readings);

            Player player = new Player();
            Player player2 = new Player();

            while(mc.HasReadings())
            {
                EmotivReading currentReading = mc.GetNextReading();

                List<String> notesList = BasicJFugueSamplePlayer.GenerateMusicalStrings(currentReading);

                String notesAndVoices = MusicalStringComposer.AppendVoice(notesList.subList(0,1));
                String notesAndVoices2 = notesList.get(2);

                player.play(notesAndVoices);
                player2.play(notesAndVoices2);
            }

    }
}
