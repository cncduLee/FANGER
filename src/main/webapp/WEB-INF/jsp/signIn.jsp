<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>
 <div class="account-container btm10">

	<div class="form-content clearfix">
    
		<form:form action="signIn" modelAttribute="signInVo" method="post">

			<h1><i class="iconbig-lock"></i>登陆</h1>	
            
			<div class="login-fields">
                
				<div class="field">

					<label for="username">用户名:</label>

					<input type="text" id="sname" name="sname" value='<c:out value="${signInVo.sname}"></c:out>' placeholder="注册邮箱号" class="login username-field" required />
					
					<form:errors path="sname" cssClass="alert alert-error"/>
					
				</div> <!-- /field -->

				<div class="field">

					<label for="password">密码:</label>

					<input type="password" id="spassword" name="spassword" value='<c:out value="${signInVo.spassword }"/>' placeholder="密码" class="login password-field" required />
					
					<form:errors path="spassword" cssClass="alert alert-error"/>
						
				</div> <!-- /password -->

			</div> <!-- /login-fields -->			
<!--  -->
			<div class="login-actions">

				<span class="login-checkbox">

					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />

					<label class="choice" for="Field">保持登陆状态</label>

				</span>

				<input type="submit" name="submit" value="登陆" class="btn-signin btn btn-primary" />
                <a href="/" class="btn-signin btn">返回</a>
                

			</div> <!-- .actions -->

<!-- 
			<div class="login-social marg10-btm">

				<p>Sign in using social network:</p>

					<a href="#" class="btn"><img src="img/twitter-18.png" /> Signin with twitter</a>

					<a href="#" class="btn"><img src="img/facebook-18.png" /> Signin with facebook</a>			

			</div>
            
            <p><a href="#">Forgot your password ?</a></p>
 -->
		  </form:form>

	   </div> <!-- /form-content -->

    </div> <!-- /account-container -->

<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    