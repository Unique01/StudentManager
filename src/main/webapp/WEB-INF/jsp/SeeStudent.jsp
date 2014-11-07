<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>See student</title>
	</head>
	<body>		
		<br />
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="formTitle">Selected student informations</h2>
					<form:form id ="editClasseForm" modelAttribute="student" 
						method="GET">
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
							<label class="control-label" >Mean</label>
							<label id="Address" class="form-control">${student.mean}</label>
						</div>
						<div class="form-group">
							<label class="control-label" >Birth Date</label>
							<label id="BirthDate" class="form-control">${student.birthDate}</label>
						</div>
						<br/>
						
						<br/><h2 class="formTitle">The events he participated to :</h2><br/>

						<c:forEach items="${student.events}" var="element"> 
							<div id="EventDiv" class="col-md-12">
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
								<div class="col-md-2">
									<label class="control-label" for="InputMark">Mark</label>
									<br />
									<label id="InputMark" class="form-control">${element.mark}</label>
								</div>
							</div>
						</c:forEach>
							
						<br/>
						<div class="text-right">
							<a href="./updateStudent?id=${student.id}"><button type="button" class="btn btn-success" >Modify</button></a>
							<a href="./ManageStudents"><button type="button" class="btn btn-danger" >Back</button></a>		
						</div>										
					</form:form>
					
				</div>
			</div>
		</div>
	</body>
</html>