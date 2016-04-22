package reflection;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.*;

/**
 * A class demonstrating the creation of a .java file from a .class file using reflection.
 * @author kelseyhyde
 */
public class Reflection {
    
    //Creates a .java file from the .class file of SortableBook.
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Class myClass = SortableBook.class;
        PrintWriter writer = new PrintWriter(new FileWriter(myClass.getSimpleName() + ".java"));
        writer.println(printPackage(myClass)); 
        writer.println(printClassHeader(myClass)); 
        writer.println(printFields(myClass));
        writer.println(printConstructors(myClass));
        writer.println(printMethods(myClass));
        writer.println("}");
        writer.close();
    }
    
    //returns a string with the package name of the class passed as an argument.
    private static String printPackage(Class c){
        StringBuilder s = new StringBuilder("");
        Package classPackage = c.getPackage();
        s.append(classPackage).append(";");
        return s.toString();
    }
    
    //returns a string with the class header of the class passed as an argument.
    private static String printClassHeader(Class c){
        StringBuilder s = new StringBuilder("");
        String m = printModifiers(c);
        s.append(m);
        
        s.append("class ");
        
        String name = c.getSimpleName();
        s.append(name).append(" ");

        Class superClass = c.getSuperclass();
        if (superClass != null){
            String superName = superClass.getSimpleName();
            s.append("extends ").append(superName).append(" ");
        }
        
        String i = printInterfaces(c);
        s.append(i).append("{ ");
        
        return s.toString();
    }
    
    //returns a string containing the fields of the class on separate lines.
    private static String printFields(Class c){
        StringBuilder s = new StringBuilder("");
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            String m = printModifiers(f);
            s.append(m);
            
            s.append(f.getType()).append(" ");
            
            s.append(f.getName()).append(";\n");
        }
        return s.toString();
    }
    
    //returns a string containing the (formatted) constructors of the class.
    private static String printConstructors(Class c){
        StringBuilder s = new StringBuilder("");
        Constructor[] constructors = c.getConstructors();
        for (Constructor con : constructors){
            s.append(printModifiers(con));
            
            s.append(c.getSimpleName()).append("(");
            
            Class[] types = con.getParameterTypes();
            s.append(printTypes(types)).append("){}\n");
        }
        return s.toString();
    }
    
    //returns a string containing the (formatted) methods of the class.
    private static String printMethods(Class c){
        StringBuilder s = new StringBuilder("");
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods){
            if (!(m.isBridge())){
                s.append(printModifiers(m));
                Class type = m.getReturnType();
                s.append(type.getSimpleName()).append(" ");
                
                s.append(m.getName()).append("(");
                
                Class[] parameters = m.getParameterTypes();
                s.append(printTypes(parameters));
                s.append("){}\n");
            }
        }
        return s.toString();
    }
    
    //returns a string containing the relevant modifiers of the class.
    private static String printModifiers(Class c){
        StringBuilder s = new StringBuilder("");
        int modifiers = c.getModifiers();
        
        String access = printAccessModifiers(modifiers);
        s.append(access);

        if (Modifier.isAbstract(modifiers))
            s.append("abstract ");
        if (Modifier.isStatic(modifiers))
            s.append("static ");
        if (Modifier.isFinal(modifiers))
            s.append("final ");
        
        return s.toString();
    }
    
    //returns a string containing the relevant modifiers of the field.
    private static String printModifiers(Field f){
        StringBuilder s = new StringBuilder("");
        int modifiers = f.getModifiers();
        
        String access = printAccessModifiers(modifiers);
        s.append(access);
        
        if (Modifier.isStatic(modifiers))
            s.append("static ");
        if (Modifier.isFinal(modifiers))
            s.append("final ");
        if (Modifier.isTransient(modifiers))
            s.append("transient ");
        if (Modifier.isVolatile(modifiers))
            s.append("volatile ");
        
        return s.toString();
    }
    
    //returns a string containing the relevant modifiers of the constructor.
    private static String printModifiers(Constructor c){
        StringBuilder s = new StringBuilder("");
        int modifiers = c.getModifiers();
        
        String access = printAccessModifiers(modifiers);
        s.append(access);
        
        return s.toString();
    }
    
    //returns a string containing the relevant modifiers of the method.
    private static String printModifiers(Method m){
        StringBuilder s = new StringBuilder("");
        int modifiers = m.getModifiers();
        
        String access = printAccessModifiers(modifiers);
        s.append(access);
        
        if (Modifier.isAbstract(modifiers))
            s.append("abstract ");
        if (Modifier.isStatic(modifiers))
            s.append("static ");
        if (Modifier.isFinal(modifiers))
            s.append("final ");
        if (Modifier.isSynchronized(modifiers))
            s.append("synchronized ");
        
        return s.toString();
    }
    
    //returns a string containing the access modifiers of a class, field, constructor or method.
    private static String printAccessModifiers(int modifiers){
        StringBuilder s = new StringBuilder("");
        if (Modifier.isPublic(modifiers))
            s.append("public ");
        else if (Modifier.isProtected(modifiers))
            s.append("protected ");
        else if (Modifier.isPrivate(modifiers))
            s.append("private ");
        
        return s.toString();
    }
    
    //returns a string containing the interfaces section of the class header.
    private static String printInterfaces(Class c){
        StringBuilder s = new StringBuilder("");
        Class[] interfaces = c.getInterfaces();
        if (interfaces.length != 0){
            s.append("implements ");
  
            if(interfaces.length == 1){
                s.append(interfaces[0].getSimpleName()).append(" ");
            }
            else {
                for (int i = 0; i < interfaces.length - 1; i++) {
                    String interfaceName = interfaces[i].getSimpleName();
                    s.append(interfaceName).append(", ");
                }
                s.append(interfaces[interfaces.length - 1].getSimpleName()).append(" ");
            }
        }
        return s.toString();
    }
    
    //returns a string containing the types of arguments in a constructor or method.
    private static String printTypes(Class[] types){
        StringBuilder s = new StringBuilder("");
        int length = types.length;
        if (length != 0){
            
            if (length == 1){
                s.append(types[0].getSimpleName()).append(" arg0");
            }
            else {
               for (int i = 0; i < length - 1; i++){
                   s.append(types[i].getSimpleName()).append(" arg").append(i).append(", ");
                   
               } 
               s.append(types[length - 1]).append(" arg").append(length - 1);
            }
        }
        return s.toString();
    }  
}
