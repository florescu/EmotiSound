import org.jfugue.Note;

import java.util.*;

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

    //private static List<String> musicalNotes = new ArrayList<String>(Arrays.asList(Note.NOTES));


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
        if (musicalNoteExcitementShortTerm != null && !musicalNoteExcitementShortTerm.isEmpty()) {
            final String musicalNotes = "I[Guitar] " + musicalNoteExcitementShortTerm + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = excitementShortTermExtent;
            }};
        }
        return null;
    }

    public static StringFloatTuple GetExcitementLongTermTuple(EmotivReading reading)
    {
        excitementLongTermExtent = reading.ExcitementLongTerm;
        String musicalNoteExcitementLongTerm = musicalNoteScale.DoScale(excitementLongTermExtent * 100);
        String duration = durationScale.DoScale(excitementLongTermExtent * 100);
        if (musicalNoteExcitementLongTerm != null && !musicalNoteExcitementLongTerm.isEmpty()) {
            final String musicalNotes = "I[SYNTH_DRUM] " + musicalNoteExcitementLongTerm + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = excitementLongTermExtent;
            }};
        }
        return null;
    }

    public static StringFloatTuple GetEngagementBoredomTuple(EmotivReading reading)
    {
        engagementBoredomExtent = reading.EngagementBoredom;
        String musicalNoteEngagementBoredom =musicalNoteScale.DoScale(engagementBoredomExtent * 100);
        String duration = durationScale.DoScale(engagementBoredomExtent * 100);
        if (musicalNoteEngagementBoredom != null && !musicalNoteEngagementBoredom.isEmpty()) {
            final String musicalNotes = "I[Music_Box] " + musicalNoteEngagementBoredom + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = engagementBoredomExtent;
            }};
        }
        return null;
    }

    public static StringFloatTuple GetFrustrationTuple(EmotivReading reading)
    {
        frustrationExtent = reading.Frustration;
        String musicalNoteFrustration = musicalNoteScale.DoScale(frustrationExtent * 100);
        String duration = durationScale.DoScale(frustrationExtent * 100);
        if (musicalNoteFrustration != null && !musicalNoteFrustration.isEmpty())
        {
            final String musicalNotes = "I[Piano] " + musicalNoteFrustration + duration;
            return new StringFloatTuple(){{aString = musicalNotes; aFloat = frustrationExtent;}};
        }
        return null;
    }

    public static StringFloatTuple GetMeditationTuple(EmotivReading reading)
    {
        meditationExtent = reading.Meditation;
        String musicalNoteMeditation = musicalNoteScale.DoScale(meditationExtent * 100);
        String duration = durationScale.DoScale(meditationExtent * 100);
        if (musicalNoteMeditation != null && !musicalNoteMeditation.isEmpty()) {
            final String musicalNotes = "I[Violin] " + musicalNoteMeditation + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = meditationExtent;
            }};
        }
        return null;
    }

    public static StringFloatTuple GetEyebrowRaiseTuple(EmotivReading reading)
    {
        eyebrowRaiseExtent = reading.EyebrowRaise;
        String musicalNoteEyebrowRaise = musicalNoteScale.DoScale(eyebrowRaiseExtent * 100);
        String duration = durationScale.DoScale(eyebrowRaiseExtent * 100);
        if (musicalNoteEyebrowRaise != null && !musicalNoteEyebrowRaise.isEmpty()) {
            final String musicalNotes = "I[PAN_FLUTE] " + musicalNoteEyebrowRaise + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = eyebrowRaiseExtent;
            }};
        }
        return null;
    }

    public static StringFloatTuple GetSmileTuple(EmotivReading reading)
    {
        smileExtent = reading.Smile;
        String musicalNoteSmile = musicalNoteScale.DoScale(smileExtent * 100);
        String duration = durationScale.DoScale(smileExtent * 100);
        if (musicalNoteSmile != null && !musicalNoteSmile.isEmpty()) {
            final String musicalNotes = "I[ALTO_SAX] " + musicalNoteSmile + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = smileExtent;
            }};
        }
        return null;
    }

    public static StringFloatTuple PlayClench(EmotivReading reading)
    {
        clenchExtent = reading.Clench;
        String musicalNoteClench = musicalNoteScale.DoScale(clenchExtent * 100);
        String duration = durationScale.DoScale(clenchExtent * 100);
        if (musicalNoteClench != null && !musicalNoteClench.isEmpty()) {
            final String musicalNotes = "I[Banjo] " + musicalNoteClench + duration;
            return new StringFloatTuple() {{
                aString = musicalNotes;
                aFloat = clenchExtent;
            }};
        }
        return null;
    }

    public static String PlayBlink(EmotivReading reading)
    {
        if (reading.Blink)
            return "I[Crystal] Di";
        else
            return "";
    }

    public static String PlayWinkLeft(EmotivReading reading)
    {
        if (reading.WinkLeft)
            return "I[Sweep] Di";
        else
            return "";
    }

    public static String PlayWinkRight(EmotivReading reading)
    {
        if (reading.WinkRight)
            return "I[Halo] Di";
        else
            return "";
    }

    public static String PlaySmirkRight(EmotivReading reading)
    {
        if (reading.SmirkRight)
            return "I[Metallic] Di";
        else
            return "";
    }

    public static String PlaySmirkLeft(EmotivReading reading)
    {
        if (reading.SmirkLeft)
            return "I[Bowed] Di";
        else
            return "";
    }

    public static String PlayLaugh(EmotivReading reading)
    {
        if (reading.SmirkLeft)
            return "I[Choir] Di";
        else
            return "";
    }

    public static String PlayFurrowBrow(EmotivReading reading)
    {
        if (reading.FurrowBrow)
            return  new Note(Note.ACOUSTIC_BASS_DRUM, 0.25).getMusicString();
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
        List<StringFloatTuple> musicalNotesWithValues = new ArrayList<StringFloatTuple>();
        if (noteExcitementShortTerm != null)
            musicalNotesWithValues.add(noteExcitementShortTerm);

        if (noteExcitementLongTerm != null)
            musicalNotesWithValues.add(noteExcitementLongTerm);

        if (noteEngagementBoredom != null)
            musicalNotesWithValues.add(noteEngagementBoredom);

        if (noteFrustration != null)
            musicalNotesWithValues.add(noteFrustration);

        if (noteMeditation != null)
            musicalNotesWithValues.add(noteMeditation);

        if (noteSmile != null)
            musicalNotesWithValues.add(noteSmile);

        if (noteClench != null)
            musicalNotesWithValues.add(noteClench);

        if (noteEyebrowRaise != null)
            musicalNotesWithValues.add(noteEyebrowRaise);

        Collections.sort(musicalNotesWithValues, Collections.reverseOrder());

        List<String> result = new LinkedList<String>();
        if (musicalNotesWithValues.size() > 2) {
            result.add(musicalNotesWithValues.get(0).aString);
            result.add(musicalNotesWithValues.get(1).aString);
            result.add(musicalNotesWithValues.get(2).aString);
        }
        else if (musicalNotesWithValues.size() == 2) {
            result.add(musicalNotesWithValues.get(0).aString);
            result.add(musicalNotesWithValues.get(1).aString);
        }
        else if (musicalNotesWithValues.size() == 1) {
            result.add(musicalNotesWithValues.get(0).aString);
        }

        String blinkString = PlayBlink(currentReading);
        if (blinkString != null && !blinkString.isEmpty())
            result.add(blinkString);

        String furrowString = PlayFurrowBrow(currentReading);
        if (furrowString != null && !furrowString.isEmpty())
            result.add(furrowString);

        String laughString = PlayLaugh(currentReading);
        if (laughString != null && !laughString.isEmpty())
            result.add(laughString);

        String smirkLeftString = PlaySmirkLeft(currentReading);
        if (smirkLeftString != null && !smirkLeftString.isEmpty())
            result.add(smirkLeftString);

        String smirkRightString = PlaySmirkRight(currentReading);
        if (smirkRightString != null && !smirkRightString.isEmpty())
            result.add(smirkRightString);

        String winkLeftString = PlayWinkLeft(currentReading);
        if (winkLeftString != null && !winkLeftString.isEmpty())
            result.add(winkLeftString);

        String winkRightString = PlayWinkRight(currentReading);
        if (winkRightString != null && !winkRightString.isEmpty())
            result.add(winkRightString);

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
