<%@page import="lottery.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Winners</title>
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
Ticket[] t =null;
try{
t = (Ticket[]) request.getAttribute("win");
}catch(Exception e)
{
RequestDispatcher disp = request.getRequestDispatcher("Control?Action=error");
disp.forward(request, response);
}
%>
<table>
<tr>
<td>
<img src="one.png">
</td>

<td>
<h1 class="jumbotron">
Ticket Number:<%=t[0].getTicketNumber()%><br>
Winner Name:<%=t[0].getBuyerName() %><br>
Amount: <%=t[0].getWinningAmount() %>
</h1>
</td>

</tr>
<tr>
<td>
<img src="two.png"/>
</td>

<td>
<h1 class="jumbotron">
Ticket Number:<%=t[1].getTicketNumber()%><br>
Winner Name:<%=t[1].getBuyerName() %><br>
Amount: <%=t[1].getWinningAmount() %>
</h1>
</td>

</tr>
<tr>
<td>
<img src="three.png"/>
</td>


<td>
<h1 class="jumbotron">
Ticket Number:<%=t[2].getTicketNumber()%><br>
Winner Name:<%=t[2].getBuyerName() %><br>
Amount: <%=t[2].getWinningAmount() %>
</h1>
</td>

</tr>

</table>
<h1><a href="/esignlive/Control?Action=next">Next</a></h1>

</body>
</html>