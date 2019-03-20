package workhome.BooksObjects;

import workhome.BooksFinal;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Books - superclass
 * @see ArtAlbums
 * @see BooksFinal
 */
public class Novels extends Books {

    private String type;

    public Novels() {

    }

    /**
     * This constructs a novel with specified name, number of pages and type.
     * @param book The name of this novel.
     * @param page The number of pages of this novel.
     * @param type The type of this novel.
     */
    public Novels(String book, int page, String type) {
        super(book, page);
        this.type = type;
    }

    /**
     * Gets the name of this novel.
     * @return novel's name.
     */
    public String getNovel() {
        return super.getBook();
    }

    /**
     * Gets the type of this novel.
     * @return novel's type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of this novel.
     * @param type the type of this novel.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * toString method
     * @return representation of this novel.
     */
    public String toString() {
        return super.toString() + " TYPE: " + getType();
    }
}