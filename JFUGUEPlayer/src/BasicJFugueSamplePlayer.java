import org.jfugue.Pattern;
import org.jfugue.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class BasicJFugueSamplePlayer {

    private BasicJFugueSamplePlayer instance = null;

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

    public static void PlayOne(EmotivReading reading)
    {
        float extent = reading.ExcitementShortTerm;

        List<String> musicalNotes = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
        }};

        String musicalNote = FloatScale.Scale(extent * 100, 0, 100, musicalNotes);

        Pattern song = new Pattern(musicalNote);

        Player player = new Player();

        player.play(song);
    }
}
