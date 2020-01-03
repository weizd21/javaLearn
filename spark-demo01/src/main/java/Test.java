/**
 * @Author:weizd
 * @Date:19-12-5
 */
public class Test {


    public static void main(String[] args) {
        String code = "/home/ap/python3.5";

        code = code.substring(code.lastIndexOf("/")+1);

        System.out.println(code);
    }
}
