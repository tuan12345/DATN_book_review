<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/books" var="bookUrl"></spring:url>
<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="padding-top: 20px;">
						<!-- widget-categories start -->
						<aside class="widget widget-categories">
							<h3 class="sidebar-title">The Loai</h3>
							<ul class="sidebar-menu">
							<c:forEach items="${listCategory }" var="category">
								<li><a href="${bookUrl }?category_id=${category.id }">${category.name }</a> <span class="count">(${category.countBook })</span></li>
								
								</c:forEach>
							</ul>
						</aside>						
						</aside> 
						<!-- shop-filter end -->
						<!-- filter-by start -->
						<aside class="widget filter-by">
							<h3 class="sidebar-title">Tac gia</h3>
							<ul class="sidebar-menu">
								<li><a href="#">L</a> <span class="count">(1)</span></li>
								<li><a href="#">M</a> <span class="count">(1)</span></li>
								<li><a href="#">S</a> <span class="count">(1)</span></li>
								<li><a href="#">XL</a> <span class="count">(1)</span></li>
								<li><a href="#">XXL</a> <span class="count">(1)</span></li>
							</ul>						
						</aside>
						<!-- filter-by end -->
						<!-- widget start -->
						<aside class="widget filter-by">
							<h3 class="sidebar-title">Nha Xuat ban</h3>
							<ul class="sidebar-menu">
								<li><a href="#">Black</a> <span class="count">(1)</span></li>
								<li><a href="#">White</a> <span class="count">(8)</span></li>
								<li><a href="#">Orange</a> <span class="count">(5)</span></li>
								<li><a href="#">Blue</a> <span class="count">(7)</span></li>
								<li><a href="#">Yellow</a> <span class="count">(11)</span></li>
								<li><a href="#">Brown</a> <span class="count">(16)</span></li>
								<li><a href="#">red</a> <span class="count">(9)</span></li>
							</ul>						
						</aside>
										
					</div>