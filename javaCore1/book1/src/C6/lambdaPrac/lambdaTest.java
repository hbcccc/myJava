package C6.lambdaPrac;

import java.util.Arrays;

public class lambdaTest {
    public static void main(String[] args) {
        var planets = new String[]{"水星","金星","地球","火星","木星","土星","天王星","海王星"};
        System.out.println(Arrays.toString(planets));
        System.out.println("sort in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("sort by string length");
        Arrays.sort(planets, (a,b) -> a.length() - b.length());
        System.out.println(Arrays.toString(planets));
    }
}
