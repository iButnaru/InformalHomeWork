package workhome.Arrayversion;
/**
 * @author Ionut Butnaru
 * version 1.0
 * @see workhome.Arrayversion.MainArray
 */

import workhome.BooksObjects.ArtAlbums;
import workhome.BooksObjects.Books;
import workhome.BooksObjects.Novels;

import java.io.File;
import java.util.Scanner;

public class BookArray implements BookArrayInterface {

    private Books[] catalogue = new Books[50];

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
     * Prints all the books from the catalogue.
     */
    public void listBookss() {
        for (Books b : catalogue) {
            if (b != null) {
                System.out.println(b);
            }
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
                    for (int i = 0; i < catalogue.length; i++) {
                        if (catalogue[i] == null) {
                            catalogue[i] = b;
                            break;
                        }
                    }
                } else if (astring[0].equals("NOVEL")) {
                    n.setBook(astring[1]);
                    n.setPage(Integer.parseInt(astring[2]));
                    n.setType(astring[3]);
                    for (int i = 0; i < catalogue.length; i++) {
                        if (catalogue[i] == null) {
                            catalogue[i] = n;
                            break;
                        }
                    }
                } else if (astring[0].equals("ARTALBUMS")) {
                    a.setBook(astring[1]);
                    a.setPage(Integer.parseInt(astring[2]));
                    a.setPaperQuality(astring[3]);
                    for (int i = 0; i < catalogue.length; i++) {
                        if (catalogue[i] == null) {
                            catalogue[i] = a;
                            break;
                        }

                    }
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
        boolean checkprg = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the book: ");
        String bookInput = sc.nextLine();
        System.out.println("Please enter the number of pages: ");
        int noPages = sc.nextInt();
        Books enteredBook = new Books(bookInput, noPages);
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                checkprg = true;
                catalogue[i] = enteredBook;

                break;
            }
        }
        System.out.println("Please see below the new list:");
        for (Books bk : catalogue) {
            if (bk != null) {
                System.out.println(bk);
            }
        }
        if (!checkprg){
            System.out.println("The catalogue is full!");
        }

    }

    /**
     * Add an item of type Novels to a list.
     */
    public void addNovels() {
        boolean checkprg = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the novel: ");
        String novelInput = scan.nextLine();
        System.out.println("Please enter the number of pages: ");
        int novelPages = scan.nextInt();
        System.out.println("Please enter the type of the novel: ");
        String novelType = scan.next();
        Books enteredNovel = new Novels(novelInput, novelPages, novelType);
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                checkprg = true;
                catalogue[i] = enteredNovel;
                break;
            }
        }
        System.out.println("Please see below the new list:");
        for (Books nov : catalogue) {
            if (nov != null) {
                System.out.println(nov);
            }

        }
        if (!checkprg){
            System.out.println("The catalogue is full!");
        }

    }

    /**
     * Adds an item of type ArtAlbums to a list.
     */
    public void addArtAlbums() {
        boolean checkprg = false;
        Scanner scann = new Scanner(System.in);
        System.out.println("Please enter the name of the art album: ");
        String name = scann.nextLine();
        System.out.println("Please enter the number of pages: ");
        int pages = scann.nextInt();
        System.out.println("Please enter the paper quality: ");
        String paperQuality = scann.next();
        Books artAlbums = new ArtAlbums(name, pages, paperQuality);
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                checkprg = true;
                catalogue[i] = artAlbums;
                break;
            }
        }
        System.out.println("Please see below the new list:");
        for (Books art : catalogue) {
            if (art != null) {
                System.out.println(art);
            }
        }
        if (!checkprg){
            System.out.println("The catalogue is full!");
        }

    }

    /**
     * Removes a chosen item from the list.
     */
    public void removeBookA() {

        System.out.println("Please see below the list:");
        for (Books bk : catalogue) {
            if (bk != null) {
                System.out.println(bk);
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write the name of the book you want to delete: ");
        String bookDelete = sc.nextLine();
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] != null) {
                if (catalogue[i].getBook().equals(bookDelete)) {
                    catalogue[i] = null;
                }
            }
        }
        System.out.println("The remaining books are: ");
        for (Books bk : catalogue) {
            if (bk != null) {
                System.out.println(bk);
            }
        }
    }
}