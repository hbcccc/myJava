package C5_Inherit.enums;

import static java.lang.System.*;

import java.util.Scanner;
public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        out.println("Enter a size:(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        out.println("The size is: "+ size);
        out.println("The abbreviation is: "+ size.getAbbreviation());
        if(size == Size.EXTRA_LARGE){
            out.println("Good job, u paie attention to the \"_\"");
        }
    }
}

enum Size{
   SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

   private String abbreviation;
   private Size(String abbreviation){
        this.abbreviation = abbreviation;
   }
   public String getAbbreviation(){
       return abbreviation;
   }

}