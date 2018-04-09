
@Copyright by SONG

Spring Boot

-- 20180403 --------------------------
00.微服务.Maven.Spring Boot
01.安装配置 MySQL,建库,建表,初始化数据
   安装设置 IntelliJ IDEA

02.IDEA 中 Spring Initializr工具,快速的构建出一个基础的Spring Boot/Cloud工程

   从 start.spring.io 下载 Maven Project 模板
   MyEclipse 导入 Maven Project



Spring Boot的基础结构共三个文件:
src/main/java  程序开发以及主程序入口
src/main/resources 配置文件
src/test/java  测试程序

03.pom.xml 中添加支持web的模块(依赖)
  <!-- 添加支持web的模块-->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
04.controller
  YML文件格式是YAML (YAML Aint Markup Language)编写的文件格式，YAML是一种直观的能够被电脑识别的的数据数据序列化格式，并且容易被人类阅读，容易和脚本语言交互的，可以被支持YAML库的不同的编程语言程序导入，比如： C/C++, Ruby, Python, Java, Perl, C#, PHP等。

  采用yaml作为配置文件的格式。xml显得冗长，properties没有层级结构，yaml刚好弥补了这两者的缺点。
  这也是Spring Boot默认就支持yaml格式的原因

  application.yml 替换 application.properties
  # : 后必需有一个空格
  server:
    port: 8086

05.启动 Application
06.Chrome: http://127.0.0.1:8080/hello

07.设置 Tomcat 端口 (默认 8080)
08.www.getpostman.com 官网下载,安装 Postman - 测试
09.前后端分离开发,与前端联调

跨域是指 不同域名之间相互访问。跨域，指的是浏览器不能执行其他网站的脚本。它是由浏览器的同源策略造成的，是浏览器对JavaScript施加的安全限制

也就是如果在A网站中，我们希望使用Ajax来获得B网站中的特定内容
如果A网站与B网站不在同一个域中，那么就出现了跨域访问问题。

什么是同一个域？
同一协议，同一ip，同一端口，三同中有一不同就产生了跨域。


postman - controller - service
1.创建 Car 实体类
2.CarService.list() - 模拟数据
3.CarController.list()
4.postman



-- 20180404 ---------------------
thymeleaf 模板开发:
1.New Empty Project: thymeleaf
2.New Module – Spring Initializr – 勾选 Template Engines:Thymeleaf

  pom.xml 新增依赖: thymeleaf
  resources 下分别创建目录:
  static    - 静态资源 css js images
  templates - 页面模板 html
  i18n      - xxx_xx_XX.properties xxx_en_US.properties

3.修改 resources/application.yml
4.新建控制器 controller/ThymeleafController.java
5.新建模板 resources/templates/hello.html
6.修改 ThymeleafApplication.java
7.启动 ThymeleafApplication 浏览器查看效果



-- 20180408 ---------------------
i18n 国际化开发步骤:
1.resources/i18n 下新建 messages.properties
2.在 resources/application.yml 中设置 i18n
3.新建 config/WebConfig.java 设置 cookie 区域和拦截器
4.控制器
5.网页 carlist.html



项目前后端分离则控制器使用 @RestController - restful 风格,不需 thymeleaf 模板
项目前后端不分离(页面和业务逻辑都在后端服务器)则使用控制器使用 @Controller,跳转版,需要 thymeleaf 模板


下载安装前端服务器:
https://nodejs.org

打开 cmd 输入命令:
C:\Users\SONG>node -v
v9.11.1

C:\Users\SONG>npm -v
5.6.0

执行命令:
npm --registry=https://registry.npm.taobao.org i -g live-server



-- 20180409 ----------------
Spring Boot + Mybatis + Mysql CRUD 开发步骤:
1.New Project - New Modules - Spring Initializr - 勾选 Template Engines:Thymeleaf
2.修改 pom.xml 新增 mybatis-spring-boot-starter 和 mysql-connector-java
    <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>1.3.2</version>
    </dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>6.0.6</version>
		</dependency>

3.修改 application.yml 配置 mybatis 和 spring.datasource
  修改 Application.java 加入 @MapperScan("com.spingboot.mybatis.mapper")

mybatis.type-aliases-package=com.spingboot.mybatis.domain

spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/employee?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

4.domain: Emp
5.mapper: EmpMapper
6.JUnit : EmpMapperTest

7.service: EmpService
8.controller: EmpController
9.postman 测试所有的 api 接口

10.前端服务器
11.html + css + js + jquery
12.进入前端目录:
  D:\Workspaces\IdeaProjects\springboot\springboot\src\webfrontend
13.live-server
14.启动 live-server 浏览器查看效果
  http://127.0.0.1:8080