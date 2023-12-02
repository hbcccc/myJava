package org.example.spring.basic_di.a_quickstart_set.Bean;

public class Cat {
    private String name;
    private  Integer age;

    private Person master;

    public void setMaster(Person master) {
        this.master = master;
    }

    public Person getMaster() {
        return master;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", master=" + master +
                '}';
    }
}
