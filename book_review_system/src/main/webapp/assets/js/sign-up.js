$(document).ready(function() {
	$(window).click(function() {
		    var mobile = $('.phone').val();
		    var fullname = $('.fullname').val();
		    var email=$('.email').val();
		    var username=$('.userName').val();
		    var password=$('.passWord').val();
			var phone_vnf_regex =/(09|03|07|08|05)+([0-9]{8})\b/g;
		    var email_regex =/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/; 
		    if(fullname==''){ $("#fullname-result").html('full name not empty');}
		    else {$("#fullname-result").html('');}
		    if(username==''){ $("#username-result").html('username not empty');}
		    else {$("#username-result").html('');}
		    if(email==''){ $("#email-result").html('email not empty');}
		    else {$("#email-result").html('');}
		    if(email==''){ $("#email-result").html('email not empty');}
		    else {$("#email-result").html('');}
		    if(password==''){ $("#password-result").html('password not empty');}
		    else {$("#password-result").html('');}
		    if(mobile !==''){
		        if (phone_vnf_regex.test(mobile)) 
		        {
		        	 $("#phone-result").html('');
		        }else{
		        	$("#phone-result").html('phone number not valid');
		        }
		    }
		    if(email !==''){
		        if (email_regex.test(email)) 
		        {
		        	 $("#email-result").html('');
		        }else{
		        	$("#email-result").html('email not valid ');
		        }
		    }
	});
	
	
	$('#signUp').click(function() {
		var  userInfor=$("#formSignUp").serialize();
		var ctx=window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
		
		$.ajax({
			type:'POST',
			data:userInfor,
			url:ctx+"/signUp",
			datatype:"json",
			success:function(response){
				
				$('#email-result').html(response.checkEmail);
				$('#username-result').html(response.checkUsername);
				$('.text-center-signup').html(response.notifivation);
				if(response.notifivation!="")
				{
					$('.alert').show();
				}
				else $('.alert').hide();
				
			}
			
		});
		
	});
});