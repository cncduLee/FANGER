<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

 <!-- begain of search bar -->
      <div class="container">
      <div class="navbar">
      <div class="navbar-inner">
        <div class="container-fluid">
          
          <div class="nav-collapse">
            <ul class="nav">
              <li><a href="#">乐享搜索：</a></li>
              <li class="divider-vertical"></li>
              <!-- 搜索栏 -->
              <form class="navbar-search pull-left search-box" action="" method="get">
					<input class="search-query search-input span3" name="keyword" type="text" placeholder="请输入想要搜索的关键词..." value=""/>
					<i class="icon-search p-a" style="right: 5px; top: 7px;"></i>
              </form>
              <li class="divider-vertical"></li>
            </ul>
            <ul class="nav pull-right">
            <li class="divider-vertical"></li>
            <li>
            	<div class="span2 view-t">
		            <button class="btn wf <c:if test="${param.viewType eq 'wf'}">active</c:if>" data-href="<c:url value="/" />" data-original-title="瀑布布局" rel="tooltip" ><i class="icon-th"></i></button>
		            <button class="btn mv <c:if test="${param.viewType eq 'map'}">active</c:if>" data-href="<c:url value="/map" />" data-original-title="地图布局" rel="tooltip"><i class="icon-map-marker"></i></button>
	            </div>
            </li>
            <li class="divider-vertical"></li>
          </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    </div>
    
    <script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <!-- end of search bar -->
    <script type="text/javascript">
    $('.view-t button').click(function(){
		var href = $(this).attr('data-href');
		window.location.href= href;
	});
    </script>