package steps;

public class MatchLine {
    public static int numberId;
    public static String name;
    public static String date;
    public static int product;

    public MatchLine(String line) {
        String[] split = line.split(";");
        name = split[0];
        System.out.println(name);
        date = split[1];
        System.out.println(date);
        numberId = Integer.parseInt(split[2]);
        System.out.println(numberId);
        product = Integer.parseInt(split[3]);
        System.out.println(product);
    }

    public static String getName() {
        return name;
    }

    public static String getDate() {
        return date;
    }

    public static int getProduct() {
        return product;
    }
//    Pattern userId = Pattern.compile("user_id : (.*?)");
//    Matcher m = userId.matcher(st);
//    boolean b = m.matches();
}
