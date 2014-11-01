import org.jfugue.Pattern;
import org.jfugue.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class BasicJFugueSamplePlayer {

    private BasicJFugueSamplePlayer instance = null;

    private static List<String> musicalNotes = new ArrayList<String>() {{
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
    }};

    private static List<String> noteDuration = new ArrayList<String>() {{
        add("n");
        add("x");
        add("t");
        add("s");
        add("i");
        add("q");
    }};

    private static FloatScale<String> musicalNoteScale = new FloatScale<String>(0, 100, musicalNotes);
    private static FloatScale<String> durationScale = new FloatScale<String>(0, 100, noteDuration);

    protected BasicJFugueSamplePlayer()
    {
    }

    public BasicJFugueSamplePlayer GetInstance()
    {
        if(instance == null)
        {
            instance = new BasicJFugueSamplePlayer();
        }

        return instance;
    }

    public static String PlayExcitementShortTerm(EmotivReading reading)
    {
        float excitementShortTermExtent = reading.ExcitementShortTerm;
        String musicalNoteExcitementShortTerm = musicalNoteScale.DoScale(excitementShortTermExtent * 100);
        String duration = durationScale.DoScale(excitementShortTermExtent * 100);
        return "I[Guitar] " + musicalNoteExcitementShortTerm + duration;
    }

    public static String PlayExcitementLongTerm(EmotivReading reading)
    {
        float excitementLongTermExtent = reading.ExcitementLongTerm;
        String musicalNoteExcitementLongTerm = musicalNoteScale.DoScale(excitementLongTermExtent * 100);
        String duration = durationScale.DoScale(excitementLongTermExtent * 100);
        return "I[SYNTH_DRUM] " + musicalNoteExcitementLongTerm + duration;
    }

    public static String PlayEngagementBoredom(EmotivReading reading)
    {
        float engagementBoredomExtent = reading.EngagementBoredom;
        String musicalNoteEngagementBoredom =musicalNoteScale.DoScale(engagementBoredomExtent * 100);
        String duration = durationScale.DoScale(engagementBoredomExtent * 100);
        return "I[ACOUSTIC_BASS] " + musicalNoteEngagementBoredom + duration;
    }

    public static String PlayFrustration(EmotivReading reading)
    {
        float frustrationExtent = reading.Frustration;
        String musicalNoteFrustration = musicalNoteScale.DoScale(frustrationExtent * 100);
        String duration = durationScale.DoScale(frustrationExtent * 100);
        return "I[Piano] " + musicalNoteFrustration + duration;
    }

    public static String PlayMeditation(EmotivReading reading)
    {
        float meditationExtent = reading.Meditation;
        String musicalNoteMeditation = musicalNoteScale.DoScale(meditationExtent * 100);
        String duration = durationScale.DoScale(meditationExtent * 100);
        return "I[Violin] " + musicalNoteMeditation + duration;
    }

    public static String PlayEyebrowRaise(EmotivReading reading)
    {
        float eyebrowRaiseExtent = reading.EyebrowRaise;
        String musicalNoteEyebrowRaise = musicalNoteScale.DoScale(eyebrowRaiseExtent * 100);
        String duration = durationScale.DoScale(eyebrowRaiseExtent * 100);
        return "I[PAN_FLUTE] " + musicalNoteEyebrowRaise + duration;
    }

    public static String PlaySmile(EmotivReading reading)
    {
        float smileExtent = reading.Smile;
        String musicalNoteSmile = musicalNoteScale.DoScale(smileExtent * 100);
        String duration = durationScale.DoScale(smileExtent * 100);
        return "I[ALTO_SAX] " + musicalNoteSmile + duration;
    }

    public static String PlayClench(EmotivReading reading)
    {
        float clenchExtent = reading.Clench;
        String musicalNoteClench = musicalNoteScale.DoScale(clenchExtent * 100);
        String duration = durationScale.DoScale(clenchExtent * 100);
        return "I[Banjo] " + musicalNoteClench + duration;
    }

}
