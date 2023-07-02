# 注解 （Annotation）

- 注解的作用
  1. 注解不是程序本身，可以对程序作出解释
  2. 注解可以被其他程序读取。
- 注解的格式
  1. 以“@注解名”在代码中存在，可以添加参数值，例如`@SuppressWarnings(Value="Unchecked")`

- 注解在哪里使用
  1. 可以附加在package， class， method， field等上面，相当于给他们添加了额外的辅助信息
  2. 我们可以通过**反射机制**编程实现对这些元数据的访问





### 元注解

可以定义注解的注解。Java定义了以下四个meta-annotation类型。

- **@Target** ：用于描述注解的适用范围（如函数、数据成员、类型、构造器等等）
- **@Retention**：表示需要在什么级别保存该注解信息，用于描述注解的生命周期
  - （Source **<** Class **<** Runtime)
- **@Document**:说明该注解将被包含在javadoc中
- **@Inherited**：说明子类可以**继承**父类中的注解





