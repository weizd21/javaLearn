import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author:weizd
 * @Date:19-11-27
 */
public class MySparkLauncher {

    private static final int CORE_P00L_SIZE = 5;

    private static final int MAX_POOL_SIZE = 10;

    private static final int QUEUE_CAPACITY = 100;

    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws Exception{


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_P00L_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());






        Map<String, String> envParams = Maps.newConcurrentMap();

        envParams.put("HADOOP_HOME", "/home/insight/spark/hadoop-2.9.0/hadoop-2.9.0");
        envParams.put("SPARK_HOME", "/home/insight/spark/spark-2.4.0-bin-hadoop2.7/spark-2.2.1");
        envParams.put("HADOOP_CONF_DIR", "/home/insight/spark/hadoop-2.9.0/hadoop-2.9.0");
        envParams.put("YARN_CONF_DIR","/home/insight/yarn-conf");



        // 待提交给spark集群处理的spark application jar（即appJar）所在路径
        String appJarName = "/home/github/javaLearn/spark-demo01/src/main/java/Hello.jar";
        SparkLauncher launcher = new SparkLauncher(envParams);
        launcher.setAppResource(appJarName);
        // 设置spark driver主类，即appJar的主类
        launcher.setMainClass("Hello");
        // 添加传递给spark driver mian方法的参数
//        launcher.addAppArgs(arg1, arg2, arg3 );
        // 设置该spark application的master
        launcher.setMaster("local[*]"); // 在yarn-cluster上启动，也可以再local[*]上
//        launcher.setMaster("yarn"); // 在yarn-cluster上启动，也可以再local[*]上
        // 关闭sparksubmit的详细报告
        launcher.setVerbose(false);
//        launcher.setVerbose(true);

//        launcher.setDeployMode("cluster");

        // 设置用于执行appJar的spark集群分配的driver、executor内存等参数
//        launcher.setConf(SparkLauncher.DRIVER_MEMORY, "2g");
//        launcher.setConf(SparkLauncher.EXECUTOR_MEMORY, "1g");
//        launcher.setConf(SparkLauncher.EXECUTOR_CORES, String.valueOf(16));
//        launcher.setConf("spark.default.parallelism", String.valueOf(128));
//        launcher.setConf("spark.executor.instances", String.valueOf(16));


        new Thread(()->{

            Process process = null;
            try {
                process = launcher.launch();

//                StringBuffer sb = new StringBuffer();
//                // 创建县城安全的list容器
//                List<String> resultList = Collections.synchronizedList(new ArrayList<>());
//                ProcessUtil.getExecResult(process,sb);
//                System.out.println(sb.toString());







//                InputStream inputStream = process.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//                String lineStr = "";
//                while ((lineStr = bufferedReader.readLine()) != null){
//                    System.out.println(lineStr);
//                }
//
//                InputStream errorStream = process.getErrorStream();

            } catch (Exception e) {
                e.printStackTrace();
            }

//            try{
//                final int result = process.waitFor();
//                System.out.println("result:"+result);
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                System.out.println("执行结束");
//            }



        }).start();

        System.out.println("----->"+Thread.currentThread().getName());

//        // 启动执行该application
//        SparkAppHandle handle = launcher.startApplication();
//
//        // application执行失败重试机制
//        // 最大重试次数
//        boolean  failedflag = false;
//        int maxRetrytimes = 3;
//        int currentRetrytimes = 0;
//        while (handle.getState() != SparkAppHandle.State.FINISHED) {
//            currentRetrytimes ++;
//            // 每6s查看application的状态（UNKNOWN、SUBMITTED、RUNNING、FINISHED、FAILED、KILLED、 LOST）
//            Thread.sleep(6000L);
//            System.out.println("applicationId is: " + handle.getAppId());
//            System.out.println("current state: " + handle.getState());
//            if ((handle.getAppId() == null && handle.getState() == SparkAppHandle.State.FAILED ) && currentRetrytimes > maxRetrytimes){
//                System.out.println(String.format("tried launching application for %s times but failed, exit.", maxRetrytimes));
//                failedflag = true;
//                break;
//            }
//        }



    }



}
