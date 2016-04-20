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
        printClassModifiers(myClass);
          
    }
    
    private static void printPackage(Class c){
        Package classPackage = c.getPackage();
        System.out.println(classPackage + ";");
    }
    
    private static void printClassModifiers(Class c){
        int modifiers = c.getModifiers();
        if (Modifier.isPublic(modifiers))
            System.out.print("public ");
        else if (Modifier.isProtected(modifiers))
            System.out.print("protected ");
        else if (Modifier.isPrivate(modifiers))
            System.out.print("private ");

        if (Modifier.isAbstract(modifiers))
            System.out.print("abstract ");
        if (Modifier.isStatic(modifiers))
            System.out.print("static ");
        if (Modifier.isFinal(modifiers))
            System.out.print("final ");
        
        System.out.println();
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
