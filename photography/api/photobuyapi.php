<?php
header ('Content-type: application/json');
//$method = $_SERVER['REQUEST_METHOD'];
require_once "../connectdb.php";

if( isset($_GET['key']))
{
	$key=$_GET['key'];
	$query="SELECT * FROM photobuytbl WHERE userid LIKE '%$key%'";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'userid'=>$row['userid'],
		'photourl'=>$row['photourl'])
		);
	}
	echo json_encode($response);
} 
else 
{
	$query="SELECT * FROM photobuytbl";
	$result=mysqli_query($conect,$query);
	$response=array();
	while($row=mysqli_fetch_assoc($result)){
		array_push($response,array(
		'id'=>$row['id'],
		'userid'=>$row['userid'],
		'photourl'=>$row['photourl'])
		);
	}
	echo json_encode($response);
}

//mysql_close($conect);

?>