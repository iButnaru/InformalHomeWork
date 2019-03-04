//package workhome;
//
//import java.io.File;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//
//public class Test {
//
//    private Books[] catalogue1 = new Books[100];
//    private Books[] catalogue2 = new Books[100];
//    private Books[] catalogue3 = new Books[100];
//
//
//    public void addBook() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the name of the book: ");
//        String bookInput = sc.nextLine();
//        System.out.println("Please enter the number of pages: ");
//        int noPages = sc.nextInt();
//        Books enteredBook = new Books(bookInput, noPages);
//        catalogue1.add(enteredBook);
//        System.out.println("Please see below the new list:");
//        for (Books bk : catalogue1) {
//            System.out.println(bk);
//        }
//    }
//
//    //Add an item of type Novels to a list.
//    public void addNovel() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please enter the name of the novel: ");
//        String novelInput = scan.nextLine();
//        System.out.println("Please enter the number of pages: ");
//        int novelPages = scan.nextInt();
//        System.out.println("Please enter the type of the novel: ");
//        String novelType = scan.next();
//        Books enteredNovel = new Novels(novelInput, novelPages, novelType);
//        catalogue2.add(enteredNovel);
//        System.out.println("Please see below the new list: ");
//        for (Books nov : catalogue2) {
//            System.out.println(nov);
//        }
//
//    }
//    //Add an item of type ArtAlbums to a list.
//
//    public void addArtAlbum() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please enter the name of the art album: ");
//        String name = scan.nextLine();
//        System.out.println("Please enter the number of pages: ");
//        int pages = scan.nextInt();
//        System.out.println("Please enter the paper quality: ");
//        String paperQuality = scan.next();
//        Books artAlbums = new ArtAlbums(name, pages, paperQuality);
//        catalogue3.add(artAlbums);
//        System.out.println("Please see below the new list: ");
//        for (Books nov : catalogue3) {
//            System.out.println(nov);
//        }
//
//    }
//    //Remove an item of type Books from a list.
//
//    public void removeBook() {
//
//        System.out.println("Please see below the list:");
//        for (Books bk : catalogue1) {
//            System.out.println(bk);
//        }
//        Iterator<Books> it1 = catalogue1.iterator();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please write the name of the book you want to delete: ");
//        String bookDelete = sc.nextLine();
//        while (it1.hasNext()) {
//            Books book = it1.next();
//            if (book.getBook().equals(bookDelete)) {
//                it1.remove();
//            }
//        }
//
//        System.out.println("The remaining books are: ");
//        for (Books bk : catalogue1) {
//            System.out.println(bk);
//
//        }
//    }
//
//    //Remove an item of type Novels from a list.
//    public void removeNovel() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please see below the list:");
//        for (Books nov : catalogue2) {
//            System.out.println(nov);
//        }
//        Iterator<Books> it2 = catalogue2.iterator();
//        System.out.println("Please write the name of the novel you want to delete: ");
//        String novelDelete = sc.nextLine();
//        while (it2.hasNext()) {
//            Books novel = it2.next();
//            if (novel.getBook().equals(novelDelete)) {
//                it2.remove();
//            }
//
//        }
//
//        System.out.println("The remaining novels are: ");
//        for (Books nov : catalogue2) {
//            System.out.println(nov);
//        }
//    }
//    //Remove an item of type ArtAlbums from a list.
//
//    public void removeArtAlbum() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please see below the list:");
//        for (Books art : catalogue3) {
//            System.out.println(art);
//        }
//        Iterator<Books> it3 = catalogue3.iterator();
//        System.out.println("Please write the name of the art album you want to delete: ");
//        String artDelete = sc.nextLine();
//        while (it3.hasNext()) {
//            Books art = it3.next();
//            {
//                if (art.getBook().equals(artDelete)) {
//                    it3.remove();
//                }
//            }
//        }
//
//        System.out.println("The remaining art albums are: ");
//        for (Books art : catalogue3) {
//            System.out.println(art);
//        }
//    }
//
//    /**
//     * Using scanner reads from file and creates new objects of type Books, Novels and ArtAlbums
//     */
//    public void loadBook() {
//        Scanner sc5;
//        File file = new File("src/workhome/myfile.txt");
//        try {
//            sc5 = new Scanner(file);
//            while (sc5.hasNextLine()) {
//                String tstring = sc5.nextLine();
//                String[] astring = tstring.split("#");
//                Books b = new Books();
//                Novels n = new Novels();
//                ArtAlbums a = new ArtAlbums();
//                if (astring[0].equals("BOOK")) {
//                    b.setBook(astring[1]);
//                    b.setPage(Integer.parseInt(astring[2]));
//                    for(int i = 0; i< catalogue1.length; i++){
//                        catalogue1[i] = b;
//                    }
//                } else if (astring[0].equals("NOVEL")) {
//                    n.setBook(astring[1]);
//                    n.setPage(Integer.parseInt(astring[2]));
//                    n.setType(astring[3]);
//                    for(int i = 0; i< catalogue2.length; i++){
//                        catalogue2[i] = n;
//                    }
//                } else if (astring[0].equals("ARTALBUMS")) {
//                    a.setBook(astring[1]);
//                    a.setPage(Integer.parseInt(astring[2]));
//                    a.setPaperQuality(astring[3]);
//                    for(int i = 0; i< catalogue3.length; i++){
//                        catalogue3[i] = a;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e);
//        }
//    }
//
//}
