<?php
if(!isset($_COOKIE["curentuser"])){
header ("location: login.php");	
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
	echo '<a href="login.php">Log In</a>';
}
?>
</div>
 <br/>
 <br/>
 <br/>
 <br/>
</br><hr/>

<div class="container" style="height: 450px;">
<h3> <a class="btn btn-warning float-right" href="photos.php">Photo List</a></h3>
</br></br>

<div class="row">
<div class="col-4 offset-md-4 form-div">

<form method="POST" action="photo-submit.php" enctype="multipart/form-data">
<div class="form.group">

<div class="form.group text-center">

<img id="profileDisplay" src="bannerphoto/avatar.jpg" onclick="triggerClick()" style="height:130px; width:300px; border:1px solid black"/>
<label>Select Photo</label>
</div>

<div class="form.group" style="padding-top:12px;">

<input type="file" name="photo" id="aimage" accept="image/jpeg,  image/png" onchange="displayImage(this)" class="form-control" style="display:none">
</div>
<div class="form.group" style="padding-top:12px;">

 <label for="category">Choose a Category:</label>
  <select id="category" name="category">
  <?php
$sql= "SELECT * FROM categorytbl";
$result= mysqli_query($conect,$sql);
while($row=mysqli_fetch_array($result)){
         
    echo '<option value="'.$row['cname'].'"';

echo '>'. $row['cname'] . '</option>'."\n";
}

?>
  </select>

		<div class="form.group">
<label>Price </label>
<input type="number" name="pprice" class="form-control" required>
</div>



</div>

<div class="form.group float-right" style="padding-top:30px;">
<button type="submit" class="btn btn-info" name="btn">Submit</button>
</div>

</div>
</form>
</div>
</div>
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

