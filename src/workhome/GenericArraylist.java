package workhome;

import workhome.BooksObjects.Books;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ionut Butnaru
 * @version 1.0
 * @see BooksCatalogues
 * Generic class used to invoke T type attribute.
 * @param <T> type of the variable.
 */

public class GenericArraylist<T extends Books> {
    private final List<T> list;

    /**
     * Constructs a new instance of the ArrayList class.
     */

    public GenericArraylist() {
        this.list = new ArrayList<>();
    }

    /**
     * Gets the generic of the class - ArrayList
     * @return ArrayList
     */

    public List<T> getList() {
        return list;
    }

    /**
     * Adds elements to the ArrayList.
     * @param obj item of type T which is being added to the ArrayList.
     */

    public void add(T obj) {
        list.add(obj);

    }

}
