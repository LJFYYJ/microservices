# **京工书院在线教育项目**

本项目是一个 B2C 模式的职业技能在线教育系统，分为前台用户系统和后台运营平台。

本项目能够为会员提供课程购买和在线学习的服务；为管理人员提供讲师管理、课程管理的服务。

## 技术架构

项目前端：Vue+ElementUI+Echarts

项目后端：Spring Boot+Spring Cloud + MyBatis-Plus + MySQL +Docker

![](img/前端.png)

![](img/后端.png)

## 系统架构

![](img/系统架构.png)

![](img/微服务.png)

## 系统服务

### Nacos

Alibaba针对Spring Cloud体系的注册中心

Nacos = Spring Cloud Eureka + Spring Cloud Config + Spring Cloud Bus

![](img/nacos.png)

![](img/nacos2.png)

![](img/nacos3.png)

### OpenFeign

Spring Cloud提供的一个声明式的伪Http客户端

便于调用远程服务

比如service-edu使用OpenFeign调用service-oss：

![](img/openfeign调用.png)

### Sentinel

是阿里开源的一套用于服务容错的综合性解决方案

有流量控制、熔断降级、系统负载保护功能

![](img/Sentinel1.png)

![](img/Sentinel2.png)

![](img/Sentinel3.png)

### Gateway

Spring Cloud Gateway为微服务架构提供简单、有效和统一的API路由管理方式

service-edu路由配置示例：

```
routes:

    - id: service-edu

     uri: lb://service-edu

     predicates:

     	- Path=/user/**, /*/edu/**
```

## 系统前端

### 前台界面

![](img/前台1.png)

![前台2](img/前台2.png)

![前台3](img/前台3.png)

![前台4](img/前台4.png)

![前台5](img/前台5.png)

![前台6](img/前台6.png)

### 后台界面

![](img/后台1.png)

![后台2](img/后台2.png)

![后台3](img/后台3.png)

![后台4](img/后台4.png)

![后台5](img/后台5.png)

## 系统实现细节

### Mybatis-Plus生成代码

- 使用代码生成器根据数据表自动生成：
  - entity 实体类
  - mapper 持久层
    - xml 持久层具体实现
  - service 服务层
    - impl 服务层具体实现
  - controller 控制层

![](img/Mybatis-Plus生成代码.png)

### Swagger测试

![](img/Swagger测试.png)

### 阿里云OSS文件上传服务

文件少不计费

![](img/阿里云OSS文件上传服务.png)

### 阿里云VOD视频点播服务

计费

![](img/阿里云VOD服务.png)



## 系统部署

本地虚拟机：将微服务打包成docker镜像

![](img/部署1.png)

阿里云仓库存储上传的镜像

![](img/部署2.png)

微服务在3台服务器上运行

![](img/运行1.png)

![运行2](img/运行2.png)

![运行3](img/运行3.png)

# 部署环境配置安装

## 1.MySQL

docker拉取MySQL镜像并运行容器

```
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 --name mysqlCollege mysql:5.7
```

MySQL配置

```
docker exec -it mysqlCollege /bin/bash
mysql -uroot -p123456
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
alter user 'root'@'localhost' identified with mysql_native_password by '123456';
flush privileges;
exit
exit
docker restart mysqlCollege
```

建立数据库

```
CREATE DATABASE jinggong_edu DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE jinggong_cms DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE jinggong_statistics DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE jinggong_trade DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE jinggong_ucenter DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE nacos_config DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```

使用Navicat分别运行sql文件将数据导入数据库

## 2.Nacos

```
docker run --env MODE=standalone --name nacos -d -p 8848:8848 nacos/nacos-server:1.1.4
docker exec -it <容器ID> /bin/bash
cd conf
vi application.properties
```

然后修改以下内容：

```
spring.datasource.platform=${SPRING_DATASOURCE_PLATFORM:mysql}
db.num=${MYSQL_DATABASE_NUM:1}
db.url.0=jdbc:mysql://${MYSQL_MASTER_SERVICE_HOST:39.102.36.248}:${MYSQL_MASTER_SERVICE_PORT:3306}/${MYSQL_MASTER_SERVICE_DB_NAME:nacos_config}?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
//同时把db.url.1的一行删掉
db.user=${MYSQL_MASTER_SERVICE_USER:root}
db.password=${MYSQL_MASTER_SERVICE_PASSWORD:123456}
```

保存修改，`exit`退出容器，然后`docker restart <容器ID>`重启容器

## 3.Sentinel

```
docker run --name sentinel -d  -p 8858:8858 -m 256m  bladex/sentinel-dashboard
```

## 4.Redis

```
docker run -p 6379:6379 --name redisCollege -d redis --requirepass "123456" --appendonly yes 
```

## 5.项目版本配置

```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.2.RELEASE</version>
        <relativePath/>
</parent>
```

```
<dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
</dependency>
```

```
<properties>
    <java.version>1.8</java.version>
    <mybatis-plus.version>3.3.1</mybatis-plus.version>
    <velocity.version>2.0</velocity.version>
    <swagger.version>2.7.0</swagger.version>
    <aliyun.oss.version>3.1.0</aliyun.oss.version>
    <jodatime.version>2.10.1</jodatime.version>
    <commons-fileupload.version>1.3.1</commons-fileupload.version>
    <commons-io.version>2.6</commons-io.version>
    <commons-lang.version>3.9</commons-lang.version>
    <httpclient.version>4.5.1</httpclient.version>
    <jwt.version>0.7.0</jwt.version>
    <aliyun-java-sdk-core.version>4.3.3</aliyun-java-sdk-core.version>
    <aliyun-java-sdk-vod.version>2.15.2</aliyun-java-sdk-vod.version>
    <aliyun-sdk-vod-upload.version>1.4.11</aliyun-sdk-vod-upload.version>
    <fastjson.version>1.2.28</fastjson.version>
    <gson.version>2.8.2</gson.version>
    <json.version>20170516</json.version>
    <commons-dbutils.version>1.7</commons-dbutils.version>
    <canal.client.version>1.1.0</canal.client.version>
    <docker.image.prefix>zx</docker.image.prefix>
    <alibaba.easyexcel.version>2.1.1</alibaba.easyexcel.version>
    <apache.xmlbeans.version>3.1.0</apache.xmlbeans.version>
</properties>
```

## 6.微服务连接配置

bootstrap.yml以service-edu为例

```
spring:
  application:
    name: service-edu
  profiles:
    active: dev # 环境标识，test、prod等
  cloud:
    nacos:
      config:
        server-addr: 39.102.46.244:8848 #nacos中心地址
        file-extension: yaml # 配置文件格式，如果是properties文件则不用配置此项
```

# 开发环境配置安装

1. vmware软件  

2. ubuntu18.04虚拟机 64位   

3. 搜狗输入法安装

   安装教程：https://www.cnblogs.com/lfri/p/10769144.html

4. java1.8.0_212安装  

   安装教程：https://www.cnblogs.com/zzy1024/p/11406269.html    

   下载链接：https://github.com/frekele/oracle-java/releases  

5. idea安装

   下载链接：https://www.jetbrains.com/idea/download/#section=linux

   ​					Ultimate版本

   激活码下载链接：http://idea.medeming.com/jetbrains/

   ​					可能过一段时间后激活码失效，到时候再想别的办法

6. maven安装  

   下载链接：https://maven.apache.org/download.cgi    

   ​					apache-maven-3.6.3-bin.tar.gz  

   安装教程：      

   ```
   # 修改环境变量
   sudo gedit ~/.bashrc
   # 在文件末尾追加，根据自己的实际情况修改MAVEN_HOME的值
   export MAVEN_HOME=/usr/local/apache-maven-3.3.9
   export PATH=${PATH}:${MAVEN_HOME}/bin
   # 使环境变量马上生效
   source ~/.bashrc
   ```

7. git安装

   `sudo apt-get install get`

8. git连接github  

   https://blog.csdn.net/renhaofan/article/details/81478130

9. typora安装 

   typora用于编辑md文件，不是必须的软件  

   https://typora.io/#linux

10. vue安装

    只跟着下面的教程完成**npm**的安装：

    npm安装教程：https://blog.csdn.net/Douz_lungfish/article/details/82991738

    接着安装**@vue/cli**:

    `npm install -g @vue/cli`

    命令行输入`vue ui`，如果跳出Vue项目管理器的页面说明安装成功

    如果提示node.js版本过低，参考教程升级node.js：https://www.cnblogs.com/imageSet/p/11802154.html

11. Vue和Spring Boot速成（4小时）：

    学习视频：https://www.bilibili.com/video/BV137411B7vB

    