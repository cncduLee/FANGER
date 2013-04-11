<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../../common/Header.jsp" flush="true"></jsp:include>
    <script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<style type="text/css">
		.nav li{margin-top:8px;}.nav li.title{margin-top:0;}.nav li.menu,.nav li.dropdown{margin:8px 3px 0 3px}
		.nav li.menu a{padding:5px 6px;*padding:4px 5px 3px 5px;}.nav li.dropdown a{padding:5px 6px;*padding:1px 5px 3px 5px;}
		.nav li a{font-size:14px;padding:6px 8px;*padding:3px 8px;}
</style>
<script type="text/javascript"> 

$(document).ready(function() {
	$(".accordion-heading a").click(function(){
		$('.accordion-toggle i').removeClass('icon-chevron-down');
		$('.accordion-toggle i').addClass('icon-chevron-right');
		if(!$($(this).attr('href')).hasClass('in')){
			$(this).children('i').removeClass('icon-chevron-right');
			$(this).children('i').addClass('icon-chevron-down');
		}
	});
	
	$(".accordion-body a").click(function(){
		$("#menu li").removeClass("active");
		$(this).parent().addClass("active");
	});
	
	$(".accordion-heading a:first i").click();
	$(".accordion-body a:first i").click();
	
});

</script>
 <div class="container">
        <div class="row">
        <!-- left menu -->
         <div class="span2 left-sidebar">
			<div class="accordion" id="menu">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#menu" href="#collapse40"><i
						class="icon-chevron-right"></i>&nbsp;&nbsp;人员信息</a>
				</div>
				<div id="collapse40" class="accordion-body collapse"
					style="height: 0px;">
					<div class="accordion-inner">
						<ul class="nav nav-list">
							<li class="active"><a href="<c:url value="/admin/user/list"/>" target="mainFrame"><i class="icon-briefcase"></i>&nbsp;&nbsp;内容发布</a></li>

							<li><a href="<c:url value="/admin/spot/list"/>" target="mainFrame"><i class="icon-comment "></i>&nbsp;&nbsp;评论管理</a></li>

							<li><a href="#" target="mainFrame"><i class="icon-glass"></i>&nbsp;&nbsp;公共留言</a></li>

							<li><a href="#" target="mainFrame"><i class="icon-folder-open"></i>&nbsp;&nbsp;文件管理</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#menu" href="#collapse32"><i
						class="icon-chevron-right"></i>&nbsp;&nbsp;栏目设置</a>
				</div>
				<div id="collapse32" class="accordion-body  collapse"
					style="height: 0px;">
					<div class="accordion-inner">
						<ul class="nav nav-list">
							<li><a href="#" target="mainFrame"><i class="icon-align-justify"></i>&nbsp;&nbsp;栏目管理</a></li>

							<li><a href="#" target="mainFrame"><i class="icon-certificate"></i>&nbsp;&nbsp;站点设置</a></li>

							<li><a href="#" target="mainFrame"><i class="icon-retweet"></i>&nbsp;&nbsp;切换站点</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		<!-- right profile -->
        <div class="span9 content-setting">
	        	<iframe id="mainFrame" name="mainFrame" 
	        		src="/admin/user/list" 
	        		style="overflow:visible;"
					scrolling="yes" frameborder="no" 
					width="100%" height="650"></iframe>
        </div>
        </div>
    </div>
       
<!-- 返回顶部-->
<jsp:include page="../utill/backTop.jsp" flush="false"></jsp:include>

<!-- 版权信息 -->
<jsp:include page="../../common/Tail.jsp" flush="false"></jsp:include>    