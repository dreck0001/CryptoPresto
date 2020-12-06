<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<title>CryptoPresto-account</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" >
<link rel="stylesheet" href="<c:url value="/resources/css/theme-black.css" />" >
<link rel="stylesheet" href="<c:url value="/resources/css/roboto.css" />" >
<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome-min.css" />" >
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar { z-index: 3; width: 250px; top: 43px; bottom: 0; height: inherit; }
</style>
<body>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Portfolio</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Transactions</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Account</a>
</nav>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href="/CryptoPresto" class="w3-bar-item w3-button w3-theme-l1">Crypto Presto</a>
<!--     <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
 --><a href="user?action=signOut" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Sign Out</a>
  </div>
</div>

<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">Welcome ${username}</h1>   
    </div>
  </div>


<!-- END MAIN -->
</div>


</body>
</html>