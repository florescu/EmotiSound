import java.util.Collections;
import java.util.*;

/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class FloatScale <T> {

    private List<T> DomainList;
    private float min;
    private float max;
    private float tick;
    private int nrPartitions;
    private List<Float> partitionedInput;

    public FloatScale(float min, float max, List<T> domainList){
        this.min = min;
        this.max = max;
        this.DomainList = domainList;
        this.nrPartitions = this.DomainList.size();
        this.tick = (max - min) / nrPartitions;

        this.partitionedInput = new ArrayList<Float>();

        for(int i = 1; i <= nrPartitions; i++)
        {
            partitionedInput.add(i * tick + min);
        }
    }

    public T DoScale(float input)
    {
        if (input < partitionedInput.get(0))
        {
            return this.DomainList.get(0);
        }
        else
        {
            for(int i = 1; i <= nrPartitions; i++)
            {
                if (input < partitionedInput.get(i))
                {
                    return this.DomainList.get(i);
                }
            }

            return this.DomainList.get(nrPartitions);
        }
    }
}
