$(document).ready(
		function() {
	$('.js-customer-button').click(function() {
		var type=$('.Jsnhanxet').text();
		if(type=="Viết Nhận Xét Của Bạn"){
			$(".displayAreview").css("display","block");
			$(".Jsnhanxet").html("Đóng")
		}
		else {
			$(".displayAreview").css("display","none");
			$(".Jsnhanxet").html("Viết Nhận Xét Của Bạn")
		}
	
		 
	});
});	