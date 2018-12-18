import java.util.Calendar;

//TODO
//Count how many days left till Christmas

public class CountDaysTillX {
    public static void CountDaysTillX() {
        Calendar now = Calendar.getInstance();
        Calendar xmass = Calendar.getInstance();
        xmass.set(Calendar.MONTH, Calendar.DECEMBER);
        xmass.set(Calendar.DAY_OF_MONTH, 25);
        long nowMilli = now.getTimeInMillis();
        long xmassMilli = xmass.getTimeInMillis();
        long delta = xmassMilli - nowMilli;
        System.out.println("Xmas is in " + (delta / 24 / 60 / 60 / 1000) + " days.");
    }
}
