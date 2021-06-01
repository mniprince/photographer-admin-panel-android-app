<?php
require_once("connectdb.php");

if(isset($_POST['btn'])){
	$name=$_POST['cname'];
	$image=$_FILES['cimage'];
	$filename=$image['tmp_name'];
	$destination=$image['name'];
	if(move_uploaded_file($filename,"categoryphoto/".$destination)){
		$sql="INSERT INTO categorytbl(cimage, cname) VALUES('categoryphoto/$destination','$name')";
if($result=mysqli_query($conect,$sql)){
	header('Location:category-list.php');
}	
	}else{
		echo "Failed";
	}
}
?>

<?php
require_once("footer.php");

?>