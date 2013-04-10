<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     
<c:set var="ctx" value="${pageContext.request.contextPath }"/>


<jsp:include page="../../common/Header.jsp" flush="false"></jsp:include>

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
                        <li><a href="<c:url value="/account/info"/>" >基本信息</a></li>
                        <li class="active"><a href="<c:url value="/account/modifyPwd"/>">密码信息</a></li>
                      </ul>
                      
                      <div class="tab-content">
                        <div class="tab-pane active"><!-- Profile -->  
                          
                          <form:form  class="form-horizontal" action="${ctx}/account/modifyPwd" method="post" modelAttribute="pwdvo">
                          
                            <div class="control-group">
                              <label class="control-label">旧密码</label>
                              <div class="controls">
                                <input type="password" name="oldpwd" id="oldpwd" value="<c:out value="${pwdvo.oldpwd}" />" class="input-xlarge" autocomplete="off" required>
                                 <form:errors path="oldpwd"  cssClass="alert alert-error" />
                              </div>
                             
                            </div>
                            
                            <div class="control-group">
                              <label class="control-label">新密码</label>
                              <div class="controls">
                                <input type="password" name="newpwd" id="newpwd" value="<c:out value="${pwdvo.newpwd}" />"  class="input-xlarge" autocomplete="off" required>
                                <form:errors path="newpwd"  cssClass="alert alert-error"/>
                              </div>
                              
                            </div>
                            
                            <div class="control-group">
                              <label class="control-label">确认新密码</label>
                              <div class="controls">
                                <input type="password" name="renewpwd" id="renewpwd"  value="<c:out value="${pwdvo.renewpwd}" />" class="input-xlarge" autocomplete="off" required>
                                <form:errors path="renewpwd"  cssClass="alert alert-error"/>
                              </div>
                              
                            </div>
                            
                            <div class="form-actions">
                                <input type="submit" name="submit" value="提交" class="btn btn-primary btn-large" />
                            </div>
                          </form:form>
                        </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>    
     	</div>
</div>

<jsp:include page="../../common/Script.jsp" flush="true"></jsp:include>
<jsp:include page="../../common/Tail.jsp" flush="true"></jsp:include>    