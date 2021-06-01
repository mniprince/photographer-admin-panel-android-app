<?php
if(!isset($_COOKIE["curentuser"])){
header ("location: photographers.php");	
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script type = "text/javascript">
         <!--
            function Warn() {
               var retVal = confirm("Do you want to Log Out now!");
               if( retVal == true ) {
                  window.location.replace("logout-core-pg.php");
                  return true;
               } else {
                  window.location.replace("photographers.php");
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
		echo $getRow['pg_name'].'</br> '.$getRow['pg_email'];
}}}
?></a></br>
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
 <br/>
 <br/>
 <br/>
 <br/> </br>
<div class="w3-row-padding">
  <div class="w3-third" style="background-color:tomato;">
    <h1><?php
	if(isset($_COOKIE["curentuser"])){
$curentUserTarget = $_COOKIE["curentuser"];	
$nameQuery= "SELECT * FROM photographertbl WHERE pg_email='$curentUserTarget'";
$runNameQuery = mysqli_query($conect,$nameQuery);
if($runNameQuery==true){
	while($getRow = mysqli_fetch_array($runNameQuery)){
		$pg_id= $getRow['pg_id'];
	}}}
	
$sql = "SELECT COUNT(*) as cnt FROM photostbl WHERE pg_id='$pg_id'";
$result = mysqli_query($conect, $sql);
$photos = mysqli_fetch_assoc($result)['cnt'];
echo $photos;
?></h1>
    <p>Uploaded Photos</p>
    
  </div>

  
  
  
</div>



</div>
</div>

<?php
require_once("footer.php");
?>
</div>
<body>

