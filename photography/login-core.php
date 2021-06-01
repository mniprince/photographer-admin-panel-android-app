<?php
require_once("connectdb.php");


$userInputName=$_REQUEST["username"];
$userInputpwd=$_REQUEST["pwd"];

$matchQuery="SELECT * FROM admintbl WHERE email_addres='$userInputName' AND user_pass='$userInputpwd'";
$runMatchQuery= mysqli_query($conect,$matchQuery);
$chkCount = mysqli_num_rows($runMatchQuery);

if($runMatchQuery==true){
if($chkCount===1){
	setcookie("curentuser",$userInputName,time()+(86400*7));
	header ("location: dashboard.php");
}else{
header ("location: login.php?wrong_info");
}}
?>