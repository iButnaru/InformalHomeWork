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

    /**
     * Add specific items to a catalogue.
     */
    void addBooks();

    /**
     * Removes specific items from a catalogue.
     */
    void removeBook();

    /**
     * Prints all items.
     */
    void listBooks();

    /**
     * Loads item from a file and creates new objects
     */
    void loadBook();
}
