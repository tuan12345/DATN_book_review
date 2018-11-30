$(function() {
	//BookDetail Page
	$(".showComment").click(function() {
	    var reviewId = $(this).val();
	    $.ajax({
			url : '/bookReview/reviews/'+reviewId+'/comments',
			type : 'GET',
			success : function(data) {
				console.log(data);
				if(jQuery.isEmptyObject(data)){
					$("#comment-" + reviewId).html("Don't have any comment");
				}else{
					var text = "";
					for(var i = 0; i< data.length; i++){
						text += "<div>";
						text += "<p>Comment by: <a href ='/bookReview/profile/"+data[i].user.id+"'>" +data[i].user.name +"</a></p>";
						text += "<p style='padding-left: 20px;'>Content: " +data[i].content +"</p>"
						text += "<p style='padding-left: 20px;'>Time: " +data[i].createdAt +"</p>"
						text +=	"</div>";
					}
					$("#comment-" + reviewId).html(text);
				}
			},
			error : function(e) {
				console.log(e);
			}
		})
		$("#comment-" + reviewId).toggle();
	});
	
	//Users Page
	$('table').on('click', '.delete_user', function(event) {
		xoa = $(this).parent().parent();
		var parentOjb = $(this).closest('.rename');
		id = parentOjb.find('.user_id').text();
		$.ajax({
			url : 'users/'+id,
			headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
			type : 'DELETE',
			success : function(data) {
				xoa.remove();
				alert(data);
			},
			error : function(e) {
				alert("User have data referenc in onther table can't delete!");
				console.log(e);
			}
		})
	});

	$('table').on('click', '.edit_user', function(event) {
		var parentOjb = $(this).closest('.rename');
		var id = parentOjb.find('.user_id').text();
		$('#myModal').modal('show');
		$.ajax({
			url : 'users/'+id,
			type : 'GET',
			success : function(data) {
				$('#cuser_id').val(data.id);
				$('#cname').val(data.name);
				$("#cemail").val(data.email);
				$('#crole').val(data.role.id);
			},
			error : function(e) {
				console.log(e);
			}
		})
		
	});
	// Update User
	$("#save_user").click(function() {
		var user = $('form').getForm2obj();
		console.log(user);
		$.ajax({
			type: "POST",
		      contentType : 'application/json; charset=utf-8',
		      headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
		      dataType : 'json',
		      url: "users",
		      data: JSON.stringify(user),
			success : function(data) {
				alert(data);
			},
			error : function(e) {
				alert(e.responseText);
			}
		})
		$('#myModal').modal('hide');
		$('#reload').load(location.href + " #reload>*");
	});
	//Get json object from form
	(function($){
	    $.fn.getForm2obj = function(){
	        var _ = {},_t=this;
	        this.c = function(k,v){ eval("c = typeof "+k+";"); if(c == 'undefined') _t.b(k,v);}
	        this.b = function(k,v,a = 0){ if(a) eval(k+".push("+v+");"); else eval(k+"="+v+";"); };
	        $.map(this.serializeArray(),function(n){
	            if(n.name.indexOf('[') > -1 ){
	                var keys = n.name.match(/[a-zA-Z0-9_]+|(?=\[\])/g),le = Object.keys(keys).length,tmp = '_';
	                $.map(keys,function(key,i){
	                    if(key == ''){
	                        eval("ale = Object.keys("+tmp+").length;");
	                        if(!ale) _t.b(tmp,'[]');
	                        if(le == (i+1)) _t.b(tmp,"'"+n['value']+"'",1);
	                        else _t.b(tmp += "["+ale+"]",'{}');
	                    }else{
	                        _t.c(tmp += "['"+key+"']",'{}');
	                        if(le == (i+1)) _t.b(tmp,"'"+n['value']+"'");
	                    }
	                });
	            }else _t.b("_['"+n['name']+"']","'"+n['value']+"'");
	        });
	        return _;
	    }
	})(jQuery);
	
	//Chart Page
	
	var series = '{}';
	$("#reviewChart").submit(function(event) {
		var year = $('#reviewDate').val().substring(0, 4);
		var month = $('#reviewDate').val().substring(5, 7)
		$.ajax({
			url : 'reviewChart/' + month + '/' + year,
			type : 'GET',
			success : function(books) {
				series = books;
				var chart = {
					type : 'column'
				};
				var title = {
					text : 'Review of Book for month'
				};
				var credits = {
					enabled : false
				};
				var json = {};
				json.chart = chart;
				json.title = title;
				json.credits = credits;
				console.log(series);
				json.series = series;
				$('#chart').highcharts(json);
			},
			error : function(e) {
				console.log(e);
			}
		})
		event.preventDefault();
	});

	$(document).ready(function() {
		var d = new Date();
		var month = d.getMonth() + 1;
		var year = d.getFullYear();
		var day = ("0" + d.getDate()).slice(-2);
		var m = ("0" + (d.getMonth() + 1)).slice(-2);
		var today = d.getFullYear()+"-"+(month)+"-"+(day);
		$('#reviewDate').val(today);
		
		$.ajax({
			url : 'reviewChart/' + month + '/' + year,
			type : 'GET',
			success : function(books) {
				series = books;
				var chart = {
					type : 'column'
				};
				var title = {
					text : 'Review of Book for month'
				};
				var credits = {
					enabled : false
				};
				var json = {};
				json.chart = chart;
				json.title = title;
				json.credits = credits;
				json.series = series;
				$('#chart').highcharts(json);
			},
			error : function(e) {
				console.log(e);
			}
		})
	});
});