<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Edit classe</title>
	</head>
	<body>		
		<br />
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="formTitle">Edit the selected classe</h2>
					<form:form id ="editClasseForm" modelAttribute="classe" commandName="classe"
						method="post">
						<div class="form-group">
							<label class="control-label" for="InputName">Name</label>
							<form:errors path="name" cssClass="error" />
							<br />
							<form:input id="InputName" class="form-control"  path="name" />
						</div>
						<div class="form-group">
							<label class="control-label" for="InputYear">Year</label>
							<form:errors path="year" cssClass="error" />
							<form:input id="InputYear" class="form-control" 
								path="year" />
						</div>
						<div class="form-group">
							<label class="control-label" for="InputAdress">Address</label>
							<form:errors path="adress" cssClass="error" />
							<br />
							<form:input id="InputAdress" class="form-control" 
								path="adress" />
						</div>
							
						<br/>
						<div class="text-right">
							<button type="submit" class="btn btn-success" >Update</button>
							<a href="./ManageClasses"><button type="button" class="btn btn-danger" >Cancel</button></a>		
						</div>										
					</form:form>
					
				</div>
			</div>
		</div>		
	</body>
</html>