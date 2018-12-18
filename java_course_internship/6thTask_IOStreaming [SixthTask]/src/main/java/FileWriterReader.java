import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
    public void writer(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            String text = "Hello Nicu!";
            writer.write(text);
            writer.append('\n');
            writer.append(')');

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void reader(String filePath) {

        try (FileReader reader = new FileReader(filePath)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
