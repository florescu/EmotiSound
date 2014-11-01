import java.util.LinkedList;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class MindToMusicController implements IMindToMusicController{
    private LinkedList<EmotivReading> EmotivReadings;

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
}
