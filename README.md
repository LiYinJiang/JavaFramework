# spriingMVC
对java常见框架做简单的功能实现并记录下笔记

资源定位
将读取资源限定位置
在xxx-servlet.xml中指定bean
例子：
	<bean id="viewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/page/" />
		<property name="suffix" value=".jsp" />
	</bean> 即限定了文件夹和后缀名称 即为 /WEB-INF/page/*.jsp 
限定后在对应的Controller  的映射方法中ModelAndView 创建时，传参即为 jsp文件名称

注解来简化代码
1、在serlvet的xml文件中 加入配置 <context:component base-package="${packageName}"/>
2、通过@Controller 来表明作为一个Controller 
3、在类的方法中注解 @RequestMapping("${uri}") 映射url中的地址 

传递表单数据
1、表单数据多为实体类承载声明一个实体类
2、声明一个填写表单的jsp文件
3、填写提交后显示的jsp文件
4、实现一个Controller 的方法，用来完成对填写表单中的数据进行注入，注入后传参中后，传入显示数据的jsp文件中并进行服务端跳转 既可查看填写的表单数据是否成功传入

@Controller 
public class heroController {

	@RequestMapping("/addHero")  //映射到 /addHero的路径
	public ModelAndView addHero(Hero hero) {  //传参的Hero 由addHero.jsp 中的属性注入其中，jsp和实体类的属性名需要保持一致。
		ModelAndView mav = new ModelAndView("showHero");
		return mav;
	}

}

实现客户端跳转
与服务端略有不同，在ModelAndView（“redirect:${jumpPath}") 即可实现客户端的跳转

Session的调用
只需在Controller 的映射方法中传参 HttpSession 通过session来赋值或者设值即可

中文显示
1、可通过Filter来处理在web.xml中 写出具体的编码方式 和筛选路径
	<filter>
		<filter-name>ChararcterEncodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>utf-8</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>ChararcterEncodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
2、在对于的jsp文件中也需符合编码方式 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
	
文件的上传
1、在web.xml中 加入支持上传的文件格式，放置在实例servlet 之前
<servlet-mapping>
		<servlet-name>default</servlet-name>
		 <url-pattern>*.jpg</url-pattern> 
	</servlet-mapping>
2、在对应的servlet 文件中
加入 多类型解析实体类配置
<bean id="multipartResolver"
		class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
3、声明的jsp文件中，form 节点 必须元素 method=“post"  enctype="multipart/form-data"
以及form中input 节点的必须元素  type="file" accept="image/*"
<form action="upload" method="post" enctype="multipart/form-data">
	选择图片资源: <input type="file" name="image" accept="image/*"><br>
	<input type="submit" value="上传">
</form>
4、声明一个实体类承载图片资源，实体类的属性名要和form中input 的name属性名一致。类型为MultipartFile 
5、在Controller 的方法传参实体类，根据注解的路径 调用时图片资源会被注入到实体类中，对其进行复制并存入服务器中即可
6、声明一个jsp文件用于显示存入服务器中的图片资源。
 
拦截器的设置
1、在servlet的xml文件中配置拦截器，在Controller 的生命周期中对请求进行拦截
例子
<mvc:interceptors>
		<mvc:interceptor>
			<mvc:mapping path="/index" />
			<bean class="interceptor.IndexInterceptor" />
		</mvc:interceptor>
		  <!-- 当设置多个拦截器时，先按顺序调用preHandle方法，然后逆序调用每个拦截器的postHandle和afterCompletion方法 --> 
	</mvc:interceptors>

2、实现指定位置的拦截器

/**
	 * preHandle在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 如果返回true
	 * 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */