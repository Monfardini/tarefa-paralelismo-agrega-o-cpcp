import java.io.File;

public class Filee {

    private String name;
    private File file;

    public Filee(String name, File file) {
        this.name = name;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }
}
