# 注解

### 加载配置文件

 **@ConfigurationProperties **

​		用于绑定properties到java类内。系统会从**application.yml**文件读取properties信息，之后加载到bean属性中。

如以下*application.yml*文件

```yml
cat:
	name: miaomiao
	age: 3
```

```java
@Component
@ConfigurationProperties(prefix = "cat") //此处用于绑定.yml中指定的对象名， eg，cat
public class Cat {
    String name;
    Integer age;
}

```

**@PropertySource**

​		没有约束文件名称，配合el表达式完成属性注入。相比上面的注解，这个灵活度低，**不能完成批量注入；不能数据校验；不能松散绑定；不能复杂类型封装等**。

```properties
name=miaomiao
age=3
```

```java
@Component
@PropertySource(value = "cat.properties")
public class Cat {
	@Value("${name}")
	String name;
    ...
}
```

- 松散绑定：比如firstName和 first_name这种命名不同，但@ConfigurationProperties注解能自动转换和绑定，没有要求名称完全相同。

- 数据校验：通过@ConfigurationProperties注解注入属性后，能配合@Validated注解完成属性的校验

  ```java
  @Component
  @ConfigurationProperties(prefix = "cat")
  @Validated
  public class Cat {
      @Email(message = "用户名需要为合法的邮箱格式")
      private String name;
  }
  ```

  

**application.yml优先级**

​	./config/application.yml  最高

​	./application.yml

​	classpath:/config/application.yml

​	classpath:/  最低





# 自动配置原理

#### 整体过程

1，如果有**@EnableAutoConfiguration**注解，springboot会读取**META-INF/spring.factories**文件内的信息，里面包含了所有自动配置类。

2，springboot会判断是否需要激活哪些自动配置类，通过各种@conditional来实现

3，之后对于需要激活的配置类，我们需要加载配置类的一些属性信息（一般xx自动配置类内部会有个**xxProperties**的属性类）。因此，配置类`xxxAutoConfiguration`上会有**@EnableConfigurationProperties(xxProperties.class)**注解， 绑定了对应的配置属性类xxProperties.class， 而这个属性类上会有**@ConfigurationProperties(prefix= ”yy.xx“)**这样的注解，会从我们定义的**application.yaml**文件读取配置信息。

4，配置完成后，Spring Boot会将包含的所有的Bean注册到容器中，以供其他组件使用。



#### @ConfigurationProperties

这个注解常用于修饰xxxProperties.class，而这个类上面也会有@Configuration 或者 @Component注解（没这两个也行，但需要在主类上加上@ConfigurationpropertiesScan注解来扫描注册xxxProperties所在的包, 或者**@EnableConfigurationProperties**注解来绑定xxProperties.class这个类：**没错，自动配置就是如此由这两个注解配合完成的**）



此外，除了以上功能（用于springboot的自动配置），这个注解也能用于我们自己构建bean的属性注入。具体来说：比如我们定义了User类

```java
@C
@ConfigurationProperties(prefix="my.userConfig")
public User{
	String name;
    Integer age;
}

```

或者如下：

```java
//第一个类User.class
public User{
	String name;
    Integer age;
}

//第二个类 MyConfig.class
@Configuration
public MyConfig{
	@Bean
    @ConfigurationProperties(prefix="my.userConfig")
    public User user(){
        return new User();
    }
}
```



