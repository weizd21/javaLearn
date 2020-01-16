
### ELK日志处理
    1. filebeats 数据采集客户端
        * beats 系列产品 轻量化采集工具
            
    2. logstash 
        * 获取数据
        * 处理数据
        * 输出数据
        * 参考文档
            https://www.cnblogs.com/dyh004/p/9638675.html
    3. elasticsearch
        接收数据

    4. kabana 可视化工具
    
    5. ELK参考网址
        高可用方案 https://www.cnblogs.com/cheyunhua/p/11119252.html
        搭建集群方案 https://blog.csdn.net/wayds/article/details/82981828
        Logstash 使用文档 https://elkguide.elasticsearch.cn/logstash/plugins/output/hdfs.html

        日志收集方案 百万级别文件 日志收集分析 https://elasticsearch.cn/question/5582


### Spring Boot's Actuator 引出
    1. Actuator 为spring boot提供的对应用健康状态、CPU、网络、IO 等指标的输出操作
        * 通过http接口向外曝露数据
    2. Prometheus(普罗米修斯),能与Actuator集成,构建可视化监控报警系统
        * 通过pull模式,拉去数据
        * 自带 时序数据库 
        * 提供 计数器(累计数据)、仪表盘(瞬时数据)、直方图(历史数据)等 数据方式
        * 同类型优秀产品 Zabbix和Open-Falcon
        * google github 提供多种 数据explorer,功能类似 Actuator
        * 参考文档: 
            Prometheus架构与实践分享 http://www.sohu.com/a/342733264_198222
            从零搭建Prometheus监控报警系统 https://www.cnblogs.com/chenqionghe/p/10494868.html
            Spring Boot Metrics监控之Prometheus&Grafana https://www.jianshu.com/p/afc3759e75b9   
        * 存储数据的原理详解
            https://yq.aliyun.com/articles/690674
    3. 应用实战参考文档
        https://bigjar.github.io/2018/08/19/Spring-Boot-Metrics%E7%9B%91%E6%8E%A7%E4%B9%8BPrometheus-Grafana/
        
    4. 参考案例/图片设计
        https://help.aliyun.com/document_detail/124815.html
     
    5. 相关产品
        micrometer http://throwable.coding.me/2018/11/17/jvm-micrometer-prometheus/       
        
        
        
        
        
 ### Fork/Join 并发操作
    1.     





### 用 docsify 生成文档部署在github
    https://docsify.js.org/#/?id=docsify





###ThingsBoard 物联网平台设备监控
    https://thingsboard.io/docs/api/
    
    
    
### Flyway 助力数据库脚本自动化
    https://flywaydb.org/
    
    




