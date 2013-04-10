<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../../common/Header.jsp" flush="true"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
                <div class="account-settings">
                    <img src="<c:url value="/resources/ img/gravatar.jpg"/>" />
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
                          <form class="form-horizontal" action="<c:url value="/account/info"/>" method="post">
                            
                            <div class="control-group">
                              <label class="control-label">登陆名</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" placeholder="John Doe">
                              </div>
                            </div>
                            
                            <div class="control-group">
                              <label class="control-label">用户名</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" placeholder="johndoe">
                                <p class="help-block">个人博客 : fanger.cloudfoundry.com</p>
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">邮箱</label>
                              <div class="controls">
                                <input type="email" class="input-xlarge" placeholder="shou@gmail.com">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">个人主页</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" placeholder="shou.com">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">关于</label>
                              <div class="controls">
                                <textarea class="input-xlarge" id="textarea" rows="3">在此添加个人说明.</textarea>
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">头像</label>
                              <div class="controls">
                                <input class="input-file" id="fileInput" type="file">
                              </div>
                            </div>
                            <div class="form-actions">
                                <input type="submit" name="submit" value="保存" class="btn btn-primary btn-large" />
                            </div>
                        </form>
                        </div>
                        </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../../common/Script.jsp" flush="true"></jsp:include>
<jsp:include page="../../common/Tail.jsp" flush="true"></jsp:include>    