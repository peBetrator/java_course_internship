import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetPath {
    public String Absolute() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s;
    }

    public String Relative() {
        File resourceFile = new File("/pom.xml");
        String s = Absolute() + resourceFile;
        return s;
    }

    public void Target(){
        Path path1 = Paths.get(Absolute());
        Path path2 = Paths.get(Relative());

        System.out.printf("Path from %s to %s: %s%n",
                path1, path2, path1.relativize(path2));
    }
}
