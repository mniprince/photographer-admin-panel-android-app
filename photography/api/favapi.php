<?php
header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";
//mysqli_select_db($conect,"acswesm5_allpo_db");

	
	$pg_id = $_POST['pg_id'];
	$user_id = $_POST['user_id'];
	$lfav = $_POST['lfav'];
	
	$query="INSERT INTO favtbl(pg_id, user_id, lfav) VALUES('$pg_id','$user_id','$lfav')";
	mysqli_query($conect,$query);
	echo json_encode(array('response'=>"Inserted Succesfully"));


?>