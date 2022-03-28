package C4_ObjectAndClass;
// we can import static stuff(method or member)
import static java.lang.Math.*;  
public class staticImport {
    public static void main(String[] args) {
        double x = 2;
        System.out.println(pow(x,2.0));
    }
    private void hello(){
        System.out.println("hello,world!");
    }
}
