package steps;

import org.junit.Test;

import java.io.*;

public class ReadFromFile {
    //precise file path below
    static File file = new File("data.txt");
    FileReader fr;
    String st;

    {
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BufferedReader br = new BufferedReader(fr);

    public void ReadFile() throws IOException {
//        URL url = ReadFromFile.class.getResource("data.txt");
//        File file = new File(url.getPath());
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        br.close();
    }

    public void ReadFromFile() throws IOException {
        while ((st = br.readLine()) != null) {
            new MatchLine(st);
            new User(MatchLine.getName());
            new OrderDetails(MatchLine.getDate());
            new Product(MatchLine.getProduct());
        }
        br.close();
    }

    public void DisplayData() throws IOException {
        while ((st = br.readLine()) != null) {
            new MatchLine(st);
            new User(MatchLine.getName()).getData();
            new OrderDetails(MatchLine.getDate()).compareDates();
            new Product(MatchLine.getProduct()).getData();
        }
        br.close();
    }

    @Test
    public static boolean existFile() {
        boolean exists = file.exists();
        return exists;
    }

    @Test
    public static boolean dataExists() {
        boolean empty = file.length() == 0;
        return empty;
    }

}
