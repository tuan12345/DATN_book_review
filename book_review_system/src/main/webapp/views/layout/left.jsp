<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/assets/js/readmore.js" var="readMoreJs"></spring:url>
<spring:url value="/books/" var="bookUrl"></spring:url>
<script src="${readMoreJs }" type="text/javascript"></script>
<div class="col-md-3"
	style="padding-top: 20px;">
	<!-- widget-categories start -->
	<aside class="widget widget-categories">
		<h3 class="sidebar-title">The Loai</h3>
		<ul class="sidebar-menu">
			<c:set var="numberCategory" value="${0 }" scope="request"></c:set>
			<c:set var="listCategorySize" value="${listCategory.size()-1 }"></c:set>
			<c:forEach items="${listCategory }" var="category">
				<c:set var="numberCategory" value="${numberCategory+1 }" scope="request"></c:set>
				<c:choose>
					<c:when test="${numberCategory<=listCategorySize/2}">
						<li class="readmoreShow"><a
							href="${bookUrl }?category_id=${category.id }">${category.name }</a>
							<span class="count">(${category.countBook })</span></li>
					</c:when>
					<c:otherwise>
						<li class="CategoryNone readmoreCategoryNone"><a
							href="${bookUrl }?category_id=${category.id }">${category.name }</a>
							<span class="count">(${category.countBook })</span></li>

					</c:otherwise>
				</c:choose>

			</c:forEach>
			<div id="readmoreCategory" style="padding-left: 80px;padding-top: 10px;"><a href="javascript:void(0)" style="color: black;font-weight: bold">Xem Thêm</a>
			<i style="margin-left: 10px;" class="fa fa-angle-down"></i>
			</div>
		</ul>
	</aside>
	<!-- shop-filter end -->
	<!-- filter-by start -->
	<aside class="widget filter-by">
		<h3 class="sidebar-title">Tac gia</h3>
		<ul class="sidebar-menu">
			<c:forEach items="${listAuthor }" var="authorInfo">
				<li><a href="${bookUrl }?authorname=${authorInfo.name }">${authorInfo.name }</a>
					<span class="count">(${authorInfo.numberBook })</span></li>
			</c:forEach>
			<div id="readmore" style="padding-left: 80px;padding-top: 10px;"><a href="#" style="color: black;font-weight: bold">Xem Thêm<i style="margin-left: 10px;" class="fa fa-angle-down"></i></a>
			

		</ul>
	</aside>
	<!-- filter-by end -->
	<!-- widget start -->
	<aside class="widget filter-by">
		<h3 class="sidebar-title">Nha Xuat ban</h3>
		<ul class="sidebar-menu">
			<c:forEach items="${publishers }" var="publisherInfo">
				<li><a href="${bookUrl }?publisher_id=${publisherInfo.id }">${publisherInfo.name }
				</a></li>
			</c:forEach>

		</ul>
	</aside>

</div>