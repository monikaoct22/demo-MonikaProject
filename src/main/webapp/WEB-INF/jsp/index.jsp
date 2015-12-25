<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ include file="../layout/taglib.jsp"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Latest Items from the blogs.</h1>
<table class="table table-bordered table-hover table-stripped">

	<thead>
		<tr>
			<th>Date</th>
			<th>Item</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td><c:out value="${item.publishedDate}" /></td>
				<td><strong> <a href="<c:out value ="${item.link}"/>"
						target="_blank"> <c:out value="${item.title }" />
					</a>
				</strong> <br /> ${item.description}</td>
			</tr>
		</c:forEach>
	</tbody>


</table>
