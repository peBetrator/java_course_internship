package steps;

import java.util.Date;
import java.util.Random;

public class Generate {
    //generate random ID
    public static int generateInt() {
        Date d = new Date();
        //it will return unique value based on time
        int bound = Math.abs((int) d.getTime());
        return bound + new Random().nextInt(10);

    }
}
