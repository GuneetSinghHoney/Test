<%@page import="lottery.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DRAW</title>
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->

</head>
<body>

RESULTS:  
<%
Ticket[] t = (Ticket[]) request.getAttribute("win");
%>
<table>
<tr>
<td>
First Ticket:
</td>

<td>
<h1 class="jumbotron">
Ticket Number:<%=t[0].getTicketNumber()%><br>
</h1>
</td>

</tr>
<tr>
<td>
Second Ticket:
</td>

<td>
<h1 class="jumbotron">
Ticket Number:<%=t[1].getTicketNumber()%><br>

</h1>
</td>

</tr>
<tr>
<td>
Third Ticket:
</td>


<td>
<h1 class="jumbotron">
Ticket Number:<%=t[2].getTicketNumber()%><br>
</h1>
</td>

</tr>

</table>
<a href=/esignlive/Control?Action=admin> Back </a>

</body>
</html>