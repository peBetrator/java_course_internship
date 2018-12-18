import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static final String filePath = "NewFolder/file.txt";

    public static void main(String[] args) throws Exception {
        CreateFile maFile = new CreateFile("NewFolder");
        //TODO
        //1 part

        //TODO NEEDS IMPROVEMENTS
        //ensure that written and read string from file is the same
        //

        maFile.createFolder();
        maFile.createFile("file.txt");
//        String textToWrite = "Here comes text";
//        maFile.writeToFile(textToWrite, filePath); //write to file a String (.getBytes() method)
        new FileWriterReader().writer(filePath);
        new FileWriterReader().reader(filePath);
//        maFile.readFromFile(filePath);//read from file (BufferedReader class)
//        maFile.deleteFile("file.txt");//delete file
//        maFile.deleteFile("Gangsters.txt");
//        maFile.deleteFolder();//delete folder

        //TODO
        //2 part
        new GetPath().Target();

        //TODO
        //3 part

        Gangster bob = new Gangster("Bob", "Singapore", 'M', "Yokudze");
        Civilian romec;
        FileOutputStream fos = new FileOutputStream("NewFolder/Gangsters.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bob);
        oos.close();

        FileInputStream fis = new FileInputStream("NewFolder/Gangsters.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println(ois.readObject().toString());
        romec = new Civilian(bob);
        System.out.println(romec.toString());
        fos.close();
        fis.close();
    }
}
