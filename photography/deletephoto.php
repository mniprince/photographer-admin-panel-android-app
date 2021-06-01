<?php
$id=$_GET['id'];
require_once("connectdb.php");
$sql= "SELECT * FROM photostbl WHERE id='$id'";
$result= mysqli_query($conect,$sql);
$row=mysqli_fetch_array($result);
$deletable_image=$row['photourl'];
if(!empty($deletable_image)){
	unlink($deletable_image);
}
$delete_sql="DELETE FROM photostbl WHERE id='$id'";
$delete_result=mysqli_query($conect,$delete_sql);
	if($delete_result){
		header('Location:photos.php');
	}
?>
