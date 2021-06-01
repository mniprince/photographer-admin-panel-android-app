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
<script
  src="https://code.jquery.com/jquery-3.5.1.slim.js"
  integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM="
  crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


  
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
<title>Professional Photographers</title>
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
$nameQuery= "SELECT * FROM user WHERE email_addres='$curentUserTarget'";
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


<div class="container" >
<h3>Top Banner<a class="btn btn-primary float-right" href="add-banner.php">Add Banner</a></h3>
</br>
<table class="table table-bordered table-striped">
<thead>
<tr>
<th>ID</th>
<th>Image</th>
<th>Action</th>
</tr>
</thead>
<?php
$sql= "SELECT * FROM bannertbl";
$result= mysqli_query($conect,$sql);
while($row=mysqli_fetch_array($result)){ ?>
	<tbody>
		<tr>
			<td><?php echo $row['id']; ?></td>
			<td><img src="<?php echo $row['bannerimage']; ?>" width="300px" height="130px"></td>
			<td>
<a  class="btn btn-info" href="bannerupdate.php?id=<?php echo $row['id'];?>">Edit</a> &nbsp;
<a  id ="delete" onclick="return myFunction()"  class="btn btn-danger" href="deletebanner.php?id=<?php echo $row['id'];?>">Delete</a>
</td>
</tr>
</tbody>
<?php }
?>

 
</table>
<script type = "text/javascript">
var link= $(this).attr("href");
	
function myFunction() {
	var retVal = confirm("Are You Sure want to delete Top Banner!");
               if( retVal == true ) {
				   window.location.href= link;
                  window.location.replace("deleteartist.php");
                  return true;
               } else {
                  window.location.replace("top-banner.php");
                  return false;
               }
	
}
</script>

</div>
</div>
</div>

</div>
<?php
require_once("footer.php");

?>
<body>

