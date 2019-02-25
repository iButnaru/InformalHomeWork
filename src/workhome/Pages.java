package workhome;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Books -
 * @see ArtAlbums
 * @see BooksFinal
 * @see Novels
 */

/**
 * This constructs a page with content and number of page.
 */
public class Pages {
    private String content;
    private int pageNumber;

    /**
     * Gets content of the page
     *
     * @return pages`s content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content of the page.
     *
     * @param content of the page
     */

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets number of the page.
     *
     * @return pages's number
     */

    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets number of the page.
     *
     * @param pageNumber number of the page.
     */

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
