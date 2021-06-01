<?php
//header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";
//mysqli_select_db($conect,"acswesm5_allpo_db");

	$course_title = $_POST['course_title'];
	$total_class =$_POST['total_class'];
	$fee = $_POST['fee'];
	$user_id = $_POST['user_id'];
	
	$query="INSERT INTO course(course_title, total_class, fee, user_id) VALUES('$course_title','$total_class','$fee','$user_id')";
	mysqli_query($conect,$query);
	echo json_encode(array('response'=>"Inserted Succesfully"));


?>