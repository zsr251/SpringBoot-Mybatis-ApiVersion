# SpringBoot-Mybatis-ApiVersion
spring boot实现接口多版本共存 灵活修改。 另：包含了spring boot常用插件的配置

## 主要解决问题
- 一般设计中无法针对**单个接口**进行灵活的版本管理
- 接口更新时需要兼容之前的接口，导致接口的**参数会越来越多**
- 接口更新后会有很多判断当前版本的 if else
- 接口多个版本不能并存

## 原理
基于spring mvc拦截器，自建方法和参数注解，利用反射和传入的版本参数调用该接口对应版本所需要的调用的方法

## 仍存在的问题
- 依赖与spring mvc
- 没有对返回值进行json处理
- 返回页面的请求无法使用（ps：虽然返回页面的也不建议使用版本控制）
- 没有复用spring获取参数的方法，目前是自己的简单实现
- 目前不支持从body中获取参数
- 目前只支持基础路径参数，不支持路径中添加正则方式获取参数

## 主要类
| 类名                 |类型     | 主要作用                                                       |
| -------------------- | ------- | ------------------------------------------------------------ |
| PathVariable         | 参数注解 |   spring自带注解，用于引用在URL中的参数 |
| ApiVersion           | 方法注解 |   注解在需要进行接口版本控制的Controller的对应方法上|
| ApiParam             | 参数注解  |  注解在真正处理方法的参数中，**非PathVariable参数必须含有该注解** |
| DefaultValueEnum     | 默认参数值 | 枚举|
| ApiVersionException  | 异常       | 工具解析中抛出的异常|
| ApiVersionInterceptor| 接口拦截器  | 核心类，进行所有处理操作|

## 了解测试路径
- 不传入接口版本号，默认为1
- 业务处理方法返回值必须为String：http://localhost:8080/api/test?av=1
- PathValue参数获取：http://localhost:8080/test/11111?av=2
- 无参数正常调用：http://localhost:8080/api/test?av=3
- 带参数调用：http://localhost:8080/api/test?av=4&a=param
- 允许非必须参数：http://localhost:8080/api/test?av=5&a=param
- 可指定默认值：http://localhost:8080/api/test?av=6&amount=100
- 获得request和response：http://localhost:8080/api/test?av=7
- 参数必须加注解：http://localhost:8080/api/test?av=8

## 其他
欢迎提出意见和完善:)
将近一年没有更新了～ 准备在2017-12-31优化维护一版:)

## 欢迎关注我的公众号和[JavaSoSo博客](http://www.javasoso.com)
![JavaSoSo公众号](https://i.loli.net/2017/11/24/5a177ebc75827.jpg) 
