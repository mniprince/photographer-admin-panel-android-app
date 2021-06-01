

<?php
require_once("connectdb.php");

if(isset($_POST['regiBtn'])){
	$pgname=$_POST['pgname'];
	$category=$_POST['category'];
	$pgemail=$_POST['pgemail'];
	$locaton=$_POST['locaton'];
	$pwd=$_POST['pwd'];
	$repwd=$_POST['repwd'];
	$image=$_FILES['pgimage'];
	$filename=$image['tmp_name'];
	$destination=$image['name'];
	
	
	
	if(move_uploaded_file($filename,"pgphoto/".$destination)){
		$sql="INSERT INTO photographertbl(category, pg_name, pg_email, pg_location, pg_image, pg_password) VALUES('$category','$pgname','$pgemail','$locaton','pgphoto/$destination','$pwd')";
if($result=mysqli_query($conect,$sql)){
	header('Location:login_pg.php?success_info');
	
}	
	}else{
		echo "Failed";
		header('Location:photographers.php');
	}}
	
	
?>

<?php
require_once("footer.php");

?>
