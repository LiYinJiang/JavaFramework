# mybatis
对java常见框架做简单的功能实现并记录下笔记

通过源目录下的mybats-config.xml 
1、连接的数据库并补充所需信息
2、和本地的xml文件或注解类建立关联。
3、设置数据库操作，如延迟加载，使用时再加载

测试并简单实现的功能
通过注解实现CRUD
在实体类的xml文件中通过动态SQL 实现条件操作。

1、打印日志
2、事务管理，
3、延迟加载
4、分页处理
一级缓存 默认支持
5、二级缓存 显式开启
在myBatis-config.xml中添加配置
<settings>
	<setting name="cacheEnabled" value="true"/> 
</settings>

在实体类中实现序列化接口 Serializable 
在对于xml文件中 加入 <cache/> 
缓存未命中的原因：
1、第一次查询未提交
2、第二次查询前有过更新

6、加入三方C3P0 数据源以支持高并发
7、通过MybatisGenerator 逆向开发 将数据库生成代码和配置文件


