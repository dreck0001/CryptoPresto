<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<title>CryptoPresto-sign in</title>
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

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href="/CryptoPresto" class="w3-bar-item w3-button w3-theme-l1">Crypto Presto</a>
<!--     <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
 --><a href="user?action=signUp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Sign Up</a>
    <a href="user?action=signIn" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Sign In</a>
  </div>
</div>

<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">Sign In</h1>
		<form action="SignIn" method="POST">
			<input type="hidden" name="operation" value="login">
            <input type="text" name="username" placeholder="Username"><br>
            <input type="password" name="password" placeholder="Password"><br>
            <input type="submit" value="Sign In">
    </form>    </div>
  </div>


<!-- END MAIN -->
</div>

<!-- <script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script> -->

</body>
</html>