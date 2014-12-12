<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="neu.edu.cs5200.*, java.util.List"%>
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

			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>





	<%      
	Browse dao = new Browse();
    List<Card> cards = dao.readAllCardBySet("ROE");
	%>
	<h1 style="margin: 1px 45px">  <%=cards.get(0).getCardsetname()%></h1>
	<table class="table table-hover">
		<caption style="margin: 1px 45px"><%=cards.size()%> cards</caption>
		<caption></caption>
		<thead>
			<tr>
			    <th width="1px"></th>
				<th width="1px">No</th>
				<th width="120px">Card Name</th>
				<th width="120px">Type</th>
				<th width="30px">Mana</th>
				<th width="30px">Rarity</th>
				<th width="30px">Edition</th>
			</tr>
		</thead>

		<tbody>
<%		   
					for (Card app : cards) {
%> 

 			    <tr>
 			    <td width="1px"></td>
 				<td>    <%= app.getSetnumber()%></td>
	            <td><%= app.getName()%></td>
	            <td><%= app.getType()%> 
	                <%if(app.getSubtype()!=null){ 
	                %> - <%= app.getSubtype()%><% }
                     else{}
                     %>
                    <%if(app.getType().equals("Creature")){%>
	                <%=app.getPower()%>/<%=app.getToughness()%><%}
                     else{}
                     %></td>
	            <td><%= app.getManacost()%></td>
	            <td><%= app.getRarity()%></td>
	            <td><%= app.getCardsetname()%></td>
<%
		}
%>
</tr>
			
		</tbody>
	</table>
</body>
</html>