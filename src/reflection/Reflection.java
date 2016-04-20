package reflection;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author kelseyhyde
 */
public class Reflection {
    
    public static void main(String[] args) throws FileNotFoundException {
        Class myClass = SortableBook.class;
        //PrintWriter writer = new PrintWriter(myClass.getSimpleName() + ".java");
        System.out.println(printPackage(myClass)); 
        System.out.println(printClassHeader(myClass)); 
        System.out.println(printFields(myClass));
        System.out.println(printConstructors(myClass));
        System.out.println(printMethods(myClass));
        System.out.println("}");
    }
    
    public static String printPackage(Class c){
        StringBuilder s = new StringBuilder("");
        Package classPackage = c.getPackage();
        s.append(classPackage).append(";");
        return s.toString();
    }
    
    private static String printModifiers(Class c){
        StringBuilder s = new StringBuilder("");
        int modifiers = c.getModifiers();
        if (Modifier.isPublic(modifiers))
            s.append("public ");
        else if (Modifier.isProtected(modifiers))
            s.append("protected ");
        else if (Modifier.isPrivate(modifiers))
            s.append("private ");

        if (Modifier.isAbstract(modifiers))
            s.append("abstract ");
        if (Modifier.isStatic(modifiers))
            s.append("static ");
        if (Modifier.isFinal(modifiers))
            s.append("final ");
        
        return s.toString();
    }
    
    public static String printClassHeader(Class c){
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
    
    public static String printFields(Class c){
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
    
    private static String printModifiers(Field f){
        StringBuilder s = new StringBuilder("");
        int modifiers = f.getModifiers();
        if (Modifier.isPublic(modifiers))
            s.append("public ");
        else if (Modifier.isProtected(modifiers))
            s.append("protected ");
        else if (Modifier.isPrivate(modifiers))
            s.append("private ");
        
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
    
    public static String printConstructors(Class c){
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
    
    private static String printModifiers(Constructor c){
        StringBuilder s = new StringBuilder("");
        int modifiers = c.getModifiers();
        if (Modifier.isPublic(modifiers))
            s.append("public ");
        else if (Modifier.isProtected(modifiers))
            s.append("protected ");
        else if (Modifier.isPrivate(modifiers))
            s.append("private ");
        
        return s.toString();
    }
    
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
    
    public static String printMethods(Class c){
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
    
    private static String printModifiers(Method m){
        StringBuilder s = new StringBuilder("");
        int modifiers = m.getModifiers();
        if (Modifier.isPublic(modifiers))
            s.append("public ");
        else if (Modifier.isProtected(modifiers))
            s.append("protected ");
        else if (Modifier.isPrivate(modifiers))
            s.append("private ");
        
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
}
