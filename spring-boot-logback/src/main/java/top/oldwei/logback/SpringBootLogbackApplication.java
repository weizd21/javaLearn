package top.oldwei.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author:weizd
 * @Date:19-8-18
 */
@SpringBootApplication
@Slf4j
public class SpringBootLogbackApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootLogbackApplication.class,args);
        log.warn("启动开始。。。。。。。。。");
        log.info(configurableApplicationContext.getClass().getName());
        log.error("启动结束。。。。。。。。");
    }



}
