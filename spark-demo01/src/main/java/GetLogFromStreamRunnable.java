import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author:weizd
 * @Date:19-11-30
 *
 *  从 输入流中获取信息
 *
 */
public class GetLogFromStreamRunnable implements Runnable{

    private InputStream inputStream;

    private DealStrHandler dealStrHandler;

    public GetLogFromStreamRunnable(InputStream inputStream,DealStrHandler dealStrHandler){
        this.inputStream = inputStream;
        this.dealStrHandler = dealStrHandler;
    }

    @Override
    public void run() {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
        String line = null;
        try{
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(Thread.currentThread().getName()+":"+line);
                dealStrHandler.handler(Thread.currentThread().getName()+":"+line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
