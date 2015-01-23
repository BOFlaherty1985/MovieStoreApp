package co.uk.moviestore.model;

import org.joda.time.DateTime;

/**
 * Video Rental Object
 *
 * @author Benjamin O'Flaherty
 * @date Created on: 23/01/2015
 * @project MovieStore
 */
public class VideoRental {

    private long id;
    private String title;
    private String category;
    private DateTime checkOut;
    private DateTime returnDate;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCheckOut(DateTime checkOut) {
        this.checkOut = checkOut;
    }

    public DateTime getCheckOut() {
        return checkOut;
    }

    public void setReturnDate(DateTime returnDate) {
        this.returnDate = returnDate;
    }

    public DateTime getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "VideoRental{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", checkOut=" + checkOut +
                ", returnDate=" + returnDate +
                '}';
    }

}
