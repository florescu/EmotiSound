import java.util.LinkedList;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class MindToMusicController implements IMindToMusicController{
    private LinkedList<EmotivReading> EmotivReadings;

    private static IMindToMusicController instance = null;

    protected MindToMusicController()
    {

    }

    public static IMindToMusicController GetInstance()
    {
        if(instance == null)
        {
            instance = new MindToMusicController();
        }

        return instance;
    }

    @Override
    public void AddReading(EmotivReading emotivReading) {
        this.EmotivReadings.add(emotivReading);
    }

    @Override
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
