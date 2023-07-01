import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test3 {
    // 注解可以显式赋值，如果没有默认值，则我们必须给注解赋值。
    @MyAnnotation2(name = "hbc", schools = {"86", "scut"})
    public void test(){

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数： 参数类型 + 参数名 ();
    String name() default "";
    int age() default 0;
    int id() default  -1;
    String[] schools(); //没有定义默认值，则我们使用该注解时，必须主动赋值
}

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@interface MyAnnotation3{
    String value(); //如果只有一个参数，默认参数名为 value
}