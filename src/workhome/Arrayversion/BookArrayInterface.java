package workhome.Arrayversion;

/**
 * Interface class contains methods which add three specific items in a list.
 * Method which adds objects of type Books to a list.
 * Method which adds objects of type Novels to a list.
 * Method which adds objects of type ArtAlbums to a list.
 * Method which removes items from a list.
 * Prints all items.
 * Loads item from a file.
 *
 * @author Ionut Butnaru
 * @version 1.0
 */
public interface BookArrayInterface {

    /**
     * Add specific items - three types of books to a list.
     */
    void addBookss();

    /**
     * Add books of type Books to a list.
     */
    void addBooks();

    /**
     * Add books of type Novels to a list.
     */
    void addNovels();

    /**
     * Add books of type ArtAlbums to a list.
     */
    void addArtAlbums();

    /**
     * Remove specific items from 3 different lists.
     */
    void removeBookA();

    /**
     * Prints all items.
     */
    void listBookss();

    /**
     * Loads item from a file and creates new objects
     */
    void loadBookss();
}
