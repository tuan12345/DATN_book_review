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
<spring:url value="/assets/js/owl.carousel.min.js"
	var="jqueryOwlCarousel" />
<spring:url value="/assets/js/jquery.meanmenu.js" var="jqueryMeanmenu" />
<spring:url value="/assets/js/wow.min.js" var="jqueryWow" />
<spring:url value="/assets/js/main.js" var="jqueryMain" />
<spring:url value="/assets/js/oderBooks.js" var="oderBooksJs" />
<script src="${oderBooksJs }" type="text/javascript"></script>
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
			<div class="row">
				<div class="section-title col-sm-3">
					<h2>List All Book</h2>
					<div class="title-icon">
						<span><i class="fa fa-angle-left"></i> <i
							class="fa fa-angle-right"></i></span>
					</div>
				</div>
				<div class="search-sort col-sm-9">
				<form:form action="/bookReview/books" method="GET">
				<input id="type" hidden  value="${typeSort}" />
					<div class="col-sm-3 slect" >
						<span class="text-sort">Sort by </span> <select  name="typeSort" class="selectpicker" data-style="btn-primary" onchange="this.form.submit()">
						<option value="0" selected disabled hidden>Choose here</option>
							<option value="1">Title</option>
							<option value="2">Publish Date</option>		
						</select>
						<input type="submit" hidden/>
					</div>
					</form:form>
					<div class="input-search-book col-sm-6 search-books">
						<div data-list-title="${titles }" id="list-title"></div>
						<spring:url value="Search" var="searchActionUrl" />
						<div data-list-category="${categories }" id="list-category"></div>
						<form:form action="${searchActionUrl }"
							method="get">
							<div class="input-search-book">
							<ul>
								<li><input id="search-book" type="text" name="search"
									class="form-control" placeholder="Search"></li>
								<li>
									<button class="btn btn-search" type="submit">
										<i class="fa fa-search"></i>
									</button>
								</li>

							</ul>
							<label class="checkbox-inline"><input name="type-search"
								id="checkCategory" type="checkbox" value="category">Category</label>
							<label class="checkbox-inline"><input name="type-search"
								id="checkTitle" type="checkbox" value="title">Title</label>
								</div>
						</form:form>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach items="${books}" var="bookInfo">
					<!-- single-product start -->
					<div class="col-md-3 mt-3">
						<div class="single-product">
							<div class="product-img">
								<a href="single-product.html"> <img
									src="${img }/${bookInfo.image}" alt="" />

								</a>
								<!-- <span class="tag-line">new</span> -->
								<div class="product-action">
									<div class="button-top">
										<a href="#" data-toggle="modal" data-target="#productModal">
											<!-- <i
										class="fa fa-search"></i></a> <a href="#"> --> <i
											class="fa fa-heart"></i>
										</a>
									</div>
									<div class="button-cart">
										<button type="submit">

											<a href="books/${bookInfo.id }">View Detail</a>
										</button>
									</div>
								</div>
							</div>
							<div class="product-content">
								<h3>
									<a href="single-product.html">${bookInfo.tittle }</a>
								</h3>
								<!-- <div class="price">
								<span class="fa fa-star-o"></span> <span class="fa fa-star-o"></span>
								<span class="fa fa-star-o"></span> <span class="fa fa-star-o"></span>
								<span class="fa fa-star-o"></span>
								<span class="old">$80.11</span>
							</div> -->
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
			<!-- row 2 -->
		</div>
		<!--start paging  -->
		<div class="paging">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<!--Previous  -->
					<c:choose>
						<c:when test="${curentPage==1 }">
							<li class="disabled"><a class="page-link" href="#">Previous</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${urlBook }?page=${curentPage - 1 }&typeSort=${typeSort}">Previous</a></li>
						</c:otherwise>
					</c:choose>
					<!--End Previous  -->
					<!--Pages  -->
					<c:forEach begin="1" end="${page }" var="val">
						<li class="page-item"><a class="page-link"
							href="${urlBook }?page=${val }&typeSort=${typeSort}">${val}</a></li>
					</c:forEach>
					<!--End Pages  -->
					<!-- Next -->
					<c:choose>
						<c:when test="${curentPage==page }">
							<li class="disabled"><a class="page-link" href="#">Next</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${urlBook}?page=${curentPage+1 }&typeSort=${typeSort}">Next</a></li>
						</c:otherwise>
					</c:choose>
					<!--End Next  -->
					<!-- start First -->
					<c:choose>
						<c:when test="${curentPage==1 }">
							<li class="disabled"><a class="page-link" href="#">First</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${urlBook }?page=${1 }&typeSort=${typeSort}">First</a></li>
						</c:otherwise>
					</c:choose>
					<!--End First  -->

				</ul>
			</nav>
		</div>
		<!--<!--end paging  -->
	</div>
	<!--start Bootstrap  -->
	<script src="${jquerymin }" type="text/javascript"></script>
	<script src="${jqueryOwlCarousel }" type="text/javascript"></script>
	<script src="${jqueryMeanmenu }" type="text/javascript"></script>
	<script src="${jqueryWow }" type="text/javascript"></script>
	<script src="${jqueryMain }" type="text/javascript"></script>
	<!--end Bootstrap  -->