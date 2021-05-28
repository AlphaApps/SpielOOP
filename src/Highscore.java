import java.util.ArrayList;

public class Highscore extends ArrayList <Score>{
    
    private static Highscore singletonObj = null;
    
    private Highscore()
    {

    }

    public static Highscore getInstance()
    {
        if (singletonObj == null)
        {
            singletonObj = new Highscore();
        }
        return singletonObj;
    }
}
