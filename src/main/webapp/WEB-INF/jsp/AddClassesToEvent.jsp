<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add classes to an event</title>
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
			<h2 class="formTitle">Selected Event informations</h2>
				<form:form modelAttribute="event" method="post">
						<div class="form-group">
							<label class="control-label" >Description</label>
							<br />
							<label id="Description" class="form-control">${event.description}</label>
						</div>
						<div class="form-group">
							<label class="control-label">Subject</label>
							<label id="Subject" class="form-control">${event.subject}</label>
						</div>
						<div class="form-group">
							<label class="control-label" >Date</label>
							<label id="Date" class="form-control">${event.date}</label>
						</div>									
				</form:form>
				
				<h2 id="tableTitle">Add classes to the selected event :<br><br></h2><br/>
				<form:form modelAttribute="classeList" method="post">
					<div class="multiselect">
						<c:forEach items="${classeList}" var="element"> 
							<label><input type="checkbox" name="classesToAssociate" value="${element.id}" />${element.toString()}</label>
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