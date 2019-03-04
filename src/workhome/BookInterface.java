package workhome;

/**
 * Interface class contains method which adds item in a list.
 * Method which removes items from a list.
 * Prints all items.
 * Loads item from a file.
 *
 * @author Ionut Butnaru
 * @version 1.0
 */
public interface BookInterface {

    //Add specific items to 3 different lists
    void addBooks();

    // Remove specific items from 3 different lists.
    void removeBook();

    //Prints all items.
    void listBooks();

    //Loads item from a file and creates new objects
    void loadBook();
}
