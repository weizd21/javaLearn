
### Spring Boot 项目引入 actuator
1. pom引入
    ```
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
          
    ```
2. yml配置
    ```
        # Use "*" to expose all endpoints, or a comma-separated list to expose selected ones
        management:
          endpoint:
            health:
              show-details: always
          endpoints:
            web:
              exposure:
                include: "*" #向外曝所有的指标接口数据      
        
    ```
 
### 引入Micrometer向外曝露prometheus能够识别的接口
1. pom引入
    ```
        <!-- Micrometer Prometheus registry  -->
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
        </dependency>
   
    ```   


### docker启动prometheus
1. 下载 prometheus 镜像
    ```
        docker pull prom/prometheus
    ```
2. 准备prometheus配置文件
    ```
        # my global config
        global:
          scrape_interval:     15s # Set the scrape interval to every 15 seconds. Default is every 1 minute.
          evaluation_interval: 15s # Evaluate rules every 15 seconds. The default is every 1 minute.
          # scrape_timeout is set to the global default (10s).
        # Load rules once and periodically evaluate them according to the global 'evaluation_interval'.
        rule_files:
        # - "first_rules.yml"
        # - "second_rules.yml"
        # A scrape configuration containing exactly one endpoint to scrape:
        # Here it's Prometheus itself.
        scrape_configs:
          # The job name is added as a label `job=<job_name>` to any timeseries scraped from this config.
          - job_name: 'prometheus'
            # metrics_path defaults to '/metrics'
            # scheme defaults to 'http'.
            static_configs:
              - targets: ['192.168.2.143:9090']
          - job_name: 'spring-actuator'
            metrics_path: '/actuator/prometheus'
            scrape_interval: 5s
            static_configs:
              - targets: ['192.168.2.143:8080']
        
        # /home/weizd/ideaProject/ccb-back/insight-label/src/main/resources/prometheus.yml

    ```
3. 启动prometheus
    ```
        docker run -d --name=prometheus -p 9090:9090 -v /home/weizd/ideaProject/ccb-back/insight-label/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
        
    ```

4. 登录页面localhost:9090 进入prometheus控制台页面


