package reflection;

import java.util.Date;

/**
 * @author kelseyhyde
 */
class Book {
    protected String title;
    protected String author;
    protected Date published;
    protected String publisher;
    protected double price;
    
    Book (String title, String author, Date published, String publisher, double price){
        this.title = title;
        this.author = author;
        this.published = published;
        this.publisher = publisher;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Published: " + publisher + ", " + published + ", Price" + price;
    }
    
    
}
