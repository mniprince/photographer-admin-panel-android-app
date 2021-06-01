<?php
//header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";
//mysqli_select_db($conect,"acswesm5_allpo_db");

	$hname = $_POST['hname'];
	$hcontact =$_POST['hcontact'];
	$hlocation = $_POST['hlocation'];
	$hetype = $_POST['hetype'];
	$hmsg = $_POST['hmsg'];
	$userid = $_POST['userid'];
	$hdate = $_POST['hdate'];
	$pgname = $_POST['pgname'];
	$pgmail = $_POST['pgmail'];
	
	$query="INSERT INTO hiretbl(hname, hcontact, hlocation, hetype, hmsg, userid, hdate, pgname, pgmail) VALUES('$hname','$hcontact','$hlocation','$hetype','$hmsg','$userid','$hdate','$pgname','$pgmail')";
	mysqli_query($conect,$query);
	echo json_encode(array('response'=>"Inserted Succesfully"));


?>