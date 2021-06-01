<!DOCTYPE html>
<html>
<style>
input[type=email], select {
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

input[type=submit]:hover {
  background-color: #45a049;
}

</style>
<?php
if(isset($_COOKIE["curentuser"])){
header ("location: profile.php");	
}
?>

<?php
require_once("header_pg.php");
?>
<div id="content">
<center>
</br>
   <img src="thumb/logo.png" width="280px" height="280px">
  </br>
<h2>Photographer Log In</h2>
<div id="loginboxes">

<form action="login_core_pg.php">
<input type="email" placeholder="Registered email" name="usermail" required />

<br/>
<br/>
<input type="password" placeholder="Password" name="pwd" required />
<br/>
<br/>
<input type="submit" value="Login" name="loginBtn"/>
<br/>
<br/>
<?php
if(isset($_REQUEST["wrong_info"])){
	echo '<b style="color:red"> Email or Password incorect! </b>';
}
?>
<?php
if(isset($_REQUEST["success_info"])){
	echo '<b style="color:green"> Registration Success ! </b> Log In Now..';
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


