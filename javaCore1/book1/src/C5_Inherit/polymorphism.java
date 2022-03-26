package C5_Inherit;

public class polymorphism {
    public static void main(String[] args) {
        test3();
    }

    private static void test1(){
        Employee[] es = new Employee[2];
        es[0] = new Employee("e", 500);
        Manager m = new Manager("m", 500);
        m.setBonus(400);
        es[1] = m;
        for( Employee e : es){
            System.out.println(e.getName()+" salary: "+e.getSalary());
        }
    }
    private static void test2(){ //another version of test1()
        Employee[] es = new Employee[2];
        es[0] = new Employee("e", 500);
        es[1] = new Manager("m", 500);
        for( Employee e : es){
            if(e instanceof Manager){
                Manager temp = (Manager) e; //only when e is really a Manager then it can pass. more examples in test3（）
                temp.setBonus(400);
            }
            System.out.println(e.getName()+" salary: "+e.getSalary());
        }
    }
    private static void test3(){ 
        Employee[] es = new Employee[2];
        es[0] = new Employee("e", 500);
        es[1] = new Manager("m", 500);

        Manager e1 = (Manager) es[1];
        System.out.println("e1 can work");

        Manager e0 = (Manager) es[0];// error detected when run-time
        System.out.println("e0 can work??");

        /**
         String s = (String) es[1];  //error detected when compile. since String is not father or son of Employee.
         */

    }
}
