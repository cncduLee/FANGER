<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../../common/Header.jsp" flush="true"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
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
                        <li class="active"><a href="#profile" data-toggle="tab">基本信息</a></li>
                        <li><a href="#password" data-toggle="tab">密码信息</a></li>
                      </ul>
                      <div class="tab-content">
                        <div class="tab-pane active" id="profile"><!-- Profile -->
                          <form class="form-horizontal">
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
                                <p class="help-block">个人博客 : http://yourdomain.com/profile/johndoe</p>
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">邮箱</label>
                              <div class="controls">
                                <input type="email" class="input-xlarge" placeholder="johndoe@domain.com">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">个人主页</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" placeholder="johndoe.com">
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
                                <input type="submit" name="submit" value="Save Change" class="btn" />
                            </div>
                        </form>
                        </div>
                        
                        <div class="tab-pane" id="password"><!-- Password -->
                          <form class="form-horizontal">
                            <div class="control-group">
                              <label class="control-label">旧密码</label>
                              <div class="controls">
                                <input type="password" class="input-xlarge">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">新密码</label>
                              <div class="controls">
                                <input type="password" class="input-xlarge">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">确认新密码</label>
                              <div class="controls">
                                <input type="password" class="input-xlarge">
                              </div>
                            </div>
                            <div class="form-actions">
                                <input type="submit" name="submit" value="Save Change" class="btn" />
                            </div>
                          </form>
                        </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../../common/Script.jsp" flush="true"></jsp:include>    
<jsp:include page="../../common/Tail.jsp" flush="true"></jsp:include>    