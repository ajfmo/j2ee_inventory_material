/**
 * 
 */
$(document).ready(
		function() {
			$(".date-picker").datepicker();

			$('.my_corner').prepend('<div class="tr"></div>').prepend(
					'<div class="tl"></div>').prepend('<div class="br"></div>')
					.prepend('<div class="bl"></div>');
		});