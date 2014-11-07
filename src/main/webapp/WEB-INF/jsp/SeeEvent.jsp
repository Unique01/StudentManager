<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>See event</title>
	</head>
	<body>		
		<br />
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="formTitle">Selected Event informations</h2>
					<form:form id ="editClasseForm" modelAttribute="event" 
						method="GET">
						<div class="form-group">
							<label class="control-label" >Date</label>
							<br />
							<label id="Date" class="form-control">${event.date}</label>
						</div>
						<div class="form-group">
							<label class="control-label">Description</label>
							<label id="Description" class="form-control">${event.description}</label>
						</div>
						<div class="form-group">
							<label class="control-label" >Subject</label>
							<label id="Subject" class="form-control">${event.subject}</label>
						</div>
						
						<br/><h2 class="formTitle">Classes associated to this event :</h2><br/>
						
						<c:forEach items="${event.classes}" var="element"> 
							<div id="StudentDiv" class="col-md-12">
								<div class="col-md-4">
									<label class="control-label" for="InputName">Name</label>
									<br />
									<label id="InputName" class="form-control">${element.name}</label>
								</div>
								<div class="col-md-5">
									<label class="control-label" for="InputAddress">Address</label>
									<br />
									<label id="InputAddress" class="form-control">${element.adress}</label>
								</div>
								<div class="col-md-3">
									<label class="control-label" for="InputYear">Year</label>
									<br />
									<label id="InputYear" class="form-control">${element.year}</label>
								</div>
							</div>
						</c:forEach>
							
						<br/>
						<div class="text-right">
							<a href="./updateEvent?id=${event.id}"><button type="button" class="btn btn-success" >Modify</button></a>
							<a href="./ManageEvents"><button type="button" class="btn btn-danger" >Back</button></a>		
						</div>										
					</form:form>	
				</div>
			</div>
		</div>			
	</body>
</html>