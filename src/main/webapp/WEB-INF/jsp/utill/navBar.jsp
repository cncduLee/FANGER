<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="side-nav" class="dis-n">
	<li class="about"><a class ="btn" href="http://fanger.cloudfoundry.com/resume" target="_blank" title="我的简历">我的简历&nbsp;&nbsp;&nbsp;<i class="icon-user"></i></a></li>
	<li class="code"><a class="btn" href="https://github.com/cncduLee/FANGER" target="_blank" title="获取源码">获取源码&nbsp;&nbsp;&nbsp;<i class="icon-file"></i></a></li>
</ul>
<script type="text/javascript">
	$(function() {
		$('#side-nav').css('top', Math.max(100, ($(window).height()-$('#side-nav').height())/2));
		$(window).resize(function(){
			$('#side-nav').css('top', Math.max(100, ($(window).height()-$('#side-nav').height())/2));
		});
		$('#side-nav a').css('marginLeft', '-85px');
		$('#side-nav').show();
		$('#side-nav > li').hover(function() {
			$('a', $(this)).stop().animate({
				'marginLeft' : '-2px'
			}, 200);
		}, function() {
			$('a', $(this)).stop().animate({
				'marginLeft' : '-85px'
			}, 200);
		});
	});
</script>