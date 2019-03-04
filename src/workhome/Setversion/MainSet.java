package workhome.Setversion;

import workhome.ArtAlbums;
import workhome.Books;
import workhome.Novels;

import java.util.Scanner;

/**
     * @author Ionut Butnaru
     * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
     * @version 1.0
     * @see SetVersion
     * @see Books
     * @see Novels
     * @see ArtAlbums
     * <p>
     * Using Scanner it gives directions in which to continue
     * Option 1 - has 3 more options - to add an object of type Books/Novels/ArtAlbums to a specific list for each one.
     * Then it prints the new list with the added book.
     * Option 2 - shows the list of the object type Books, Novels, ArtAlbums.
     * Deletes the name of the inserted book and it prints the new list.
     * Option 3 - It prints all the existing objects of type Books, Novels and ArtAlbums.
     * Option 0 - exits the program.
     * *
     */
    public class MainSet {

        public static void main(String[] args) {

            SetVersion b = new SetVersion();
            int option;
            b.loadBookss();

            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("In order to continue..." + "\nPress 1 to add an item" + "\nPress 2 to delete an item" + "\nPress 3 just to see all items" + "\nPress 0 to exit the program.");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        b.addBookss();
                        break;
                    case 2:
                        b.removeBookA();
                        break;
                    case 3:
                        b.listBookss();
                        break;
                }
            } while (option != 0);
        }
    }

