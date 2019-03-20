package workhome;

/**
 * @author Ionut Butnaru
 * @version 1.0
 * @see BooksCatalogues
 * Custom exception used to stop entering a duplicate item in a list.
 */

public class NameException extends Exception {


    public NameException(String message){
        super(message);
    }

}
