<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>


<jsp:include page="../../common/Header.jsp" flush="true"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
                <div class="account-settings">
                	<c:choose>
                	<c:when test="${not empty sessionScope.signInUser.avatar}">
                		<img src="${sessionScope.signInUser.avatar.resId }" id="account_avatar"/>
                	</c:when>
                	<c:otherwise>
                		<img src="<c:url value="/resources/img/gravatar.jpg"/>" id="account_avatar"/>
                	</c:otherwise>
                	</c:choose>
                    
                </div>
                <div class="account-detail">
                    <p><strong>创建时间 :</strong></p>
                    <p>${sessionScope.signInUser.createAt }</p>
                    <p><strong>性别 : </strong></p>
                    <p>${sessionScope.signInUser.gender }</p>
                    <p><strong>联系方式: </strong></p>
                    <p><a href="mailto:${sessionScope.signInUser.email }">${sessionScope.signInUser.email }</a></p>
                    <hr />
                    <p><a href="<c:url value="/account/profiles?accountId=${sessionScope.signInUser.id }"/>">个人账户</a></p>
                </div>
            </div>
            <div class="span9 content-setting">
                <div class="content-settings">
                    <div class="tabbable"> <!-- Only required for left/right tabs -->
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="<c:url value="/account/info"/>">基本信息</a></li>
                        <li><a href="<c:url value="/account/modifyPwd"/>">密码信息</a></li>
                      </ul>
                      
                      <div class="tab-content">
                        <div class="tab-pane active" >
                          
                          <form:form class="form-horizontal" action="${ctx}/account/info" method="post" modelAttribute="userInfoVo">
                          
                            <div class="control-group">
                              <label class="control-label">用户名</label>
                              <div class="controls">
                                <input type="text" name="name" class="input-xlarge" placeholder="${sessionScope.signInUser.name }">
                                <form:errors path="name"  cssClass="alert alert-error" />
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">邮箱</label>
                              <div class="controls">
                                <input type="email" name="email" class="input-xlarge" placeholder="${sessionScope.signInUser.email }">
                              	<form:errors path="email"  cssClass="alert alert-error" />
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">个人主页</label>
                              <div class="controls">
                                <input type="text" name="blog" class="input-xlarge" placeholder="${sessionScope.signInUser.blog }">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">关于</label>
                              <div class="controls">
                                <textarea class="input-xlarge" name="summary" id="textarea" rows="3" placeholder="在此添加个人说明."></textarea>
                              </div>
                            </div>
                            
                            <div class="control-group" id="account_avatar_div_upload">
                              <label class="control-label">头像:</label>
                              <div class="controls">
                                <a class="btn btn-primary" id="fileInput"  data-toggle="modal" href="#image-cut-modal">上传头像</a>
                              </div>
                            </div>
                            
                            <div class="control-group" id="account_avatar_div" style="display:none;">
                              <label class="control-label">头像:</label>
                              <div class="controls">
                                <img src="" id="account_avatar_img">
                                <input type="hidden" value="" name="avatalrUr" id="avatar_id_hiden">
                              </div>
                            </div>
                            
                            <div class="form-actions">
                                <input type="submit" name="submit" value="保存" class="btn btn-primary btn-large" />
                            </div>
                            
                        </form:form>
                        </div>
                        </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>

<!-- 脚本文件 -->
<jsp:include page="../../common/Script.jsp" flush="true"></jsp:include>  

<!-- 头像上传节点 -->
<jsp:include page="./avatar/avatarUpload.jsp" flush="true"></jsp:include>

<!-- 版权信息 -->
<jsp:include page="../../common/Tail.jsp" flush="true"></jsp:include>