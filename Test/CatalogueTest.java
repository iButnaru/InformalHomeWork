import org.junit.Test;
import workhome.BooksObjects.ArtAlbums;
import workhome.BooksObjects.Books;
import workhome.BooksObjects.Novels;
import workhome.GenericArraylist;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CatalogueTest {

    @Test
    public void addItemInArrayTest() {
        Books b = new Books("Fitness", 203);
        Books[] myArray = new Books[0];
        Books[] tempArray = new Books[myArray.length + 1];
        for (int i = 0; i < myArray.length; i++) {
            tempArray[i] = myArray[i];
        }
        tempArray[myArray.length] = b;
        myArray = tempArray;
        assertEquals(1, myArray.length);
        assertEquals(myArray[0], b);
    }

    @Test
    public void addItemInArrayListTest() {
        Novels n1 = new Novels("NovelName", 156, "SF");
        Novels n2 = new Novels("Tom Jones", 232, "Romance");
        GenericArraylist myArrayList = new GenericArraylist();
        myArrayList.add(n1);
        assertEquals(1, myArrayList.getList().size());
        assertEquals(n1, myArrayList.getList().get(0));
        myArrayList.add(n2);
        assertNotNull(myArrayList);
        assertEquals(2, myArrayList.getList().size());
        assertEquals(n2, myArrayList.getList().get(1));
    }

    @Test
    public void addItemInHashSetTest() {
        ArtAlbums a1 = new ArtAlbums("Aerosmith", 45, "Good");
        ArtAlbums a2 = new ArtAlbums("Tori Amos", 78, "Poor");
        HashSet<Books> mySet = new HashSet<>();
        mySet.add(a1);
        assertEquals(1, mySet.size());
        assertTrue(mySet.contains(a1));
        mySet.add(a2);
        assertEquals(2, mySet.size());
        assertTrue(mySet.contains(a2));
    }

    @Test
    public void removeItemFromArrayTest() {
        Books[] myArray = new Books[]{new Books("Fitness", 203), new Books("Peterson", 356)};
        Books[] tempArray = new Books[myArray.length - 1];
        int j = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (!myArray[i].getBook().equals("Fitness")) {
                tempArray[j] = myArray[i];
                j++;
            }
        }
        myArray = tempArray;
        assertEquals(1, myArray.length);
    }

    @Test
    public void removeItemFromArrayListTest() {
        Novels n1 = new Novels("NovelName", 156, "SF");
        Novels n2 = new Novels("Tom Jones", 232, "Romance");
        GenericArraylist myArrayList = new GenericArraylist();
        myArrayList.add(n1);
        myArrayList.add(n2);
        assertEquals(2, myArrayList.getList().size());
        myArrayList.getList().remove(n1);
        assertEquals(1, myArrayList.getList().size());
        myArrayList.getList().remove(n2);
        assertEquals(0, myArrayList.getList().size());
    }

    @Test
    public void removeItemFromHashSetTest() {
        ArtAlbums a1 = new ArtAlbums("Aerosmith", 45, "Good");
        ArtAlbums a2 = new ArtAlbums("Tori Amos", 78, "Poor");
        HashSet<Books> mySet = new HashSet<>();
        mySet.add(a1);
        mySet.add(a2);
        assertEquals(2, mySet.size());
        mySet.remove(a1);
        assertEquals(1, mySet.size());
        mySet.remove(a2);
        assertEquals(0, mySet.size());
    }

    @Test
    public void loadItemsTest() {
        Scanner sc5;
        File file = new File("Test/FileTest");
        Books[] arrayCatalogue = new Books[0];
        ArrayList<Books> arrayListcatalogue = new ArrayList<>();
        HashSet<Books> hashSetCatalogue = new HashSet<>();
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
                    int currentSize = arrayCatalogue.length;
                    int newSize = currentSize + 1;
                    Books[] tempcatalogue = new Books[newSize];
                    for (int j = 0; j < currentSize; j++) {
                        tempcatalogue[j] = arrayCatalogue[j];
                    }
                    tempcatalogue[newSize - 1] = b;
                    arrayCatalogue = tempcatalogue;
                } else if (astring[0].equals("NOVEL")) {
                    n.setBook(astring[1]);
                    n.setPage(Integer.parseInt(astring[2]));
                    n.setType(astring[3]);
                    arrayListcatalogue.add(n);
                } else if (astring[0].equals("ARTALBUMS")) {
                    a.setBook(astring[1]);
                    a.setPage(Integer.parseInt(astring[2]));
                    a.setPaperQuality(astring[3]);
                    hashSetCatalogue.add(a);
                }
            }
        } catch (Exception e) {
            LOGGER.warning("An error occurred: " + e);
        }

        assertEquals(2, arrayCatalogue.length);
        assertEquals("Book1Test", arrayCatalogue[0].getBook());
        assertEquals(2, arrayListcatalogue.size());
        assertEquals("Novel1Test", arrayListcatalogue.get(0).getBook());
        assertEquals(1, hashSetCatalogue.size());
        for (Books a : hashSetCatalogue) {
            assertEquals(a.getBook(), "ArtTest1");
        }

    }
}


