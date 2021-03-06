
<span style="color:red;font:bold 50">jwolf-micro v1.0.0</span>

# 一、项目简介
- jwolf-micro是基于最新主流技术栈实现的一套全栈微服务开源学习型项目,Java部分还会拓深,前端,AI,大数据只会基于后期jwolf-micro必须业务适当拓展。
- 目前项目已集成Java界绝大多少中间件,[编写了一键部署的docker-compose文件,（部分k8s部署）](./script),各技术栈已作测试。
- 后期计划做一些核心业务,并深入一些核心技术栈源码实现。
- 部分文档可能不够详细,敬请原谅,后期有时间再补充,建议细读代码中的注释
- 源码地址
[Github](https://github.com/jwolf123456/jwolf-micro)
[Gitee](https://gitee.com/jwolf-space/jwolf-micro)
欢迎提issue,PR及技术讨论
# 二、系统架构
![系统架构图](./doc/doc-resource/系统架构图.png)
## 1.后端技术架构
```
1.后端核心springcloud alibaba2021,springcloud2020,springboot2.5.4
2.注册中心,配置中心nacos2.0.3
3.数据库mysql8,mybatis-plus
4.缓存redis
5.搜索引擎Elasticsearch7.10.x
6.消息队列rocketMq/kafka
7.网关nginx,springcloud-gateway
8.微服务调用openfegin与熔断限流sentinel1.8
9.分布式事务seata1.4.x
10.监控报警Prometheus/grafana
11.其它mongodb/minio/oauth2/spring-security等
```

## 2.大前端
```
1.后台管理Vue-element-admin
2.H5/移动端/小程序uni-app（规划）
```
## 3.AI
```
1.推荐算法（规划）
2.人脸识别（规划）
```

# 三、部署架构
```
1.fat-jar+shell 
2.docker+jenkins
3.k8s
```
![部署架构图](./doc/doc-resource/jenkis-docker-cicd.png)

# 四、项目目录说明
```
├── doc                                      文档
├── pom.xml
├── jwolf-common
    ├── src
    │   └── main
    │       ├── java
    │       │   └── com
    │       │       └── jwolf
    │       │           └── common            
    │       │               ├── config        配置
    │       │               ├── bean          bean
    │       │               ├── constant      常量枚举
    │       │               ├── aop           aop
    │       │               ├── exception     异常
    │       │               └── other         其它
    │       │               └── util          工具类
    │       └── resources 
├── jwolf-auth                                认证授权
├── jwolf-gateway                             网关
├── jwolf-manage                              管理平台后端
├── jwolf-manage-ui                           管理平台前端
├── jwolf-service                             微服务二级父工程
    ├── jwolf-service-xx1
    ├── jwolf-service-xx2
├── jwolf-service-api                         微服务API二级父工程
    ├── jwolf-service-xx1-api
    ├── jwolf-service-xx2-api
└── script                                    安装,启动,配置,db等脚本
└── tool                                      工具箱

```


# 五、更新日志
- 2021/11/27 README.md初始化
- 2021/12/02 V1分支【V1 架构，中间件，技术栈测试】
- 2021/12/12 V2分支【V2.1
  基于oauth2设计的登录系统,支持多用户体系登录,SSO,手机验证码,社交登录, 权限验证等】
- 2022/01/16 V2分支【V2.2 k8s部署架构升级;AI-tensorflow2,大数据-spark demo程序案例与常见架构，套路】
- 2022/xx/xx V3分支【V3 一个有灵魂的jwolf——加入核心业务】 TODO
- 2022/xx/xx V4分支【V4 AI智能化,核心组件源码分析】 TODO
# 六、quickstart
- [1.开发环境](doc/运行环境.md)

# 七、其它说明
- master为最新分支,重要节点会拉取一个新分支作为备份



