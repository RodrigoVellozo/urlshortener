<!DOCTYPE html> 
<html> 
<head> 
	<title>BROU</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta name="viewport" content="width=device-width, initial-scale=1" /> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" /> 
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
	<script type="text/javascript" src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script> 
	
	<script type="text/javascript"  src="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"></script>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<style type="text/css">
.movie-list thead th, .movie-list tbody th .ui-table-cell-label,
	.movie-list tbody td .ui-table-cell-label {
	text-transform: uppercase;
	font-size: .7em;
	color: rgba(0, 0, 0, 0.5);
	font-weight: normal;
}
/* White bg, large blue text for rank and title */
.movie-list tbody th {
	font-size: 1.2em;
	background-color: #fff;
	color: #77bbff;
	text-align: center;
}
/*  Add a bit of extra left padding for the title */
.movie-list tbody td.title {
	padding-left: .8em;
}
/*  Custom stacked styles for mobile sizes */
/*  Use a max-width media query so we don't have to undo these styles */
@media ( max-width : 40em) {
	/*  Negate the margin between sections */
	.movie-list tbody th {
		margin-top: 0;
		text-align: left;
	}
	/*  White bg, large blue text for rank and title */
	.movie-list tbody th, .movie-list tbody td.title {
		display: block;
		font-size: 1.2em;
		line-height: 110%;
		padding: .5em .5em;
		background-color: #fff;
		color: #77bbff;
		-moz-box-shadow: 0 1px 6px rgba(0, 0, 0, .1);
		-webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, .1);
		box-shadow: 0 1px 6px rgba(0, 0, 0, .1);
	}
	/*  Hide labels for rank and title */
	.movie-list tbody th .ui-table-cell-label, .movie-list tbody td.title .ui-table-cell-label
		{
		display: none;
	}
	/*  Position the title next to the rank, pad to the left */
	.movie-list tbody td.title {
		margin-top: -2.1em;
		padding-left: 2.2em;
		border-bottom: 1px solid rgba(0, 0, 0, .15);
	}
	/*  Make the data bold */
	.movie-list th, .movie-list td {
		font-weight: bold;
	}
	/* Make the label elements a percentage width */
	.movie-list td .ui-table-cell-label, .movie-list th .ui-table-cell-label
		{
		min-width: 20%;
	}
}
/* Media query to show as a standard table at wider widths */
@media ( min-width : 40em ) {
	/* Show the table header rows */
	.movie-list td, .movie-list th, .movie-list tbody th, .movie-list tbody td,
		.movie-list thead td, .movie-list thead th {
		display: table-cell;
		margin: 0;
	}
	/* Hide the labels in each cell */
	.movie-list td .ui-table-cell-label, .movie-list th .ui-table-cell-label
		{
		display: none;
	}
}
/* Hack to make IE9 and WP7.5 treat cells like block level elements */
/* Applied in a max-width media query up to the table layout breakpoint so we don't need to negate this */
@media ( max-width : 40em ) {
	.movie-list td, .movie-list th {
		width: 100%;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
		box-sizing: border-box;
		float: left;
		clear: left;
	}
}
</style>

</head> 
<body> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div data-role="page" id="page1"> 
		<div data-role="header"> 
			<h1>rengised a ton m'I - a URL shortener</h1> 
			 <a href="home">Shortener URL's!!!</a>
		</div> 
		
			<div>
			 <table data-role="table" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive" data-column-btn-theme="b" data-column-btn-text="Columns to display..." data-column-popup-theme="a" >
				 <thead align="center">
					 <tr>
						 <th data-priority="1">URL</th>
						 <th data-priority="2">URL Shortned</th>
						 <th data-priority="3">UPDATE</th>
						 <th data-priority="4">DELETE</th>
					 </tr>
				 </thead>
				 <tbody>
				<c:forEach items="${lista }" var="linha">
					 <tr>
						 <td>${linha.longurl }</td>
						 <td>${linha.shorturl }</td>
						 <td><a class="btn btn-danger" href="edit.htm?id=${linha.id }" >EDIT</a></td>
						 <td><a class="btn btn-primary" href="delete.htm?id=${linha.id }" onclick="return confirm('Confirma a exclusão desta URL?')"  >DELETE</a></td>
					 </tr>
				</c:forEach>
				 </tbody>
			 </table>
			</div>
	</div> 
		
		






</body> 
</html>