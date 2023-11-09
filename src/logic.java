import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class logic {

    private ArrayList<String> mylist = new ArrayList<String>();
    ArrayList<String> matches;
    Scanner scanner;
    String searchword;
    int matchcount = 0;
    String eq = "=".repeat(50);

    // RUNS ALL METHODS
    public void run() {
        scanner = new Scanner(System.in);
        //generate100();
        askinput();
        printlist();
        search();
        printsearch();
        keepsearching();
    }

    // MADE FOR TESTING
    public void generate100(){
        for (int i = 0; i <= 100; i++) {
            mylist.add(String.valueOf(i));
        }
    }

    // ASKS FOR STRING INPUT
    public void askinput() {

        boolean keepask = true;
        scanner = new Scanner(System.in);
        System.out.println("Q to Stop asking");

        while (keepask == true) {

            System.out.println("Enter your word or sentance: ");
            String string = scanner.nextLine();

            //RUNNING/ EXIT SEQUENCE
            if (string.equals("Q")) {
                keepask = false;
            }
            else {
                mylist.add(string);
            }

        }

    }

    // PRINTS OUT THE WHOLE LIST
    public void printlist() {

        System.out.println("\n=====LIST CONTENT=====");

        for (int i = 0; i < mylist.size(); i++) {
            String line = "-".repeat(25);
            System.out.println(line);
            System.out.println(mylist.get(i));

        }

    }

    // ASKS AND SEARCHES FOR SEARCHWORD IN EACH LIST INDEX
    public void search(){
        matches = new ArrayList<String>();

        System.out.println("Enter a character, word, sentance to search for in the list: ");
        searchword = scanner.nextLine();

        for (int i = 0; i < mylist.size(); i++) {

            if(mylist.get(i).contains(searchword)){
                matches.add(mylist.get(i));
                matchcount++;
            }

            else{
                //KEEP RUNNING
            }

        }

    }

    // PRINTS OUT THE MATCHING STRINGS
    public void printsearch(){
        System.out.println(eq+ "\nMatching results containing: " + searchword + "\n");

        for (int i = 0; i < matches.size(); i++) {
            System.out.println(matches.get(i));
        }

        if(matchcount==0){
            System.out.println("No match was found!");
        }
        else{
            // DO NOTHING
        }

    }

    public void keepsearching(){
        System.out.println("\n" + eq + "\nDo you want to search another keyword? ( YES/NO ): ");
        String answerkeepsearch = scanner.nextLine();
        if(answerkeepsearch.equals("YES")){
            search();
                System.out.println(eq);
            printsearch();
            keepsearching();
        }
        else{
            System.exit(0);
        }
    }

}