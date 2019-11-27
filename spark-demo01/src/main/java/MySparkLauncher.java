import com.google.common.collect.Maps;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:weizd
 * @Date:19-11-27
 */
public class MySparkLauncher {


    public static void main(String[] args) throws Exception{

        Map<String, String> envParams = Maps.newConcurrentMap();
        envParams.put("YARN_CONF_DIR", "/home/insight/spark/hadoop-2.9.0/hadoop-2.9.0");
        envParams.put("HADOOP_CONF_DIR", "/home/insight/spark/hadoop-2.9.0/hadoop-2.9.0");
        envParams.put("SPARK_HOME", "/home/insight/spark/spark-2.4.0-bin-hadoop2.7/spark-2.2.1");
        envParams.put("SPARK_PRINT_LAUNCH_COMMAND", "1");


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
        // 关闭sparksubmit的详细报告
        launcher.setVerbose(false);
        // 设置用于执行appJar的spark集群分配的driver、executor内存等参数
//        launcher.setConf(SparkLauncher.DRIVER_MEMORY, "2g");
//        launcher.setConf(SparkLauncher.EXECUTOR_MEMORY, "1g");
//        launcher.setConf(SparkLauncher.EXECUTOR_CORES, String.valueOf(16));
//        launcher.setConf("spark.default.parallelism", String.valueOf(128));
//        launcher.setConf("spark.executor.instances", String.valueOf(16));

        // 启动执行该application
        SparkAppHandle handle = launcher.startApplication();

        // application执行失败重试机制
        // 最大重试次数
        boolean  failedflag = false;
        int maxRetrytimes = 3;
        int currentRetrytimes = 0;
        while (handle.getState() != SparkAppHandle.State.FINISHED) {
            currentRetrytimes ++;
            // 每6s查看application的状态（UNKNOWN、SUBMITTED、RUNNING、FINISHED、FAILED、KILLED、 LOST）
            Thread.sleep(6000L);
            System.out.println("applicationId is: " + handle.getAppId());
            System.out.println("current state: " + handle.getState());
            if ((handle.getAppId() == null && handle.getState() == SparkAppHandle.State.FAILED ) && currentRetrytimes > maxRetrytimes){
                System.out.println(String.format("tried launching application for %s times but failed, exit.", maxRetrytimes));
                failedflag = true;
                break;
            }
        }



    }



}
