package top.oldwei.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:weizd
 * @Date:19-12-10
 */
@Data
@Configuration
@EnableConfigurationProperties(ThreadPoolParam.class)
@ConfigurationProperties(prefix = "master.executor")
public class ThreadPoolParam {

    private String name;

    private Integer corePoolSize;

    private Integer maxPoolSize;

    private Integer queueCapacity;

    private String threadNamePrefix;


}
