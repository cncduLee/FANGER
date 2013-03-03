<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>
 <div class="account-container btm10">

	<div class="form-content clearfix">
    
		<form action="./" method="post">

			<h1><i class="iconbig-lock"></i> Sign In</h1>	
            
			<div class="login-fields">
            
				<p>Sign in using your registered account:</p>
                
				<div class="field">

					<label for="username">Username:</label>

					<input type="text" id="username" name="username" value="" placeholder="Username" class="login username-field" required />

				</div> <!-- /field -->

				<div class="field">

					<label for="password">Password:</label>

					<input type="password" id="password" name="password" value="" placeholder="Password" class="login password-field" required />

				</div> <!-- /password -->

			</div> <!-- /login-fields -->			

			<div class="login-actions">

				<span class="login-checkbox">

					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />

					<label class="choice" for="Field">Keep me signed in</label>

				</span>

				<input type="submit" name="submit" value="Sign in" class="btn-signin btn btn-primary" />
                <a href="#" class="btn-signin btn">Cancel</a>
                

			</div> <!-- .actions -->


			<div class="login-social marg10-btm">

				<p>Sign in using social network:</p>

					<a href="#" class="btn"><img src="img/twitter-18.png" /> Signin with twitter</a>

					<a href="#" class="btn"><img src="img/facebook-18.png" /> Signin with facebook</a>			

			</div>
            
            <p><a href="#">Forgot your password ?</a></p>

		  </form>

	   </div> <!-- /form-content -->

    </div> <!-- /account-container -->

<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    