import java.util.Calendar;
import java.util.Date;

//TODO
// Find out what day of the week was on given as parameter date

public class FindOutDayOfTheWeek {
    public static void FindOutDayOfTheWeek(int yyyy, int mn, int dt) {
        String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
                "Friday", "Saturday"};
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(yyyy, mn, dt));
        System.out.println(strDays[c.get(Calendar.DAY_OF_WEEK) - 1] + ' ' + dt + "/" + mn + "/" + yyyy);
    }

}
