<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>IT修真院欢迎您!</h2>
  <c:set var="message" value="${message}"></c:set>
  <p><c:out value="${message}"/></p>
  
  
  <c:choose>
   	<c:when test="${judge==1}">
		<form action="selectUserByPhone">
			<fieldset>
				<legend>Sign In:</legend>
					<br/><br/>
					UserPhone:<br/>
					<input type="text" name="userPhone" value=""><br/>
					password:<br/>
					<input type="password" name="password" value="">
					<br/><br/>
					<input type="submit" value="Submit">
					<br/><br/>
					<a href="http://localhost:8080/task5_huang/register">New here ? Sign Up</a>
			</fieldset>
	    </form>		
	</c:when>	
	<%-- <c:otherwise>
		<form action="login">
			<fieldset>
				<legend>message:</legend>
					<br/><br/>
					<input type="submit" value="Submit"><br/><br/>
			</fieldset>
		</form>	
	</c:otherwise> --%>
</c:choose>
</body>
</html>