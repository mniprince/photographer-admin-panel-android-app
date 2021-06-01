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
$nameQuery= "SELECT * FROM admintbl WHERE email_addres='$curentUserTarget'";
$runNameQuery = mysqli_query($conect,$nameQuery);
if($runNameQuery==true){
	while($getRow = mysqli_fetch_array($runNameQuery)){
		echo $getRow['fname'].' '.$getRow['lname'];
}}}
?></a></br>
<?php
if(isset($_COOKIE["curentuser"])){
echo '<a  href="#" onclick = "Warn();">Log Out</a>';	
}else{
	echo '<a href="login.php">Log In</a>';
}
?>
</div> </br></br></br></br>
<div class="w3-row-padding">
  <div class="w3-third" style="background-color:tomato;">
    <h1> <?php
$sql = "SELECT COUNT(*) as cnt FROM photographertbl";
$result = mysqli_query($conect, $sql);
$photographer = mysqli_fetch_assoc($result)['cnt'];
echo $photographer;
?></h1>
    <p>Photographers</p>
    
  </div>

  <div class="w3-third" style="background-color:cyan;">
    <h1><?php
$sql = "SELECT COUNT(*) as cnt FROM categorytbl";
$result = mysqli_query($conect, $sql);
$category = mysqli_fetch_assoc($result)['cnt'];
echo $category;
?></h1>
    <p>Category</p> 
  </div>

  <div class="w3-third" style="background-color:red;">
    <h1><?php
$sql = "SELECT COUNT(*) as cnt FROM photostbl";
$result = mysqli_query($conect, $sql);
$photos = mysqli_fetch_assoc($result)['cnt'];
echo $photos;
?></h1>
    <p>Photos</p>
  </div>

  
</div>



</div>
</div>

<?php
require_once("footer.php");
?>
</div>
<body>

