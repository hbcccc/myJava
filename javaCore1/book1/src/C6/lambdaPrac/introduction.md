函数式接口（functional interface）：定义为只有一个抽象方法的接口（如Comparator）。可以提供一个lambda表达式。
- lambda表达式形式：
    - 三个成分： 参数，箭头(->)，表达式
    - 参数：
        - 若有多个，要括号括起来。如 ` (a,b) -> {...}`
        - 若没有参数，需要用空括号来表示。 `() -> {...}`
        - 若只有一个参数，则可以省略括号。 `a -> {...}`
    - 表达式：
        - 若只有一句能表达，则可省略花括号。`(a,b) -> a.length() - b.length()`
        - 若需要多句，则必须用花括号。` (a,b) -> {...;...;}`
- 例子:用Arrays.sort接受Comparator<String>对象来举例。
    ```java
    Comparator<String> lenComp = (a,b) -> a.length() - b.length();
    ```
    因为`Comparator<String>`是只有一个方法的接口，所以可以提供一个lambda表达式。（必要条件）
    在这个条件的基础上，在java底层，会将lambda表达式转换成**函数式接口**。
    