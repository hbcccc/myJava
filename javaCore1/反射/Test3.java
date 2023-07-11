public class Test3 {
    static{
        System.out.println("Main 初始化");
    }
    public static void main(String[] args) throws ClassNotFoundException {

        // 1， 主动引用
//        Son s1 = new Son();

        // 反射也会产生主动引用
//        Class c1 = Class.forName("Son"); // 因为类只会被加载一次，所以第二次的时候不会输出sout （static属于类）

        // 不会产生类的引用的方法
//        System.out.println(Son.b); //此时，子类Son没有被加载

//        Son[] array = new Son[5]; // 此时，甚至父类和子类都没加载！

        System.out.println(Son.M); // static  final 常量加载，也不会引起类的加载。
    }
}

class Father{
    public int faInt = 1;
    static int b = 2;
    static{
        System.out.println("父类初始化");
    }
}

class Son extends Father{
    public int sonInt = 2;
    static final int M = 1;
    static{
        System.out.println("子类初始化");
    }
}
