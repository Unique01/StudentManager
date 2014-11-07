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
		     
		    $("#classeTable").dataTable( {
		        "bProcessing": false,
		        "bServerSide": false,
		        "sort": "position",
		        "sAjaxSource": "springPaginationDataTablesClasses.web",
		        "aoColumns": [
		            { "mData": "name" },
		            { "mData": "year" },
		            { "mData": "adress" },
		            {
		            	bSortable: false,
		                mRender: function (data, type, row) { 
		                	var edit = "<a class='glyphicon glyphicon-list-alt' href='updateClasse?id=" + row.id + "'></a>";
		                	var associateStudent = "<a class='glyphicon glyphicon-user' href='addStudentsToClasse?id=" + row.id + "'></a>";
		                	var see = "<a class='glyphicon glyphicon-search' href='seeClasse?id=" + row.id + "'></a>";
		                	var del = "<a class='glyphicon glyphicon-trash' href='deleteClasse?id=" + row.id  + "' onclick=\"return confirm('Are you sure you want to delete this class?')\"></a>";                	
		             		
		                	return edit + " / " + associateStudent + " / " + see + " / "+ del; 
		                }
		        
                    }
		        ]
		    } ); 
		
		} );
		
		</script>		
	</head>
	
	<body>				
		<div class="container">
			<% if(request.getAttribute("classeAddedAlert")!=null){
				if((Boolean) request.getAttribute("classeAddedAlert")) { %>
			<div id = "classeAdded1" class="alert alert-dismissable alert-success">
				<div id="classeAdded2">
	            	<strong>Well done!</strong> You successfully added a class.
	            </div>
			</div>
			<% }} %>
			
			<% if(request.getAttribute("classeUpdatedAlert")!=null){
				if((Boolean) request.getAttribute("classeUpdatedAlert")) { %>
			<div id = "classeUpdated1" class="alert alert-dismissable alert-success">
				<div id="classeUpdated2">
	            	<strong>Well done!</strong> You successfully updated your class.
	            </div>
			</div>
			<% }} %>
			
			<% if(request.getAttribute("studentsAddedAlert")!=null){
				if((Boolean) request.getAttribute("studentsAddedAlert")) { %>
			<div id = "studentsAdded1" class="alert alert-dismissable alert-success">
				<div id="studentsAdded2">
	            	<strong>Well done!</strong> You successfully added students to your class.
	            </div>
			</div>
			<% }} %>
					
				<form:form action="" method="GET">
					<h2 id="tableTitle">My list of classes<br><br></h2><br/>
					<a href="./createClasse"><button type="button" >Add a class</button></a>
					
					<table class ="homeTable" width="100%" style="border: 3px; background: rgb(243, 244, 248);"><tr><td>
					    <table id="classeTable" class="display" cellspacing="0" width="100%">
					        <thead>
					            <tr>
					                <th>Name</th>
					                <th>Year</th>
					                <th>Address</th>
					                <th>Modify / Associate students / See / Delete</th>
					            </tr>
					        </thead>     
					    </table>
					    </td></tr></table>
				</form:form>
			</div>
	</body>
</html>


