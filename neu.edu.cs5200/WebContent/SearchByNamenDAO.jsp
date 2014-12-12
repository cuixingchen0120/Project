<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="neu.edu.cs5200.* ,java.util.* , java.sql.Timestamp, java.text.DateFormat, java.util.Calendar, java.util.Date, java.text.SimpleDateFormat"%>
<!DOCTYPE html >
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<link href="css/star-rating.min.css" media="all" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/star-rating.min.js" type="text/javascript"></script>


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
					<li><a href="http://localhost:8080/neu.edu.cs5200/AveragerRate.jsp">Top10</a></li>
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
	
<%  

	
	Card card = (Card)request.getAttribute("card");
	if(card!=null){
	CardDAO dao = new CardDAO();
	dao.createCard(card);
	Global.cardname = card.getName();
	Global.cardid = card.getCardid();
	Global.setnumber = card.getSetnumber();
	Global.searchname = card.getSearchname();
	Global.description = card.getDescription();
	Global.flavor = card.getFlavor();
	Global.releasedat = card.getReleasedat();
	Global.colors = card.getColors();
	Global.manacost = card.getManacost();
	Global.convertedmanacost =card.getConvertedmanacost();
	Global.cardsetname = card.getCardsetname();
	Global.type = card.getType();
	Global.subtype = card.getSubtype();
	Global.power = card.getPower();
	Global.relatedcardid = card.getRelatedcardid();
	
%>
	
	
	
	
	
	
	
	<p> The card's id is<%= Global.cardid %> </p>
	<p> The related card id is<%= Global.relatedcardid %> </p>
	<p> The set number is <%= Global.setnumber %> </p>
	<p> The Name is <%= Global.cardname %></p>
	<p> The search name is <%= Global.searchname %></p>
	<p> <%= Global.description %></p>
	<p> <%= Global.flavor %></p>
	<p> The clolor is <%= Global.colors %></p>
	<p> The mana cost is <%= Global.manacost %></p>
	<p> The converted mana cost is <%= Global.convertedmanacost %></p>
	<p> Card set name : <%= Global.cardsetname %></p>
	<p> Type : <%= Global.type %></p>
	<p> Subtype : <%= Global.subtype %></p>
	<p> Power : <%= Global.power %> </p>
	<p><img alt="" src="http://api.mtgdb.info/content/card_images/<%= Global.cardid %>.jpeg"></p>
<%}else{ %>
<p> The card's id is<%= Global.cardid %> </p>
	<p> The related card id is<%= Global.relatedcardid %> </p>
	<p> The set number is <%= Global.setnumber %> </p>
	<p> The Name is <%= Global.cardname %></p>
	<p> The search name is <%= Global.searchname %></p>
	<p> <%= Global.description %></p>
	<p> <%= Global.flavor %></p>
	<p> The clolor is <%= Global.colors %></p>
	<p> The mana cost is <%= Global.manacost %></p>
	<p> The converted mana cost is <%= Global.convertedmanacost %></p>
	<p> Card set name : <%= Global.cardsetname %></p>
	<p> Type : <%= Global.type %></p>
	<p> Subtype : <%= Global.subtype %></p>
	<p> Power : <%= Global.power %> </p>
	<p><img alt="" src="http://api.mtgdb.info/content/card_images/<%= Global.cardid %>.jpeg"></p>

<%} %>



<%
RateDAO rdao = new RateDAO();

String action = request.getParameter("action");
String name = request.getParameter("name");
if("update".equals(action)){

double num = Double.parseDouble(name);
Timestamp date = new Timestamp(System.currentTimeMillis());
Rate r = new Rate(Global.username,Global.cardname,num,date);
rdao.createRate(r);
AverageRateDAO dao = new AverageRateDAO();
dao.deleteAverageRate();
AverageRateDAO dao1 = new AverageRateDAO();
dao1.CalculateRate();
AverageRateDAO dao2 = new AverageRateDAO();
dao2.Output();
}
%>

<form action="SearchByNamenDAO.jsp">
<div class="container col-lg-4 col-lg-offset-4" Style="margin-top: 10px">

		<input name="name" class="form-control" placeholder="Please enter number from 0 to 5"/>
		<button name="action" value="update" class="btn btn-primary" >Rate</button>

</div>
</form>

<form action="/neu.edu.cs5200/AddAction">

	<button class="btn btn-primary" >AddToFavourite</button>



</form>






<%CommentDAO cdao = new CommentDAO();
				UserDAO udao = new UserDAO();
		
				String idStr = request.getParameter("id");
				List<Comment> comments = cdao.findCommentByCardname(Global.cardname);
				
				for(Comment dir:comments) {
					User user = udao.findUserbyUsername(dir.getUsername());
					//Global.comment =dir.getComment();
				%>
				

<form action="/neu.edu.cs5200/CommentDelete">
<div class="panel panel-info" style="margin: 100px 40px 0px 40px">
		<div class="panel-heading">Comment</div>
		<div class="panel panel-default">
			<div class="panel-heading">CommentTitle</div>
			<div class="panel-body">
				
			<p><%= dir.getComment()%></p>
		
			</div>
			
			<ul class="list-group">
				<li class="list-group-item"><p class="text-right" >Commented by <%= dir.getUsername()%>(ID: <%=user.getId() %>)    Date is <%=dir.getDate() %>  CommentId is <%=dir.getCommentid() %> </p></li>
			</ul>
				<button class="btn btn-danger" >Delete</button>
				
		</div>
	</div>

	<%} %>
	</form>
	
	
	
	
	<div class="panel panel-info" style="margin: 20px 40px 20px 40px">
		<div class="panel-heading">My Comment</div>
		<div class="panel panel-default">
			
			<div class="panel-body">
				<form role="form" action="/neu.edu.cs5200/CommentAction">
					<div class="form-group">
						<textarea class="form-control" placeholder="Write your comment"  name="comment"  rows="5"></textarea>
					</div>
					<div align="right">
				<button class="btn btn-primary" >Submit</button>
				</div>
				</form>
				
			</div>
		</div>
	</div>
	
	
<script>

 	if(<%= Global.username != null %>){ 
 		document.getElementById("login").innerHTML = "<%= Global.username %>";
 		var login = document.getElementById("login");
 		login.setAttribute("href", "/neu.edu.cs5200/update.jsp");
 		document.getElementById("logout").innerHTML = "Logout";
 		var logout = document.getElementById("logout");
 		logout.setAttribute("href", "/neu.edu.cs5200/Login.jsp");		
 	}
		
</script>



</body>
</html>