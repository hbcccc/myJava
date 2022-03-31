- 接口的内容
    - 静态成员：`True`
    - ~~对象成员（实例字段）~~：`False`
    - 静态方法：`True`（Java8之后）
    - 抽象方法：`True`
    - 普通方法：`True`
    - 默认方法(default)：`True`（非抽象方法）

- 接口之间可以有继承关系
    ``` java
    public interface a{...}
    public interface b extends a{...}
    ```
- 一个类可以实现多个接口,用 `"," ` 隔开
    ```java
    public class hbc extends student implements runable, compareTo{...}
    ```
- 默认方法的冲突：可能是多个接口有同样名和参数的默认方法（接口间），也可能是一个类的父类和当前类实现的接口存在同样的方法（父类-接口）。
    ```java
    //情况二：父类-接口冲突
    public class father{
        public void protectPeple(){
            System.out.println("protect from father.");
        }
    }
    public interface protect{
        default void protectPeple(){
            System.out.println("protect people.");
        }
    }
    class son extends father implements protect{...}
    ```
    解决方法：“类优先”规则：接口同名的默认方法会被父类的覆盖。调用 `son`调用`protectPeople`方法会显示`protect from father.`
    