package C5_Inherit;

public class Manager extends Employee {

    private double bonus = 0;

    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }


    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void  test1(){
        Manager[] managers = new Manager[10];
        Employee[] employees = managers;

        //this can't work. Never do that !
        //reason: employees[0] is actually a Manager pointer(Manager x), son can't point to his father(x = new(Employee) )
        
        //why employees[0] is still a Manger pointer? since we already Employee[] e = ms;
        //because every Array stores the type mark when init.(In this case, type mark is Manager)
        
        employees[0] = new Employee("hbc",500.0);

        managers[0].setBonus(400);
    }

    private static void test2(){
        //this can work. beacause e is just a normal Employee pointer.
        Manager m = new Manager("hbc", 500.0);
        Employee e = m;
        e = new Employee("hbc", 500.0);
        m.setBonus(400);
        System.out.println("m salaray: "+m.getSalary());
        System.out.println("e salaray: "+ e.getSalary());
    }

}

class MultiInherit{
     class A{
        public void f(int x){
            System.out.println("A-int");
        }
        public void f(double x){
            System.out.println("A-double");
        }
    }

    class B extends A{
        public void f(int x){
            System.out.println("B-int");
        }
    }

    class C extends B {
        @Override
        public void f(int x) {
            System.out.println("C-int");
        }
//        public void f(double x){
//            System.out.println("C-double");
//        }
    }

    class D extends C{
        private String name = "hbc";
    }

    public D getD(){
         return  new D();
    }
    public static void main(String[] args) {
        MultiInherit m = new MultiInherit();
        MultiInherit.D md = m.getD();
        //实际调用哪个函数，在编译阶段会生成“方法表”，指定了类的函数的函数入口：如D的f（int）入口是C.f(int)， f（double）入口是A.(double)
        // ，然后运行时再判断调用哪个（对于public），称为“动态绑定”。
        md.f(0);
        md.f(2.2);
    }
}
