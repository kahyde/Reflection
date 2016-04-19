package reflection;

import java.util.Date;

/**
 * @author kelseyhyde
 */
class SortableBook extends Book implements Sortable {
    private int deweyDecimal;
    private boolean sorted;
    private static int sortedCount;
    
    SortableBook(String title, String author, Date published, String publisher, double price, int deweyDecimal){
        super(title, author, published, publisher, price);
        this.deweyDecimal = deweyDecimal;
        sorted = false;
    }
    
    SortableBook(Book book, int deweyDecimal){
        super(book.title, book.author, book.published, book.publisher, book.price);
        this.deweyDecimal = deweyDecimal;
        sorted = false;
    }
    
    @Override
    public void sort(){
        String category = this.produceCategory();
        
        if (!sorted){
            sorted = true;
            incrementSortedCount();

            System.out.println("The book " + title + " has been sorted into the category: " + category);
            System.out.println("There have now been " + sortedCount + " books sorted."); 
        }
        else {
            System.out.println("This book has already been sorted into the category: " + category);
            System.out.println("There have been " + sortedCount + " books sorted."); 
        }
        
    }
    
    @Override
    public String produceCategory(){
        if (deweyDecimal >= 0 && deweyDecimal <= 99 )
            return "General Knowledge";
        else if (deweyDecimal >= 100 && deweyDecimal <= 199 )
            return "Philosophy & Psychology";
        else if (deweyDecimal >= 200 && deweyDecimal <= 299 )
            return "Religion";
        else if (deweyDecimal >= 300 && deweyDecimal <= 399 )
            return "Social Sciences";
        else if (deweyDecimal >= 400 && deweyDecimal <= 499 )
            return "Languages";
        else if (deweyDecimal >= 500 && deweyDecimal <= 599 )
            return "Science";
        else if (deweyDecimal >= 600 && deweyDecimal <= 699 )
            return "Technology";
        else if (deweyDecimal >= 700 && deweyDecimal <= 799 )
            return "Arts and Recreation";
        else if (deweyDecimal >= 800 && deweyDecimal <= 899 )
            return "Literature";
        else if (deweyDecimal >= 900 && deweyDecimal <= 999 )
            return "History and Geography";
        else
            return "No Category";
    }

    @Override
    public String toString() {
        return super.toString() + "SortableBook{" + "deweyDecimal=" + deweyDecimal + ", sorted=" + sorted + '}';
    }
    
    
    
    private static void incrementSortedCount(){
        sortedCount++;
    }
}
