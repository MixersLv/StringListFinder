import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    private final ArrayList<String> wordList = new ArrayList<String>();
    private final String eq = "=".repeat(50);
    private final ArrayList<String> matches = new ArrayList<String>();
    private final InputStream dictionary;
    private final Scanner scanner;
    private String searchword;

   public Logic(InputStream dictionary, Scanner scanner){
      this.dictionary = dictionary;
      this.scanner = scanner;
    }

    // RUNS ALL METHODS
    public void run() {
        //generate100();
        readDictionary();
        search();
        printSearch();
        keepSearching();
    }

    // MADE FOR TESTING
    public void generate100() {
        for (int i = 0; i <= 100; i++) {
            wordList.add(String.valueOf(i));
        }
    }

    // ASKS FOR STRING INPUT
    public void readDictionary() {
        Scanner inputd = new Scanner(dictionary);
       while (inputd.hasNextLine()){
           String word = inputd.nextLine();
           wordList.add(word);
       }
    }


    // ASKS AND SEARCHES FOR SEARCHWORD IN EACH LIST INDEX
    public void search() {

        matches.clear();

        System.out.println("Enter a character, word, sentance to search for in the list: ");
        searchword = scanner.nextLine();

        for (int i = 0; i < wordList.size(); i++) {

            if (wordList.get(i).contains(searchword)) {
                matches.add(wordList.get(i));
            }

        }

    }

    // PRINTS OUT THE MATCHING STRINGS
    public void printSearch() {
        System.out.println(eq + "\nMatching results containing: " + searchword + "\n");

        for (int i = 0; i < matches.size(); i++) {
            System.out.println(matches.get(i));
        }

        if (matches.isEmpty()) {
            System.out.println("No match was found!");
        }

    }

    public void keepSearching() {
        System.out.println("\n" + eq + "\nDo you want to search another keyword? ( YES/NO ): ");
        String answerkeepsearch = scanner.nextLine();
        if (answerkeepsearch.equals("YES")) {
            search();
            System.out.println(eq);
            printSearch();
            keepSearching();
        } else {
            System.exit(0);
        }
    }

}