package C5_Inherit;

public class Employee {
    private String name = "";
    private double salary = 0.0;

    public Employee(String name, double salary){
        this.name = name;
        if(salary>0){
            this.salary = salary;
        }
        else{
            //maybe throw an exception ?
        }
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
