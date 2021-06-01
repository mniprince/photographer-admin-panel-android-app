
<?php
require_once("header.php");
?>
<div id="content">
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <style>
 #profileDisplay{
	display: block;
	width: 80%;
	margin: 10px auto;
	border-radius: 80%;
	
}

.button {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 10px;
  width: 380px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 2;
  right: 5;
}
 </style>

</br>
  <div> <img src="thumb/camera.jpg" ></div>
  </br>
  </br>
  <button class="button" onclick="window.location.href='photographers.php'"><span>Photographers LogIn </span></button>
</div>

<?php
require_once("footer.php");
?>
</div>


