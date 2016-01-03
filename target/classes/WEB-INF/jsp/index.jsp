<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ include file="../layout/taglib.jsp"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1><spring:message code="label.index.heading"></spring:message></h1>
<table class="table table-bordered table-hover table-stripped">

	<thead>
		<tr>
			<th><spring:message code="label.index.date"></spring:message></th>
			<th><spring:message code="label.index.item"></spring:message></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>
				<c:out value="${item.publishedDate}" />
				<br/>
				 <c:out value="${item.blog.name}"/>
				</td>
				<td><strong> <a href="<c:out value ="${item.link}"/>"
						target="_blank"> <c:out value="${item.title }" />
					</a>
				</strong> <br /> ${item.description}</td>
			</tr>
		</c:forEach>
	</tbody>


</table>
