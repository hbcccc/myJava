import java.lang.annotation.*;

@MyAnnotation
public class tes2 {
    @MyAnnotation
    public void test(){

    }
}


// 定义一个注解
// @Target 是元注解（注解的注解），定义了我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})

// Retention 是元注解，定义了我们注解在什么生命周期生效（Source<Class<Runtime），默认为Runtime,
//  eg 定义为Runtime，则在Source、Class、Runtime都生效
//      定义为Source，则旨在Source时期生效
@Retention(value = RetentionPolicy.RUNTIME)

// Documented 是元注解，表明我们的注解会被记录在javaDoc中
@Documented

// Inherited 是元注解，表明我们的注解能够被子类继承
@Inherited
@interface MyAnnotation{
}
