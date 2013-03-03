<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
                <div class="account-settings">
                    <img src="img/gravatar.jpg" />
                </div>
                <div class="account-detail">
                    <p><strong>Sign up :</strong></p>
                    <p>3 weeks a go</p>
                    <p><strong>Location : </strong></p>
                    <p>California</p>
                    <p><strong>Website : </strong></p>
                    <p><a href="#">http://johndoe.com</a></p>
                    <hr />
                    <p><a href="profile.html">View Public Profile</a></p>
                </div>
            </div>
            <div class="span9 content-setting">
                <div class="content-settings">
                    <div class="tabbable"> <!-- Only required for left/right tabs -->
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="#profile" data-toggle="tab">Profile</a></li>
                        <li><a href="#password" data-toggle="tab">Password</a></li>
                      </ul>
                      <div class="tab-content">
                        <div class="tab-pane active" id="profile"><!-- Profile -->
                          <form class="form-horizontal">
                            <div class="control-group">
                              <label class="control-label">Your Name</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" value="John Doe">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">Username</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" value="johndoe">
                                <p class="help-block">Your Public Profile : http://yourdomain.com/profile/johndoe</p>
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">Email</label>
                              <div class="controls">
                                <input type="email" class="input-xlarge" value="johndoe@domain.com">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">Website</label>
                              <div class="controls">
                                <input type="text" class="input-xlarge" value="johndoe.com">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">About</label>
                              <div class="controls">
                                <textarea class="input-xlarge" id="textarea" rows="3">Lorem ipsum dolor sit amet.</textarea>
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">Avatar</label>
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
                              <label class="control-label">Enter Old Password</label>
                              <div class="controls">
                                <input type="password" class="input-xlarge">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">Enter New Password</label>
                              <div class="controls">
                                <input type="password" class="input-xlarge">
                              </div>
                            </div>
                            <div class="control-group">
                              <label class="control-label">Confirm New Password</label>
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

<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    