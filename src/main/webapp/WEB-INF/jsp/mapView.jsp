<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>

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
            <li><button class="btn wf"   data-href="<c:url value="/"/>" data-original-title="瀑布布局" rel="tooltip" ><i class="icon-th"></i></button></li>
            <li class="divider-vertical"></li>
            <li><button class="btn mv active" data-href="<c:url value="/"/>" data-original-title="地图布局" rel="tooltip"><i class="icon-map-marker"></i></button></li>
            <li class="divider-vertical"></li>
          </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    </div>
    <!-- end of search bar -->


<jsp:include page="/WEB-INF/jsp/utill/mapScript.jsp" flush="true"></jsp:include>
<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    