public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p1 = new Student();
        System.out.println("这个人是"+p1.name);

        // 方式一：通过对象获得
        Class c1 = p1.getClass();
        System.out.println(c1.hashCode());

        // 方式二： 通过forName获得
        Class c2 = Class.forName("Student");
        System.out.println(c2.hashCode());

        // 方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        Class c4 = c1.getSuperclass();
        System.out.println(c4);
    }
}

class Person{
    public String name;
    public Person() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class  Teacher extends  Person{
    public Teacher() {
        this.name = "老师";
    }
}