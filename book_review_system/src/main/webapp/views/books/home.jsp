<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<!--start resource  -->
<spring:url value="/" var="urlHome" />
<spring:url value="/listAllBook.jsp" var="bookUrl" />
<spring:url value="/assets/img/slider/s1.jpg" var="imgSliderS1"></spring:url>
<spring:url value="/assets/img/slider/s2.png" var="imgSliderS2"></spring:url>
<spring:url value="/assets/img/slider/s3.png" var="imgSliderS3"></spring:url>

<!--end resource  -->
<!--start bootstrap  -->
<spring:url value="/assets/lib/css/nivo-slider.css" var="nivoSlider" />
<spring:url value="/assets/css/owl.carousel.css" var="owlCarousel" />
<spring:url value="/assets/css/font-awesome.min.css" var="frontAwesome" />
<spring:url value="/assets/mycss/style.css" var="style" />
<spring:url value="/assets/css/font-awesome.min.css" var="fontAwesome" />
<spring:url value="/assets/css/responsive.css" var="responsive" />

<spring:url value="/assets/lib/js/jquery.nivo.slider.pack.js"
	var="jqueryNivo" />
<spring:url value="/assets/lib/js/nivo-active.js" var="NivoActive" />
<link rel="stylesheet" href="${nivoSlider}" />
<link rel="stylesheet" href="${owlCarousel}" />
<%-- <link rel="stylesheet" href="${style}" /> --%>
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${fontAwesome}" />
<link rel="stylesheet" href="${responsive}" />
<!--end bootstrap  -->
</head>
<body>
	
	<security:authorize access="isAuthenticated()">
		<div class="container">
			<div class="row">
				<h2 class="text-center">Your Activities</h2>
				<c:if test="${activityMsg != null}">
					<div class="alert alert-danger" role="alert">
						<span class="text-center">${activityMsg}</span>
					</div>
				</c:if>
				<c:if test="${activityMsg == null}">
					<table class="table">
						<thead>
							<tr>
								<th width="30%"></th>
								<th width="50%">Description</th>
								<th width="20%">Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${activities}" var="activity">
								<tr>
									<td></td>
									<td>${activity.note}</td>
									<td><time class="timeago" datetime="${activity.createdAt}">${activity.createdAt}</time></td>

								</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<h2 class="text-center">Follower Activities</h2>
				<c:if test="${followerActivitiesMsg != null}">
					<div class="alert alert-danger" role="alert">
						<span class="text-center">${followerActivitiesMsg}</span>
					</div>
				</c:if>
				<c:if test="${followerActivitiesMsg == null}">
					<table class="table">
						<thead>
							<tr>

								<th width="30%">Follower Name</th>
								<th width="50%">Description</th>
								<th width="20%">Time</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${followerActivities}" var="followerActivity">
								<tr>
									<td>${followerActivity.user.fullName}</td>

									<td>${followerActivity.note}</td>
									<td><time class="timeago"
											datetime="${followerActivity.createdAt}">${activity.createdAt}</time></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</security:authorize>
</body>
<script src="${jquerymin }" type="text/javascript"></script>

<script>
	jQuery(document).ready(function() {
		jQuery("time.timeago").timeago();
	});
</script>
</html>
