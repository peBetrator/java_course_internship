public class User {

    private static String userName;
    private static int id;

    public User(String userName) {
        this.userName = userName;
        this.id = Generate.generateInt();
    }

    public static void getUserData() {
        System.out.println("ID - " + id + "; Name - " + userName);
    }
}