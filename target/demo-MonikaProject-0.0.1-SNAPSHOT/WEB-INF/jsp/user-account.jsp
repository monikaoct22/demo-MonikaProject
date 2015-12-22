<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>



<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">New Blog</button>

<form:form commandName="blog" cssClass="form-horizontal  blogForm">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Blog</h4>
				</div>
				<div class="modal-body">


					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">URl:</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save" />

				</div>
			</div>


		</div>
	</div>
</form:form>

<br />
<br />


<script type="text/javascript">
	$(document).ready(
			function() {
				$('.nav-tabs a:first').tab('show') // Select first tab 
				$(".triggerRemove").click(
						function(e) {
							e.preventDefault();
							$("#modalRemove .removebtn").attr("href",
									$(this).attr("href"));
							$("#modalRemove").modal();

						});
				$(".blogForm").validate(
						{

							rules : {
								name : {
									required : true,
									minlength : 1

								},
								url : {
									required : true,
									url : true

								},
								highlight : function(element) {
									$(element).closest('.form_group')
											.removeClass('has-success')
											.addClass('has_error');
								},
								unhighlight : function(element) {
									$(element).closest('.form_group')
											.removeClass('has-error').addClass(
													'has_success');
								}
							}
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
					class="triggerRemove">Remove Blog</a>

				<h1>${blog.name}</h1>
				<p>${blog.url}</p>
				<!--  TODO: Will add text dynamically depending on the language. -->
				<table>
					<thead>
						<tr>
							<th>Title</th>
							<th>Link</th>
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
					<h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
				</div>
				<div class="modal-body">Do you want to remove this Blog?</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
				<a href="" class="btn btn-danger  removebtn">Remove</a>
			</div>
		</div>
	</div>
</div>
