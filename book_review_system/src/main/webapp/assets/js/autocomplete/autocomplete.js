$(document).ready(function() {
	// data titles
	var $listTitle = $('#list-title').data('list-title');
	$listTitle = $listTitle.replace("[", "");
	$listTitle = $listTitle.replace("]", "");
	var list_title = $listTitle.split(',');
	// data category
	var $listCategory = $('#list-category').data('list-category');
	$listCategory = $listCategory.replace("[", "");
	$listCategory = $listCategory.replace("]", "");
	var list_category = $listCategory.split(',');
	// checkbox category click
	$('#checkCategory').click(function() {
		if ($(this).is(":checked")) {
			if ($("#checkTitle").is(":checked")) {
				$("#checkTitle").prop('checked', false);
			}
			
			_search(list_category);

		}

	});
	// checkbox title click
	$('#checkTitle').click(function() {
		if ($(this).is(":checked")) {
			if ($("#checkCategory").is(":checked")) {
				$("#checkCategory").prop('checked', false);
			}
			_search(list_title);
		}
	})

	function _search(arr) {
		$("#search-book").autocomplete({
			source : arr
		});

	}
});