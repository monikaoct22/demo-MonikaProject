<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>
	<c:out value="${user.name}" />
</h1>


<br />
<br />


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

<div>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			<li><a href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a></li>
		</c:forEach>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">

				<!-- <button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">Remove</button> -->

				<a
					href="<spring:url value="/account/${blog.id}.html">+</spring:url>"
					class="triggerRemove"><spring:message
						code="label.userAccount.blog.removeBlog" /></a>

				<h1>${blog.name}</h1>
				<p>${blog.url}</p>

				<table class="table table_bordered table-hoven table-stripped ">
					<thead>
						<tr>
							<th><spring:message code="label.userAccount.item.title" /></th>
							<th><spring:message code="label.userAccount.item.link" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.items }" var="item">
							<tr>
								<td>${item.title }</td>
								<td>${item.link }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

		</c:forEach>
	</div>



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
					<h4 class="modal-title" id="myModalLabel"><spring:message code="label.userAccount.blog.removeBlog" /></h4>
				</div>
				<div class="modal-body"><spring:message code="label.userAccount.blog.removeBlog.confirmation" /></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="label.userAccount.blog.removeBlog.cancel" /></button>
				<a href="" class="btn btn-danger  removebtn"><spring:message code="label.userAccount.blog.removeBlog.remove" /></a>
			</div>
		</div>
	</div>
</div>
