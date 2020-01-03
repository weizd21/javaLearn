### elasticsearch 与 jdk 版本匹配
```
    5.x -----> java8
       
   
    https://www.elastic.co/cn/support/matrix#matrix_jvm
   
    版本不一致,会在启动的时候提示报错信息
```



### elasticsearch 配置文件解释
```
    
################################### 集群相关配置 ################################### 
# cluster.name可以确定你的集群名称,当你的elasticsearch集群在同一个网段中elasticsearch会自动的找到具有相同cluster.name的elasticsearch服务. 
# 所以当同一个网段具有多个elasticsearch集群时cluster.name就成为同一个集群的标识.，可以手动指定也可以自动生成
# cluster.name: elasticsearch 
 
#################################### 节点相关配置 ##################################### 
# 节点名称同理,可自动生成也可手动配置. 
# node.name: node-1
 
# 允许一个节点是否可以成为一个master节点,es是默认集群中的第一台机器为master,如果这台机器停止就会重新选举master. 
# node.master: true 
 
# 允许该节点存储数据(默认开启) 
# node.data: true 
 
# 默认情况下，多个节点可以在同一个安装路径启动，如果你想让你的es只启动一个节点，可以进行如下设置
# node.max_local_storage_nodes: 1 
 
#################################### 索引相关配置 #################################### 
# 设置索引的分片数,默认为5 
#index.number_of_shards: 5 
 
# 设置索引的副本数,默认为1: 
#index.number_of_replicas: 1 
 
# 配置文件中提到的最佳实践是,如果服务器够多,可以将分片提高,尽量将数据平均分布到大集群中去
# 同时,如果增加副本数量可以有效的提高搜索性能 
# 需要注意的是,"number_of_shards" 是索引创建后一次生成的,后续不可更改设置 
# "number_of_replicas" 是可以通过API去实时修改设置的 
 
#################################### 路径相关配置 #################################### 
# 配置文件存储位置 
# path.conf: /path/to/config 
 
# 数据存储位置(单个目录设置) 
# path.data: /path/to/data 
# 多个数据存储位置,有利于性能提升 
# path.data: /path/to/data1,/path/to/data2 
 
# 临时文件的路径 
# path.work: /path/to/work 
 
# 日志文件的路径 
# path.logs: /path/to/logs 
 
# 插件安装路径 
# path.plugins: /path/to/plugins 
 
 
################################### 内存相关配置 #################################### 
# 当JVM开始写入交换空间时（swapping）ElasticSearch性能会低下,你应该保证它不会写入交换空间 
# 设置这个属性为true来锁定内存,同时也要允许elasticsearch的进程可以锁住内存,linux下可以通过 `ulimit -l unlimited` 命令 
# bootstrap.mlockall: true 
# 确保 ES_MIN_MEM 和 ES_MAX_MEM 环境变量设置为相同的值,以及机器有足够的内存分配给Elasticsearch 
# 注意:内存也不是越大越好,一般64位机器,最大分配内存别才超过32G 
 
############################## 网络相关配置 ############################### 
# 设置绑定的ip地址,可以是ipv4或ipv6的，默认绑定本机ip
# network.bind_host: 192.168.0.1  
 
# 设置其它节点和该节点交互的ip地址,如果不设置它会自动设置,值必须是个真实的ip地址 
# network.publish_host: 192.168.0.1 
 
# 同时设置bind_host和publish_host上面两个参数 
# network.host: 192.168.0.1    #绑定监听IP
 
# 设置节点间交互的tcp端口,默认是9300 
# transport.tcp.port: 9300 
 
# 设置是否压缩tcp传输时的数据，默认为false,不压缩
# transport.tcp.compress: true 
 
# 设置对外服务的http端口,默认为9200 
# http.port: 9200 
 
# 设置请求内容的最大容量,默认100mb 
# http.max_content_length: 100mb 
 
# 使用http协议对外提供服务,默认为true,开启 
# http.enabled: false


```


### elasticsearch 常用命令
```
    查询所有数据：curl http://localhost:9200/_search?pretty
    
    集群健康状态：curl -XGET http://localhost:9200/_cluster/health?pretty
    
    删除所有数据：curl -X DELETE 'http://localhost:9200/_all'
    
    删除指定索引：curl -X DELETE 'http://localhost:9200/索引名称'
```







### 报错处理
1. bound or publishing to a non-loopback address, enforcing bootstrap checks ERROR: 
    ```
       [2018-05-18T17:44:59,658][INFO ][o.e.b.BootstrapChecks    ] [gFOuNlS] 
       ERROR: [2] bootstrap checks failed
       [1]: max file descriptors [4096] for elasticsearch process is too low, increase to at least [65536]
       
       [2]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
       
       
       解决：
       [1]: max file descriptors [65535] for elasticsearch process is too low, increase to at least [65536]
       
       切换到root用户
       
       编辑 /etc/security/limits.conf，追加以下内容；
       * soft nofile 65536
       * hard nofile 65536
       此文件修改后需要重新登录用户，才会生效
       [2]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
       
       编辑 /etc/sysctl.conf，追加以下内容：
       vm.max_map_count=655360
       保存后，执行：
       sysctl -p

    ```





### elasticsearch 国内的的镜像源
```
    https://thans.cn/mirror/elasticsearch.html
    
    官网下载地址：https://www.elastic.co/cn/downloads/
    
```



### 参考文档
```
        
    https://mp.weixin.qq.com/s/tVBm8K5OytFQNB4laYlH8Q
```







