package workhome;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Novels
 * @see ArtAlbums
 * @see BooksFinal - main
 *
 */



public class Books {

    private String book;
    private int page;


    //Empty constructor.
    public Books(){
    }
    /**
     * This constructs a book with specified name and number of pages
     * @param book The name of this book.
     * @param page The number of pages of this book.
     */
    public Books(String book, int page){
        this.book = book;
        this.page = page;

    }

    /**
     * Gets the name of this book.
     * @return this book's name.
     */
    public String getBook(){
        return book;
    }

    /**
     * Sets the name of this book.
     * @param book the name of this book.
     */
    public void setBook(String book){
        this.book = book;
    }

    /**
     * Gets the number of pages of this book.
     * @return the book's number of pages.
     */
    public int getPage(){
        return page;
    }

    /**
     * Sets the number of pages of this book.
     * @param page the number of pages.
     */
    public void setPage(int page){
        this.page = page;
    }

    /**
     * toString method.
     * @return the representation of this book.
     */
    public String toString() {
        return " NAME: " + getBook() + " PAGES: " + getPage();
    }

}
