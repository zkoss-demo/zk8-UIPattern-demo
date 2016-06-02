(function($){
	var menuBG = $('<div id="menu-bg">');
	$(document)
	.on("click", ".menu-button.more", function(){
		$(".west")
		.toggleClass("show")
		.before(
		    menuBG.fadeToggle(
		        !$(".west").hasClass("show")
		));
	})
	.on("click", "#menu-bg", function(){
		$(".west").removeClass("show");
		menuBG.fadeOut();
	})
	.on("click", "a.list-group-item", function(){
		$(this)
		.next(".sub-menu-list")
		.height(function(){
			if($(this).height() != 0) return 0;
			var h = 0;
			$(".list-group-item", this).each(function(){
				h += $(this).outerHeight();
			});
			return h;
		})
		.siblings(".sub-menu-list").height(0);
	});
})(jQuery);