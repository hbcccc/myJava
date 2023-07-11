import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test7_annotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class c1 = Class.forName("Student2");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation ann:annotations) {
            System.out.println(ann);
        }

        System.out.println("================");

        //获取属性的注解
        Field fd1 = c1.getField("name");
        FieldHbc annOfName = fd1.getAnnotation(FieldHbc.class);
        System.out.println(annOfName.column());
        System.out.println(annOfName.type());
        System.out.println(annOfName.length());


    }
}

@TableHBC("db_student")
class Student2{

    @FieldHbc(column = "name",type = "varchar",length = 10)
    public String name;

    @FieldHbc(column = "age",type = "int",length = 10)
    public int age;

    @FieldHbc(column = "id",type = "int",length = 10)
    public int id;

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableHBC{
    String value();
}


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldHbc{
    String column();
    String type();
    int length();
}

