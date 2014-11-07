<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title>Manage Classes</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
		<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
		
		<script type="text/javascript">		
		$(document).ready(function() {
		     
		    $("#studentTable").dataTable( {
		        "bProcessing": false,
		        "bServerSide": false,
		        "sort": "position",
		        "sAjaxSource": "springPaginationDataTablesStudents.web",
		        "aoColumns": [
		            { "mData": "name" },
		            { "mData": "surname" },
		            { "mData": "mean" },
		            { "mData": "birthDate" },
		            {
		            	bSortable: false,
		                mRender: function (data, type, row) { 
		                	var edit = "<a class='glyphicon glyphicon-list-alt' href='updateStudent?id=" + row.id + "'></a>";
		                	var associateEvents = "<a class='glyphicon glyphicon-user' href='addEventsToStudent?id=" + row.id + "'></a>";
		                	var see = "<a class='glyphicon glyphicon-search' href='seeStudent?id=" + row.id + "'></a>";
		                	var setEventMark = "<a class='glyphicon glyphicon-pencil' href='setEventMark?id=" + row.id + "'></a>";
		                	var del = "<a class='glyphicon glyphicon-trash' href='deleteStudent?id=" + row.id  + "' onclick=\"return confirm('Are you sure you want to delete this student?')\"></a>";                	
		             		
		                	return edit + " / " + associateEvents + " / " + see +  " / " + setEventMark + " / "+ del; 
		                }
		        
                    }
		        ]
		    } ); 
		
		} );
		
		</script>		
	</head>
	
	<body>				
		<div class="container">
			<% if(request.getAttribute("studentAddedAlert")!=null){
				if((Boolean) request.getAttribute("studentAddedAlert")) { %>
			<div id = "studentAdded1" class="alert alert-dismissable alert-success">
				<div id="studentAdded2">
	            	<strong>Well done!</strong> You successfully added a student.
	            </div>
			</div>
			<% }} %>
			
			<% if(request.getAttribute("studentUpdatedAlert")!=null){
				if((Boolean) request.getAttribute("studentUpdatedAlert")) { %>
			<div id = "studentUpdated1" class="alert alert-dismissable alert-success">
				<div id="studentUpdated2">
	            	<strong>Well done!</strong> You successfully updated your student.
	            </div>
			</div>
			<% }} %>
			
			<% if(request.getAttribute("eventsAddedAlert")!=null){
				if((Boolean) request.getAttribute("eventsAddedAlert")) { %>
			<div id = "eventsAddedAlert1" class="alert alert-dismissable alert-success">
				<div id="eventsAddedAlert2">
	            	<strong>Well done!</strong> You successfully associated events to your student.
	            </div>
			</div>
			<% }} %>
					
				<form:form action="" method="GET">
					<h2 id="tableTitle">My list of students<br><br></h2><br/>
					<a href="./createStudent"><button type="button" >Add a student</button></a>
					
					<table class ="homeTable" width="100%" style="border: 3px; background: rgb(243, 244, 248);"><tr><td>
					    <table id="studentTable" class="display" cellspacing="0" width="100%">
					        <thead>
					            <tr>
					                <th>Name</th>
					                <th>Surname</th>
					                <th>Mean</th>
					                <th>Birth Date</th>
					                <th>Modify / Associate events / See / SetMarks / Delete</th>
					            </tr>
					        </thead>     
					    </table>
					    </td></tr></table>
				</form:form>
			</div>
	</body>
</html>


