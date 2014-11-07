<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>See classe</title>
	</head>
	<body>		
		<br />
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="formTitle">Selected Classe informations</h2>
					<form:form id ="editClasseForm" modelAttribute="classe" 
						method="GET">
						<div class="form-group">
							<label class="control-label" >Name</label>
							<br />
							<label id="Name" class="form-control">${classe.name}</label>
						</div>
						<div class="form-group">
							<label class="control-label">Year</label>
							<label id="Year" class="form-control">${classe.year}</label>
						</div>
						<div class="form-group">
							<label class="control-label" >Address</label>
							<label id="Address" class="form-control">${classe.adress}</label>
						</div>
						
						<br/><h2 class="formTitle">The students of this class :</h2><br/>
						
						<c:forEach items="${classe.students}" var="element"> 
							<div id="StudentDiv" class="col-md-12">
								<div class="col-md-5">
									<label class="control-label" for="InputName">Name</label>
									<br />
									<label id="InputName" class="form-control">${element.name}</label>
								</div>
								<div class="col-md-5">
									<label class="control-label" for="InputSurname">Surname</label>
									<br />
									<label id="InputSurname" class="form-control">${element.surname}</label>
								</div>
								<div class="col-md-2">
									<label class="control-label" for="InputMean">Mean</label>
									<br />
									<label id="InputMean" class="form-control">${element.mean}</label>
								</div>
							</div>
						</c:forEach>
							
						<br/>
						<div class="text-right">
							<a href="./updateClasse?id=${classe.id}"><button type="button" class="btn btn-success" >Modify</button></a>
							<a href="./ManageClasses"><button type="button" class="btn btn-danger" >Back</button></a>		
						</div>										
					</form:form>
					
				</div>
			</div>
		</div>			
	</body>
</html>