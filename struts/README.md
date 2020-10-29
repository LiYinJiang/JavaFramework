# struts
对java常见框架做简单的功能实现并记录下笔记

将数据显示到jsp文件中
1、数据的实体类进行声明
2、Controller 声明操作数据， struts中即为action ，action中声明实体类属性
3、struts.xml中对action进行配置

<action name="showHero" class="action.HeroAction" method="show">  name指示 访问路径。
			<result name="show">showHero.jsp</result> //方法返回结果与name一致时就显示jsp文件
		</action>
		
数据提交到action 
1、jsp中通过form节点 
<form action="addHero">
	name: <input type="text" name="hero.name"> <br > 
attackPower:<input type="text" name="hero.attackPower"> <br >
 <input type="submit" value="submit">
</form>
点击submit后 执行Action的 addHero方法 hero的属性也注入到 action的Hero 成员中。
2、struts.xml 设定action 匹配的方法
<action name="addHero" class="action.HeroAction" method="addHero">
			<result name="showHero">showHero.jsp</result>
		</action>
3、在action类中加入方法并和xml中result 返回值对应来完成添加后跳转的功能
public String addHero() {
		
		return "showHero";
	}
	

中文显示
中文显示需要编码统一，UTF-8通用性最好，GBK，ISO-8859-1也可以但要保持一致
1、在jsp提交数据
2、struts.xml 拿到数据的解码
3、浏览器显示的jsp文件 三个保持一致

加入日志打印查找错误
在源文件中加入 log4j.xml 
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration PUBLIC "-//log4j/log4j Configuration//EN" "log4j.dtd">
 
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
     
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
       <layout class="org.apache.log4j.PatternLayout">
          <param name="ConversionPattern" value="%d %-5p %c.%M:%L - %m%n"/>
       </layout>
    </appender>
  
    <!-- specify the logging level for loggers from other libraries -->
    <logger name="com.opensymphony">
        <level value="DEBUG" />
    </logger>
 
    <logger name="org.apache.struts2">
         <level value="DEBUG" />
    </logger>
   
   <!-- for all other loggers log only debug and above log messages -->
     <root>
        <priority value="INFO"/>
        <appender-ref ref="STDOUT" />
     </root>
     
</log4j:configuration> 

Request 和 response 在struts中通过ServletActionContext.getxxx

session的获取有两种形式
常规方法 导入 servlet-api.jar 包通过ServletActionContext.getRequest().getSession()
struts 的方法 Map m =ActionContext.getContext().getSession();

上传文件
1、传递文件，jsp文件中form 必须属性 enctype="multipart/form-data" method="post"   input中type="file"
2、struts.xml 中加入action 来实现功能 包含action 类名，方法名，返回值对应的jsp文件
3、action 中具备资料属性。如File 成员名和 上传jsp文件的input name属性值一致。
4、资料上传后可以跳转到显示资料的页面便于验证


文件尺寸的设置
通过struts.xml 配置
<constant name="struts.multipart.maxSize" value="10240000"/>
