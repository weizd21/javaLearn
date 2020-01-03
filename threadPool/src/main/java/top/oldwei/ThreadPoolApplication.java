package top.oldwei;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.ApplicationPid;

/**
 * @Author:weizd
 * @Date:19-12-10
 */
@EnableConfigurationProperties
@SpringBootApplication

public class ThreadPoolApplication {


    public static void main(String[] args) {

        System.out.println("pid；"+(new ApplicationPid()).toString());


        System.out.println(Runtime.getRuntime().availableProcessors());




        //SpringApplication.run(ThreadPoolApplication.class,args);





    }
}
