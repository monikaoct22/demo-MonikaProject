<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show') // Select first tab 
		$(".triggerRemove").click(function(e) {
			e.preventDefault();
			$("#modalRemove .removebtn").attr("href", $(this).attr("href"));
			$("#modalRemove").modal();

		});

	});
</script>


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
						<c:out value="${user.name}"/> </a></td>
				<!-- class="btn btn-danger" -->
				<td>${user.email}</td>
				<td><a
					href='<spring:url value="/users/remove/${user.id}.html" ></spring:url>' class="btn btn-danger triggerRemove">remove
						user</a></td>
			</tr>
		</c:forEach>

		</td>
</table>


<!-- Modal -->
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
				</div>
				<div class="modal-body">Really wanna remove</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
				<a href="" class="btn btn-danger  removebtn">Remove</a>
			</div>
		</div>
	</div>
</div>

</html>