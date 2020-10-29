<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- 
<form action="addHero" method="post">
	name: <input type="text" name="hero.name"> <br /> attackPower:<input
		type="text" name="hero.attackPower"> <br /> <input
		type="submit" value="submit">
</form>
 -->
<s:form action="addHero">
	<s:textfield name="hero.name" label="hero name" />
	<s:submit value="Submit" />
</s:form>

</html>