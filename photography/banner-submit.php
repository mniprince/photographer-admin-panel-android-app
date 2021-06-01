<?php
require_once("connectdb.php");

if(isset($_POST['btn'])){
	$image=$_FILES['bannerimage'];
	$filename=$image['tmp_name'];
	$destination=$image['name'];
	if(move_uploaded_file($filename,"bannerphoto/".$destination)){
		$sql="INSERT INTO bannertbl(bannerimage) VALUES('bannerphoto/$destination')";
if($result=mysqli_query($conect,$sql)){
	header('Location:top-banner.php');
}	
	}else{
		echo "Failed";
	}
}
?>

<?php
require_once("footer.php");

?>