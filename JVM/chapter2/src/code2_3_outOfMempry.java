import java.util.ArrayList;
import java.util.List;

public class code2_3_outOfMempry {
    public static void main(String[] args) {
//        System.out.println("Hello, world!");
        List<code2_3_outOfMempry> list = new ArrayList<>();
        while(true){
            list.add(new code2_3_outOfMempry());
        }
    }
}
