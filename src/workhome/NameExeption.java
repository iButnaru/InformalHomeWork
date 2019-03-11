package workhome;

/**
 * @author Ionut Butnaru
 * @version 1.0
 * @see BooksTest
 * Custom exception used to stop entering a duplicate item in a list.
 */

public class NameExeption extends Exception {


    public NameExeption(String message){
        super(message);
    }

}
