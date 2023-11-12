import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream dictionary = Files.newInputStream(Path.of("./files/wordlist.txt"));
        Scanner userInput = new Scanner(System.in);
        Logic l = new Logic(dictionary, userInput);
        l.run();

    }


}
