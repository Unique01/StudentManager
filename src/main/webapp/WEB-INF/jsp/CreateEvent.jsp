<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Create new event</title>
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
			<h2 class="formTitle">Add a new event</h2>
				<form:form modelAttribute="event" commandName="event"
					method="post">
					<div class="form-group">
						<label class="control-label" for="InputDate">Date</label>
						<form:errors path="date" cssClass="error" />
						<br />
						<form:input id="InputDate" cssClass="datepicker" class="form-control" path="date" />

					</div>
					<div class="form-group">
						<label class="control-label" for="InputDescription">Description</label>
						<form:errors path="description" cssClass="error" />
						<form:input id="InputDescription" class="form-control" 
							path="description" />
					</div>
					<div class="form-group">
						<label class="control-label" for="InputSubject">Subject</label>
						<form:errors path="subject" cssClass="error" />
						<br />
					    <form:select path="subject" id="subjectList">
					        <form:option value="">Select a subject: </form:option>
					        <c:forEach items="${subjects}" var="subject">
					    	    <form:option value="${subject}">${subject}</form:option>
					        </c:forEach>
					    </form:select>
					</div>
			
					<br/>
					<div class="text-right">
						<button type="submit" class="btn btn-success">Submit</button>
						<a href="./ManageEvents"><button type="button" class="btn btn-danger" >Cancel</button></a>		
					</div>										
				</form:form>
				
			</div>
		</div>
	</div>


</body>
</html>