<?php
require_once("connectdb.php");
?>
<!DOCTYPE HTML>
<html lang="en-US">
<head>

  <script type = "text/javascript">
         <!--
            function Warn() {
               var retVal = confirm("Do you want to Log Out now!");
               if( retVal == true ) {
                  window.location.replace("logout-core-pg.php");
                  return true;
               } else {
                  window.location.replace("photographers.php");
                  return false;
               }
            }
         //-->
      </script> 



<meta charset="UTF-8">
<title>Professional Photographers</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<?php
require_once("connectdb.php");

?>

<div id="wrapper">

<div id="header">
<?php
if(isset($_COOKIE["curentuser"])){
echo '<a  href="#" onclick = "Warn();">Log Out</a>';	
echo '<a  href="dashboard_pg.php">Dashboard</a>';	
}else{
	echo '<a href="login_pg.php">Log In</a> ';
	
	echo '<a href="reg_pg.php">Registration</a>';
}
?>
<h1>Welcome Photographers</h1>
</div>