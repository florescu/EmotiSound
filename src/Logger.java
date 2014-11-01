/**
 * Created by rosudrag-pc on 11/1/2014.
 */
public class Logger {
    private static Logger instance = null;

    protected Logger() {}

    public static Logger GetInstance()
    {
        if(instance == null)
        {
            instance = new Logger();
        }
        return instance;
    }

    public static void LogException(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
