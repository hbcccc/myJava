package Chapter1;

public class StackStructTest {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;

        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+" M");
        System.out.println(Runtime.getRuntime().totalMemory() /1024/1024+" M");
    }
}