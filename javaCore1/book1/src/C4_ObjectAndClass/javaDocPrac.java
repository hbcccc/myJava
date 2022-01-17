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

//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
//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
//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
//test