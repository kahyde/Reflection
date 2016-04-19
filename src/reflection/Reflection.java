package reflection;

import java.lang.reflect.*;
import java.util.Date;

/**
 * @author kelseyhyde
 */
public class Reflection {
      
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException{
        Class myClass = SortableBook.class;
        printPackage(myClass); 
          
    }
    
    private static void printPackage(Class c){
        System.out.println(c.getPackage() + ";");
    }
    
    private static void printModifiers(Class c){
        
    }
    
    private static void printClassHeader(Class c){
        
    }
    
    private static void printInterfaces(Class c){
        
    }
    
    private static void printFields(Class c){
        
    }
    
    private static void printConstructors(Class c){
        
    }
    
    private static void printMethods(Class c){
        
    }
    
}
