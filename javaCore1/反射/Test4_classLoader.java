public class Test4_classLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器 (AppClassLoader)
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获得系统类加载器的父类加载器-->扩展类加载器 (ExtClassLoader)
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获得扩展类加载器的父类 --> 根加载器（C/C++）
        ClassLoader grandpa = parent.getParent();
        System.out.println(grandpa);

        // 测试当前类是是哪个加载其加载到
        ClassLoader test4ClassLoader = Class.forName("Test4_classLoader").getClassLoader();
        System.out.println(test4ClassLoader);

        // 测试JDK内置类是什么加载的
        ClassLoader classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        /*
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\charsets.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\access-bridge-64.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\cldrdata.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\dnsns.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\jaccess.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\jfxrt.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\localedata.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\nashorn.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\sunec.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\sunjce_provider.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\sunmscapi.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\sunpkcs11.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\ext\zipfs.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\jce.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\jfr.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\jfxswt.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\jsse.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\management-agent.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\resources.jar;
        C:\Users\12425\.jdks\corretto-1.8.0_372\jre\lib\rt.jar;
        C:\Users\12425\Desktop\git\myJava\javaCore1\反射\out\production\反射;
        C:\Program Files\JetBrains\IntelliJ IDEA 2023.1.3\lib\idea_rt.jar
         */

    }
}
