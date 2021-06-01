<?php
header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";

if( isset($_GET['key']))
{
	$key=$_GET['key'];
	$query="SELECT * FROM favtbl WHERE pg_id LIKE '%$key%'";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'pg_id'=>$row['pg_id'],
		'user_id'=>$row['user_id'],
		'lfav'=>$row['lfav'])
		);
	}
	echo json_encode($response);
} 
else 
{
	$query="SELECT * FROM favtbl";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'pg_id'=>$row['pg_id'],
		'user_id'=>$row['user_id'],
		'lfav'=>$row['lfav'])
		);
	}
	echo json_encode($response);
}

//mysql_close($conect);

?>