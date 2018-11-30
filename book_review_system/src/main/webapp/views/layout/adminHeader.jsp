<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/assets/img/avatar1_small.jpg" var="avatar" />
<header class="header dark-bg">
	<div class="toggle-nav">
		<div class="icon-reorder tooltips"
			data-original-title="Toggle Navigation" data-placement="bottom">
			<i class="icon_menu"></i>
		</div>
	</div>
	<!--logo start-->
	<spring:url value="/adminHome" var="adminHome" />
	<a href="${adminHome}" class="logo">Nice <span class="lite">Admin</span></a>
	<!--logo end-->
	<div>
		<a href="?lang=en">English</a> <a href="?lang=vi">Vietnamsese</a>
	</div>
	<div class="nav search-row" id="top_menu"></div>
	<div class="top-nav notification-row">
		<!-- notificatoin dropdown start-->
		<ul class="nav pull-right top-menu">
			<!-- user login dropdown start-->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> <span class="profile-ava">
						<img alt="" src="${avatar}">
				</span> <span class="username">ADMIN</span> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu extended logout">
					<div class="log-arrow-up"></div>
					<spring:url value="/profile" var="profile" />
					<li class="eborder-top"><a href="${profile}"><i
							class="icon_profile"></i> My Profile</a></li>
					<li>
						<form action="<c:url value='/j_spring_security_logout' />"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button class="btn btn-primary btn-lg btn-block" type="submit">Log
								out</button>
						</form>
					</li>
				</ul></li>
			<!-- user login dropdown end -->
		</ul>
		<!-- notificatoin dropdown end-->
	</div>
</header>
<!--header end-->

<!--sidebar start-->
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu">
			<li class="active"><a class="" href="${home}"> <i
					class="icon_house_alt"></i> <span>Dashboard</span>
			</a></li>
			<spring:url value="/users" var="user" />
			<li><a class="" href="${user}"> <i class="icon_genius"></i>
					<span>User</span>
			</a></li>
			<spring:url value="/adminBook" var="book" />
			<li><a class="" href="${book }"> <i class="icon_piechart"></i>
					<span>Book</span>
			</a></li>	
			<spring:url value="/charts" var="charts" />
			<li><a class="" href="${charts }"> <i
					class="icon_piechart"></i> <span>Charts</span>

			</a></li>		
		</ul>
		<!-- sidebar menu end-->
	</div>
</aside>
<!--sidebar end-->