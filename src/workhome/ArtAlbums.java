package workhome;

/**
 * @author Ionut Butnaru
 * {@C:\Users\Ionut\IdeaProjects\HelloWorld\src}
 * @version 1.0
 * @see Books - superclass
 * @see Novels
 * @see BooksFinal
 */
public class ArtAlbums extends Books {

    private String paperQuality;

    public ArtAlbums() {

    }

    /**
     * This constructs and art album with specified name, number of pages and quality of paper.
     *
     * @param book         The name of this art album.
     * @param page         The number of pages of this art album.
     * @param paperQuality The quality of this art album's paper.
     */
    public ArtAlbums(String book, int page, String paperQuality) {
        super(book, page);
        this.paperQuality = paperQuality;
    }

    /**
     * Gets the name of this art album.
     *
     * @return art album's name.
     */
    public String getNovel() {
        return super.getBook();
    }

    /**
     * Gets the quality of this art album's paper.
     *
     * @return art album's paper quality.
     */

    public String getPaperQuality() {
        return paperQuality;
    }

    /**
     * Sets the quality of this art album's paper.
     *
     * @param paperQuality paper's quality of this album
     */

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    /**
     * toString method
     *
     * @return representation of this art album.
     */
    public String toString() {
        return super.toString() + " PAPER QUALITY: " + getPaperQuality();
    }
}