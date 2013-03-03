<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          
          <a class="brand" href="、"><img src="<c:url value="/resources/img/logo.png"/>"></a>
          <div class="nav-collapse">
            <ul class="nav">
			  <li class="divider-vertical"></li>
              <li><a href="#">关键词:</a></li>
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
            
            
            <c:choose>
            <c:when test="${empty signInUser}">
            	<li><a href="signIn"><i class="icon-lock"></i>登陆</a></li>
	            <li class="divider-vertical"></li>
	            <li><a href="signUp"><i class="icon-edit"></i>注册</a></li>
	            <li class="divider-vertical"></li>
	            <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">关于 <b class="caret"></b></a>
		            <ul class="dropdown-menu">
		                <li><a href="#">开发进度</a></li>
		                <li><a href="#">博客</a></li>
		                <li><a href="#">关于</a></li>
		                <li class="divider"></li>
		                <li><a href="#">帮助</a></li>
		                <li><a href="#">反馈</a></li>
	              	</ul>
            	</li>
            </c:when>
            <c:otherwise>
            	<li class="gravatar"><a href="profile"></a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">John Doe <b class="caret"></b></a>
	              <ul class="dropdown-menu">
	                <li><a href="account_setting.html"><i class="icon-user"></i>账户设置</a></li>
	                <li class="divider"></li>
	                <li><a href="signin.html"><i class="icon-off"></i>登出</a></li>
	              </ul>
	            </li>
            </c:otherwise>
            </c:choose>
            
            <li class="divider-vertical"></li>
          </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div> 