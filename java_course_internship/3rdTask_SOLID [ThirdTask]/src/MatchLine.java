public class MatchLine {
    /******************
     Gets string line with all data and splits it to variables
     *****************/
    public static int numberId;
    public static String name;
    public static String date;
    public static int product;

    public MatchLine(String line) {
        String[] split = line.split(";");
        name = split[0];
        date = split[1];
        numberId = Integer.parseInt(split[2]);
        product = Integer.parseInt(split[3]);
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
