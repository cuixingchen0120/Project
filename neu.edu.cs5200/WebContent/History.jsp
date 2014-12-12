<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="neu.edu.cs5200.*, java.util.List"%>
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
<title>SearchByName</title>



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
					<li><a href="http://localhost:8080/neu.edu.cs5200/Browse New.jsp">Browse New Set</a></li>
					<li><a href="http://localhost:8080/neu.edu.cs5200/AveragerRate.jsp">Top10</a></li>
					<li class="dropdown" id="accountmenu">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="http://localhost:8080/neu.edu.cs5200/History.jsp">View My History</a></li>
                            <li><a href="http://localhost:8080/neu.edu.cs5200/Rate.jsp">View My Rate</a></li>
                            <li><a href="http://localhost:8080/neu.edu.cs5200/Comment.jsp">View My Comment</a></li>
                            
							</ul>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a id="login" href="http://localhost:8080/neu.edu.cs5200/Login.jsp">Log
							in</a></li>
					<li><a>|</a></li>
					<li><a id="logout" href="http://localhost:8080/neu.edu.cs5200/Register.jsp">Register</a></li>

				</ul>
			</div>

			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>





	<h1 style="margin: 1px 87px">Search History</h1>
	<%
		HistoryDAO dao = new HistoryDAO();
		List<History> history = dao.findHistoryByUsername(Global.username);
	%>
	<table class="table table-hover">
		<caption style="margin: 1px 87px"> <%=history.size() %> results</caption>
		<thead>
			<tr>
                <th width="80px"></th>
				<th width="300px">Username</th>
				<th width="400px">Cardname</th>
				<th>DateSearched</th>
			</tr>
		</thead>

		<tbody>
			<%
				for (History app : history) {
			%>
			<tr>
			    <td width="80px"></td>
				<td width="300px"><%=app.getUsername()%></td>
				<td width="400px"><%=app.getCardname()%></td>
				<td><%=app.getDatesearched()%></td>
				<%
					}
				%>
			</tr>


		</tbody>
	</table>
	
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.dropdown-toggle').dropdown();
        });
   </script>
   
   
   
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
   
	
	
</body>
</html>

