package reflection;

import java.lang.reflect.*;
import java.util.Date;

/**
 * @author kelseyhyde
 */
public class Reflection {

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException{
        Class myClass = SortableBook.class;
        
        String classPackage = myClass.getName();
        System.out.println("Class Name is: " + classPackage);
        

        
    }
    
    private void printModifiers(){
        
    }
    
    private void printClassHeader(){
        
    }
    
    private void printInterfaces(){
        
    }
    
    private void printFields(){
        
    }
    
    private void printConstructors(){
        
    }
    
    private void printMethods(){
        
    }
    
}
