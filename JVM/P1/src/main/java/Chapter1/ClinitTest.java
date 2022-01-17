package Chapter1;

public class ClinitTest {
    public static int num = 0;
    static void recursive(){
        num++;
        recursive();
    }

    public static void main(String[] args) {
        try{
            recursive();
        }catch (Throwable e){
            System.out.println(num);
            //e.printStackTrace();
        }
    }
}
