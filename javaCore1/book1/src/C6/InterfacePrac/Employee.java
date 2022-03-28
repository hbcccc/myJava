package C6.InterfacePrac;

import java.util.Arrays;

/**
 * this class is modified to implement a interface "Comparable", which defines a method "compareTo"
 */
public class Employee implements Comparable {
    
    public int compareTo(Object otherObject){
        Employee other = (Employee) otherObject;
        return  Double.compare(this.salary, other.salary);
    }

    private double salary;
    private String name;
    Employee(String name,double s){
        this.salary = s;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public static void main(String[] args) {
        Employee a = new Employee("a",200.5);
        Employee b = new Employee("b",300.0);
        Employee c = new Employee("c",250.0);

        char[] chs = new char[]{'<','=','>'};
        System.out.println("c "+chs[c.compareTo(a)+1]+" a");
        System.out.println("c "+chs[c.compareTo(b)+1]+" b");

        var es = new Employee[]{a,b,c};
        Arrays.sort(es);
        for(Employee e : es){
            System.out.println(e.getName()+", salary:"+e.getSalary());
        }

    }
    public static void test1(){
        //this can work
        Comparable e = new Employee("hbc", 2000.0);

        //this can't, 
//      Comparable e = new Comparable();
    }
}
