import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通过反射, 动态地创建对象
public class Test6_createObj {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class c1 = Class.forName("User");

//        //构造一个对象
//        User user1 = (User) c1.newInstance(); //本质调用了无参构造器
//        System.out.println(user1);
//
//        //通过构造器构建对象
//        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
//        User hbc = (User) constructor.newInstance("hbc",23,23);
//        System.out.println(hbc);

        // 通过反射调用方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "hbc");
        System.out.println(user3);

        // 通过反射操作属性  --> 直接用会报错,因为调用的是private
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true); // 加入这行后就去掉了访问安全检测, 能调用private 属性
        name.set(user4,"hbcccc");
        System.out.println(user4);
    }
}
