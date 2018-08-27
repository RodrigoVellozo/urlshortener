<!DOCTYPE html> 
<html> 
<head> 
	<title>BROU</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta name="viewport" content="width=device-width, initial-scale=1" /> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" /> 
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
	<script type="text/javascript" src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head> 
<body> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	

	<div data-role="page" id="page1"> 
		<div data-role="header"> 
			<h1>rengised a ton m'I - a URL shortener</h1> 
			 <a href="home">Shortener URL's!!!</a>
		</div> 
		
	
			<h2>${txt}</h2>
			<hr>
				
		<div align="center">
			<img src="img/shortinho.png"/>
		</div>
		
		<div>
			<form action="update.htm" method="post">
				<div data-role="fieldcontain">
					<div align="center">
					<input type="hidden" name="id" value="${u2.id }">
					<input  type="text" name="longurl" id="url" data-clear-btn="true" required="required" value="${u2.longurl }"/><br><br>
					<input type="submit" value="ToShorten!!!" id="btn1"/>
					</div>
				</div>
			</form>
		</div>
		${msg }


		
		
		




	</div> 
</body> 
</html>