import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Filee file1 = new Filee("gladiador", new File("utils/gladiador.txt"));
        Filee file2 = new Filee("lalaland", new File("utils/lalaland.txt"));
        Filee file3 = new Filee("lotr", new File("utils/lotr.txt"));
        Filee file4 = new Filee("spiderman", new File("utils/spiderman.txt"));
        Filee file5 = new Filee("superman", new File("utils/superman.txt"));
        Filee file6 = new Filee("toystory", new File("utils/toystory.txt"));

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2));

        pool.execute(new ProcessingOfFiles(file1, 2));
        pool.execute(new ProcessingOfFiles(file2, 6));
        pool.execute(new ProcessingOfFiles(file3, 3));
        pool.execute(new ProcessingOfFiles(file4, 1));
        pool.execute(new ProcessingOfFiles(file5, 7));
        pool.execute(new ProcessingOfFiles(file6, 5));

        pool.shutdown();
    }
}