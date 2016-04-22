package reflection;
public class SortableBook extends Book implements Sortable { 
private int deweyDecimal;
private boolean sorted;
private static int sortedCount;

public SortableBook(String arg0, String arg1, String arg2, String arg3, double arg4, int arg5){}
public SortableBook(Book arg0, int arg1){}

public String toString(){}
public void sort(){}
public String produceCategory(){}
public int getDeweyDecimal(){}
public void setDeweyDecimal(int arg0){}
public boolean getSorted(){}
public static int getSortedCount(){}
private static void incrementSortedCount(){}

}
