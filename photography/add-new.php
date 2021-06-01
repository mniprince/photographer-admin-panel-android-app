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
<title>Matrivash</title>
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
</div> </br>
<h2>Add Category</h2>

<div class="w3-row-padding">
  <div class="w3-third" style="background-color:tomato;">
    
  </div>

  <div class="w3-third" style="background-color:cyan;">
    
  </div>

  <div class="w3-third" style="background-color:red;">
 
  </div>
  
  
</div>



</div>
</div>

<?php
require_once("footer.php");
?>
</div>
<body>

