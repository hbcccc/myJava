package C4_ObjectAndClass;

/**s
 * @author hbcccc
 * <img src="doc-files/pic.png" />
 */
public class javaDocPrac {
    private String name = "hbcccc";

    /**
     * this method does nothing!
     * <img src="../doc-files/pic.png" />
     */
    public void foo(){
        System.out.println("test!");
    }

    // run: javadoc -d ../docDirectory *.java
    //notice: must be in /src as root dir
    public static void main(String[] args){
        javaDocPrac j = new javaDocPrac();
        j.foo();
    }
}


//test6