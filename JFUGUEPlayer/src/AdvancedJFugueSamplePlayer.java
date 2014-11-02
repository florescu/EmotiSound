import org.jfugue.Instrument;
import org.jfugue.JFugueDefinitions;
import org.jfugue.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/2/2014.
 */
public class AdvancedJFugueSamplePlayer {
    /*private static List<String> musicalNotes = new ArrayList<String>() {{
        add("");
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
    }};*/

    private static List<String> noteDuration = new ArrayList<String>() {{
        add("n");
        add("x");
        add("t");
        add("s");
        add("i");
        add("q");
    }};

    private static List<String> musicalNotes = new ArrayList<String>(Arrays.asList(Note.NOTES));
    private static List<String> instruments = new ArrayList<String>(Arrays.asList(Instrument.INSTRUMENT_NAME));


    private static FloatScale<String> musicalNoteScale = new FloatScale<String>(0, 100, musicalNotes);
    private static FloatScale<String> instrumentScale = new FloatScale<String>(0, 100, instruments);
    private static FloatScale<String> durationScale = new FloatScale<String>(0, 100, noteDuration);

    public static String ProcessReadingMethodOne(EmotivReading reading)
    {
        String instrument;
        String duration;
        String note;
        String musicalString = "";

        instrument = "I["+ instrumentScale.DoScale(reading.Clench) + "]";
        duration = durationScale.DoScale(reading.EyebrowRaise);
        note = musicalNoteScale.DoScale(reading.Smile);

        musicalString = instrument + " " + note + duration;

        return musicalString;
    }
}
