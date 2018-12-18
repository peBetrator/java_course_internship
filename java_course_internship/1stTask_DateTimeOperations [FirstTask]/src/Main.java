public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //count time spend


        new CountDaysTillX().CountDaysTillX();
        new HowMuchTimeTillX().HowMuchTimeTillX();
        System.out.print("London time ");
        new DifferentTimeZones().DifferentTimeZones("GMT+1");//London time
        System.out.print("New York time ");
        new DifferentTimeZones().DifferentTimeZones("GMT-4");//New York time
        System.out.print("Tokyo time ");
        new DifferentTimeZones().DifferentTimeZones("GMT+9");//Tokyo time
        new FindOutDayOfTheWeek().FindOutDayOfTheWeek(1985, 10, 18);

        long endTime = System.currentTimeMillis();
        System.out.print((endTime - startTime) + "ms");

    }

}


