<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title>Manage Events</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
		<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
		
		<script type="text/javascript">		
		$(document).ready(function() {
		     
		    $("#eventTable").dataTable( {
		        "bProcessing": false,
		        "bServerSide": false,
		        "sort": "position",
		        "sAjaxSource": "springPaginationDataTablesEvents.web",
		        "aoColumns": [
		            { "mData": "date" },
		            { "mData": "description" },
		            { "mData": "subject" },
		            {
		            	bSortable: false,
		                mRender: function (data, type, row) { 
		                	var edit = "<a class='glyphicon glyphicon-list-alt' href='updateEvent?id=" + row.id + "'></a>";
		                	var associateClasses = "<a class='glyphicon glyphicon-user' href='addClassesToEvent?id=" + row.id + "'></a>";
		                	var see = "<a class='glyphicon glyphicon-search' href='seeEvent?id=" + row.id + "'></a>";
		                	var del = "<a class='glyphicon glyphicon-trash' href='deleteEvent?id=" + row.id  + "' onclick=\"return confirm('Are you sure you want to delete this event?')\"></a>";                	
		             		
		                	return edit + " / " + associateClasses + " / " + see + " / "+ del; 
		                }
		        
                    }
		        ]
		    } ); 
		
		} );
		
		</script>		
	</head>
	
	<body>				
		<div class="container">
			<% if(request.getAttribute("eventAddedAlert")!=null){
				if((Boolean) request.getAttribute("eventAddedAlert")) { %>
			<div id = "eventAdded1" class="alert alert-dismissable alert-success">
				<div id="eventAdded2">
	            	<strong>Well done!</strong> You successfully added a event.
	            </div>
			</div>
			<% }} %>
			
			<% if(request.getAttribute("eventUpdatedAlert")!=null){
				if((Boolean) request.getAttribute("eventUpdatedAlert")) { %>
			<div id = "eventUpdated1" class="alert alert-dismissable alert-success">
				<div id="eventUpdated2">
	            	<strong>Well done!</strong> You successfully updated your event.
	            </div>
			</div>
			<% }} %>
			
			<% if(request.getAttribute("classesAddedAlert")!=null){
				if((Boolean) request.getAttribute("classesAddedAlert")) { %>
			<div id = "classesAdded1" class="alert alert-dismissable alert-success">
				<div id="classesAdded2">
	            	<strong>Well done!</strong> You successfully associated classes to your event.
	            </div>
			</div>
			<% }} %>
					
				<form:form action="" method="GET">
					<h2 id="tableTitle">My list of events<br><br></h2><br/>
					<a href="./createEvent"><button type="button" >Add an event</button></a>
					
					<table class ="homeTable" width="100%" style="border: 3px; background: rgb(243, 244, 248);"><tr><td>
					    <table id="eventTable" class="display" cellspacing="0" width="100%">
					        <thead>
					            <tr>
					                <th>Date</th>
					                <th>Description</th>
					                <th>Subject</th>
					                <th>Modify / Associate classes / See / Delete</th>
					            </tr>
					        </thead>     
					    </table>
					    </td></tr></table>
				</form:form>
			</div>
	</body>
</html>


