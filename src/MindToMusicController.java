import java.util.LinkedList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class MindToMusicController {
    private LinkedList<EmotivReading> EmotivReadings;

    private static MindToMusicController instance = null;

    protected MindToMusicController()
    {
    	EmotivReadings = new LinkedList<EmotivReading>();
    }

    public static MindToMusicController GetInstance()
    {
        if(instance == null)
        {
            instance = new MindToMusicController();
        }

        return instance;
    }

    public void AddReading(EmotivReading emotivReading) {
        this.EmotivReadings.add(emotivReading);
    }

    public EmotivReading GetNextReading() {
        EmotivReading reading = EmotivReadings.getFirst();
        EmotivReadings.removeFirst();
        return reading;
    }

    public List<EmotivReading> GetAllReadings()
    {
        return EmotivReadings;
    }


}
