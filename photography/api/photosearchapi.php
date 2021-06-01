<?php
header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";

if( isset($_GET['key']))
{
	$key=$_GET['key'];
	$query="SELECT * FROM photostbl WHERE category LIKE '%$key%'";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'pg_id'=>$row['pg_id'],
		'category'=>$row['category'],
		'price'=>$row['price'],
		'photourl'=>$row['photourl'])
		);
	}
	echo json_encode($response);
} 
else 
{
	$query="SELECT * FROM photostbl";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'pg_id'=>$row['pg_id'],
		'category'=>$row['category'],
		'price'=>$row['price'],
		'photourl'=>$row['photourl'])
		);
	}
	echo json_encode($response);
}

//mysql_close($conect);

?>