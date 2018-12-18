import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(23);
//        list1.add(22);
//        list1.add(21);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(23);
//        list2.add(3);
//
//        GenericClass<Integer> cl = new GenericClass<>();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Max");
        list1.add("Lol");
        list1.add("Kek");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Max");
        list2.add("3");

        GenericClass<String> cl = new GenericClass<>();

        System.out.print("Concatenated list is : ");
        System.out.println(cl.concatList(list1, list2));
        System.out.print("Difference between two lists is : ");
        System.out.println(cl.findUnCommon(list1, list2));
        System.out.print("Intersection between two lists is : ");
        System.out.println(cl.findCommon(list1, list2));
        System.out.print("Lists are elements in common : ");
        System.out.println(Collections.disjoint(list1, list2)); //disjoint is used to check if two collections have no elements in common

        DataTransfer<Integer> Coffe = new DataTransfer<>(12);
        Coffe.setCoffee();

        LocalDateTime date1 = LocalDateTime.now();
        Period period = Period.ofDays(2);
        Duration duration = Duration.of(2, ChronoUnit.HOURS);
        System.out.println("Add days " + new ActionsWithTime(date1).addTime(period));
        System.out.println("Add hours " + new ActionsWithTime(date1).addTime(duration));

        LocalTime date2 = LocalTime.now();
        System.out.println(new ActionsWithTime<>(date2).addTime(duration));
        System.out.println("Subtract time " + new ActionsWithTime(date2).subtractTime(duration));


    }
}
