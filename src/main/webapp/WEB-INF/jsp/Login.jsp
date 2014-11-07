<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
	<title>Connexion</title>
	<script>
		$(document).ready(
				function() {
					$('#navigationBar').hide();
				});
	</script>
</head>

<body >
	<div class="container">		
		<% if(request.getAttribute("wrongCredentialAlert")!=null){
				if((Boolean) request.getAttribute("wrongCredentialAlert")) { %>
			<div id = "wrongCredentialAlert1" class="alert alert-dismissable alert-warning">
				<div id="wrongCredentialAlert2">
	            	<strong>Wrong credentials!</strong> Please, verify your email and password.
	            </div>
			</div>
			<% }} %>
		<br/><br/>
		<div class="row" style="margin: 0; height: 100%;">
			<div class="col-md-12" id ="connectionDiv">
			<form:form commandName="login" method="post">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputEmail3" class="control-label" id="textColorLoginPage">Email</label>
						</div>
						<div class="col-sm-10">
							<form:input type="email" class="form-control" id="inputEmail3" placeholder="Email" path="email"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label" id="textColorLoginPage">Password</label>
						</div>
						<div class="col-sm-10">
							<form:input type="password" class="form-control" id="inputPassword3" placeholder="Password" path="safePassword"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Sign in</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>