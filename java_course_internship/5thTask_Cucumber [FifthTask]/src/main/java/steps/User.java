package steps;

public class User {
    private static String userName = null;
    private static int id;

    public User(String userName) {
        this.userName = userName;
        this.id = Generate.generateInt();
    }

    public static void getData() {
        System.out.println("ID - " + id + "; Name - " + userName);
    }

    public static boolean IfObjectWasCreated() {
        if (userName == null) return false;
        else return true;
    }
}
