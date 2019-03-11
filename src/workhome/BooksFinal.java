package workhome;

import workhome.BooksObjects.ArtAlbums;
import workhome.BooksObjects.Books;
import workhome.BooksObjects.Novels;

import java.util.Scanner;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Books
 * @see Novels
 * @see ArtAlbums
 * <p>
 * Using Scanner it gives directions in which to continue
 * Option 1 - has 3 more options - to add an object of type Books/Novels/ArtAlbums to a specific list for each one.
 * Then it prints the new list with the added book.
 * Option 2 - has 3 more options - shows the list of the object of type Books/Novels/ArtAlbums.
 * Deletes the name of the inserted book and it prints the new list.
 * Option 3 - It prints all the existing objects of type Books, Novels and ArtAlbums.
 * Option 0 - exits the program.
 * *
 */
public class BooksFinal {

    public static void main(String[] args) {

        BooksTest b = new BooksTest();
        int option;
        b.loadBook();

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("In order to continue..." + "\nPress 1 to add an item" + "\nPress 2 to delete an item" + "\nPress 3 just to see all items" + "\nPress 0 to exit the program.");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    b.addBooks();
                    break;
                case 2:
                    b.removeBooks();
                    break;
                case 3:
                    b.listBooks();
                    break;
            }
        } while (option != 0);
    }
}