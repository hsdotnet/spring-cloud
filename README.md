# QuickStart
基于SpringCloud Finchley.RELEASE 

组件：
1. 服务注册、发现: eureka  后期提供consul
2. 配置管理:spring config 
3. 集群容错: hystrix
4. API网关: zuul
5. 服务负载:feign+ribbon
6. api文档输出:swagger2
7. 链路跟踪:spring cloud sletuh ->zipkin
8. 安全认证:jwt
9. 服务监控:spring-boot-admin

# 各模块介绍

| 模块名称        | 端口   |  简介  |
| --------   | -----:  | :----:  |
| admin-server      | 1000   |   服务监控中心，监控所有服务模块    |
| config-server        |   1001   |   分布式配置中心   |
| eureka-server        |    1002   |  服务注册中心，提供服务注册、发现功能  | (1006 备份服务注册中心)
| zipkin-server        |    1004   |  分布式链路追踪  |
| zuul-server        |    1003    |  API网关模块  |
| product-service       |    1010    |  商品服务  |
| mall        |    1020    |  前端  |


# 快速上手
- 1、先启动admin-server,eureka-server,config-server,zuul-server,zipkin-server
- 2、再依次启动product基础业务服务
- 3、最后启动mall服务，
- 4、后续再供页面，基于vue+iview
