<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

    <!-- javascript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/js/image-gallery.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.mousewheel-3.0.6.pack.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.fancybox.js"/>"></script>

	<script type="text/javascript" src="<c:url value="/resources/js/swfobject.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.form.js" />"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=zh_cn"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/gmap3.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.uploadify.v2.1.4.js" />"></script>

<script type="text/javascript">
	 adjustWebWidth();
	function adjustWebWidth(){
		var web_width = $(window).width()-50;
		var pin_h_count = Math.max(4,Math.floor((web_width - 15)/237)); 
		web_width = pin_h_count*237-15;
		$('.content-wrapper').each(function(){
			var padding_left = $(this).css('padding-left');
			var padding_right = $(this).css('padding-right');
			var padding = 0, pl, pr;
			if($.trim(padding_left).length >1){
				pl = parseFloat(padding_left.substring(0, padding_left.length-2));
				if(!isNaN(pl)){
					padding += pl;
				}
			}
			if($.trim(padding_right).length>2){
				pr = parseFloat(padding_right.substring(0, padding_right.length-2));
				if(!isNaN(pr)){
					padding += pr;
				}
			}
			$(this).css('width', web_width-padding+'px');
		});
	}
	function noNeedAdjustWebWidth(noNeed){
		if(noNeed != 'true'){
			$(document).ready(function() {
				$(window).resize(adjustWebWidth);
			});
		}
	}
	function setHeaderTab(tab){
		$('ul.nav li').removeClass('active');
		$('ul.nav li#nav-' + tab).addClass('active');
	}
	$('#geo-city-picker a').click(function(){
		var city = $(this).attr('title').toLowerCase();
		op.city_picker_geo_callback(city);
	});
	noNeedAdjustWebWidth('${param.noNeed}')
	setHeaderTab('${param.tab}');
	$('.brand').find('.icon-home').hide();
	$('.brand').mouseenter(function(){
		$(this).find('.version').hide();
		$(this).find('.icon-home').show();
	});
	$('.brand').mouseleave(function(){
		$(this).find('.version').show();
		$(this).find('.icon-home').hide();
	});
</script>

  </body>
</html>