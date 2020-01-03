package top.oldwei.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author:weizd
 * @Date:19-12-10
 */
@Configuration
@ConditionalOnBean(ThreadPoolParam.class)
@Slf4j
public class ThreadPoolConfig {


    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(@Autowired ThreadPoolParam threadPoolParam){

        log.info("init threadPoolTaskExecutor begin");

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(threadPoolParam.getCorePoolSize());

        threadPoolTaskExecutor.setMaxPoolSize(threadPoolParam.getMaxPoolSize());

        threadPoolTaskExecutor.setThreadNamePrefix(threadPoolParam.getThreadNamePrefix());

        threadPoolTaskExecutor.setQueueCapacity(threadPoolParam.getQueueCapacity());

        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolTaskExecutor.initialize();


        log.info("init threadPoolTaskExecutor end");


        return threadPoolTaskExecutor;

    }


}
