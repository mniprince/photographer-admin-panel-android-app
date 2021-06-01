<?php
require_once("connectdb.php");

if(isset($_COOKIE["curentuser"])){
$curentUserTarget = $_COOKIE["curentuser"];	
$nameQuery= "SELECT * FROM photographertbl WHERE pg_email='$curentUserTarget'";
$runNameQuery = mysqli_query($conect,$nameQuery);
if($runNameQuery==true){
	while($getRow = mysqli_fetch_array($runNameQuery)){
		$pg_id= $getRow['pg_id'];
}}}

if(isset($_POST['btn'])){
	$price=$_POST['pprice'];
	$category=$_POST['category'];
	$image=$_FILES['photo'];
	$filename=$image['tmp_name'];
	$destination=$image['name'];
	if(move_uploaded_file($filename,"eventphoto/".$destination)){
		$sql="INSERT INTO photostbl(pg_id, photourl,category,price) VALUES('$pg_id','eventphoto/$destination','$category','$price')";
if($result=mysqli_query($conect,$sql)){
	header('Location:photos.php');
}	
	}else{
		echo "Failed";
	}
}
?>

<?php
require_once("footer.php");

?>