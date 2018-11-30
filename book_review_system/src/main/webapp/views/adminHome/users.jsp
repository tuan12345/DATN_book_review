<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/assets/js/user-script.js" var="userScript" />
<h2 class="text-center">User Manage</h2>
<spring:url value="/users/report" var="report"></spring:url>
<spring:url value="/users/import" var="importExcel"></spring:url>
<button class="btn btn-default" type="button">
	<a href="${report}">Export Excel</a>
</button>
<button class="btn btn-default" type="button" data-toggle="modal"
	data-target="#importModal">Import Admin from Excel</button>
<div class="text-center">
	<h3>
		<strong>${message}</strong>
	</h3>

	<h3>
		<strong>${importMsg}</strong>
	</h3>
</div>
<table class="table">
	<thead>
		<tr>
			<th>User ID</th>
			<th>Full Name</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Role</th>
			<th width="10%"></th>
		</tr>
	</thead>
	<tbody id="reload">

		<c:forEach items="${users}" var="user">
			<tr class="rename">
				<td class="user_id">${user.id}</td>
				<td class="user_full_name">${user.name}</td>
				<td>${user.userName}</td>
				<td class="user_email">${user.email}</td>
				<td class="user_role">${user.role.name}</td>
				<td>
					<button type="button" class="btn btn-warning edit_user">Edit</button>
					<button type="button" class="btn btn-danger delete_user">Delete</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Edit User</h4>
			</div>
			<div class="modal-body">
				<p>User Info</p>
				<form name="updateUser" class="form-validate form-horizontal"
					method="POST">
					<input id="cuser_id" type="text" hidden="1" name="id">
					<div class="form-group ">
						<label for="cname" class="control-label col-lg-2">Full
							Name <span class="required">*</span>
						</label>
						<div class="col-lg-10">
							<input class="form-control" id="cname" name="name" minlength="5"
								type="text" required />
						</div>
					</div>
					<div class="form-group ">
						<label for="cemail" class="control-label col-lg-2">E-Mail
							<span class="required">*</span>
						</label>
						<div class="col-lg-10">
							<input class="form-control " id="cemail" type="email"
								name="email" required />
						</div>
					</div>
					<div class="form-group ">
						<label for="curl" class="control-label col-lg-2">Role</label>
						<div class="col-lg-10">
							<select class="form-control input-sm m-bot15" id='crole'
								name="role[id]">
								<c:forEach var="role" items="${roles}">
									<option value="${role.id}">${role.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-primary" type="button" id="save_user">Save</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer"></div>
		</div>

	</div>
</div>
<!-- End Modal -->

<!-- Modal -->
<div id="importModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Import Admin</h4>
			</div>
			<div class="modal-body">

				<form action="${importExcel}/?${_csrf.parameterName}=${_csrf.token}" class="form-validate form-horizontal"
					method="POST" enctype="multipart/form-data">
					<div class="form-group ">
						<label for="cname" class="control-label col-lg-2">Excel
							file<span class="required">*</span>
						</label>
						<div class="col-lg-10">
							<input class="form-control" name="file" accept="${excelType}"
								type="file" required />			
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-primary" type="submit">Import
								User</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>

		</div>

	</div>
</div>

<!-- Pagination -->
<div class="text-center">
	<spring:url value="/users" var="user" />
	<ul class="pagination pagination-lg">
		<c:if test="${currenPage != 1}">
			<li><a href="${user}?page=${currenPage - 1}">&lt;&lt;</a></li>
		</c:if>
		<c:forEach begin="1" end="${pages}" var="val">
			<c:choose>
				<c:when test="${val == currenPage}">
					<li><a style="color: white; background: blue;">${val}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${user}?page=${val}">${val}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${currenPage != pages}">
			<li><a href="${user}?page=${currenPage + 1}">&gt;&gt;</a></li>
		</c:if>

	</ul>
</div>

<!-- End Pagination -->
<script src="${userScript}" type="text/javascript"></script>