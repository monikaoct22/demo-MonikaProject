<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<!-- Start:Add new blog -->
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal1">
	<spring:message code="label.userAccount.newBlog" />
</button>

<form:form commandName="blog" cssClass="form-horizontal  blogForm">
	<!-- Modal -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<spring:message code="label.userAccount.newBlog" />
					</h4>
				</div>
				<!-- End:Add new blog -->

				<!-- start : pop up for adding blog	 -->
				<div class="modal-body">

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><spring:message
								code="label.userAccount.blog.name" /></label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label"><spring:message
								code="label.userAccount.blog.uri" /></label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<spring:message code="label.userAccount.blog.close" />
					</button>
					<input type="submit" class="btn btn-primary" value="Save" />

				</div>
			</div>


		</div>
	</div>
</form:form>
<!-- End : pop up for adding blog	 -->
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
					class="triggerRemove"><spring:message
						code="label.userAccount.blog.removeBlog" /></a>

				<h1>${blog.name}</h1>
				<p>${blog.url}</p>
				<!--  TODO: Will add text dynamically depending on the language. -->


				<!-- Start :add New item -->

				<button type="button" class="btn btn-primary btn-lg "
					data-toggle="modal" data-target="#myModal">
					<spring:message code="label.userAccount.item.newItem" />
				</button>

				<form:form commandName="item" cssClass="form-horizontal  ItemForm">
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
									<h4 class="modal-title" id="myModalLabel">
										<spring:message code="label.userAccount.item.newItem" />
									</h4>
								</div>


								<!-- End :add New item -->

								<!-- start : pop up for adding item	 -->
								<div class="modal-body">

									<div class="form-group">
										<label for="title" class="col-sm-2 control-label"><spring:message
												code="label.userAccount.item.title" /></label>
										<div class="col-sm-10">
											<form:input path="title" cssClass="form-control" />
											<form:errors path="title" />
										</div>
									</div>
									<div class="form-group">
										<label for="link" class="col-sm-2 control-label"><spring:message
												code="label.userAccount.item.link" /></label>
										<div class="col-sm-10">
											<form:input path="link" cssClass="form-control" />
											<form:errors path="link" />
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">
										<spring:message code="label.userAccount.item.close" />
									</button>
									<input type="submit" class="btn btn-primary" value="Save item" />

								</div>
							</div>
						</div>
					</div>
				</form:form>

				<!-- End : pop up for adding item	 -->

				<table class="table table_bordered table-hoven table-stripped">

					<thead>
						<tr>
							<th><spring:message
									code="label.userAccount.DisplayItem.title" /></th>
							<th><spring:message
									code="label.userAccount.DisplayItem.link" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.items }" var="item">
							<tr>
								<td>${item.title }</td>
								<td><a href="${item.link}" target="_blank">${item.link}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</c:forEach>
	</div>

	<!-- Remove blog confirmation message -->
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<spring:message code="label.userAccount.blog.removeBlog" />
					</h4>
				</div>
				<div class="modal-body">
					<spring:message
						code="label.userAccount.blog.removeBlog.confirmation" />
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<spring:message code="label.userAccount.blog.removeBlog.cancel" />
				</button>
				<a href="" class="btn btn-danger  removebtn"><spring:message
						code="label.userAccount.blog.removeBlog.remove" /></a>
			</div>
		</div>
	</div>
	<!-- END: Remove blog confirmation message -->
</div>