import java.util.Date;

public class OrderDetails {
    private static int DD;
    private static int MM;
    private static int YYYY;

    public OrderDetails(String date) {
        String[] values = date.split("-");
        DD = Integer.parseInt(values[0]);
        MM = Integer.parseInt(values[1]);
        YYYY = Integer.parseInt(values[2]);
//        String[] date1 = date.split("-");
//        Calendar beginTime = Calendar.getInstance();
//        beginTime.set(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]), Integer.parseInt(date1[0]));
    }

    public static void compareDates() {
        /************
         Check if order was made before 10.30.2018
         ************/
        Date date1 = new Date(YYYY, MM, DD);
        long diff1 = date1.getTime();
        Date date2 = new Date(2018, 10, 30);
        long diff2 = date2.getTime();

        if (diff1 < diff2) System.out.println("Order was made before 10/30/2018");
        if (diff1 >= diff2) System.out.println("Order was made after 10/30/2018");
    }


}
