# MVC常用注解

- @Repository 用于注解Dao类
- @Service 用于注解service层的类
- @Controller 同理

# Web需要解决的问题

- 导入静态资源
- 首页
- jsp，模板引擎Thymeleaf
- 装配拓展SpringMVC
- 增删改查
- 拦截器
- 国际化



## 关于静态资源

我们可以放以下目录,这样不需要controller的mapping，也能直接通过url访问



- clashpath:/resource

- clashpath:/static(默认用这里)

- clashpath:/public

  



## 模板引擎

之前spring开发中，我们需要配置viewResolver来解析渲染视图，制定好prefix和suffix后，我们在controller只需要return ”xx“就行，不需要return ”xx.html“（xx.html这个文件得放在prefix定义的目录内）。

springboot也是一样，其中一个称之为模板引擎的组件就是搞这个的，一个常见的实现是thymeleaf。但是springboot默认没加载，得手动加

```xml
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
</dependency>
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-java8time</artifactId>
</dependency>
```

按照springboot的命名规则，我们如果要配置属性，在application.yaml内配置就行，然后底层会存在叫做**thyemeleafProperties**的class，其使用@ConfigurationProperties注解来绑定。

![image-20231130131856162](d3-springbootWeb-1.assets/image-20231130131856162.png)

果然是这样吧。

![image-20231130131958602](d3-springbootWeb-1.assets/image-20231130131958602.png)

同时autoconfig这个springboot部件内也有thymeleafAutoConfiguration这样的自动配置类，因此完成了thymeleaf相关依赖的自动装载。



但现在实际开发是前后端分离的更多些，后端只需要写好接口返回json文件，渲染view那些交给前端，也不太需要模板引擎对这种不分离的的model and view渲染。



## 拓展springMVC的feature

比如我们不想用thymeleaf这个viewResolver（模板引擎、视图解析器），我们要用自己创建的，那怎么才能用上呢？

答案：在**WebMvcConfigurer实现类**的上面标注**@Configuration**，在内部声明好ViewResolver类型的bean即可。

另外的例子就是@override来重写方法

```java
@Configuration
public class MyConfig implements WebMvcConfigurer {
    //把ViewResolver添加到到容器里
    @Bean
    public ViewResolver myViewResolver(){
        return  new MyViewResolver();
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hbc").setViewName("index");
    }

}

//下面是自己定义的ViewResolver
class MyViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        return null;
    }
}
```

这样WebMvcConfigurer会扫描项目所有的ViewResolver，也包含我们创建的。

注意，**不能注明**@EnableWebMvc注解，它会导致默认的WebMvc的默认autoConfig失效（因为webMvcAutoConfiguration上有个condition，存在某个bean，那就不生效，而@EnableWebMvc刚好实现了这个bean接口，所以寄了）

 

如果使用thymeleaf接管viewResolver，在访问静态资源时，可以这样

```html
   <link th:href="@{/css/signin.css}" rel="stylesheet" type="text/css">
```

其中css文件放在**static**文件夹内



## 国际化

#### i18n配置文件

在application.properties中写好要支持多语言的配置，比如我要对login页面搞多语言支持，那就填入以下信息

```
spring.messages.basename=i18n.login
```

在resource目录下创建`i18n`文件夹，在里面写入多个语言配置文件。

```properties
login.properties  //默认
login_zh_CN.properties  //中
login_en_US.properties	//英
```

以`login_zh_CN.properties `为例，内容包含key-value对

```properties
login.username=请输入用户名
```

#### 前端

在前端html要展示这段文字的地方这样写

```html
 <input  th:placeholder="#{login.username}" required="" autofocus="">
```

使用`th:placeholder="#{login.username}"`这样的格式去声明此处要填入多语言，以login.username位key来根据环境填入value

前端页面这样写，点击的话会调用/signin这个mapping，并传入参数`language='zh_CN'`

```html
<a class="btn btn-sm" th:href="@{/signin(language='zh_CN')}">中文</a>
<a class="btn btn-sm" th:href="@{/signin(language='en_US')}">English</a>
```

#### 后端

后端也得要处理这个语言并设置激活哪个。创建LocaleResolver的实现类

```java
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        System.out.println("hhhhhhhhh");
        String language = request.getParameter("language");
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
//            System.out.println("language: "+ language);
            return  new Locale(split[0], split[1]);
        }
        Locale locale = Locale.getDefault();
        return  locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
```

并注入到IOC容器内，之后就可以了

```java
    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }
```

关键点：**bean名称必须是localeResolver**，因为spring底层会根据bean的名称来添加localeResolver，改了识别不到，只会当作普通的bean。



## 登陆+拦截器

登陆如果通过了账户校验，就添加session，记录用户信息。

```java
@RequestMapping("/signin")
public String signin(@RequestParam("username") String username,
				@RequestParam("password") String password,
				Model model, HttpSession session){
    if(!StringUtils.isEmpty(username) && "123456".equals(password)){
        session.setAttribute("loginUser",username);
        return "redirect:/main.html";
    }
    model.addAttribute("msg", "用户名或者密码错误!");
    return  "sign-in";
}
```



同时添加拦截器：该拦截器适用于全局的，所有请求（除了指定排除的请求）都会进行拦截，然后判断有无session，如果没有的话就返回登录页这样子。

```java
//自定义拦截器
public class LoginHandlerInteceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登入成功后，应该有用户session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            request.setAttribute("msg", "没有权限，请先登陆");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        }
        return true;
    }
}
```

```java
//添加拦截器到容器内 
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    ...
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInteceptor())
              .addPathPatterns("/**").excludePathPatterns("/index.html", 					"/","/user/signin", "/css/*", "/js/**", "/img/**");
    }
    ...
}
```

可以看到以上@Configuration注解和WebMvcConmfigurer接口配合，在内部重写方法，就完成了springMVC的feature拓展。

## Jdbc连接数据库

在application.yaml的配置文件中，声明好connector、dataSource类型以及属性就行。然后在Dao类中加入jdbcTemplate的自动注入@Autowired




------



# Druid

不用springBoot内置的几个默认dataSource，我们换用第三方的，如Druid，可以这样去配置。

使用方式：

1. 首先添加Druid依赖，可以从mavenRepository官网查询

2. 在application.yaml中写入以下配置, 以此设定使用第三方的dataSource实现

   ```yaml
   spring:
   	datasource:
   		username: xxx
   		password: xxx
   		url: jdbc:mysql//xxxx
   		driver-class-name: com.mysql.xxxx.Driver
   		#以下是要添加的
   		type: com.alibaba.druid.pool.DruidDataSource
   ```

   

3. 创建druid相关的属性配置文件，放在application.yaml中。

4. ```yaml
   myDruidConfig:
   	# 常规属性
   	minIdel: 5
   	maxActive: 20
   	
   	#让Druid优于其他dataSource的关键，可以配置功能强大的拦截器，有这样几种: stat用于监控统计  Log4j用于日志, wall用于防止sql注入攻击。 需要这些功能就填入进去
   	filters: stat, wall, log4j
   	#这些拦截器的依赖需要我们自己写入到maven依赖中，不然会报错
   ```

   

5. 将属性配置绑定到DruidDataSource实例中。具体而言需要创建一个配置类。

   ```java
   @Configuration
   public class DruidConfig{
       
       @ConfigurationProperties(prefix="myDruidConfig")
       @Bean
       public DataSource druidDataSource){
           return new DruidDataSource();
       }
       
       //我估计druid内部会自动注入以下bean作为自己的属性。
       @Bean
        public ServletRegistrationBean statViewServlet(){
            ServletRegistrationBean<StatViewServlet> bean = new 
                ServletRegistrationBean<>(new StatViewServlet());
            
            HashMap<String, String> initParams = new HashMap<>();
            
            //这两个key是druid固定的，定义在druid库的常量中的
            initParams.put("loginUsername", "admin");
            initParams.put("loginPassword", "123456");
            
            //允许谁能访问
            initParams.put("allow", "");
            
         
            bean.setInitParameters(initParameters);
            return bean;         
        } 
   }
   ```



------



# Mybatis

## 1，基础使用

1. 创建Mapper层（Dao层）

   ```java
   @Mapper     //用于mybatis标识
   @Repository //用于注入IOC
   public UserMapper{
       User getUserById(Integer id);
       int addUser(User user);
   }
   ```

2. 创建mapper的配置文件。放在 resources/mybatis/mapper目录下面. 以UserMapper.xml为例

   ```xml
   <mapper namespace="com.hbc.mapper.UserMapper">
       <select id="getUserById" resultType="User">
           select * from user where id = #{id};
       </select>
       
       <insert id="addUser" parameterType="User">
          insert into user(id, name, pwd) values (#{id}, #{name}, #{pwd});
       </insert>
       
       <update>
       	......
       </update>
       
       <delete>
       	......
       </delete>
       
   </mapper>
   
   ```

   

3. 在application.yaml文件配置相关信息

   ```yaml
   mybatis:
   	type-aliases-package: com.hbc.pojo  # 这里是实体类的位置
   	mappert-locations: classpath:mybatis/mapper/*.xml # 这里是mapper配置的xml文件
   	
   ```

   

4. Controller的编写（省得打代码，先不写service层了。controller直接调用mapper）

```java
   @RestController
   public class UserController{
   	@Autowired
       private UserMapper userMapper; // Mapper实现类（Dao实现类）
   
   	@GetMapping("/getUserById")
   	public User getUserById(Integer id){
           User user = userMapper.getUserById(id);
           return user;
       }
       
       @GetMapping("/addUser")
   	public User addUser(User user){
           userMapper.addUser(user);
           return "ok";
       } 
   }
```

5. 收工！ 可以发现，在~~传递参数~~以及对象封装方面，mybatis相比jdbcTemplate更加方便。原先需要自己定义RowMapper，现在不用了。**但是！原先Dao使用jdbcTemplate写法时可以简单地进行额外逻辑判断，但现在如果要加逻辑判断的话，要写在mapper.xml文件中**，不是java语法，需额外专门学习。

![image-20231204232313666](d3-springbootWeb-1.assets/image-20231204232313666.png)


----



# springSecurity

是针对Spring项目的安全框架，只用进行少量的配置，就能完成强大的安全管理。

几个关键类与注解

- WebSecurityConfigurerAdapter： 自定义Security策略
- AuthenticationManagerBuilder： 自定义认证策略
- @EnableWebSecurity: 开启WebSecurity模式



Spring Security的两个主要目标：”认证“和”授权“

认证：是面向用户的， eg，用户与vip等级，给用户一个vip等级

授权：是面向内容的，eg，vip页面与vip等级，对应等级的才能进
