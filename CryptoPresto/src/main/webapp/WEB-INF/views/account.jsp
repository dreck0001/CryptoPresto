<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<title>CryptoPresto</title>
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


<!-- ------------USER LOGGED IN------------ -->

<c:if test="${not empty user}">
<!-- Sidebar -->
	<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  		<a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    		<i class="fa fa-remove"></i>
  		</a>
  		<h4 class="w3-bar-item"><b>Menu</b></h4>
 	 	<a class="w3-bar-item w3-button w3-hover-black" href="/CryptoPresto/account?menu=portfolio">Portfolio</a>
  		<a class="w3-bar-item w3-button w3-hover-black" href="/CryptoPresto/account?menu=transactions">Transactions</a>
  		<a class="w3-bar-item w3-button w3-hover-black" href="/CryptoPresto/account?menu=account_addBank_cancel">Account</a>
	</nav>
	
<!-- Navbar -->
	<div class="w3-top">
  		<div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    		<a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    		<a href="/CryptoPresto" class="w3-bar-item w3-button w3-theme-l1">Crypto Presto</a>
 			<a href="SignOut" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Sign Out</a>
  		</div>
	</div>
	
	<c:if test="${empty addingBank}">
		<div class="w3-main" style="margin-left:250px">
  			<div class="w3-row w3-padding-64">
    			<div class="w3-twothird w3-container">
      				<h1 class="w3-text-teal">Welcome ${user.getUsername()} </h1> 
      				<p> Digital Address: CP${user.getId()}
      				<p> Member Since    : ${user.getDateCreated()}
      				<p> Linked Bank Accounts    : 
      				<select name="bank">
      				<c:forEach items="${banks}" var="bank">
    					<option value="${bank.getId()}">${bank.getBankName()} - ${bank.getType()}</option> 				
					</c:forEach>				
            		</select>
					<button id="addBank" class="float-left submit-button" >Add</button>
					<button id="addBank" class="float-left submit-button" >Edit</button>
					<button id="addBank" class="float-left submit-button" >Delete</button>
    			</div>
  			</div>
			<script type="text/javascript">
    			document.getElementById("addBank").onclick = function () {
    				/* document.forms[0].action = "/CryptoPresto/account?menu=account_addBank";
                    document.forms[0].submit(); */
        			location.href = "/CryptoPresto/account?menu=account_addBank"; 
    			};
			</script>
			<h3 style="color:red;" > ${status} </h3>
		</div>
	</c:if>
	
	<c:if test="${not empty addingBank}">
	<div class="w3-main" style="margin-left:250px">
  	<div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
	<h1 class="w3-text-teal">Fill Bank Details </h1> 
	<form action="/CryptoPresto/bank.htm" method="post">
		Select Bank:
        <select name="bankName">
        	<option value="Citizens Bank">Citizens Bank</option>
        	<option value="Rockland Trust Bank">Rockland Trust Bank</option>
       		<option value="TD Bank">TD Bank</option>
       		<option value="Bank of America">Bank of America</option>
       		<option value="People’s United Bank">People’s United Bank</option>
       		<option value="Digital Federal Credit Union">Digital Federal Credit Union</option>
       		<option value="Chase Bank">Chase Bank</option>
       		<option value="Barclays Bank">Barclays Bank</option>
       		<option value="Santander Bank">Santander Bank</option>
        </select>
        <br><br>
          	Routing Number: <input type="text" name="routingNumber"/><br/><br/>
          	Accountng Number: <input type="text" name="accountNumber"/><br/><br/>
            Account Type:
                <input type="radio" name="accountType" value="Savings"/>
                <label>Savings</label>
                <input type="radio" name="accountType" value="Checking"/>
                <label>Checking</label>
            <br/><br/>
            
        <input type="submit" value="Add Bank Account"/>
 	</form>
 	<button id="cancelAddBank" class="float-left submit-button" >Cancel</button>
 	<script type="text/javascript">
    	document.getElementById("cancelAddBank").onclick = function () {
    		location.href = "/CryptoPresto/account?menu=account_addBank_cancel"; 
    	};
	</script>
    </div>
  	</div>
  	</div>
	</c:if>
</c:if>















<!-- ------------USER NOT LOGGED IN------------ -->

<c:if test="${empty user}">
	<!-- Navbar -->
	<div class="w3-top">
  		<div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    		<a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    		<a href="/CryptoPresto" class="w3-bar-item w3-button w3-theme-l1">Crypto Presto</a>
			<a href="user?action=signUp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Sign Up</a>
    		<a href="user?action=signIn" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Sign In</a>
  		</div>
	</div>

	<div class="w3-main" style="margin-left:250px">
  		<div class="w3-row w3-padding-64">
    		<div class="w3-twothird w3-container">
				<h1 class="w3-text-teal">Welcome</h1>
    			<p>Crypto Presto is a platform that offers users the opportunity to buy, sell and transfer cryptocurrency assets to any digital currency address. 
    			<p>Sign in to continue.
    		</div>
  		</div>
	</div>
</c:if>
<!-- END MAIN -->
</body>
</html>

