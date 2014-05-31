/**
 * @author 王浩 bingoogol@sina.com
 */

( function($) {
		$.fn.bingoogol_accordion = function(opts) {
			var settings = $.extend({
				selectedClz : "navSelected",
				titleTagName : "h4"
			}, opts || {});
			var titleNode = $(this).find("ul>" + settings.titleTagName);
			var selectedNode = $(this).find("ul." + settings.selectedClz + ">" + settings.titleTagName);
			titleNode.css("cursor", "pointer");
			titleNode.nextAll().css("display", "none");
			selectedNode.nextAll().css("display", "block");
			titleNode.click(function() {
				var checked = $(this).parent().hasClass(settings.selectedClz);
				if (checked) {
					$(this).parent().removeClass(settings.selectedClz);
					$(this).nextAll().slideUp();
				} else {
					selectedNode = $(this).parent().parent().find("ul." + settings.selectedClz + ">" + settings.titleTagName);
					selectedNode.nextAll().slideUp();
					selectedNode.parent().removeClass(settings.selectedClz);
					$(this).parent().addClass(settings.selectedClz);
					$(this).nextAll().slideDown();
				}
			});
		};
	}(jQuery));
