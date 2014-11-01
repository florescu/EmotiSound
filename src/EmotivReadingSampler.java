import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class EmotivReadingSampler {
    public static EmotivReadingSampler instance = null;

    private Logger logger = Logger.GetInstance();

    protected EmotivReadingSampler(){}

    public static EmotivReadingSampler GetInstance()
    {
        if(instance == null)
        {
            instance = new EmotivReadingSampler();
        }

        return instance;
    }

    public void CreateSampleFile(String filename, List<EmotivReading> emotivReadings)
    {
        Gson gson = new Gson();

        String json = gson.toJson(emotivReadings);

        try{
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        }
        catch (IOException e)
        {
            logger.LogException(e);
        }
    }
}
