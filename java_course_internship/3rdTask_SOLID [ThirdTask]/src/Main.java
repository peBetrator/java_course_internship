import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

//TODO
//Read data from file and parse it to objects:
//          User, Product and OrderDetails
// 

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = Main.class.getResource("data.txt");
        File f = new File("data.txt");
        //File f = new File(url.getPath());
        FileReader fr = new FileReader(f);


//        Path file = Paths.get("data.txt");
//        System.out.println(file.toAbsolutePath());

        BufferedReader br = new BufferedReader(fr);
        String st;
        while ((st = br.readLine()) != null) {
            new MatchLine(st);
            new User(MatchLine.getName()).getUserData();
            new OrderDetails(MatchLine.getDate()).compareDates();
            new Product(MatchLine.getProduct()).getProductID();
        }
        br.close();
    }
}

