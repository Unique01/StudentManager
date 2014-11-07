<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Set marks</title>
	</head>
	<body>
		<div class="container">
		<div class="row">
			<div class="col-md-12">			
				<h2 id="tableTitle">Set marks associated to the following events :<br><br></h2><br/>
				<form:form modelAttribute="student" method="post">
					<c:forEach items="${student.events}" var="element" varStatus="status"> 
						<fieldset class="EventFieldset">
						<legend>Event ${status.index +1}</legend>
							<div id="SetEventUpperDiv" class="col-md-12">
								<div class="col-md-4">
									<label class="control-label" for="InputDescription">Description</label>
									<br />
									<label id="InputDescription" class="form-control">${element.description}</label>
								</div>
								<div class="col-md-3">
									<label class="control-label" for="InputSubject">Subject</label>
									<br />
									<label id="InputSubject" class="form-control">${element.subject}</label>
								</div>
								<div class="col-md-3">
									<label class="control-label" for="InputDate">Date</label>
									<br />
									<label id="InputDate" class="form-control">${element.date}</label>
								</div>
							</div>
							<div id="SetEventLowerDiv" class="col-md-12">
								<div class="col-md-6">
									<label class="control-label" for="InputMark">Mark</label>
									<br />
									<input id="InputMark${element.id}" name="marks" class="form-control" />
								</div>
							</div>
						</fieldset>
					</c:forEach>
					
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