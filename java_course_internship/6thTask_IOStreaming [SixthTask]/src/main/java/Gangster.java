import java.io.Serializable;

public class Gangster implements Serializable {
    //private transient String name; //while adding transient keyword to variable it won't be persisted to file and recovered to object
    private String name;
    private String nationality;
    private char gender;
    private String rank;

    public Gangster(String name, String nationality, char gender, String rank) {
        this.name = name;
        this.nationality = nationality;
        this.gender = gender;
        this.rank = rank;
    }
    @Override
    public String toString() {
        return "Gangster{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", rank='" + rank + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public char getGender() {
        return gender;
    }

    public String getRank() {
        return rank;
    }
}
