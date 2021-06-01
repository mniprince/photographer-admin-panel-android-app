<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 30%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


</style>

<?php
if(isset($_COOKIE["curentuser"])){
header ("location: profile.php");	
}
?>

<?php
require_once("header.php");
?>
<div id="content">
<center>
</br>
  <div> <img src="thumb/logo.png" width="250px" height="250px"></div>
  </br>
<h2>Admin Log In</h2>
<div id="loginboxes">

<form action="login-core.php">
<input type="text" placeholder="User Name" name="username" required/>
<br/>
<br/>
<input type="password" placeholder="Password" name="pwd" required/>
<br/>
<br/>
<input type="submit" value="Login" name="loginBtn"/>
<br/>
<br/>
<?php
if(isset($_REQUEST["wrong_info"])){
	echo '<b style="color:red"> UserName or Password incorect! </b>';
}
?>
<br/>
<br/>
</form></center>
</div>


</div>

<?php
require_once("footer.php");
?>
</div>


