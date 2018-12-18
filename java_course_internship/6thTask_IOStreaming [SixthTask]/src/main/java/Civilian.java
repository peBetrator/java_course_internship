import java.io.Serializable;

public class Civilian implements Serializable {
    private String name;
    private String nationality;
    private char gender;
    private String rank;

    public Civilian(Gangster gangster) {
        this.name = gangster.getName();
        this.nationality = gangster.getNationality();
        this.gender = gangster.getGender();
        this.rank = gangster.getRank();
    }
    @Override
    public String toString() {
        return "Civilian{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", rank='" + rank + '\'' +
                '}';
    }
}
