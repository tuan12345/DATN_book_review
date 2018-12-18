$(document).ready(function() {
	$('#readmoreCategory').click(function() {
		if($('#readmoreCategory a').text()=="Xem Thêm"){
			$('#readmoreCategory a').html("Rút Gọn");
		
			$('.CategoryNone').removeClass('readmoreCategoryNone').addClass('readmoreShow');
		}
		else{
			$('#readmoreCategory a').html("Xem Thêm");
			$('.CategoryNone').addClass('readmoreShow');
		}
		
	});
	
});