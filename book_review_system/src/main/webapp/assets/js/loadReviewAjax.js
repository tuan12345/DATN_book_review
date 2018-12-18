$(document).ready(
		function() {
			function showReview(response){
				$('.showReviewAjax').html("");
				jQuery.each(response, function(review){
					$('.a').css({ display: "none" });
					var html = '';
					 html+='<div class="row itemreview " >';
					 html+='<div class="col-md-3 product-col-1 ">';
					 html+='<p class="image">';
						html+='<div class="avatar-img">';
							html+='<span class="avatar-letter">AT</span>';
						html+='</div>';
						html+='</p>';
						html+='<p class="name">'+response[review].name+'</p>';
						html+='<p class="day"><time class="timeggo" datetime="${reviewInfo.getCreatedAt() }">'+response[review].creatDate+'</time>';	
					html+='</div>';
					html+='<div class="review-right">';
							html+='<span>'+response[review].numberStar+'</span> <span class="fa fa-star-o"></span>';
							html+='<p>'+response[review].content+'</p>';
						html+='</div>'

				html+='</div>';			 
					$('.showReviewAjax').append(html);
					  });
			}
			$(document).on('click','.abc1',function() {
				alert("nhay vao1");
			});
			$('.abc').click(
					function() {
						alert("nhay vao");
						var page = $(this).data('page-number');
						var book_id = $('.book-id').val();
						var ctx = window.location.pathname.substring(0,
								window.location.pathname.indexOf("/", 2));
						$.ajax({
							type : 'GET',
							data : {
								page : page,
								id_book : book_id
							},
							url :ctx+"/reviewAjax",
							datatype : "json",
							success : function(response) {
								$('.showReviewAjax').html("");
								jQuery.each(response, function(review){
									$('.a').css({ display: "none" });
									var html = '';
									 html+='<div class="row itemreview " >';
									 html+='<div class="col-md-3 product-col-1 ">';
									 html+='<p class="image">';
										html+='<div class="avatar-img">';
											html+='<span class="avatar-letter">AT</span>';
										html+='</div>';
										html+='</p>';
										html+='<p class="name">'+response[review].name+'</p>';
										html+='<p class="day"><time class="timeggo" datetime="${reviewInfo.getCreatedAt() }">'+response[review].creatDate+'</time>';	
									html+='</div>';
									html+='<div class="review-right">';
											html+='<span>'+response[review].numberStar+'</span> <span class="fa fa-star-o"></span>';
											html+='<p>'+response[review].content+'</p>';
										html+='</div>'

								html+='</div>';			 
									$('.showReviewAjax').append(html);
									  });
							}

						});
					});
			$('.useful').click(function() {
				var page = $(this).data('page-number');
				var book_id = $('.book-id').val();
				var ctx = window.location.pathname.substring(0,
						window.location.pathname.indexOf("/", 2));
				if(page==null) page=1;
				$.ajax({
					type : 'GET',
					data : {
						page : page,
						id_book : book_id,
						userful : "userful"
					},
					url :ctx+"/reviewAjax",
					datatype : "json",
					success : function(response){
						$('.b').css({ display: "none" });
						$('#appendBefor').css({ display: "inline-block" });
						var a=response[0].totalPage;
										for(var i=1;i<=response[0].totalPage;i++){
											var html='';
											html+='<li><a class="abc1" data-page-number='+i+'>';
											html+='<span class="current">'+i+'</span></a></li>';
											$(html).insertBefore('#appendBefor');	
										}
										showReview(response);							
						console.log(response[0].totalPage);
						
					}
				});
			
			});
		});