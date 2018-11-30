function initMap() {
	// The location of Framgia
	var uluru = {
		lat : 21.016799,
		lng : 105.781919
	};
	// The map, centered at Framgia
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : 20,
		center : uluru
	});
	// The marker, positioned at Framgia
	var marker = new google.maps.Marker({
		position : uluru,
		map : map
	});
}

$(document).ready(function() {
	$('#alert').click(function() {
		alert("Login to send request");
	})

})