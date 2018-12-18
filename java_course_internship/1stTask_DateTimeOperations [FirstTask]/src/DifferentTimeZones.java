import java.util.Calendar;
import java.util.TimeZone;

//TODO
//Show what time is it in time-zone given as parameter

public class DifferentTimeZones {

    public static void DifferentTimeZones(String GMT) {
        TimeZone tz = TimeZone.getTimeZone(GMT);
        Calendar c = Calendar.getInstance(tz);

        System.out.println(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
    }
}
