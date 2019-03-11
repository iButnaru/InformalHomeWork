package workhome;

import workhome.BooksObjects.ArtAlbums;
import workhome.BooksObjects.Books;
import workhome.BooksObjects.Novels;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Ionut Butnaru
 * version 1.0
 * @see workhome.BooksFinal
 */

public class BooksTest implements BookInterface {

    private Books[] catalogue1 = new Books[0];
    private GenericArraylist<Books> catalogue2 = new GenericArraylist<>();
    private HashSet<Object> catalogue3 = new HashSet<>();


    /**
     * Option 1 - adds an item of type Books to a list
     * Option 2 - adds an item of type Novels to a list
     * Option 3 - adds an item of type ArtAlbums to a list
     */

    public void addBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to add a book \nPress 2 to add a novel \nPress 3 to add and art album");
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
     * Option 1 - removes an item of type Books
     * Option 2 - removes an item of type Novels
     * Option 3 -  removes an item of type ArtAlbums
     */

    public void removeBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select from the following options... ");
        System.out.println("Enter 1 to delete a book. \nEnter 2 to delete a novel. \nEnter 3 to delete an art album.");
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
     * Prints all the books from the catalogues.
     */
    public void listBooks() {
        for (Books b : catalogue1) {
            System.out.println(b);
        }
        for (Books n : catalogue2.getList()) {
            System.out.println(n);
        }
        for (Object a : catalogue3) {
            System.out.println(a);
        }
    }

    /**
     * Checks if parameters are equal and throw NameException.
     * @param book object of type Books.
     * @param name String parameter.
     * @throws NameExeption if the given parameters are equal.
     */

    private void checkBook(Books book, String name) throws NameExeption {
        for (Books item : catalogue1) {
            if (item.getBook().equals(name)) {
                throw new NameExeption("The item is already in the catalogue.");
            }
        }
    }

    /**
     * Add an item of type Books to a list.
     */

    public void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the book: ");
        String bookInput = sc.nextLine();
        System.out.println("Please enter the number of pages: ");
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
            System.out.println("Please see below the new list:");
            for (Books bk : catalogue1) {
                System.out.println(bk);
            }
        } catch (NameExeption e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks if parameters are equal and throw NameException.
     * @param book object of type Books.
     * @param name String parameter.
     * @throws NameExeption if the given parameters are equal.
     */

    private void checkNovel(Books book, String name) throws NameExeption {
        for (Books item : catalogue2.getList()) {
            if (item.getBook().equals(name)) {
                throw new NameExeption("The item is already in the catalogue.");
            }
        }
    }

    /**
     * Add an item of type Novels to a list.
     */
    public void addNovel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the novel: ");
        String novelInput = scan.nextLine();
        System.out.println("Please enter the number of pages: ");
        int novelPages = scan.nextInt();
        System.out.println("Please enter the type of the novel: ");
        String novelType = scan.next();
        Books enteredNovel = new Novels(novelInput, novelPages, novelType);
        try {
            for (Books item : catalogue2.getList()) {
                checkNovel(item, novelInput);
            }
            catalogue2.add(enteredNovel);
        } catch (NameExeption e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Please see below the new list: ");
        for (Books nov : catalogue2.getList()) {
            System.out.println(nov);
        }
    }

    /**
     * Add an item of type ArtAlbums to a list.
     */

    public void addArtAlbum() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Please enter the name of the art album: ");
        String name = scann.nextLine();
        System.out.println("Please enter the number of pages: ");
        try {
            int pages = scann.nextInt();
            System.out.println("Please enter the paper quality: ");
            String paperQuality = scann.next();
            Books artAlbums = new ArtAlbums(name, pages, paperQuality);
                catalogue3.add(artAlbums);
                System.out.println("Please see below the new list:");

                for (Object art : catalogue3) {
                    System.out.println(art);
            }
        } catch (Exception e) {
            System.out.println("You must enter a digit as page number.");
        }
    }

    /**
     * Remove an item of type Books from a list.
     */

    public void removeBook() {

        System.out.println("Please see below the list:");
        for (Books bk : catalogue1) {
            System.out.println(bk);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write the name of the book you want to delete: ");
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
        System.out.println("The remaining books are: ");
        for (Books bk : tempcatalogue) {
            System.out.println(bk);
        }
    }

    /**
     * Remove an item of type Novels from a list.
     */
    public void removeNovel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please see below the list:");
        for (Books nov : catalogue2.getList()) {
            System.out.println(nov);
        }
        Iterator<Books> it2 = catalogue2.getList().iterator();
        System.out.println("Please write the name of the novel you want to delete: ");
        for (Books nov : catalogue2.getList()) {
        }
        String novelDelete = sc.nextLine();
        while (it2.hasNext()) {
            Books novel = it2.next();
            if (novel.getBook().equals(novelDelete)) {
                it2.remove();
            }
        }
        System.out.println("The remaining novels are: ");
        for (Books nov : catalogue2.getList()) {
            System.out.println(nov);
        }
    }

    /**
     * Remove an item of type ArtAlbums from a list.
     */

    public void removeArtAlbum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please see below the list:");
        for (Object art : catalogue3) {
            System.out.println(art);
        }
        Iterator<Object> it3 = catalogue3.iterator();
        System.out.println("Please write the name of the art album you want to delete: ");
        String artDelete = sc.nextLine();
        while (it3.hasNext()) {
            Books art = (Books) it3.next();
            {
                if (art.getBook().equals(artDelete)) {
                    it3.remove();
                }
            }
        }

        System.out.println("The remaining art albums are: ");
        for (Object art : catalogue3) {
            System.out.println(art);
        }
    }

    /**
     * Using scanner reads from file and creates new objects of type Books, Novels and ArtAlbums
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
            System.out.println("An error occurred: " + e);
        }
    }
}