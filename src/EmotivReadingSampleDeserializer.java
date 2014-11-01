/**
 * Created by rosudrag-pc on 11/1/2014.
 */

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EmotivReadingSampleDeserializer {

    public static List<EmotivReading> DeserializeFileIntoReadingList(String filename) throws FileNotFoundException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader(filename));

        List<EmotivReading> readings = gson.fromJson(br, new TypeToken<List<EmotivReading>>(){}.getType());

        return readings;
    }
}
