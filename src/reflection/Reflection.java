package reflection;

import java.lang.reflect.*;

/**
 * @author kelseyhyde
 */
public class Reflection {
      
    public static void main(String[] args){
        Class myClass = SortableBook.class;
        printPackage(myClass); 
        printClassHeader(myClass); 
        printFields(myClass);
    }
    
    public static void printPackage(Class c){
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
    }
    
    public static void printClassHeader(Class c){
        printClassModifiers(c);
        System.out.print("class ");
        String name = c.getSimpleName();
        System.out.print(name + " ");

        Class superClass = c.getSuperclass();
        if (superClass != null){
            String superName = superClass.getSimpleName();
            System.out.print("extends " + superName + " ");
        }
        
        printInterfaces(c);
        
        System.out.println("{ ");
    }
    
    private static void printInterfaces(Class c){
        Class[] interfaces = c.getInterfaces();
        if (interfaces.length != 0){
            System.out.print("implements ");
  
            if(interfaces.length == 1)
                System.out.print(interfaces[0].getSimpleName() + " ");
            else{
                for (int i = 0; i < interfaces.length - 1; i++) {
                    String interfaceName = interfaces[i].getSimpleName();
                    System.out.print(interfaceName + ", ");
                }
                System.out.print(interfaces[interfaces.length - 1].getSimpleName() + " ");
            }
        }
    }
    
    public static void printFields(Class c){
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            printFieldModifiers(f);
            Object type = f.getType();
            System.out.print(type + " ");
            String name = f.getName();
            System.out.println(name + ";");
        }
    }
    
    private static void printFieldModifiers(Field f){
        int modifiers = f.getModifiers();
        if (Modifier.isPublic(modifiers))
            System.out.print("public ");
        else if (Modifier.isProtected(modifiers))
            System.out.print("protected ");
        else if (Modifier.isPrivate(modifiers))
            System.out.print("private ");
        
        if (Modifier.isStatic(modifiers))
            System.out.print("static ");
        if (Modifier.isFinal(modifiers))
            System.out.print("final ");
        if (Modifier.isTransient(modifiers))
            System.out.print("transient ");
        if (Modifier.isVolatile(modifiers))
            System.out.print("volatile ");
    }
    
    private static void printConstructors(Class c){
        
    }
    
    private static void printMethods(Class c){
        
    }
    
}
