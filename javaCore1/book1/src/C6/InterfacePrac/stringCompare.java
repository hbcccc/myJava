package C6.InterfacePrac;

import java.util.Arrays;
import java.util.Comparator;

public class stringCompare {
    public static void main(String[] args) {
        String[] a = {"hbc","hbccc","hbcc"};
        lengthComparator comp = new lengthComparator();
        Arrays.sort(a, comp);
        for(String s :a)
            System.out.println(s); 
    }
}

//reverse the compareTo of class String 
class lengthComparator implements Comparator<String>{

    public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
    }

}

