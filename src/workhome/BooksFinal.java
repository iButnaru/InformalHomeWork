package workhome;

import workhome.BooksObjects.ArtAlbums;
import workhome.BooksObjects.Books;
import workhome.BooksObjects.Novels;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Books
 * @see Novels
 * @see ArtAlbums
 * <p>
 * Using Scanner it gives directions in which to continue
 * Option 1 - has 3 more options - to add an object of type {@link Books}, {@link Novels}, {@link ArtAlbums} to a specific list for each one.
 * Then it prints the new list with the added book.
 * Option 2 - has 3 more options - shows the list of the object of type {@link Books}, {@link Novels}, {@link ArtAlbums}.
 * Deletes the name of the inserted book and it prints the new list.
 * Option 3 - It prints all the existing objects of type {@link Books}, {@link Novels}, {@link ArtAlbums}.
 * Option 0 - exits the program.
 * *
 */
public class BooksFinal {

    private static final Logger LOGGER = Logger.getLogger(BooksFinal.class.getName());

    public static void main(String[] args) {

        BooksCatalogues b = new BooksCatalogues();
        int option;
        b.loadBook();

        do {
            Scanner scanner = new Scanner(System.in);
            LOGGER.info("In order to continue..." + "\n       Press 1 to add an item" + "\n       Press 2 to delete an item" + "\n       Press 3 just to see all items" + "\n       Press 0 to exit the program.");
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