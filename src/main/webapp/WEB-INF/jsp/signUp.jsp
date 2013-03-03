<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>

<div class="account-container">

	<div class="form-content clearfix">
    
		<form:form action="signUp" method="post" modelAttribute="signUpUserVo">

			
			<h1><i class="iconbig-note-write"></i>注册</h1>	
            
			
			<div class="login-fields">
            
				<div class="field">

					<label for="name">用户名:</label>

					<input type="text" id="name" name="name" value="<c:out value="${signUpUserVo.name}" />" placeholder="昵称" class="login username-field" autocomplete="off" required />
					
					<form:errors path="name" cssClass="alert alert-error"/>
					
				</div> <!-- /field -->
                
                <div class="field">

					<label for="email">邮箱:</label>

					<input type="email" id="email" name="email" value="<c:out value="${signUpUserVo.email}" />" placeholder="邮箱" class="login email-field" autocomplete="off" required />
					
					<form:errors path="email" cssClass="alert alert-error"/>
					
				</div> <!-- /field -->


				<div class="field">

					<label for="password">密码:</label>

					<input type="password" id="password" name="password" value="<c:out value="${requestScope.signUpUserVo.password}" />" placeholder="密码" class="login password-field" autocomplete="off" required />
					
					<form:errors path="password"  cssClass="alert alert-error"/>
					
				</div> <!-- /password -->
				
				<div class="field">

					<label for="passwordRe">确认密码:</label>

					<input type="password" id="passwordRe" name="passwordRe" value="<c:out value="${signUpUserVo.passwordRe}" />" placeholder="确认密码" class="login password-field" autocomplete="off" required />

					<form:errors path=""  cssClass="alert alert-error"/>
					
				</div> <!-- /password -->
				

			</div> <!-- /login-fields -->			

			<div class="login-actions">

				<input type="submit" name="submit" value="注册" class="btn-signin btn btn-primary" />
                
                <a href="/" class="btn-signin btn">取消</a>
				
			</div> <!-- .actions -->

<!-- 
			<div class="login-social marg10-btm">

				<p>Sign up using social network:</p>

					<a href="#" class="btn"><img src="img/twitter-18.png" /> Signup with twitter</a>

					<a href="#" class="btn"><img src="img/facebook-18.png" /> Signup with facebook</a>			

			</div>
 -->
		</form:form>

	   </div> <!-- /form-content -->

    </div> <!-- /account-container -->

<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    