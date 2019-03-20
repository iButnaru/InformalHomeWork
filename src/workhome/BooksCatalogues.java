package workhome;

import workhome.BooksObjects.ArtAlbums;
import workhome.BooksObjects.Books;
import workhome.BooksObjects.Novels;

import java.io.File;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Ionut Butnaru
 * version 1.0
 * @see workhome.BooksFinal
 * implements {@link #addBooks()} depending on option you chose from {@link Scanner} input, adds {@link Books}, {@link Novels}, {@link ArtAlbums}.
 * implements {@link #removeBooks()} depending on option you chose from {@link Scanner} input, removes {@link Books}, {@link Novels}, {@link ArtAlbums}.
 * implements {@link #listBooks()} prints all books.
 * implements {@link #addBook()} adds object {@link Books}, in Array.
 * implements {@link #addNovel()} adds object {@link Novels}, in ArrayList.
 * implements {@link #addArtAlbum()} adds object {@link ArtAlbums}, in HashSet.
 * implements {@link #removeBook()} removes object {@link Books}, from Array.
 * implements {@link #removeNovel()} removes object {@link Novels}, from ArrayList.
 * implements {@link #removeArtAlbum()} removes object {@link ArtAlbums}, from HashSet.
 * implements {@link #loadBook()} fills the lists with Books objects.
 */
public class BooksCatalogues implements BookInterface {

    private static final Logger LOGGER = Logger.getLogger(BooksCatalogues.class.getName());
    private Books[] catalogue1 = new Books[0];
    private GenericArraylist<Books> catalogue2 = new GenericArraylist<>();
    private HashSet<Books> catalogue3 = new HashSet<>();

    /**
     * Option 1 - adds {@link #addBook()} an item of type {@link Books} to an Array {@link #catalogue1}.
     * Option 2 - adds {@link #addNovel()} an item of type {@link Novels} to an ArrayList {@link #catalogue2}.
     * Option 3 - adds {@link #addArtAlbum()} an item of type {@link ArtAlbums} to a HashSet {@link #catalogue3}.
     */

    public void addBooks() {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Press 1 to add a book \n      Press 2 to add a novel \n      Press 3 to add and art album");
        int items = sc.nextInt();
        switch (items) {
            case 1:
                addBook();
                break;
            case 2:
                addNovel();
                break;
            case 3:
                addArtAlbum();
                break;
        }
    }

    /**
     * Option 1 - removes {@link #removeBook()} an item of type {@link Books} from and Array {@link #catalogue1}.
     * Option 2 - removes {@link #removeNovel()} an item of type {@link Novels} from an ArrayList {@link #catalogue2}.
     * Option 3 -  removes {@link #removeArtAlbum()} an item of type {@link ArtAlbums} from a HashSet {@link #catalogue3}.
     */

    public void removeBooks() {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Please select from the following options... ");
        LOGGER.info("Enter 1 to delete a book. \n      Enter 2 to delete a novel. \n      Enter 3 to delete an art album.");
        int deleteOption = sc.nextInt();
        switch (deleteOption) {
            case 1:
                removeBook();
                break;

            case 2:
                removeNovel();
                break;

            case 3:
                removeArtAlbum();
                break;
        }
    }

    /**
     * Prints all the books from the {@link #catalogue1}, {@link #catalogue2}, {@link #catalogue3}.
     */
    public void listBooks() {
        LOGGER.info("Books:");
        for (Books b : catalogue1) {
            LOGGER.info(String.valueOf(b));
        }
        LOGGER.info("Novels:");
        for (Books n : catalogue2.getList()) {
            LOGGER.info(String.valueOf(n));
        }
        LOGGER.info("Art albums:");
        for (Object a : catalogue3) {
            LOGGER.info(String.valueOf(a));
        }
    }

    /**
     * Checks if parameters are equal and throw NameException.
     *
     * @param book object of type Books.
     * @param name String parameter.
     * @throws NameException if the given parameters are equal.
     */

    private void checkBook(Books book, String name) throws NameException {
        for (Books item : catalogue1) {
            if (item.getBook().equals(name)) {
                throw new NameException("The item is already in the catalogue.");
            }
        }
    }

    /**
     * Using {@link Scanner} reads user input.
     * With the inserted parameters, it creates a new object {@link Books}.
     * Adds the new created object in an Array.
     * Prints the updated list.
     */

    public void addBook() {
        try {
            Scanner sc = new Scanner(System.in);
            LOGGER.info("Please enter the name of the book: ");
            String bookInput = sc.nextLine();
            LOGGER.info("Please enter the number of pages: ");
            int noPages = sc.nextInt();
            Books enteredBook = new Books(bookInput, noPages);
            try {
                for (Books item : catalogue1) {
                    checkBook(item, enteredBook.getBook());
                }
                int currentSize = catalogue1.length;
                int newSize = currentSize + 1;
                Books[] tempcatalogue = new Books[newSize];
                for (int j = 0; j < currentSize; j++) {
                    tempcatalogue[j] = catalogue1[j];
                }
                tempcatalogue[newSize - 1] = enteredBook;
                catalogue1 = tempcatalogue;
                LOGGER.info("Please see below the new list:");
                for (Books bk : catalogue1) {
                    LOGGER.info(String.valueOf(bk));
                }
            } catch (NameException e) {
                LOGGER.warning(e.getMessage());
            }
        } catch (InputMismatchException e) {
            LOGGER.warning("Please enter digits for the number of page.");
        }
    }

    /**
     * Checks if parameters are equal and throw NameException.
     *
     * @param book object of type Books.
     * @param name String parameter.
     * @throws NameException if the given parameters are equal.
     */

    private void checkNovel(Books book, String name) throws NameException {
        for (Books item : catalogue2.getList()) {
            if (item.getBook().equals(name)) {
                throw new NameException("You have entered a duplicate item.");
            }
        }
    }

    /**
     * Using {@link Scanner} reads user input.
     * With the inserted parameters, it creates a new object {@link Novels}.
     * Adds the new created object in an ArrayList.
     * Prints the updated list.
     */

    public void addNovel() {
        try {
            Scanner scan = new Scanner(System.in);
            LOGGER.info("Please enter the name of the novel: ");
            String novelInput = scan.nextLine();
            LOGGER.info("Please enter the number of pages: ");
            int novelPages = scan.nextInt();
            LOGGER.info("Please enter the type of the novel: ");
            String novelType = scan.next();
            Books enteredNovel = new Novels(novelInput, novelPages, novelType);
            try {
                for (Books item : catalogue2.getList()) {
                    checkNovel(item, novelInput);
                }
                catalogue2.add(enteredNovel);
                LOGGER.info("Please see below the new list: ");
                for (Books nov : catalogue2.getList()) {
                    LOGGER.info(String.valueOf(nov));
                }

            } catch (NameException e) {
                LOGGER.warning(e.getMessage());
            }
        } catch (InputMismatchException e) {
            LOGGER.warning("Please enter digits for the number of page.");
        }
    }

    /**
     * Checks if parameters are equal and throw NameException.
     *
     * @param book object of type Books.
     * @param name String parameter.
     * @throws NameException if the given parameters are equal.
     */

    private void checkArtAlbum(Books book, String name) throws NameException {
        for (Books item : catalogue3) {
            if (item.getBook().equals(name)) {
                throw new NameException("You have entered a duplicate item.");
            }
        }
    }

    /**
     * Using {@link Scanner} reads user input.
     * With the inserted parameters, it creates a new object {@link ArtAlbums}.
     * Adds the new created object in a HashSet.
     * Prints the updated list.
     */

    public void addArtAlbum() {
        Scanner scann = new Scanner(System.in);
        LOGGER.info("Please enter the name of the art album: ");
        String name = scann.nextLine();
        LOGGER.info("Please enter the number of pages: ");
        try {
            int pages = scann.nextInt();
            LOGGER.info("Please enter the paper quality: ");
            String paperQuality = scann.next();

            Books artAlbums = new ArtAlbums(name, pages, paperQuality);
            try {
                for (Books item : catalogue3) {
                    checkArtAlbum(item, name);
                }
                catalogue3.add(artAlbums);
                LOGGER.info("Please see below the new list:");

                for (Books art : catalogue3) {
                    LOGGER.info(String.valueOf(art));
                }
            } catch (NameException e) {
                LOGGER.warning(e.getMessage());
            }

        } catch (Exception e) {
            LOGGER.warning("You must enter a digit as page number.");
        }
    }

    /**
     * Using {@link Scanner} reads user input.
     * A new list is created every time the program receives input.
     * All items are added one by one in the new list if they are not equal with the input.
     * New list is copied in the original list without the chosen object of type{@link Books}.
     * Prints the updated list.
     */

    public void removeBook() {

        LOGGER.info("Please see below the list:");
        for (Books bk : catalogue1) {
            LOGGER.info(String.valueOf(bk));
        }
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Please write the name of the book you want to delete: ");
        String bookDelete = sc.nextLine();
        int currentSize = catalogue1.length;
        int newSize = currentSize - 1;
        Books[] tempcatalogue = new Books[newSize];
        int i = 0;
        for (int j = 0; j < currentSize; j++) {
            if (!catalogue1[j].getBook().equals(bookDelete)) {
                tempcatalogue[i] = catalogue1[j];
                i++;
            }
        }
        catalogue1 = tempcatalogue;
        LOGGER.info("The remaining books are: ");
        for (Books bk : tempcatalogue) {
            LOGGER.info(String.valueOf(bk));
        }
    }

    /**
     * Using {@link Scanner} reads user input.
     * With {@link Iterator} iterates through all list and if object of type {@link Novels} is equal with input, then is removed.
     * Prints the updated list.
     */

    public void removeNovel() {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Please see below the list:");
        for (Books nov : catalogue2.getList()) {
            LOGGER.info(String.valueOf(nov));
        }
        Iterator<Books> it2 = catalogue2.getList().iterator();
        LOGGER.info("Please write the name of the novel you want to delete: ");
        for (Books nov : catalogue2.getList()) {
            LOGGER.info(String.valueOf(nov));
        }
        String novelDelete = sc.nextLine();
        while (it2.hasNext()) {
            Books novel = it2.next();
            if (novel.getBook().equals(novelDelete)) {
                it2.remove();
            }
        }
        LOGGER.info("The remaining novels are: ");
        for (Books nov : catalogue2.getList()) {
            LOGGER.info(String.valueOf(nov));
        }
    }

    /**
     * Using {@link Scanner} reads user input.
     * With {@link Iterator} iterates through all list and if object of type {@link ArtAlbums} is equal with input, then is removed.
     * Prints the updated list.
     */

    public void removeArtAlbum() {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Please see below the list:");
        for (Books art : catalogue3) {
            LOGGER.info(String.valueOf(art));
        }
        Iterator<Books> it3 = catalogue3.iterator();
        LOGGER.info("Please write the name of the art album you want to delete: ");
        String artDelete = sc.nextLine();
        while (it3.hasNext()) {
            Books art = it3.next();
            {
                if (art.getBook().equals(artDelete)) {
                    it3.remove();
                }
            }
        }

        LOGGER.info("The remaining art albums are: ");
        for (Books art : catalogue3) {
            LOGGER.info(String.valueOf(art));
        }
    }

    /**
     * Using {@link Scanner} reads from file.
     * Creates new objects.
     * Fills the lists {@link #catalogue1}, {@link #catalogue2}, {@link #catalogue3} with the new created objects of type{@link Books}, {@link Novels}, {@link ArtAlbums}.
     */
    public void loadBook() {
        Scanner sc5;
        File file = new File("src/workhome/myfile.txt");
        try {
            sc5 = new Scanner(file);
            while (sc5.hasNextLine()) {
                String tstring = sc5.nextLine();
                String[] astring = tstring.split("#");
                Books b = new Books();
                Novels n = new Novels();
                ArtAlbums a = new ArtAlbums();
                if (astring[0].equals("BOOK")) {
                    b.setBook(astring[1]);
                    b.setPage(Integer.parseInt(astring[2]));
                    int currentSize = catalogue1.length;
                    int newSize = currentSize + 1;
                    Books[] tempcatalogue = new Books[newSize];
                    for (int j = 0; j < currentSize; j++) {
                        tempcatalogue[j] = catalogue1[j];
                    }
                    tempcatalogue[newSize - 1] = b;
                    catalogue1 = tempcatalogue;
                } else if (astring[0].equals("NOVEL")) {
                    n.setBook(astring[1]);
                    n.setPage(Integer.parseInt(astring[2]));
                    n.setType(astring[3]);
                    catalogue2.add(n);
                } else if (astring[0].equals("ARTALBUMS")) {
                    a.setBook(astring[1]);
                    a.setPage(Integer.parseInt(astring[2]));
                    a.setPaperQuality(astring[3]);
                    catalogue3.add(a);
                }
            }

        } catch (Exception e) {
            LOGGER.warning("An error occurred: " + e);
        }
    }
}