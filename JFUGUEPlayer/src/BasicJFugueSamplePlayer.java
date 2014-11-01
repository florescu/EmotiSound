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

    private static FloatScale<String> musicalNoteScale = new FloatScale<String>(0, 100, musicalNotes);

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
        return "V0 I[Guitar] " + musicalNoteExcitementShortTerm;
    }

    public static String PlayExcitementLongTerm(EmotivReading reading)
    {
        float excitementLongTermExtent = reading.ExcitementLongTerm;
        String musicalNoteExcitementLongTerm = musicalNoteScale.DoScale(excitementLongTermExtent * 100);
        return "V1 I[SYNTH_DRUM] " + musicalNoteExcitementLongTerm;
    }

    public static String PlayEngagementBoredom(EmotivReading reading)
    {
        float engagementBoredomExtent = reading.EngagementBoredom;
        String musicalNoteEngagementBoredom =musicalNoteScale.DoScale(engagementBoredomExtent * 100);
        return "V2 I[ACOUSTIC_BASS] " + musicalNoteEngagementBoredom;
    }

    public static String PlayFrustration(EmotivReading reading)
    {
        float frustrationExtent = reading.Frustration;
        String musicalNoteFrustration = musicalNoteScale.DoScale(frustrationExtent * 100);
        return "V3 I[Piano] " + musicalNoteFrustration;
    }

    public static String PlayMeditation(EmotivReading reading)
    {
        float meditationExtent = reading.Meditation;
        String musicalNoteMeditation = musicalNoteScale.DoScale(meditationExtent * 100);
        return "V4 I[Violin] " + musicalNoteMeditation;
    }

    public static String PlayEyebrowRaise(EmotivReading reading)
    {
        float eyebrowRaiseExtent = reading.EyebrowRaise;
        String musicalNoteEyebrowRaise = musicalNoteScale.DoScale(eyebrowRaiseExtent * 100);
        return "V5 I[PAN_FLUTE] " + musicalNoteEyebrowRaise;
    }

    public static String PlaySmile(EmotivReading reading)
    {
        float smileExtent = reading.Smile;
        String musicalNoteSmile = musicalNoteScale.DoScale(smileExtent * 100);
        return "V6 I[ALTO_SAX] " + musicalNoteSmile;
    }

    public static String PlayClench(EmotivReading reading)
    {
        float clenchExtent = reading.Clench;
        String musicalNoteClench = musicalNoteScale.DoScale(clenchExtent * 100);
        return "V7 I[Banjo] " + musicalNoteClench;
    }

}
