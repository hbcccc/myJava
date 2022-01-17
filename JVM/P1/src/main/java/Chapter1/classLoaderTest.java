package Chapter1;


import java.net.URL;

public class classLoaderTest {
    public static void main(String[] args) {
        ClassLoader cl = classLoaderTest.class.getClassLoader();
        while(cl != null){
            System.out.println(cl);
            cl = cl.getParent();
        }

        //输出为null，不是说parentLoader不存在，而是表示String类是通过“引导类加载器bootstrapClassLoader”加载的，其为C语言实现。
        System.out.println(String.class.getClassLoader());


    }
}
