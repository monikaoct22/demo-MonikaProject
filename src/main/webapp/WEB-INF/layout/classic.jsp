<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="securitys"%>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>


<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
	<!-- TODO:  This is not working.will look into it later. -->
	<tilesx:useAttribute name="current" />
	<!-- ----------------------------------------- -->

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? active :''}"><a
							href='<spring:url value="/"  />'>Home</a></li>
						<securitys:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? active :''}"><a
								href='<spring:url value="/users.html" ></spring:url>'>Users</a></li>
						</securitys:authorize >
						<securitys:authorize access="! isAuthenticated()">
						<li class="${current == 'register' ? active :''}"><a
							href='<spring:url value="/register.html" ></spring:url>'>Register</a></li>
							</securitys:authorize>
						<securitys:authorize access="! isAuthenticated()">
							<li class="${current == 'login' ? active :''}"><a
								href='<spring:url value="/login.html" ></spring:url>'>Login</a></li>
						</securitys:authorize>
						<securitys:authorize access="isAuthenticated()">
							<li><a href='<spring:url value="/logout" ></spring:url>'>Logout</a></li>
						</securitys:authorize>
						<li><a href="#">Contact</a></li>
						<securitys:authorize access="isAuthenticated()">
						<li class="${current == 'account' ? active :''}"><a
								href='<spring:url value="/account.html" ></spring:url>'>My account</a></li>
						</securitys:authorize>
					</ul>

				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<tiles:insertAttribute name="body" />

		<br />
		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>
</body>

</html>