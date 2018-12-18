import java.io.*;

public class CreateFile {
    private String FOLDER;

    public CreateFile(String path) {
        this.FOLDER = path;
    }

    public void createFolder() {
        File newFolder = new File(FOLDER);
        boolean created = newFolder.mkdir();
        if (created)
            System.out.println("Folder was created !");
        else
            System.out.println("Unable to create folder");
    }

    public void deleteFolder() {
        File newFolder = new File(FOLDER);
        if (newFolder.delete()) {
            System.out.println(newFolder + "  was deleted");
        } else System.out.println("Folder " + newFolder + " was NOT deleted");
    }

    public void createFile(String fileName) throws IOException {
        File yourFile = new File(FOLDER + File.separator + fileName);
        yourFile.createNewFile(); // if file already exists will do nothing
        //FileOutputStream oFile = new FileOutputStream(yourFile, false);
        System.out.println("File created");
    }

    public void deleteFile(String fileName) {
        File yourFile = new File(FOLDER + File.separator + fileName);
        if (yourFile.delete()) {
            System.out.println(fileName + "  was deleted");
        } else System.out.println("File " + fileName + " doesn't exists in project root directory");
    }

    public void writeToFile(String text, String filePath) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        byte[] strToBytes = text.getBytes();
        outputStream.write(strToBytes);

        outputStream.close();
    }

    public void readFromFile(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);

        br.close();
    }

}