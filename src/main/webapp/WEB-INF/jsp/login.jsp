<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../layout/taglib.jsp"%>

<!-- TODO: Will put this stuff in CSS file. -->
<style>
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<form class="form-signin" action="<c:url value="/login" />" 
	method='POST'>
	<h2 class="form-signin-heading"><spring:message code="label.login.heading"/></h2>
	<input type="text" name="username" id="inputEmail" class="form-control"
		placeholder="<spring:message code="label.login.username.placeholder"/>" required autofocus> 
	<input type="password"
		name="password" id="inputPassword" class="form-control"
		placeholder="<spring:message code="label.login.password.placeholder"/>" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="label.login.submit"/></button>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
