package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author kelseyhyde
 */
public class Reflection {
      
    public static void main(String[] args){
        Class myClass = SortableBook.class;
        printPackage(myClass); 
        printClassHeader(myClass); 
        printFields(myClass);
        printConstructors(myClass);
        printMethods(myClass);
        System.out.println("}");
    }
    
    public static void printPackage(Class c){
        Package classPackage = c.getPackage();
        System.out.println(classPackage + ";");
    }
    
    private static void printModifiers(Class c){
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
        printModifiers(c);
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
            else {
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
            printModifiers(f);
            
            System.out.print(f.getType() + " ");
            
            System.out.println(f.getName() + ";");
        }
    }
    
    private static void printModifiers(Field f){
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
    
    public static void printConstructors(Class c){
        Constructor[] constructors = c.getConstructors();
        for (Constructor con : constructors){
            printModifiers(con);
            
            System.out.print(c.getSimpleName() + "(");
            
            Class[] types = con.getParameterTypes();
            printTypes(types);
            
            System.out.println("){}");
        }
    }
    
    private static void printModifiers(Constructor c){
        int modifiers = c.getModifiers();
        if (Modifier.isPublic(modifiers))
            System.out.print("public ");
        else if (Modifier.isProtected(modifiers))
            System.out.print("protected ");
        else if (Modifier.isPrivate(modifiers))
            System.out.print("private ");
    }
    
    private static void printTypes(Class[] types){
        int length = types.length;
        if (length != 0){
            
            if (length == 1){
                System.out.print(types[0].getSimpleName() + " arg0 ");
            }
            else {
               for (int i = 0; i < length - 1; i++){
                   System.out.print(types[i].getSimpleName() + " arg" + i + ", ");
               } 
               System.out.print(types[length - 1] + " arg" + (length - 1));
            }
        }

    }
    
    public static void printMethods(Class c){
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods){
            if (!(m.isBridge())){
                printModifiers(m);
                Class type = m.getReturnType();
                System.out.print(type.getSimpleName() + " ");
                System.out.print(m.getName());
                System.out.println("(){}");
            }
        }
    }
    
    private static void printModifiers(Method m){
        int modifiers = m.getModifiers();
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
        if (Modifier.isSynchronized(modifiers))
            System.out.print("synchronized ");
    }
    
    
    
}
