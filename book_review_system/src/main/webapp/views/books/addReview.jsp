<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<spring:url value="/assets/img/book" var="img"></spring:url>
<spring:url value="/books" var="urlBook"></spring:url>
<!--start Bootstrap  -->
<spring:url value="/assets/img/book/1.jpg" var="book" />
<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/assets/css/owl.carousel.css" var="owlCarousel" />
<spring:url value="/assets/css/font-awesome.min.css" var="frontAwesome" />
<spring:url value="/assets/mycss/style.css" var="style" />
<spring:url value="/assets/js/vendor/jquery-1.12.0.min.js"
	var="jquerymin" />
<spring:url value="/assets/js/owl.carousel.min.js"
	var="jqueryOwlCarousel" />
<spring:url value="/assets/js/jquery.meanmenu.js" var="jqueryMeanmenu" />
<spring:url value="/assets/js/wow.min.js" var="jqueryWow" />
<spring:url value="/assets/js/main.js" var="jqueryMain" />
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${owlCarousel}" />
<link rel="stylesheet" href="${frontAwesome}" />
<link rel="stylesheet" href="${style}" />
<!---end Bootstrap   -->
<div class="slider-container">
	<!-- Slider Image -->
</div>
<!-- home slider end -->
<!-- banner-area start -->
<div class="banner-area pad-60"></div>
<!-- banner-area end -->
<div class="category-area category-area-2 pad-60">
	<div class="container">
		<div class="row">
			<div class="section-title">
				<h2>Add Review</h2>
				<div class="title-icon">
					<span><i class="fa fa-angle-left"></i> <i
						class="fa fa-angle-right"></i></span>
				</div>
			</div>
		</div>
	</div>
	<div class="container" style="background: white;">
		<div class="row">
			<spring:url value="/books/${idBook }/reviews/add" var="addReview"></spring:url>
			<form:form action="${addReview }" method="post" class="login-content"
				modelAttribute="reviewInfo">
				<div class="col-sm-2">
					<label>Your rating:</label>
				</div>
				<div class="col-sm-10">
					<span>
						<div class="rating-input" style="margin-left: -100px">
							<select class="selectpicker" data-style="btn-success"
								name="numberOfStar">
								<option value="" selected disabled hidden>Choose here</option>
								<option value="1">Don't bother</option>
								<option value="2">Disappointing</option>
								<option value="3">Just Fine</option>
								<option value="4">Really good</option>
								<option value="5">The best</option>
							</select>
						</div>
					</span>
				</div>
		</div>

		<input name="id" type="hidden" value="${idReview }">
		<div class="row">
			<div class="col-sm-2" style="margin-top: 0px">
				<label for="comment">Content Review:</label>
			</div>
			<div class="col-sm-10">
				<textarea class="text_size" style="width: 800px; height: 400px;"
					id="comment" name="content">${reviewInfo.getContent() }</textarea>
				<input name="id-review" type="hidden" value="${idReview}">
			</div>
		</div>
		<div style="padding-top: 20px">
			<c:choose>
				<c:when test="${hidden=='2' }">
					<input type="submit" class="btn btn-info " value="Edit Review">

				</c:when>
				<c:otherwise>
					<input type="submit" class="btn btn-info " value="Post Review">
				</c:otherwise>
			</c:choose>
		</div>
		</form:form>
	</div>
</div>
<!--start Bootstrap  -->
<script src="${jquerymin }" type="text/javascript"></script>
<script src="${jqueryOwlCarousel }" type="text/javascript"></script>
<script src="${jqueryMeanmenu }" type="text/javascript"></script>
<script src="${jqueryWow }" type="text/javascript"></script>
<script src="${jqueryMain }" type="text/javascript"></script>
<!--end Bootstrap  -->