<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
<spring:url value="/assets/img/book/dacnhantam.jpg" var="book1" />
<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/assets/css/owl.carousel.css" var="owlCarousel" />
<spring:url value="/assets/css/font-awesome.min.css" var="frontAwesome" />
<spring:url value="/assets/mycss/style.css" var="style" />
<spring:url value="/assets/css/dialog.css" var="dialogCss" />
<spring:url value="/assets/js/dialog/dialog.js" var="dialogJs" />
<spring:url value="/assets/js/vendor/jquery-1.12.0.min.js"
	var="jquerymin" />
<spring:url value="/assets/js/owl.carousel.min.js"
	var="jqueryOwlCarousel" />
<spring:url value="/assets/js/jquery.meanmenu.js" var="jqueryMeanmenu" />
<spring:url value="/assets/js/wow.min.js" var="jqueryWow" />
<spring:url value="/assets/js/main.js" var="jqueryMain" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="canonical"
	href="http://localhost:8081/bookReview/books/${bookInfo.id }" />
<spring:url value="/assets/js/user-script.js" var="userScript" />
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${dialogCss}" />
<link rel="stylesheet" href="${owlCarousel}" />
<link rel="stylesheet" href="${frontAwesome}" />
<link rel="stylesheet" href="${style}" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:if test="${msgBookNotFound !=null}">
	<div class="alert alert-warning" role="alert">${msgBookNotFound}</div>
</c:if>
<c:if test="${bookInfo !=null}">
	<div class="shop-area" style="background-color: #ebeaea;">
		<div class="container" style="background-color: white;">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-5 col-sm-5 col-xs-12">
							<div class="single-pro-tab-content">
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="home">
										<a href="#"><img style="padding-top: 10px;"
											src="${img}/${bookInfo.imageDetail}"
											data-zoom-image="${book1 }" alt="" /></a>
									</div>

								</div>

							</div>
						</div>
						<div class="col-md-7 col-sm-7 col-xs-12 shop-list shop-details">
							<div class="product-content">
								<h3>
									<a href="single-product.html">${bookInfo.tittle}</a>
								</h3>
								<div>
									<span>Tác giả: <a href="">${bookInfo.authorName}</a></span>

								</div>
								<div class="s-p-rating">
									<span class="rating"> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star-o"></i>
									</span> <span class="review-no">${bookInfo.quantityVote} Review
										(s)</span> <span class="review-no add-review"><a href="#">Add
											your review</a></span>
								</div>
								<hr>
								<div class="white-panel">
									<div class="attribute-table single-table"></div>
									<table style="height: 300px" id="chi-tiet" cellspacing="0"
										class="table table-bordered table-detail table-striped">
										<colgroup>
											<col style="width: 25%;">
											<col>
										</colgroup>
										<tbody>
											<tr>
												<td rel="publisher_vn">Thể Loại</td>
												<td class="last"><a
													href="http://tiki.vn/cty-sach/tre.html">${bookInfo.category.name}</a></td>
											</tr>
											<tr>
												<td rel="author">Ngày Xuất Bản</td>
												<td class="last">${bookInfo.publishDate }</td>
											</tr>
											<tr>
												<td rel="publication_date">Tác Giả</td>
												<td class="last">${bookInfo.authorName }</td>
											</tr>
											<tr>
												<td rel="dimensions">Số Trang</td>
												<td class="last">${bookInfo.numberOfPage }</td>
											</tr>
											<tr>
												<td rel="manufacturer_book_vn">Nhà xuất bản</td>
												<td class="last">${bookInfo.publisher.name}</td>
											</tr>

										</tbody>
									</table>
								</div>
								<div class="product-share">
									<label>Share:</label> <span> <a href="#"><i
											class="fa fa-facebook"></i></a> <a href="#"><i
											class="fa fa-twitter"></i></a> <a href="#"><i
											class="fa fa-google-plus"></i></a> <a href="#"><i
											class="fa fa-linkedin"></i></a> <a href="#"><i
											class="fa fa-pinterest"></i></a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row" style="box-sizing: border-box;">
						<div class="col-md-12 col-sm-12">
							<div class="product-tabs">
								<div>
									<!-- Nav tabs -->
									<ul class="pro-details-tab" role="tablist">
										<li role="presentation" class="active"><a
											href="#tab-desc" aria-controls="tab-desc" role="tab"
											data-toggle="tab">Description</a></li>

									</ul>
									<!-- Tab panes -->
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane active" id="tab-desc">
											<div class="product-tab-desc">
												<p>${bookInfo.description }</p>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-12 col-sm-12"
							style="background-color: #e3e3e3; margin-top: -50px;">
							<div class="product-tabs">
								<div>
									<!-- Nav tabs -->
									<ul class="pro-details-tab" role="tablist">
										<li role="presentation" class="active"><a
											href="#tab-desc" aria-controls="tab-desc" role="tab"
											data-toggle="tab">Khách Hàng Nhận Xét</a></li>

									</ul>
								</div>
							</div>
							<div class="row"
								style="background-color: white; margin-top: -50px;">
								<div class="col-md-3 product-customer-col-1">
									<h4>Đánh Giá Trung Bình</h4>
									<p class="total-review-point">${bookInfo.avgStar }/5</p>
									<div class="item-rating"
										style="text-align: center; margin-top: -10px;">
										<div class="s-p-rating">
											<span class="rating"> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star-o"></i>
											</span>
										</div>

										<p class="comments-count">
											<a
												href="toi-thay-hoa-vang-tren-co-xanh-nguyen-nhat-anh-p337191/nhan-xet">(${bookInfo.quantityVote}
												nhận xét)</a>
										</p>
									</div>
								</div>
								<div class="col-md-5 product-customer-col-2">
									<div class="item rate-5">
										<span class="rating-num">5<span><i
												class="fa fa-star"></i> </span></span>
										<div class="progress">
											<div class="progress-bar progress-bar-success"
												style="width: ${bookInfo.percentStar5}%;">
												<span class="sr-only"></span>
											</div>
										</div>
										<span class="rating-num-total">${bookInfo.percentStar5}%</span>
									</div>
									<div class="item rate-4">
										<span class="rating-num">4<span><i
												class="fa fa-star"></i> </span></span>
										<div class="progress">
											<div class="progress-bar progress-bar-success"
												style="width: ${bookInfo.percentStar4}%;">
												<span class="sr-only"></span>
											</div>
										</div>
										<span class="rating-num-total">${bookInfo.percentStar4}%</span>
									</div>
									<div class="item rate-3">
										<span class="rating-num">3<span><i
												class="fa fa-star"></i> </span></span>
										<div class="progress">
											<div class="progress-bar progress-bar-success"
												style="width: ${bookInfo.percentStar3}%;">
												<span class="sr-only"></span>
											</div>
										</div>
										<span class="rating-num-total">${bookInfo.percentStar3}%</span>
									</div>
									<div class="item rate-2">
										<span class="rating-num">2<span><i
												class="fa fa-star"></i> </span></span>
										<div class="progress">
											<div class="progress-bar progress-bar-success"
												style="width: ${bookInfo.percentStar2}%;">
												<span class="sr-only"></span>
											</div>
										</div>
										<span class="rating-num-total">${bookInfo.percentStar2}%</span>
									</div>
									<div class="item rate-1">
										<span class="rating-num">1<span><i
												class="fa fa-star"></i> </span></span>
										<div class="progress">
											<div class="progress-bar progress-bar-success"
												style="width: ${bookInfo.percentStar1}%;">
												<span class="sr-only"></span>
											</div>
										</div>
										<span class="rating-num-total">${bookInfo.percentStar1}%</span>
									</div>
								</div>

								<div class="col-md-3 product-customer-col-3">
									<h4>Chia Sẻ Nhận Xét Của Bạn</h4>

									<security:authorize access="isAnonymous()">
									<spring:url value="/login" var="loginUrl"></spring:url>
										<a href="${loginUrl }"><button type="button"
											class="btn btn-default js-customer-button">
											<span class="Jsnhanxet">Đăng nhập để viết nhận xét</span>
										</button></a>
									</security:authorize>
									<security:authorize access="isAuthenticated()">
										<button type="button"
											class="btn btn-default js-customer-button">
											<span class="Jsnhanxet">Viết Nhận Xét Của Bạn</span>
										</button>
									</security:authorize>
									

								</div>
							</div>
						</div>
					</div>
					<div class="row displayAreview">
						<h3 class="col-md12 js-customer-h3">Gửi nhận xét của bạn</h3>
						<div class="product-customer-col-4 js-customer-col-4"
							style="display: block;">
							<spring:url value="/books/${bookInfo.id }/reviews/add"
								var="addReview"></spring:url>
							<form:form action="${addReview }" method="POST" id="addReviewFrm"
								modelAttribute="reviewInfo">
								<div class="rate form-group has-feedback has-success"
									id="rating_wrapper">
									<label>1. Đánh giá của bạn về sản phẩm này:</label> <span>
										<div class="rate">
											<select class="selectpicker" data-style="btn-success"
												name="numberOfStar">
												<option value="" selected disabled hidden>Choose
													here</option>
												<option value="1">Không Bận Tâm</option>
												<option value="2">Thất vọng</option>
												<option value="3">Bình Thường</option>
												<option value="4">Thật Sự Tốt</option>
												<option value="5">Rất Tốt</option>
											</select>
										</div>
									</span>
								</div>
								<div class="title form-group" id="title_wrapper">
									<label for="review_title">2. Tiêu đề của nhận xét:</label> <input
										type="text"
										placeholder="Nhập tiêu đề nhận xét (không bắt buộc)"
										name="title" id="review_title" class="form-control input-sm">

								</div>

								<div class="review-content form-group has-feedback">
									<label for="review_detail">3. Viết nhận xét của bạn vào
										bên dưới:</label>
									<textarea placeholder="Nhận xét của bạn về sản phẩm này"
										class="form-control content" name="content" id="review_detail"
										cols="30" rows="10" data-bv-field="detail"></textarea>

								</div>
								<spring:url value="/review" var="urlReview"></spring:url>
								<input style="background: #fdd22f;" type="submit"
									class="btn btn-default btn-add-review " value="Gửi nhận xét"></input>
							</form:form>

						</div>
					</div>
					<div class="row product-review-box">
						<div data-reactroot="" class="product-review-box">
							<div class="product-review-content">
								<div id="product-review-box">
									<div>
										<div class="review-filter">
											<p>Chọn xem nhận xét</p>
											<div class="btn-group huuich">
												<button type="button"
													class="btn btn-default dropdown-toggle"
													data-toggle="dropdown">
													Hữu ích <span class="caret"></span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a class="useful" >Hữu ích</a></li>
													<li><a class="new">Mới nhất</a></li>

												</ul>
											</div>
											<div class="btn-group read">
												<button type="button"
													class="btn btn-default dropdown-toggle"
													data-toggle="dropdown">
													Tất cả người dùng <span class="caret"></span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Đã đọc</a></li>
													<li><a href="#">Đang đọc</a></li>

												</ul>
											</div>
											<div class="btn-group rate">
												<button type="button"
													class="btn btn-default dropdown-toggle"
													data-toggle="dropdown">
													Tất cả sao <span class="caret"></span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Tất cả sao</a></li>
													<li><a href="#">5 sao</a></li>
													<li><a href="#">4 sao</a></li>
													<li><a href="#">3 sao</a></li>
													<li><a href="#">2 sao</a></li>
													<li><a href="#">1 sao</a></li>

												</ul>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row itemreview">
						<div class="showReviewAjax"></div>
						<c:forEach items="${reviews}" var="reviewInfo">
							<div class="row itemreview a">
								<div class="col-md-3 product-col-1 ">
									<p class="image">
									<div class="avatar-img">
										<span class="avatar-letter">AT</span>
									</div>
									</p>
									<p class="name">${reviewInfo.getUserInfo().getName()}</p>
									<p class="day">
										<time class="timeggo" datetime="${reviewInfo.getCreatedAt() }">${reviewInfo.getCreatedAt()}</time>
								</div>
								<div class="col-md-8 review-right">
									<span>${ reviewInfo.getNumberOfStar()}</span> <span
										class="fa fa-star-o"></span><span>${ reviewInfo.getTitle()}</span>
									<p>${reviewInfo.getContent()}</p>
								</div>

							</div>
						</c:forEach>
						<div class="row list-pager b">
							<ul>
								<c:forEach begin="1" end="${totalPage }" var="val">

									<input type="text" class="book-id" value="${bookInfo.id }"
										hidden />
									<li><a class="abc" data-page-number=${val} <%-- href="${book_id}?page=${val }" --%>><span
											class="current">${val }</span></a></li>

								</c:forEach>
								<li><a href="#" class="next"><i
										class="glyphicon glyphicon-chevron-right"></i></a></li>
							</ul>
						</div>
						<div class="row list-pager ">
						<input type="text" class="book-id" value="${bookInfo.id }"
										hidden />
						<ul class="showPage">
						<li id="appendBefor" ><a href="#" class="next"><i
										class="glyphicon glyphicon-chevron-right"></i></a></li>
						</ul>
						</div>
					</div>
				</div>
			</div>
</c:if>
<script>
	jQuery(document).ready(function() {
		jQuery("time.timeggo").timeago();
	});
</script>
<script src="${dialogJs }" type="text/javascript"></script>
<script src="${jquerymin }" type="text/javascript"></script>
<script src="${jqueryOwlCarousel }" type="text/javascript"></script>
<script src="${jqueryMeanmenu }" type="text/javascript"></script>
<script src="${jqueryWow }" type="text/javascript"></script>
<script src="${jqueryMain }" type="text/javascript"></script>
<script src="${userScript}" type="text/javascript"></script>


<!--end Bootstrap  -->



