import java.util.Collections;
import java.util.*;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class MusicalNoteScale {

    public static <T> T Scale(float input, float min, float max, List<T> domainList)
    {
        int nrPartitions = domainList.size();

        float MaxMinusMin = max - min;
        float tick = MaxMinusMin / nrPartitions;

        List<Float> partitionedInput = new ArrayList<Float>();

        for(int i = 1; i <= nrPartitions; i++)
        {
            partitionedInput.add(i * tick + min);
        }

        if (input < partitionedInput.get(0))
        {
            return domainList.get(0);
        }
        else
        {
            for(int i = 1; i <= nrPartitions; i++)
            {
                if (input < partitionedInput.get(i))
                {
                    return domainList.get(i);
                }
            }

            return domainList.get(nrPartitions);
        }
    }
}
