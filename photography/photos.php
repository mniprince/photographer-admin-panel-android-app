<?php
if(!isset($_COOKIE["curentuser"])){
header ("location: login_pg.php");	
}
?>

<?php
require_once("left_pg.php");
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
$nameQuery= "SELECT * FROM photographertbl WHERE pg_email='$curentUserTarget'";
$runNameQuery = mysqli_query($conect,$nameQuery);
if($runNameQuery==true){
	while($getRow = mysqli_fetch_array($runNameQuery)){
		echo $getRow['pg_name'].' '.$getRow['pg_email'];
}}}
?></a>
<?php
if(isset($_COOKIE["curentuser"])){
echo '<a  href="#" onclick = "Warn();">Log Out</a>';	
}else{
	echo '<a href="login_pg.php">Log In</a>';
}
?>
</div>
 <br/>
 <br/>
 <br/>
 <br/>
 <hr/>


<div class="container" >
<h3>Photos<a class="btn btn-primary float-right" href="add-photo.php">Add Photo</a></h3>
</br>
<table class="table table-bordered table-striped">
<thead>
<tr>
<th>Image</th>
<th>Category</th>
<th>Price</th>
<th>Action</th>
</tr>
</thead>
<?php
if(isset($_COOKIE["curentuser"])){
$curentUserTarget = $_COOKIE["curentuser"];	
$nameQuery= "SELECT * FROM photographertbl WHERE pg_email='$curentUserTarget'";
$runNameQuery = mysqli_query($conect,$nameQuery);
if($runNameQuery==true){
	while($getRow = mysqli_fetch_array($runNameQuery)){
		$pg_id= $getRow['pg_id'];
	}}}
$sql= "SELECT * FROM photostbl WHERE pg_id='$pg_id'";
$result= mysqli_query($conect,$sql);
while($row=mysqli_fetch_array($result)){ ?>
	<tbody>
		<tr>
			
			<td><img src="<?php echo $row['photourl']; ?>" width="300px" height="130px">
			</td>
			<td><?php echo $row['category']; ?></td>
			<td><?php echo $row['price']; ?></td>
			<td>
 &nbsp;
<a  id ="delete" onclick="return myFunction()"  class="btn btn-danger" href="deletephoto.php?id=<?php echo $row['id'];?>">Delete</a>
</td>
</tr>
</tbody>
<?php }
?>

 
</table>
<script type = "text/javascript">
var link= $(this).attr("href");
	
function myFunction() {
	var retVal = confirm("Are You Sure want to delete This Image!");
               if( retVal == true ) {
				   window.location.href= link;
                  window.location.replace("deletephoto.php");
                  return true;
               } else {
                  window.location.replace("photos.php");
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

