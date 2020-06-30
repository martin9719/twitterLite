// I need to create a function where its going to hide the sign up form 
$(document).ready(function(){
	$('#unfollow_btn').hover(function(){
		$(this).removeClass('btn-primary');
		$(this).addClass('btn-danger');
		$(this).html("Unfollow");	
		},
		function(){
			$(this).html("following");
			$(this).removeClass('btn-danger');
			$(this).addClass('btn-primary');
		});
		
})