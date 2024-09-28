import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessingOfFiles implements Runnable{

    private Filee file;
    private int time;

    public ProcessingOfFiles(Filee file, int time) {
        this.file = file;
        this.time = time;
    }

    @Override
    public void run() {
        String response;
        try {
            response = String.format("O arquivo %s tem %d palavras.", this.file.getName(), quantityOfWords());
        } catch (FileNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
    }

    public int quantityOfWords() throws FileNotFoundException, InterruptedException {
        System.out.println("Iniciando leitura do arquivo " + this.file.getName());
        Scanner leitor = new Scanner(this.file.getFile());
        int quantity = 0;
        System.out.println("contando palavras do arquivo " + this.file.getName());
        while (leitor.hasNext()) {
            String word = leitor.next();
            quantity++;
        }
        Thread.sleep(time*1000);
        return quantity;
    }
}
