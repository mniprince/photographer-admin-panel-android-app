<?php
if(!isset($_COOKIE["curentuser"])){
header ("location: login.php");	
}
?>

<?php
require_once("left.php");
?>


<div class="split right">
<div id="content" >
<!DOCTYPE HTML>
<html lang="en-US">
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   
  <script type = "text/javascript">
         <!--
            function Warn() {
               var retVal = confirm("Do you want to Log Out now!");
               if( retVal == true ) {
                  window.location.replace("logout-core.php");
                  return true;
               } else {
                  window.location.replace("index.php");
                  return false;
               }
            }
         //-->
      </script> 



<meta charset="UTF-8">
<title>Artist Details Update</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<?php
require_once("connectdb.php");

?>

<div id="wrapper">

<div class="b">
<a style="color:tomato;"><?php
if(isset($_COOKIE["curentuser"])){
$curentUserTarget = $_COOKIE["curentuser"];	
$nameQuery= "SELECT * FROM admintbl WHERE email_addres='$curentUserTarget'";
$runNameQuery = mysqli_query($conect,$nameQuery);
if($runNameQuery==true){
	while($getRow = mysqli_fetch_array($runNameQuery)){
		echo $getRow['fname'].' '.$getRow['lname'];
}}}
?></a>
<?php
if(isset($_COOKIE["curentuser"])){
echo '<a  href="#" onclick = "Warn();">Log Out</a>';	
}else{
	echo '<a href="login.php">Log In</a>';
}
?>
</div>
</br><hr/>

<div class="container" style="height: 450px;">
<h3> <a class="btn btn-success float-right" href="category-list.php">Back List</a></h3>
</br></br>
<h2>Category Update</h2>
<div class="row">
<div class="col-4 offset-md-4 form-div">
<?php 
$id=$_GET['id'];
$sql ="SELECT * FROM categorytbl WHERE id='$id'";
$result=mysqli_query($conect,$sql);
$row=mysqli_fetch_array($result);
if(isset($_POST['update'])){
	$name=$_POST['cname'];
	$image=$_FILES['cimage'];
	$tmp_name=$image['tmp_name'];
	$file_name=$image['name'];
	if($image['size']>1){
		if(file_exists($row['cimage']) && !empty($row['cimage'])){
			unlink($row['cimage']);
		}
		move_uploaded_file($tmp_name, "categoryphoto/".$file_name);
		$update_sql="UPDATE categorytbl SET cimage='categoryphoto/$file_name', cname='$name' WHERE id='$id' ";
	}else{
		$update_sql="UPDATE categorytbl SET cname='$name' WHERE id='$id' ";
	}
	$update_result=mysqli_query($conect,$update_sql);
	if($update_result){
			
			
		header('Location:category-list.php');
	}else{ ?>
		<script>
swal({
  title: "Good job!",
  text: "You clicked the button!",
  icon: "success",
});
</script>
			<?php
		header('Location:category-list.php');
	}	
}
?>




<form method="POST" action="" enctype="multipart/form-data">
<div class="form.group">
<div class="form.group">
<label>Category Name</label>
<input type="text" name="cname" value="<?php echo $row['cname'];?>" class="form-control">
</div>
</br>
<div class="form.group text-center">

<img id="profileDisplay" src="<?php echo $row['cimage']; ?>" onclick="triggerClick()" style="height:100px; width:100px; border:1px solid black"/>
<label>Click Image to Update</label>
</div>

<div class="form.group" style="padding-top:12px;">

<input type="file" name="cimage" id="aimage" accept="image/jpeg,  image/png" onchange="displayImage(this)" class="form-control" style="display:none">
</div>

<div class="form.group float-right" style="padding-top:30px;">
<button type="submit" class="btn btn-warning" name="update">Update</button>
</div>

</div>
</form>
</div></div>
<script type="text/javascript">
function triggerClick() {
  document.querySelector('#aimage').click();
}

function displayImage(e) {
  if (e.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e){
      document.querySelector('#profileDisplay').setAttribute('src', e.target.result);
    }
    reader.readAsDataURL(e.files[0]);
  }
}
</script>


</div>

</div>
</div>

<?php
require_once("footer.php");

?>
</div>

</body>

