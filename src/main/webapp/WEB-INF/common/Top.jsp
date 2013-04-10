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
          
          <a class="brand" href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo.gif"/>"></a>
          <div class="nav-collapse">
            <ul class="nav">
			  <li class="divider-vertical"></li>
              <li><a href="<c:url value="/account/list"/>">乐享先锋</a></li>
			  <li class="divider-vertical"></li>
              <li><a href="<c:url value="/resources/spot/FANGERAND.apk"/>" class="brand" ><img alt="app" src="<c:url value="/resources/img/android.jpg"/>" height="40"></a></li>
			  <li class="divider-vertical"></li>
            </ul>
            <ul class="nav pull-right">
            <li class="divider-vertical"></li>
            
            
            <c:choose>
            <c:when test="${empty sessionScope.signInUser}">
            	<li><a href="<c:url value="/signIn"/>"><i class="icon-lock"></i>登陆</a></li>
	            <li class="divider-vertical"></li>
	            <li><a href="<c:url value="/signUp"/>"><i class="icon-edit"></i>注册</a></li>
	            <li class="divider-vertical"></li>
	            <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">关于 <b class="caret"></b></a>
		            <ul class="dropdown-menu">
		                <li><a href="#">开发进度</a></li>
		                <li><a href="https://github.com/cncduLee" target="_blank">博客</a></li>
		                <li><a href="#">关于</a></li>
		                <li class="divider"></li>
		                <li><a href="#">帮助</a></li>
		                <li><a href="#">反馈</a></li>
	              	</ul>
            	</li>
            </c:when>
            <c:otherwise>
            	<li class="gravatar"><a href="<c:url value="/account/profiles?accountId=${sessionScope.signInUser.id}" />"></a></li>
            	<li class="divider-vertical"></li>
	            <li><a href="<c:url value="/spot/create" />">我要分享</a>
	            <li class="divider-vertical"></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.signInUser.name} <b class="caret"></b></a>
	              <ul class="dropdown-menu">
	                <li><a href="<c:url value="/account/info"/>"><i class="icon-user"></i>账户设置</a></li>
	                <li class="divider"></li>
	                <li><a href="<c:url value="/account/modifyPwd"/>"><i class="icon-user"></i>修改密码</a></li>
	                <li class="divider"></li>
	                
	                <li><a href="<c:url value="/signOut"/>"><i class="icon-off"></i>登出</a></li>
	              </ul>
	            </li>
            </c:otherwise>
            </c:choose>
            
            <li class="divider-vertical"></li>
          </ul>
          </div>
        </div>
      </div>
    </div>