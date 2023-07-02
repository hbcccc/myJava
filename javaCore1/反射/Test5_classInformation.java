import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获取类的信息
public class Test5_classInformation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class user = Class.forName("User");

        // 获得类名
        System.out.println(user.getName());
        System.out.println(user.getSimpleName());

        System.out.println("===============================");

        //获得属性
//        user = Class.forName("Son");
        Field[] fields = user.getFields();  //只能获得本类和父类全部的public的属性
        for(Field field: fields)
            System.out.println("public:"+field);

        fields = user.getDeclaredFields(); //获得全部的属性
        for(Field field: fields)
            System.out.println(field);
        System.out.println("****");
        Field fd2 = user.getDeclaredField("name");
        System.out.println(fd2);

        System.out.println("===============================");

        //获得类的方法
        Method[] methods = user.getMethods(); //获得本类及其父类的全部public方法
        for(Method method: methods)
            System.out.println("正常的 "+method);

        methods = user.getDeclaredMethods(); //获得本类的全部方法！
        for(Method method: methods)
            System.out.println(method);
        System.out.println("****");
        //获得指定方法
        Method m1 = user.getMethod("getName",null); //第二个参数是 method的“传参”， 是为了获取指定的函数（当getName同名函数存在重载的时候）
        System.out.println(m1);



    }
}
