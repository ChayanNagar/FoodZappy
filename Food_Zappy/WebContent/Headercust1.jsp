<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>

<head>
<title>Zappy Food</title>

  <meta charset="utf-8">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body >



<nav class="navbar navbar-light" style="background-color: #f9fd08;">
  <div class="container-fluid">
    <div class="navbar-header">
      <div id="logo" class="fl_left">
      <a class="navbar-brand" href="index.jsp"><img src = "images/zappy-logo.png"></a>
      </div>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="./viewgridcustomer">Home</a></li>
      <li><a href="ViewCart"><span class="glyphicon glyphicon-shopping-cart	"><span class="cart_count">${count}</span></span><h5>Cart</h5></a></li>
      
          
          
      </ul>
      
     <!--  <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>-->
  
  </div>
</nav>
       
      
          
  
  </div>
</nav>
    