<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../../common/Header.jsp" flush="true"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="span3 right-sidebar">
                <div class="account-settings">
                    <img src="<c:url value="/resources/ img/gravatar.jpg"/>" />
                </div>
                <div class="account-detail">
                    <p><strong>最近登陆时间 :</strong></p>
                    <p>3 周 前</p>
                    <p><strong>地址 : </strong></p>
                    <p>成都</p>
                    <p><strong>博客 : </strong></p>
                    <p><a href="#">http://johndoe.com</a></p>
                    <hr />
                    <p><a href="profile.html">个人账户</a></p>
                </div>
            </div>
            
            
            <div class="span9 content-setting">
                <div class="content-settings">
                    <div class="tabbable"> <!-- Only required for left/right tabs -->
                      
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="#profile" data-toggle="tab">他/她身边的故事</a></li>
                        <li><a href="#groupInfo" data-toggle="tab">他/她的圈子</a></li>
                      </ul>
                      
                      <div class="tab-content">
                        <div class="tab-pane active" id="profile"><!-- Profile -->
                          	
                          	<!-- 在此填入相关分享内容 -->
                          	<h3>在此填入相关分享内容</h3>
                          	
                          </div>
                        
                        <div class="tab-pane" id="groupInfo"><!-- Password -->
                            <!-- 在此填入相关分享内容 -->
                          	<h3>在此填入相关分享内容</h3>
                          	
      	               </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>
    </div>

<jsp:include page="../../common/Tail.jsp" flush="true"></jsp:include>    