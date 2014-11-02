import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class BasicJFugueSamplePlayer {

    private BasicJFugueSamplePlayer instance = null;
    private static float excitementShortTermExtent;
    private static float excitementLongTermExtent;
    private static float engagementBoredomExtent;
    private static float frustrationExtent;
    private static float meditationExtent;
    private static float eyebrowRaiseExtent;
    private static float smileExtent;
    private static float clenchExtent;

    private static List<String> musicalNotes = new ArrayList<String>() {{
        add("");
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
    }};

    private static List<String> noteDuration = new ArrayList<String>() {{
        add("");
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

    public static StringFloatTuple GetExcitementShortTuple(EmotivReading reading)
    {
        excitementShortTermExtent = reading.ExcitementShortTerm;
        String musicalNoteExcitementShortTerm = musicalNoteScale.DoScale(excitementShortTermExtent * 100);
        String duration = durationScale.DoScale(excitementShortTermExtent * 100);
        final String musicalNotes = "I[Guitar] " + musicalNoteExcitementShortTerm + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = excitementShortTermExtent;}};
    }

    public static StringFloatTuple GetExcitementLongTermTuple(EmotivReading reading)
    {
        excitementLongTermExtent = reading.ExcitementLongTerm;
        String musicalNoteExcitementLongTerm = musicalNoteScale.DoScale(excitementLongTermExtent * 100);
        String duration = durationScale.DoScale(excitementLongTermExtent * 100);
        final String musicalNotes = "I[SYNTH_DRUM] " + musicalNoteExcitementLongTerm + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = excitementLongTermExtent;}};
    }

    public static StringFloatTuple GetEngagementBoredomTuple(EmotivReading reading)
    {
        engagementBoredomExtent = reading.EngagementBoredom;
        String musicalNoteEngagementBoredom =musicalNoteScale.DoScale(engagementBoredomExtent * 100);
        String duration = durationScale.DoScale(engagementBoredomExtent * 100);
        final String musicalNotes = "I[ACOUSTIC_BASS] " + musicalNoteEngagementBoredom + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = engagementBoredomExtent;}};
    }

    public static StringFloatTuple GetFrustrationTuple(EmotivReading reading)
    {
        frustrationExtent = reading.Frustration;
        String musicalNoteFrustration = musicalNoteScale.DoScale(frustrationExtent * 100);
        String duration = durationScale.DoScale(frustrationExtent * 100);
        final String musicalNotes = "I[Piano] " + musicalNoteFrustration + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = frustrationExtent;}};
    }

    public static StringFloatTuple GetMeditationTuple(EmotivReading reading)
    {
        meditationExtent = reading.Meditation;
        String musicalNoteMeditation = musicalNoteScale.DoScale(meditationExtent * 100);
        String duration = durationScale.DoScale(meditationExtent * 100);
        final String musicalNotes = "I[Violin] " + musicalNoteMeditation + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = meditationExtent;}};
    }

    public static StringFloatTuple GetEyebrowRaiseTuple(EmotivReading reading)
    {
        eyebrowRaiseExtent = reading.EyebrowRaise;
        String musicalNoteEyebrowRaise = musicalNoteScale.DoScale(eyebrowRaiseExtent * 100);
        String duration = durationScale.DoScale(eyebrowRaiseExtent * 100);
        final String musicalNotes = "I[PAN_FLUTE] " + musicalNoteEyebrowRaise + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = eyebrowRaiseExtent;}};
    }

    public static StringFloatTuple GetSmileTuple(EmotivReading reading)
    {
        smileExtent = reading.Smile;
        String musicalNoteSmile = musicalNoteScale.DoScale(smileExtent * 100);
        String duration = durationScale.DoScale(smileExtent * 100);
        final String musicalNotes = "I[ALTO_SAX] " + musicalNoteSmile + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = smileExtent;}};
    }

    public static StringFloatTuple PlayClench(EmotivReading reading)
    {
        clenchExtent = reading.Clench;
        String musicalNoteClench = musicalNoteScale.DoScale(clenchExtent * 100);
        String duration = durationScale.DoScale(clenchExtent * 100);
        final String musicalNotes = "I[Banjo] " + musicalNoteClench + duration;
        return new StringFloatTuple(){{aString = musicalNotes; aFloat = clenchExtent;}};
    }

    public static String PlayBlink(EmotivReading reading)
    {
        if (reading.Blink)
            return "I[Crystal] De";
        else
            return "";
    }

    public static String PlayWinkLeft(EmotivReading reading)
    {
        if (reading.WinkLeft)
            return "I[Sweep] De";
        else
            return "";
    }

    public static String PlayWinkRight(EmotivReading reading)
    {
        if (reading.WinkRight)
            return "I[Halo] De";
        else
            return "";
    }

    public static String PlaySmirkRight(EmotivReading reading)
    {
        if (reading.SmirkRight)
            return "I[Metallic] De";
        else
            return "";
    }

    public static String PlaySmirkLeft(EmotivReading reading)
    {
        if (reading.SmirkLeft)
            return "I[Bowed] De";
        else
            return "";
    }

    public static String PlayLaugh(EmotivReading reading)
    {
        if (reading.SmirkLeft)
            return "I[Choir] De";
        else
            return "";
    }

    public static String PlayFurrowBrow(EmotivReading reading)
    {
        if (reading.FurrowBrow)
            return "V9 [ACOUSTIC_BASS_DRUM] De";
        else
            return "";
    }

    public static List<String> GenerateMusicalStrings(EmotivReading currentReading) {
        final StringFloatTuple noteExcitementShortTerm = BasicJFugueSamplePlayer.GetExcitementShortTuple(currentReading);
        final StringFloatTuple noteExcitementLongTerm = BasicJFugueSamplePlayer.GetExcitementLongTermTuple(currentReading);
        final StringFloatTuple noteEngagementBoredom = BasicJFugueSamplePlayer.GetEngagementBoredomTuple(currentReading);
        final StringFloatTuple noteFrustration = BasicJFugueSamplePlayer.GetFrustrationTuple(currentReading);
        final StringFloatTuple noteMeditation = BasicJFugueSamplePlayer.GetMeditationTuple(currentReading);
        final StringFloatTuple noteSmile = BasicJFugueSamplePlayer.GetSmileTuple(currentReading);
        final StringFloatTuple noteClench = BasicJFugueSamplePlayer.PlayClench(currentReading);
        final StringFloatTuple noteEyebrowRaise = BasicJFugueSamplePlayer.GetEyebrowRaiseTuple(currentReading);

        //Compute max.
        List<StringFloatTuple> musicalNotesWithValues = new ArrayList<StringFloatTuple>(){{
            add(noteExcitementShortTerm);
            add(noteExcitementLongTerm);
            add(noteEngagementBoredom);
            add(noteFrustration);
            add(noteMeditation);
            add(noteSmile);
            add(noteClench);
            add(noteEyebrowRaise);
        }};

        Collections.sort(musicalNotesWithValues, Collections.reverseOrder());

        List<String> result = new LinkedList<String>();
        result.add(musicalNotesWithValues.get(0).aString);
        result.add(musicalNotesWithValues.get(1).aString);
        result.add(musicalNotesWithValues.get(2).aString);

        return result;
    }

}

class StringFloatTuple implements Comparable<StringFloatTuple>
{
    String aString;
    float aFloat;

    @Override
    public int compareTo(StringFloatTuple o) {
        if(this.aFloat < o.aFloat)
        {
            return -1;
        }
        else if(this.aFloat > o.aFloat)
        {
            return 1;
        }
        else{
            return 0;
        }
    }
}
