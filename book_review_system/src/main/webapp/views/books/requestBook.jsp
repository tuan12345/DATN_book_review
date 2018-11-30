<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="slider-container">
	<!-- Slider Image -->
</div>
<!-- home slider end -->
<!-- banner-area start -->
<div class="banner-area pad-60"></div>
<div class="container">
	<hr>
	<div class="row">
		<h3 class="text-center">Request Book</h3>
	</div>
	<div class="row">
		<c:if test="${sendSuccessMsg != null}">
			<div class="alert alert-success" role="alert">
				<h4>${sendSuccessMsg}</h4>
			</div>
		</c:if>
		<spring:url value="/sendRequest" var="sendRequestUrl"></spring:url>
		<div class='col-sm-8 col-sm-push-2'>
			<form:form action="${sendRequestUrl}?${_csrf.parameterName}=${_csrf.token}"
				method="post" modelAttribute="RequestInfo"
				class="form-validate form-horizontal">
				<div class="form-group ">
					<label class="control-label col-lg-2">Title <span
						class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="bookTittle" type="text" required />
					</div>
				</div>

				<div class="form-group ">
					<label class="control-label col-lg-2">Author <span
						class="required">*</span>
					</label>
					<div class="col-lg-10">
						<input class="form-control" name="bookAuthor" type="text" required />
					</div>
				</div>

				<div class="form-group ">
					<label for="curl" class="control-label col-lg-2">Category</label>
					<div class="col-lg-10">
						<select class="form-control input-sm m-bot15" name="idCategory"
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
						<button class="btn btn-primary" type="submit">Send Request</button>
						<button type="reset" class="btn btn-warning">Reset</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>