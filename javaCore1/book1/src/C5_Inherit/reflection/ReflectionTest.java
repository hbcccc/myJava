package C5_Inherit.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

// import C5_Inherit.Employee;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        test2();
    }
    private static void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        //create a object with reflection.
        String className = "C4_ObjectAndClass.staticImport";
        Class cl = Class.forName(className);
        Object obj = cl.getConstructor().newInstance();
    
    }
    private static void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        //show the info of a class.
        // String className = "C4_ObjectAndClass.staticImport";
        String className = "C5_Inherit.Manager";
        Class cl = Class.forName(className);

        String modifier = Modifier.toString(cl.getModifiers());
        if(modifier.length()>0){
            System.out.print(modifier+" ");
        }
        System.out.print("class "+className);
        Class superClass = cl.getSuperclass();
        if(superClass!=null && superClass!=Object.class){
            System.out.println(" extends "+ superClass.getName());
        }
        System.out.println("{");

        

    }
}
