import java.util.List;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class MusicalStringComposer {
    protected MusicalStringComposer(){};

    public static String AppendVoice(List<String> strings)
    {
        String result = "";
        int counter = 0;

        for(String string : strings)
        {
            if(counter == 16)
            {
                break;
            }

            String voice = "V" + counter;

            result += " " + voice + " " + string;

            counter++;
        }

        return result;
    }
}
