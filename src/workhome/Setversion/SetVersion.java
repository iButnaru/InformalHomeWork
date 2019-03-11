package workhome.Setversion;

import workhome.Arrayversion.BookArrayInterface;
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
 * @see MainSet
 */


public class SetVersion implements BookArrayInterface {
    private HashSet<Object> catalogue = new HashSet<>();

    /**
     * Option 1 - adds an item of type Books to a list
     * Option 2 - adds an item of type Novels to a list
     * Option 3 - adds an item of type ArtAlbums to a list
     */

    public void addBookss() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to add a book \nPress 2 to add a novel \nPress 3 to add and art album");
        int items = sc.nextInt();
        switch (items) {
            case 1:
                addBooks();
                break;
            case 2:
                addNovels();
                break;
            case 3:
                addArtAlbums();
                break;
        }
    }

    /**
     * Prints all the books from the catalogues.
     */
    public void listBookss() {
        for (Object b : catalogue) {
            System.out.println(b);
        }
    }

    /**
     * Using scanner reads from file and creates new objects of type Books, Novels and ArtAlbums
     */
    public void loadBookss() {
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
                    catalogue.add(b);
                } else if (astring[0].equals("NOVEL")) {
                    n.setBook(astring[1]);
                    n.setPage(Integer.parseInt(astring[2]));
                    n.setType(astring[3]);
                    catalogue.add(n);
                } else if (astring[0].equals("ARTALBUMS")) {
                    a.setBook(astring[1]);
                    a.setPage(Integer.parseInt(astring[2]));
                    a.setPaperQuality(astring[3]);
                    catalogue.add(a);
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }

    /**
     * Add an item of type Books to a list.
     */
    public void addBooks() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the book: ");
        String bookInput = sc.nextLine();
        System.out.println("Please enter the number of pages: ");
        try {
            int noPages = sc.nextInt();
            Books enteredBook = new Books(bookInput, noPages);
            catalogue.add(enteredBook);
            System.out.println("Please see below the new list:");
            for (Object bk : catalogue) {
                System.out.println(bk);
            }

        }
        catch (Exception e){
            System.out.println("You must enter a digit as page number.");
        }

    }

    /**
     * Add an item of type Novels to a list.
     */
    public void addNovels() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the novel: ");
        String novelInput = scan.nextLine();
        System.out.println("Please enter the number of pages: ");
        try {
            int novelPages = scan.nextInt();
            System.out.println("Please enter the type of the novel: ");
            String novelType = scan.next();
            Books enteredNovel = new Novels(novelInput, novelPages, novelType);
            catalogue.add(enteredNovel);
            System.out.println("Please see below the new list:");
            for (Object nov : catalogue) {
                System.out.println(nov);
            }
        }
        catch (Exception e){
            System.out.println("You must enter a digit as page number.");
        }
    }

    /**
     * Add an item of type ArtAlbums to a list.
     */
    public void addArtAlbums() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Please enter the name of the art album: ");
        String name = scann.nextLine();
        System.out.println("Please enter the number of pages: ");
        try {
            int pages = scann.nextInt();
            System.out.println("Please enter the paper quality: ");
            String paperQuality = scann.next();
            Books artAlbums = new ArtAlbums(name, pages, paperQuality);
            catalogue.add(artAlbums);
            System.out.println("Please see below the new list:");
            for (Object art : catalogue) {
                System.out.println(art);
            }
        }
        catch (Exception e){
            System.out.println("You must enter a digit as page number.");
        }
    }

    /**
     * Remove an item of type Books from a list.
     */
    public void removeBookA() {

        System.out.println("Please see below the list:");
        for (Object bk : catalogue) {
                System.out.println(bk);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write the name of the book you want to delete: ");
        Iterator<Object> it = catalogue.iterator();
        System.out.println("Please write the name of the book you want to delete: ");
        String bookDelete = sc.nextLine();
        while (it.hasNext()){
            Books book;
            book = (Books) it.next();
            if(book.getBook().equals(bookDelete)){
                it.remove();
            }
        }
        System.out.println("The remaining books are: ");
        for (Object bk : catalogue) {
                System.out.println(bk);
        }
    }
}
