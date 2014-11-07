<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add students to a class</title>
		<script type="text/javascript">		
			jQuery.fn.multiselect = function() {
			    $(this).each(function() {
			        var checkboxes = $(this).find("input:checkbox");
			        checkboxes.each(function() {
			            var checkbox = $(this);
			            // Highlight pre-selected checkboxes
			            if (checkbox.prop("checked"))
			                checkbox.parent().addClass("multiselect-on");
			 
			            // Highlight checkboxes that the user selects
			            checkbox.click(function() {
			                if (checkbox.prop("checked"))
			                    checkbox.parent().addClass("multiselect-on");
			                else
			                    checkbox.parent().removeClass("multiselect-on");
			            });
			        });
			    });
			};		
			
			$(function() {
			     $(".multiselect").multiselect();
			});
		</script>		
	</head>
	<body>
		<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h2 class="formTitle">Selected Student informations</h2>
				<form:form modelAttribute="student" method="post">
						<div class="form-group">
							<label class="control-label" >Name</label>
							<br />
							<label id="Name" class="form-control">${student.name}</label>
						</div>
						<div class="form-group">
							<label class="control-label">Surname</label>
							<label id="Surname" class="form-control">${student.surname}</label>
						</div>
						<div class="form-group">
							<label class="control-label" >BirthDate</label>
							<label id="BirthDate" class="form-control">${student.birthDate}</label>
						</div>									
				</form:form>
				
				<h2 id="tableTitle">Add events to the selected student :<br><br></h2><br/>
				<form:form modelAttribute="studentList" method="post">
					<div class="multiselect">
						<c:forEach items="${eventList}" var="element"> 
							<label><input type="checkbox" name="eventsToAssociate" value="${element.id}" />${element.toString()}</label>
						</c:forEach>					
					</div>
					
					<br/>
					<div class="text-right">
						<button type="submit" class="btn btn-success" >Submit</button>
						<a href="./ManageStudents"><button type="button" class="btn btn-danger" >Back</button></a>		
					</div>	
				</form:form>
				
				</div>
			</div>
		</div>	
	</body>
</html>