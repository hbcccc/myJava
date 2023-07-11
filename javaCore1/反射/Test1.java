
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的Class 对象, 该对象唯一，多次创建只是获得其引用，指向同一个对象
        Class c1 = Class.forName("User");
        System.out.println(c1);
        System.out.println(c1.hashCode());

    }
}

class User {
    private String name;
    private int id;
    private int age;

    public User() {

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{:"+"name:"+this.name+"; id:"+this.id+"; age:"+this.age+";}";
    }
}