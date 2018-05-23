<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
      <link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
<title>- Administrator -</title>
</head>
<body>
<center>
<table class="table">
<thead>
<tr>
<td>
<H1 class="jumbotron">Pot : <%=request.getAttribute("pot").toString()%></H1>
</td>
<td>
<ul class = "nav nav-pills nav-stacked">
<li><a href="/esignlive/Control?Action=buy">Buy Ticket</a></li>
<li><a href="/esignlive/Control?Action=draw">Draw</a></li>
</ul>
</td>
</tr>
</thead>
</table>


<table class="table">

<%
HashMap<Integer,String> list = (HashMap<Integer,String>) request.getAttribute("list");
Set set = list.entrySet();
Iterator iterator = set.iterator();
while(iterator.hasNext()) {
   Map.Entry gun = (Map.Entry)iterator.next();

%>
<thead>

<tr>
<th>Ticket Number</th>
<th>Ticket Holder Name</th>
</tr>

<tr>
<td>
<h3><span class = "label label-primary">
<%=gun.getKey()%></span>
</h3>
</td>

<td>
<h3><span class = "label label-success">
<%=gun.getValue()%></span>
</h3>
</td>
</tr>
</thead>

<%} %>
</table>




</center>
</body>
</html>