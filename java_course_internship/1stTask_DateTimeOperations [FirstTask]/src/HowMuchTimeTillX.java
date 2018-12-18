import java.text.SimpleDateFormat;
import java.util.Calendar;

//TODO
//Count how much time(months , days and hours) is left till Christmas

public class HowMuchTimeTillX {
    public static void HowMuchTimeTillX() {
        Calendar now = Calendar.getInstance();
        Calendar temp_now = Calendar.getInstance();
        Calendar xmass = Calendar.getInstance();
        xmass.set(Calendar.MONTH, Calendar.DECEMBER);
        xmass.set(Calendar.DAY_OF_MONTH, 25);
        long diff = xmass.getTimeInMillis() - now.getTimeInMillis();

        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        System.out.print("There are " + diffDays / 30 + " months, ");

        if (diffDays / 30 > 1) while (diffDays >= xmass.get(Calendar.DAY_OF_MONTH)) {
            System.out.println(diffDays);
            int today = temp_now.get(Calendar.DAY_OF_MONTH);
            int days = temp_now.getActualMaximum(Calendar.DAY_OF_MONTH);
            diffDays -= (days - today);
            temp_now.set(Calendar.MONTH, Calendar.MONTH + 1);
        }
        else {
            int today = temp_now.get(Calendar.DAY_OF_MONTH);
            int days = temp_now.getActualMaximum(Calendar.DAY_OF_MONTH);
            diffDays -= (days - today);
        }
        System.out.print(diffDays - now.get(Calendar.DAY_OF_MONTH) + " days, ");

        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        Integer tempHours = Integer.valueOf(sdf.format(now.getTime()));
        System.out.println((24 - tempHours) + " hours till Xmas.");
    }
}
