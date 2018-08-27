<!DOCTYPE html> 
<html> 
<head> 
	<title>BROU</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta name="viewport" content="width=device-width, initial-scale=1" /> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" /> 
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
	<script type="text/javascript" src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script> 
	

</head> 
<body> 
	<div data-role="page" id="page1">
		<div data-role="header">
			<h1>rengised a ton m'I - a URL shortener</h1>
			<a href="listar.htm">Listar URL's</a>
		</div>

		<div align="center">
			<img id="image-1" alt="shortener!!!" src="img/shortinho.png" />
		</div>
		
		<div data-role="content">
			<form action="gravar.htm" method="post">
				<div data-role="fieldcontain">
					<div align="center">
					<input  type="text" name="longurl" id="url" data-clear-btn="true" required="required" /><br><br>
					<input type="submit" value="ToShorten!!!" id="btn1"/>
					</div>
				</div>
			</form>
		</div>
		${msg }


 
	</div> 
</body> 
</html>