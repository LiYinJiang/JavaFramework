# spring
对java常见框架做简单的功能实现并记录下笔记

spring 基于IOC和AOP 两个关键功能
IOC  invesion of control 控制反转，即由用户自己创建对象管理改为由spring 创建，而用户只需要使用。
AOP 切面功能，开发中诸多模块分核心和辅助模块。分别开发然后将辅助模块挂载到核心模块上 
1、注入对象
最简单的注入对象
	1、声明实体类 
	2、在xml文件中通过Bean 元素块，指明属性和类。通过Depend inject 依赖注入，用户可载入xml文件后直接调用对象，对象属性内容已被注入
2、使用注解注入对象
	1、在实体类名上声明 @Component 表示作为一个Bean 
	2在类的成员上加入@Autowired 可以让该成员自动注入内容 也可以在该成员的赋值方法上加入@Autowired 效果一样。
	3、若类成员也是一个Bean 并已被@Component声明 ,则可以通过@Resource 来制定名字
3、AOP
Aspect Oriented Program 切面编程 
直观的例子
登录为核心业务，在登录时把登录时间记录到日志中
声明服务 xxxService
实现日志记录的功能
建立切面 xxxAspect 
可在服务执行前后进行操作。
在xml文件中进行配置 将 切面和服务进行关联
	<!-- servcie -->
	<bean name="s" class="eryingzhang.net.service.HeroService" />
	<!-- log -->
	<bean id="loggerAspect"
		class="eryingzhang.net.aspect.LoggerAspect" />
	<bean id="timingAspect"
		class="eryingzhang.net.aspect.TimingAspect" />

	<aop:config>
		<aop:pointcut id="loggerCutpoint"
			expression="execution(* eryingzhang.net.service.HeroService.*(..))" />
		<aop:aspect id="logAspect" ref="loggerAspect">
			<aop:around method="log" pointcut-ref="loggerCutpoint" />
		</aop:aspect>
	</aop:config>
4、注解实现AOP
在xml中加入Bean 扫描目录
<context:component-scan
		base-package="eryingzhang.net.service" />
在业务类service 上加入 @Component 表明它是个Bean
在切面类Aspect上加入@Component , @Aspect 表示是切面
在方法上加入@Around(value="execution(* ${classPath}.*(..))")

5、使用注解的方式用junit测试
在spring 中测试也是基于junit的
注解有略微区别
@RunWith(SpringJUnit4ClassRunner.class) 表示这是个Sprig的测试类

@ContextConfiguration("classpath:applicationContext.xml") 定位spring的配置文件 测试中会需要
@AutoWired 自动装配 需要的对象
@Test 测试逻辑，放在要测试的函数名上
