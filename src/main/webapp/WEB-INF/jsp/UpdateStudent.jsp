<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Edit student</title>
		<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<script>
		$(document).ready(function() {
		    $('.datepicker').datepicker();
		});
		</script>
	</head>
	<body>		
		<br />
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="formTitle">Edit the selected student</h2>
					<form:form id ="editClasseForm" modelAttribute="student" commandName="student"
						method="post">
						<div class="form-group">
							<label class="control-label" for="InputName">Name</label>
							<form:errors path="name" cssClass="error" />
							<br />
							<form:input id="InputName" class="form-control"  path="name" />
						</div>
						<div class="form-group">
							<label class="control-label" for="InputYear">Surname</label>
							<form:errors path="surname" cssClass="error" />
							<form:input id="InputSurname" class="form-control" 
								path="surname" />
						</div>
						<div class="form-group">
							<label class="control-label" for="InputAdress">Birth Date</label>
							<form:errors path="birthDate" cssClass="error" />
							<br />
							<form:input id="InputBirthDate" cssClass="datepicker" class="form-control" path="birthDate" />
						</div>
							
						<br/>
						<div class="text-right">
							<button type="submit" class="btn btn-success" >Update</button>
							<a href="./ManageStudents"><button type="button" class="btn btn-danger" >Cancel</button></a>		
						</div>										
					</form:form>
					
				</div>
			</div>
		</div>		
	</body>
</html>