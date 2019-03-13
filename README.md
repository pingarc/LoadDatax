#基于该框架开发了调用Data3.0的调用接口，接口可以传入参数，job为作业名字（必须的参数，不需要带后缀），另一个参数为作业中的动态变量，可以传入多个变量，变量名要跟作业中的一样，如下
 
 
 http://ip:8080/datax/xxx?job=teradatatomysql&stable=test，作业中需要${参数名}
 
                    ``` "connection": [
                             {
                                 "jdbcUrl": "jdbc:mysql://XXXXXX:XX/${sdbname}?characterEncoding=utf-8",
                                 "table": ["${stable}"]
                             }
                         ],```

 
 #作业调用方法分三种：
 
  - 1 本地调用接口，该方法要求datax与该接口部署在同一台服务器上，然后通过接口调用job作业
 
       http://ip:8080/LoadDatax/datax/exeJob?job=teradatatomysql&statis_mon=201811
        
  - 2 远程接口调用，该方法通过远程ssh到服务器，该接口需要datax所在服务器的ip，用户名，密码，以及开放22端口，在application.property中配置，部署该程序的服务器可以与datax服务器通信，两者可以不在一台机器上然后调用接口
         http://ip:8080/LoadDatax/datax/rpcJob?job=teradatatomysql&statis_mon=201812
         
   - 3 通过spring定时任务执行job，该方法需要通过编码实现，在com.df.datax.task.JobTask 自定义自己的实现代码即可      

# REST风格框架：
LoadDatax项目是一个基于Spring的符合REST风格的项目，具有MVC分层结构并实现前后端分离。该项目体现了一个具有REST风格项目的基本特征：

 - 具有统一响应结构；
 
 - 前后台数据流转机制(HTTP消息与Java对象的互相转化机制)；
 
 - 统一的异常处理机制；
 
 - 参数验证机制；
 
 - Cors跨域请求机制;
 
 - 安全(鉴权)机制。
 

 