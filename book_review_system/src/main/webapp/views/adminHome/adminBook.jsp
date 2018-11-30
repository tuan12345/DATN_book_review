<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2 class="text-center">Book Manage</h2>
<div class="container">
	<hr>
	<div class="row">
		<h3 class="text-center">Add book</h3>
	</div>
	<div class="row">
		<c:if test="${addSuccessMsg != null}">
			<div class="alert alert-success" role="alert"><h4>${addSuccessMsg}</h4></div>
		</c:if>
		<spring:url value="books" var="addBook"></spring:url>
		<div class='col-sm-8 col-sm-push-2'>
			<form:form action="${addBook}?${_csrf.parameterName}=${_csrf.token}" method="post"
				enctype="multipart/form-data" commandName="BookInfo"
				class="form-validate form-horizontal">
				<div class="form-group ">
					<label class="control-label col-lg-2">Title <span
						class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="tittle" type="text" required />
					</div>
				</div>

				<div class="form-group ">
					<label class="control-label col-lg-2">Publish Date <span
						class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="publishDate1" type="date" required />
					</div>
				</div>

				<div class="form-group ">
					<label class="control-label col-lg-2">Author <span
						class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="authorName" type="text" required />
					</div>
				</div>

				<div class="form-group ">
					<label for="cname" class="control-label col-lg-2">Number of
						Page <span class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="numberOfPage" type="number"
							required />
					</div>
				</div>

				<div class="form-group ">
					<label for="cname" class="control-label col-lg-2">Image <span
						class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="image1" type="file" required />
					</div>
				</div>

				<div class="form-group ">
					<label for="curl" class="control-label col-lg-2">Category</label>
					<div class="col-lg-10">
						<select class="form-control input-sm m-bot15" name="category.id"
							required>
							<option value="">---Option---</option>
							<c:forEach var="category" items="${categories}">
								<option value="${category.id}">${category.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button class="btn btn-primary" type="submit">Add Book</button>
						<button type="reset" class="btn btn-warning">Reset</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>