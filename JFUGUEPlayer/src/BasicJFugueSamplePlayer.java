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
        String musicalNoteExcitementShortTerm = MusicalNoteScale.Scale(excitementShortTermExtent * 100, 0, 100, musicalNotes);
        return musicalNoteExcitementShortTerm;
    }

    public static String PlayExcitementLongTerm(EmotivReading reading)
    {
        float excitementLongTermExtent = reading.ExcitementLongTerm;
        String musicalNoteExcitementLongTerm = MusicalNoteScale.Scale(excitementLongTermExtent * 100, 0, 100, musicalNotes);
        return musicalNoteExcitementLongTerm;
    }

    public static String PlayEngagementBoredom(EmotivReading reading)
    {
        float engagementBoredomExtent = reading.EngagementBoredom;
        String musicalNoteEngagementBoredom = MusicalNoteScale.Scale(engagementBoredomExtent * 100, 0, 100, musicalNotes);
        return musicalNoteEngagementBoredom;
    }

    public static String PlayFrustration(EmotivReading reading)
    {
        float frustrationExtent = reading.Frustration;
        String musicalNoteFrustration = MusicalNoteScale.Scale(frustrationExtent * 100, 0, 100, musicalNotes);
        return musicalNoteFrustration;
    }

    public static String PlayMeditation(EmotivReading reading)
    {
        float meditationExtent = reading.Meditation;
        String musicalNoteMeditation = MusicalNoteScale.Scale(meditationExtent * 100, 0, 100, musicalNotes);
        return musicalNoteMeditation;
    }

    public static String PlayEyebrowRaise(EmotivReading reading)
    {
        float eyebrowRaiseExtent = reading.EyebrowRaise;
        String musicalNoteEyebrowRaise = MusicalNoteScale.Scale(eyebrowRaiseExtent * 100, 0, 100, musicalNotes);
        return musicalNoteEyebrowRaise;
    }

    public static String PlaySmile(EmotivReading reading)
    {
        float smileExtent = reading.Smile;
        String musicalNoteSmile = MusicalNoteScale.Scale(smileExtent * 100, 0, 100, musicalNotes);
        return musicalNoteSmile;
    }

    public static String PlayClench(EmotivReading reading)
    {
        float clenchExtent = reading.Clench;
        String musicalNoteClench = MusicalNoteScale.Scale(clenchExtent * 100, 0, 100, musicalNotes);
        return musicalNoteClench;
    }

}
