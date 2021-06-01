<?php
header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";

if( isset($_GET['key']))
{
	$key=$_GET['key'];
	$query="SELECT * FROM course WHERE user_id LIKE '%$key%'";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'fee'=>$row['fee'],
		'user_id'=>$row['user_id'],
		'total_class'=>$row['total_class'],
		'course_title'=>$row['course_title'])
		);
	}
	echo json_encode($response);
} 
else 
{
	$query="SELECT * FROM course";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'fee'=>$row['fee'],
		'user_id'=>$row['user_id'],
		'total_class'=>$row['total_class'],
		'course_title'=>$row['course_title'])
		);
	}
	echo json_encode($response);
}

//mysql_close($conect);

?>