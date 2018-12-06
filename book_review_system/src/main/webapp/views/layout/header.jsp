<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--parameter url  -->
<spring:url value="/books" var="bookUrl"></spring:url>
<spring:url value="/" var="homeUrl"></spring:url>
<spring:url value="/login" var="loginUrl"></spring:url>
<spring:url value="/requestBook" var="requestUrl"></spring:url>
<spring:url value="/assets/img/bookstor_compact.png" var="icon" />

<spring:url value="/" var="urlHome" />
<spring:url value="/" var="homeUrl" />
<spring:url value="/assets/img/slider/s1.jpg" var="imgSliderS1"></spring:url>
<spring:url value="/assets/img/slider/s2.png" var="imgSliderS2"></spring:url>
<spring:url value="/assets/img/slider/s3.png" var="imgSliderS3"></spring:url>
<spring:url value="/books" var="bookUrl" />
<header class="header-pos sticky-top">
	<!-- header-bottom-area start -->
	
	<div class="header-bottom-area">
		<div class="container-fluid">
			<div class="inner-container">
				<div class="row">
					<div class="col-md-2 col-sm-4 col-xs-5">
						<div class="logo">
							<a href="${homeUrl}"><img src="${icon}" /></a>
						</div>
					</div>
					<div class="col-md-5 hidden-xs hidden-sm">
						<div class="main-menu">
							<nav>
								<ul>
									<li><a href="${homeUrl}">home</a></li>
									<li><a href="${bookUrl}">Book</a></li>
									<security:authorize access="isAnonymous()">
										<li><a id="alert">Request</a></li>
									</security:authorize>
									<security:authorize access="isAuthenticated()">
										<li><a href="${requestUrl }">Request</a></li>
									</security:authorize>
									<li><a href="shop.html">Option</a>
												<div class="mega-menu mega-menu-2">											
													<span>
														<a href="shop.html" class="mega-title">Publisher </a>
														<c:forEach items="${publishers }" var="publisher">
														<a href="${bookUrl }?publisher_id=${publisher.id }">${publisher.name } </a>
														</c:forEach>
														
													</span>
													<span>
														<a href="shop.html" class="mega-title">Author </a>
														<c:forEach items="${listAuthor }" var="author">
														<a href="${bookUrl }?authorname=${author }">${author }</a>
														</c:forEach>
														
														
													</span>
													<span>
														<a href="shop.html" class="mega-title">Category </a>
														<c:forEach items="${listCategory }" var="category">
														<a href="${bookUrl }?category_id=${category.id }">${category.name } </a>
														</c:forEach>
													</span>
													<span class="mega-menu-img">
														<a href="shop.html"><img alt="" src="img/banner/banner-tratraicaytuoi.png"></a>
													</span>
												</div>											
											</li> 
								</ul>
							</nav>
						</div>
					</div>
					<div class="col-md-3 hidden-xs hidden-sm">
						<div data-list-title="${titles }" id="list-title"></div>
						<spring:url value="Search" var="searchActionUrl" />
						<div data-list-category="${categories }" id="list-category"></div>
						<form class="navbar-form navbar-left" action="${searchActionUrl }"
							method="get">
							<div class="input-search">
								<ul>
									<li><input id="search" type="text" name="search"
										class="form-control" placeholder="Search"></li>
									<li>
										<button class="btn btn-search" type="submit">
											<i class="fa fa-search"></i>
										</button>
									</li>
								</ul>
							</div>
						</form>
					</div>
					<div class="col-md-2 col-sm-8 col-xs-7 header-right">
						<div class="user-meta">
							<security:authorize access="isAuthenticated()">
								<h4 class="text-primary">
									Welcome:
									<security:authentication property="principal.username" />
								</h4>
								<ul>
									<spring:url value="/profile" var="profile" />
									<li class="eborder-top"><a href="${profile}"><i
											class="icon_profile"></i> My Profile</a></li>
									<li>
										<form action="<c:url value='/j_spring_security_logout' />"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
											<button class="btn btn-primary btn-xs btn-block"
												type="submit">Log out</button>
										</form>
									</li>
								</ul>
							</security:authorize>
							<security:authorize access="isAnonymous()">
								<a href="${loginUrl}">Login Here</a>
							</security:authorize>
						</div>
						<security:authorize access="isAuthenticated()">
							<div class="row col-md-6 noti ">
								<a href="#" class="item-notification"> <i class="fa fa-bell"
									aria-hidden="true"></i> Notifications <i
									class="notification-size">${currentUser.getUnWatchedNotifications()}</i>
									<input type="text" class="currentUser" hidden
									value="${currentUser.getId() }" />
								</a>
								<ul role="menu" class="sub-menu notifications-body">
								</ul>
							</div>
						</security:authorize>
					</div>
				</div>
			</div>
		</div>
</header>
<div class="slider-container">
		<!-- Slider Image -->
		<div id="mainSlider" class="nivoSlider slider-image">
			<img src="${imgSliderS1 }" alt="main slider" title="#htmlcaption1" />
			<img src="${imgSliderS2 }" alt="main slider" title="#htmlcaption2" />
			<img src="${imgSliderS3 }" alt="main slider" title="#htmlcaption2" />
		</div>
		<!-- Slider Caption 1 -->
		<div id="htmlcaption1" class="nivo-html-caption slider-caption-1">
			<div class="slider-progress"></div>
			<div class="slide1-text">
				<div class="middle-text">
					<div class="cap-dec wow bounceInDown" data-wow-duration="0.9s"
						data-wow-delay="0s">
						<h3>beverage collection in 2018</h3>
					</div>
					<div class="cap-title wow bounceInRight" data-wow-duration="1.2s"
						data-wow-delay="0.2s">
						<h1>Top Book Review</h1>
					</div>
					<div class="cap-readmore wow bounceInUp" data-wow-duration="1.3s"
						data-wow-delay=".5s">
						<a href="#">Home</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Slider Caption 2 -->
		<div id="htmlcaption2" class="nivo-html-caption slider-caption-2">
			<div class="slider-progress"></div>
			<div class="slide1-text">
				<div class="middle-text">
					<div class="cap-dec wow bounceIn" data-wow-duration="0.7s"
						data-wow-delay="0s">
						<h3>trendy summer collection 2016</h3>
					</div>
					<div class="cap-title wow bounceIn" data-wow-duration="1s"
						data-wow-delay="0.2s">
						<h1>Top Book Review</h1>
					</div>
					<div class="cap-readmore wow bounceIn" data-wow-duration="1.1s"
						data-wow-delay=".5s">
						<a href="#">Home</a>
					</div>
				</div>
			</div>
		</div>
		<div id="htmlcaption3" class="nivo-html-caption slider-caption-1">
			<div class="slider-progress"></div>
			<div class="slide1-text">
				<div class="middle-text">
					<div class="cap-dec wow bounceInDown" data-wow-duration="0.9s"
						data-wow-delay="0s">
						<h3>trendy summer collection 2016</h3>
					</div>
					<div class="cap-title wow bounceInRight" data-wow-duration="1.2s"
						data-wow-delay="0.2s">
						<h1>Top Book Review</h1>
					</div>
					<div class="cap-readmore wow bounceInUp" data-wow-duration="1.3s"
						data-wow-delay=".5s">
						<a href="#">Home</a>
					</div>
				</div>
			</div>
		</div>
	</div>