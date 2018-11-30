<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/assets/mycss/style1.css" var="style1" />
<spring:url value="/assets/css/font-awesome.min.css" var="fontAwesome" />
<link rel="stylesheet" href="${style1}" />
<link rel="stylesheet" href="${fontAwesome}" />
<footer id="footer">
	<div class="container">
		<!-- Row -->
		<div class="row">
			<div class="col-md-12">
				<!-- footer logo -->
				<!-- /footer logo -->
				<!-- footer follow -->
				<ul class="footer-follow">
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
					<li><a href="#"><i class="fa fa-instagram"></i></a></li>
					<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
					<li><a href="#"><i class="fa fa-youtube"></i></a></li>
				</ul>
				<!-- /footer follow -->
				<div id="map" frameborder="0" style="border: 0" allowfullscreen></div>
				<!-- footer copyright -->
				<div class="footer-copyright">
					<p>
						Copyright © 2016-2018. All Rights Reserved. <a
							href="http://scanfcode.com/" target="_blank">Scanfcode</a>
					</p>
				</div>
				<!-- /footer copyright -->
			</div>
		</div>
		<!-- /Row -->
	</div>
	<!-- /Container -->
</footer>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCQvkFPLJ2jt_0BzZUmFtqvrOCR5Z7H2Ak&callback=initMap">
	
</script>
