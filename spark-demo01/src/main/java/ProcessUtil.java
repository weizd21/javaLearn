import cn.hutool.core.util.StrUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author:weizd
 * @Date:19-11-28
 * Process 工具类
 *
 *
 */
public class ProcessUtil {






    public static void getExecResult(Process process,StringBuffer sb) throws Exception{
        final BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
        final BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        new Thread(()->{
            String line = null;
            try{
                while ((line = stdout.readLine()) != null){
                    if(sb != null){
                        sb.append(line+"/n");
                    }
                    System.out.println("stdout:"+line);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();



        new Thread(()->{
            String line = null;
            try{
                while ((line = stderr.readLine()) != null){
                    if(sb != null){
                        sb.append(line+"/n");
                        System.out.println("stderr:"+line);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();


        process.waitFor();

        int exit = process.exitValue();

        if(exit != 0){
            throw new RuntimeException("执行失败退出");
        }

    }





}
