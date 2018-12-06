<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="homeUrl"></spring:url>
<spring:url value="/signUp" var="signUp"></spring:url>
<div class="login-area">
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="margin-top: 100px;">
				<div class="login-content">
					<h2 class="login-title">Login</h2>
					<p>Hello,Welcome to your account</p>
					<div class="social-sign">
						<a href="#"><i class="fa fa-facebook"></i> Sign in with
							facebook</a> <a class="twitter" href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile&state=profile&redirect_uri=http://localhost:8080/bookReview/login-google&response_type=code
    &client_id=<spring:eval expression="@propertyConfigurer.getProperty('GOOGLE_CLIENT_ID')" />&approval_prompt=force"><i
							class="fa fa-google-plus"></i> Sign in with Google</a>
					</div>

					<form action="<c:url value='j_spring_security_login' />"
						method="POST">
						<c:if test="${msg != null}">
							<div class="alert alert-danger" role="alert">
								<span class="text-center">${msg}</span>
							</div>
						</c:if>
						<label>User name</label> <input type="text" name="username"
							autofocus /> <label>Password</label> <input type="password"
							name="password" />
						<div class="login-lost">
							<span class="log-rem"> <input type="checkbox"
								name="remember-me" /> <label>Remember me!</label> <spring:url
									value="/resetPassword" var="reserPassWord"></spring:url>
							</span> <span class="forgot-login"> <a href="${reserPassWord}">Forgot
									your password?</a>
							</span>
						</div>
						<input class="login-sub" type="submit" value="Login" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</div>
			<div class="col-md-6" style="margin-top: 100px;">
				<div class="login-content login-margin">
					<h2 class="login-title">create a new account</h2>
					<p>Create your own Unicase account.</p>
					
					<form:form id="formSignUp" modelAttribute="userInfo" >
					<div class="alert alert-success" role="alert" hidden>
								<span class="text-center-signup"></span>
							</div>
						<label>Full name (*)</label> <input type="text" name="name" class="fullname" /> 
						<div class="sign-up"><span id="fullname-result"  ></span></div>
							<label>Phone number</label> <input type="number" class="phone" name="phone" />
							<div class="sign-up"><span id="phone-result"  ></span></div>
							<label>Email (*)</label> <input type="text" name="email" class="email" />  
							<div class="sign-up"><span id="email-result"  ></span></div>
							<label>User name (*)</label> <input type="text" name="userName" class="userName" /> 
							<div class="sign-up"><span id="username-result"  ></span></div>
							<label>PassWord (*)</label> <input type="password" name="passWord" class="passWord" />
							<div class="sign-up"><span id="password-result"  ></span></div>
							
							 <input class="login-sub" id="signUp" value="sign up" type="button" />
							 
							 <div class="login-sub" style="float: right;padding-right: 300px;" ><span id="ajax-result"  ></span></div>
						<%-- 	 <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> --%>
							
					</form:form>
					<div class="sign-up-today">
						<h2 class="login-title">sign up today and you'll be able to:</h2>
						<ul>
							<li><span> <i class="fa fa-check-square-o"></i> <span>speed
										your way through the checkout</span>
							</span></li>
							<li><span> <i class="fa fa-check-square-o"></i> <span>track
										your order easily</span>
							</span></li>
							<li><span> <i class="fa fa-check-square-o"></i> <span>keep
										a record of your all purchase</span>
							</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>