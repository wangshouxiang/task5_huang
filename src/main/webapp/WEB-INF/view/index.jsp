<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<form>
		<table width="100%" border=1>
			<tr>
				<th>userPhone</th>
				<th>userPassword</th>
			</tr>
			<c:set value="${user}" var="user" />
				<tr>
					<td>${user.userPhone}</td>
					<td>${user.userPwd}</td>
				</tr>
		</table>
	</form>
</body>
</html>