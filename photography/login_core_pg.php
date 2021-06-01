<?php
require_once("connectdb.php");


$userInputName=$_REQUEST["usermail"];
$userInputpwd=$_REQUEST["pwd"];

$matchQuery="SELECT * FROM photographertbl WHERE pg_email='$userInputName' AND pg_password='$userInputpwd'";
$runMatchQuery= mysqli_query($conect,$matchQuery);
$chkCount = mysqli_num_rows($runMatchQuery);

if($runMatchQuery==true){
if($chkCount===1){
	setcookie("curentuser",$userInputName,time()+(86400*7));
	header ("location: dashboard_pg.php");
}else{
header ("location: login_pg.php?wrong_info");
}}
?>