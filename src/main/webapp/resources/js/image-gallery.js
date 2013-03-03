$(document).ready(function () {
    
    $("[rel=tooltip]").tooltip();
    
    $("a.group").fancybox({
		'titleShow'     : false,
		openEffect : 'elastic',
		openSpeed  : 150,
		closeEffect : 'elastic',
		closeSpeed  : 150,
		closeClick : true,
	});
    
    $(".images1").fancybox({
		wrapCSS    : 'fancybox-custom',
		closeClick : true,
        'titleShow'     : false,
		helpers : {
			overlay : {
					css : {
							'background-color' : '#222'
						}
					}
				}
	});
    
    $(".images2").fancybox({
		'titleShow'     : false,
		openEffect : 'elastic',
		openSpeed  : 500,
		closeEffect : 'elastic',
		closeSpeed  : 350,
		closeClick : true,
	});
    
    $("a.images3").fancybox({
	    'titleShow'     : false,
        openSpeed  : 0,
        closeSpeed  : 0,
		'transitionIn'	: 'none',
		'transitionOut'	: 'none'
	});
    
    $(".images4").fancybox({
		'titleShow'     : false,
		openEffect : 'elastic',
		openSpeed  : 100,
		closeEffect : 'elastic',
		closeSpeed  : 250,
		closeClick : true,
	});
    
    $("a[rel=wheel_group]").fancybox({
		'transitionIn'		: 'none',
		'transitionOut'		: 'none',
		'titlePosition' 	: 'over',
		'titleFormat'       : function(title, currentArray, currentIndex, currentOpts) {
		    return '<span id="fancybox-title-over">Image ' +  (currentIndex + 1) + ' / ' + currentArray.length + ' ' + title + '</span>';
		}
	});
    
	});