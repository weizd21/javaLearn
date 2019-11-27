import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:weizd
 * @Date:19-11-27
 */
public class Hello {


    public static void main(String[] args) {


        System.out.println("launcher enter time :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));



        System.out.println("launcher leave time :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));


    }


}
