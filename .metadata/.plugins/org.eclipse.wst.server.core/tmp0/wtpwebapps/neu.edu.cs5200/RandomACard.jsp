<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="neu.edu.cs5200.*"%>
<!DOCTYPE html >
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">



<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/round-about.css" rel="stylesheet">
<title>RandomACard</title>
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="http://localhost:8080/neu.edu.cs5200/Login.jsp">MTG</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="http://localhost:8080/neu.edu.cs5200/Rules.jsp">Rules</a></li>
					<li><a href="http://localhost:8080/neu.edu.cs5200/SearchByName.jsp">SearchByName</a></li>
					<li><a href="http://localhost:8080/neu.edu.cs5200/RandomACard.jsp">RandomACard</a></li>
					<li><a href="http://localhost:8080/neu.edu.cs5200/AveragerRate.jsp">Top10</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a id="login" href="http://localhost:8080/neu.edu.cs5200/Login.jsp">Log
							in</a></li>
					<li><a>|</a></li>
					<li><a id="logout" href="">Register</a></li>

				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	
	
	
	
	
	
	<form action="/neu.edu.cs5200/RandomAction">
	<table class="table">
		
		<tr>
			
			
			<td><button name="action" value="random" class="btn btn-success" > Random</button></td>
	
				
			
		</tr>

	
	</table>
	</form>
	
	<script>

 	if(<%= Global.username != null %>){ 
 		document.getElementById("login").innerHTML = "<%= Global.username %>";
 		var login = document.getElementById("login");
 		login.setAttribute("href", "http://localhost:8080/neu.edu.cs5200/update.jsp");
 		document.getElementById("logout").innerHTML = "Logout";
 		var logout = document.getElementById("logout");
 		logout.setAttribute("href", "/neu.edu.cs5200/Login.jsp");		
 	}
		
</script>

 	<image  style="margin: 50px 550px" src="http://localhost:8080/neu.edu.cs5200/img/Color-Wheel.jpg">

</body>
</html>