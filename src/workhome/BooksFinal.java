package workhome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Books
 * @see Novels
 * @see ArtAlbums
 * * Novels and ArtAlbums are inherited from the super class Books
 * Using Scanner it gives directions in which to continue
 * Option 1 - has 3 more options - to add an object of type Books/Novels/ArtAlbums to a specific list for each one.
 * Then it prints the new list with the added book.
 * Option 2 - has 3 more options - shows the list of the object of type Books/Novels/ArtAlbums.
 * Deletes the name of the inserted book and it prints the new list.
 * Option 3 - It prints all the existing objects of type Books, Novels and ArtAlbums.
 * Uses ArrayList, Iterator, Scanner
 * *
 */
public class BooksFinal {

    public static void main(String[] args) {
//Creates new objects of type - Books, Novels, ArtAlbums
        Books book1 = new Books("Peterson", 345);
        Books book2 = new Books("Business", 536);

        Books novel1 = new Novels("To be", 34, "SF");
        Books novel2 = new Novels("Windy", 74, "Romance");

        Books album1 = new ArtAlbums("Secrets", 126, "good");
        Books album2 = new ArtAlbums("Developing", 336, "bad");


        //Creates a list, adds objects in it and prints message with the size of the list

        ArrayList<Books> catalogue1 = new ArrayList<>();
        catalogue1.add(book1);
        catalogue1.add(book2);
        ArrayList<Books> catalogue2 = new ArrayList<>();
        catalogue2.add(novel1);
        catalogue2.add(novel2);
        ArrayList<Books> catalogue3 = new ArrayList<>();
        catalogue3.add(album1);
        catalogue3.add(album2);

        Scanner sc = new Scanner(System.in);
        String direction;
        int items;
        String bookInput;
        int noPages;
        String novelInput;
        String novelType;
        int novelPages;
        String artInput;
        int artPages;
        String paperQuality;
        int deleteOption;
        String bookDelete;
        String novelDelete;
        String artDelete;

        System.out.println("In order to continue... \nPress 1 to add an item \nPress 2 to delete an item \nPress 3 just to see all items");
        direction = sc.nextLine();

        switch (direction){
            case "1":
                System.out.println("Press 1 to add a book \nPress 2 to add a novel \nPress 3 to add and art album");
                items = sc.nextInt();
                Scanner sc1 = new Scanner(System.in);
                Scanner sct = new Scanner(System.in);
                Scanner scq = new Scanner(System.in);
                switch (items){
                    case 1:
                        System.out.println("Please enter the name of the book: ");
                        bookInput = sc1.nextLine();
                        System.out.println("Please enter the number of pages: ");
                        noPages = sc.nextInt();
                        Books enteredBook = new Books(bookInput, noPages);
                        catalogue1.add(enteredBook);
                        System.out.println("Please see below the new list:");
                        for (Books bk : catalogue1){
                            System.out.println(bk);
                            break;
                        }
                    case 2:
                        System.out.println("Please enter the name of the novel: ");
                        novelInput = sc1.nextLine();
                        System.out.println("Please enter the number of pages: ");
                        novelPages = sc.nextInt();
                        System.out.println("Please enter the type of the novel: ");
                        novelType = sct.nextLine();
                        Books enteredNovel = new Novels(novelInput, novelPages, novelType);
                        catalogue2.add(enteredNovel);
                        System.out.println("Please see below the new list: ");
                        for (Books nov : catalogue2){
                            System.out.println(nov);

                        }
                        break;
                    case 3:
                        System.out.println("Please enter the name of the art album: ");
                        artInput = sc1.nextLine();
                        System.out.println("Please enter the number of pages: ");
                        artPages = sc.nextInt();
                        System.out.println("Please enter the paper quality: ");
                        paperQuality = scq.nextLine();
                        Books enteredArtAlbum = new ArtAlbums(artInput, artPages, paperQuality);
                        catalogue3.add(enteredArtAlbum);
                        System.out.println("Please see below the new list: ");
                        for (Books art : catalogue3){
                            System.out.println(art);
                        }
                }
                break;

            case "2":
                System.out.println("Please select from the following options... ");
                System.out.println("Enter 1 to delete a book. \nEnter 2 to delete a novel. \nEnter 3 to delete an art album.");
                deleteOption = sc.nextInt();
                Iterator<Books> it1 = catalogue1.iterator();
                Iterator<Books> it2 = catalogue2.iterator();
                Iterator<Books> it3 = catalogue3.iterator();

                Scanner sc2 = new Scanner(System.in);
                Scanner sc3 = new Scanner(System.in);
                Scanner sc4 = new Scanner(System.in);
                switch (deleteOption){

                    case 1:

                        System.out.println("Please see below the list:");
                        for (Books bk : catalogue1){
                            System.out.println(bk); }
                        System.out.println("Please write the name of the book you want to delete: ");
                        bookDelete = sc2.nextLine();

                        while (it1.hasNext()){
                            Books book = it1.next();
                            if (book instanceof Books){
                                if (((Books) book).getBook().equals(bookDelete) ){
                                    it1.remove();
                                }
                            }
                        }
                        System.out.println("The remaining books are: ");
                        for (Books bk : catalogue1){
                            System.out.println(bk); }
                        break;
                    case 2:
                        System.out.println("Please see below the list:");
                        for (Books nov : catalogue2){
                            System.out.println(nov); }
                        System.out.println("Please write the name of the novel you want to delete: ");
                        novelDelete = sc3.nextLine();
                        while(it2.hasNext()){
                            Books novel = it2.next();
                            if(novel instanceof Novels){
                                if (((Novels) novel).getBook().equals(novelDelete)){
                                    it2.remove();
                                }
                            }
                        }
                        System.out.println("The remaining novels are: ");
                        for (Books nov : catalogue2){
                            System.out.println(nov); }
                        break;

                    case 3:
                        System.out.println("Please see below the list:");
                        for (Books art : catalogue3){
                            System.out.println(art); }
                        System.out.println("Please write the name of the art album you want to delete: ");
                        artDelete = sc4.nextLine();
                        while (it3.hasNext()){
                            Books art = it3.next();
                            if(art instanceof ArtAlbums){
                                if (((ArtAlbums) art).getBook().equals(artDelete)){
                                    it3.remove();
                                }
                            }
                        }
                        System.out.println("The remaining art albums are: ");
                        for (Books art : catalogue3){
                            System.out.println(art); }
                        break;
                }
                break;

            case "3":
                System.out.println("BOOKS: ");
                for (Books bk : catalogue1){
                    System.out.println(bk); }
                System.out.println("NOVELS: ");
                for (Books nov : catalogue2){
                    System.out.println(nov); }
                System.out.println("ART ALBUMS: ");
                for (Books art : catalogue3){
                    System.out.println(art); }
                break;
        }
    }
}