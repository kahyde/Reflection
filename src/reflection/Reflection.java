package reflection;

import java.util.Date;

/**
 * @author kelseyhyde
 */
public class Reflection {

    public static void main(String[] args){
        Date date = new Date();
        SortableBook sBook = new SortableBook("hello", "hello", date, "hello", 12.34, 245);
        SortableBook sBook1 = new SortableBook("hello", "hello", date, "hello", 12.34, 345);
        SortableBook sBook2 = new SortableBook("hello", "hello", date, "hello", 12.34, 445);
        SortableBook sBook3 = new SortableBook("hello", "hello", date, "hello", 12.34, 545);
        SortableBook sBook4 = new SortableBook("hello", "hello", date, "hello", 12.34, 645);
        System.out.println(sBook);
        System.out.println(sBook.produceCategory());
        sBook.sort();
        sBook2.sort();
        sBook2.sort();
        sBook3.sort();
        sBook4.sort();
        sBook4.sort();
    }
    
}
