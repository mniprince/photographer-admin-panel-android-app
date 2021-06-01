<?php
//header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";
//mysqli_select_db($conect,"acswesm5_allpo_db");

	$photoid = $_POST['photoid'];
	$pgid =$_POST['pgid'];
	$photourl = $_POST['photourl'];
	$price = $_POST['price'];
	$userid = $_POST['userid'];
	
	$query="INSERT INTO photobuytbl(photoid, pgid, photourl, price, userid) VALUES('$photoid','$pgid','$photourl','$price','$userid')";
	mysqli_query($conect,$query);
	echo json_encode(array('response'=>"Inserted Succesfully"));


?>