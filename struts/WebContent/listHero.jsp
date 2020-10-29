<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<style>
table {
	border-collapse: collapse;
}

td {
	border: 1px solid gray;
}
</style>
<table align="center">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>st.index</td>
		<td>st.count</td>
		<td>st.first</td>
		<td>st.last</td>
		<td>st.odd</td>
		<td>st.even</td>
	</tr>
	<s:iterator value="heros" var="h" status="st">
		<tr>
			<td>${h.id }</td>
			<td>${h.name }</td>
			<td>${st.index}</td>
			<td>${st.count}</td>
			<td>${st.first}</td>
			<td>${st.last}</td>
			<td>${st.odd}</td>
			<td>${st.even}</td>
		</tr>
	</s:iterator>
</table>