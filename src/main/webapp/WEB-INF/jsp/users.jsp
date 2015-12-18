<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<!-- TODO: Will add text dynamically depending on the language.  -->
<html>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>User Name:</th>
			<th>Email:</th>
			<th>operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><a href='<spring:url value="/users/${user.id}.html"/>'>
						${user.name} </a></td>
				<!-- class="btn btn-danger" -->
				<td>${user.email}</td>
				<td><a
					href='<spring:url value="/users/remove/${user.id}.html" ></spring:url>'>remove
						user</a></td>
			</tr>
		</c:forEach>

		</td>
</table>
</html>