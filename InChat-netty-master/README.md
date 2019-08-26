
<div align=center>

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/inchat/logo.png)

[![QQ群](https://img.shields.io/badge/QQ%E7%BE%A4-628793702-yellow.svg)](https://jq.qq.com/?_wv=1027&k=57X4L74)
[![作者](https://img.shields.io/badge/%E4%BD%9C%E8%80%85-MySelf-blue.svg)](https://github.com/UncleCatMySelf)
[![Netty入门](https://img.shields.io/badge/%E5%AD%A6%E4%B9%A0-Netty%E5%85%A5%E9%97%A8-ff69b4.svg)](doc/study/mulu.md)
[![Maven](https://img.shields.io/badge/Maven-1.1.4-orange)](https://mvnrepository.com/artifact/com.github.UncleCatMySelf/InChat)


</div>

## 申明

本项目入驻[**AwakenCN**](https://github.com/AwakenCN)开源组织，后续将继续更新调整，部分API后续会更改，感谢每一位朋友的支持与关注。

## 简介

***(InChat)Iot Netty Chat***


一个轻量级、高效、分布式的异步通信框架, 支持聊天和物联网, 您可以使用它来快速构建具有后台的聊天服务器, 并快速自定义自己的通信 api, 包括具有不同的通讯可以支持的协议。

**欢迎参与QQ群交流与提供建议、业务场景、需求功能等**

**[代码贡献指南](http://www.imooc.com/article/272573)**

> 目前项目更新内容：补充文案、设计稿说明、使用说明等

## Maven版本

功能列表：

> * 用户token登录校验
> * 自我聊天
> * 点对点聊天
> * 群聊
> * 获取在线用户数与用户标签列表
> * 发送系统通知
> * 1.1.3版本新增SSL加密，分布式测试点对点、群聊功能（分布式为试用版，暂不支持SSL加密）
> * 1.1.4版本修改数据存储问题，并提供SpringBoot-Demo

* [基于InChat的SpringBoot版本通讯聊天数据存储Demo，附带详细流程说明（InChat1.1.4）](https://unclecatmyself.github.io/2019/08/23/inchatby4/)

```
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>InChat</artifactId>
    <version>1.1.4</version>
</dependency>
```

## InChat项目里程碑

> 项目研发的开放目标，以Maven包为基本的发布（兼对应版本的文档输出）设定为每个里程碑的产出。

### 项目于2018年8月14号开始成立，前一个月以Demo为发展路线，后期转为框架研发。

### V1.0.0版本 【2018-12-14】

> 版本昵称：赤猫

版本目标：完成基本的消息通讯（仅支持文本消息），离线消息存储，历史消息查询，一对一聊天、自我聊天、群聊等

* [V1.0.0版本使用说明](doc/version/v1.0.0.md)
* [V1.0.0版本使用说明视频教程](https://v.qq.com/x/page/i0813oy0lov.html)

> 目前项目代码已经推进入了下一版本，如果你想下载这个版本的源码，可以到这里下载[V1.0.0-alpha](https://github.com/UncleCatMySelf/InChat/releases/tag/V1.0.0-alpha)

```
<!-- https://mvnrepository.com/artifact/com.github.UncleCatMySelf/InChat -->
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>InChat</artifactId>
    <version>1.0-alpha</version>
</dependency>
```

### V1.1.0-alpha版本 【2018-12-21】

> 版本昵称：赤猫-1

版本目标：移除对SpringBoot的环境依赖，InChat独立生存与使用，结合上一版的功能，并添加服务器发送消息接口

* [V1.1.0-alpha版本使用说明](https://unclecatmyself.github.io/2018/12/21/InChatV1.1.0%E7%89%88%E6%9C%AC%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E/)
* [V1.1.0-alpha版本视频教学](https://v.qq.com/x/page/i08165ym286.html)

```
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>InChat</artifactId>
    <version>1.1.0-alpha</version>
</dependency>
```

### V1.1.2版本 【2019-01-04】

> 版本昵称：赤猫-2

版本更新：添加HTTP接口调用，捕获已知异常

* [V1.1.2版本使用说明](https://unclecatmyself.github.io/2019/01/03/inchatby112/)
* [V1.1.2版本视频教学](https://v.qq.com/x/page/y08228i7znk.html)

```
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>InChat</artifactId>
    <version>1.1.2</version>
</dependency>
```


### V1.1.3版本 【2019-01-15】

> 版本昵称：橙猫

版本目标：InChat集群与wss,SSL加密与分布式测试点对点与群聊

* [InChatV1.1.3版本使用说明](https://unclecatmyself.github.io/2019/01/15/inchatby113/)

```
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>InChat</artifactId>
    <version>1.1.3</version>
</dependency>
```

### V1.1.4版本 【2019-08-23】

版本目标：实现数据存储，单机、单机加密、分布式等默认功能

* [基于InChat的SpringBoot版本通讯聊天数据存储Demo，附带详细流程说明](https://unclecatmyself.github.io/2019/08/23/inchatby4/)

```
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>InChat</artifactId>
    <version>1.1.3</version>
</dependency>
```

### 项目日志

* [项目研发日志更新](doc/Project-Log-cn.md)

### 教程

*  [Netty入门与源码讲解](doc/study/mulu.md)
*  [官方案例](https://github.com/AwakenCN/InChat/tree/official-demo) 


### 项目相关

> * [项目设计思路](doc/design_cn.md)
> * [登录模块详细设计](doc/detail/Login-cn.md)
> * [登录模块整改版V0.1](doc/detail/login_rect.md)

### 相关资料（欢迎贡献）

* [QQ群建议贡献](doc/advice/advice.md)

## 效果展示

![加密](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/inchatGIF/%E5%8A%A0%E5%AF%86.gif)
![分布式](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/inchatGIF/%E5%88%86%E5%B8%83%E5%BC%8F.gif)
![demo](https://github.com/UncleCatMySelf/img-myself/blob/master/img/inchatGIF/inchat_demo.gif)
![log](https://github.com/UncleCatMySelf/img-myself/blob/master/img/inchatGIF/inchat_log.gif)
![postman](https://github.com/UncleCatMySelf/img-myself/blob/master/img/inchatGIF/inchat_postman.gif)
![send](https://github.com/UncleCatMySelf/img-myself/blob/master/img/inchatGIF/inchat_send.gif)

## 下载地址

下载地址：https://github.com/UncleCatMySelf/SBToNettyChat/releases

## 下载 & 问题

https://github.com/UncleCatMySelf/SBToNettyChat/issues

## 关于贡献

[!Noseparte说: 开源项目InChat贡献记](https://www.imooc.com/article/272573)

## 公众号：Java猫说

**学习交流群：728698035**

> 现架构设计（码农）兼创业技术顾问，不羁平庸，热爱开源，杂谈程序人生与不定期干货。

![Image Text](https://user-gold-cdn.xitu.io/2018/12/28/167f41f1a5729856?w=344&h=344&f=jpeg&s=8231)

