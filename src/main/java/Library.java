import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Library {
   static HashMap<String, Book> library = new HashMap<String, Book>();
   static List<Book> cart = new ArrayList<Book>();
   static Scanner scanner = new Scanner(System.in);
   static String userInput;

    public static void addBook(){
        while (true){
            System.out.println("If you would like to add a book; type add. If not, type the title of the book to lookup the book. Type DONE is you are finished!");
            userInput = scanner.next();
            System.out.println(userInput);
            if (!(userInput.equals("add"))){
                lookUp(userInput);
            } else if (userInput.equals("DONE")){
                break;
            }
            else {
                System.out.println("What is the title?");
                String title = scanner.next();
                System.out.println("How many pages does it have?");
                int pageCount = scanner.nextInt();
                System.out.println("What is the genre?");
                String genre = scanner.next();
                Book book = new Book(title, genre, pageCount);
                library.put(title, book);
                cart.add(book);
                System.out.println(cart);
               }
             }   
             System.out.println("Your cart:");
             System.out.println(cart);
             scanner.close();
        }

    @Override
    public String toString() {
        return "Library []";
    }
    static public void lookUp(String title){
        if(library.containsKey(title)){
            System.out.println("Looks like we have that book:");
            System.out.println(library.get(title));
        }
        else {
            System.out.println("Sorry looks like we dont have that book.");
        }
    }
}
