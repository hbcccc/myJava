import java.util.ArrayList;
import java.util.List;

/*
* VM options: -Xms20m +Xmx20m
* The objects will be stored in java heap. when this space is full, it will throw an Error
* */
public class code2_3_outOfMempry {
    public static void main(String[] args) throws Exception {
//        System.out.println("Hello, world!");
        List<code2_3_outOfMempry> list = new ArrayList<>();
        while (true) {
            list.add(new code2_3_outOfMempry());
        }
    }
}
