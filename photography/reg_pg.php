<!DOCTYPE HTML>
<html lang="en-US">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=email], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 30%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


</style>
<meta charset="UTF-8">
<title>Photographers Registration</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>



<?php
require_once("header_pg.php");
?>
<div id="content">
<center>
</br>
  <div> <img src="thumb/logo.png" width="100px" height="100px"></div>
  </br>
<h2>Photographers Registration</h2>
<div id="loginboxes">

<form method="POST" action="regi-core.php"enctype="multipart/form-data">
<div class="form.group text-center">

<img id="profileDisplay" src="thumb/avatar.jpg" onclick="triggerClick()" style="height:130px; width:300px; border:1px solid black"/>
<br/>
<label>Upload Photographers Image</label>
</div>
<div style="padding-top:12px;">

<input type="file" name="pgimage" id="aimage" accept="image/jpeg,  image/png" onchange="displayImage(this)" class="form-control" style="display:none">
</div>

 <label for="category">Choose a Category:</label><br/>
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
  <br/>
  <br/>
<input type="text" placeholder="Full Name" name="pgname" required />
<br/>
<br/>
<input type="email" placeholder="Email" name="pgemail" required />

<br/>
<br/>
<input type="text" placeholder="Location" name="locaton" required />
<br/>
<br/>
<input type="password" placeholder="Password" id="pwd" name="pwd" minlength="6" maxlength="8"/>
<br/>
<br/>
<input type="password" placeholder="Retype Password" id="repwd" name="repwd" minlength="6" maxlength="8" />
<br/>
<br/>
<input type="submit" value="Registration" name="regiBtn" onclick="return Validate()"/>
<br/>

<br/>
<br/>
</form></center>
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
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("pwd").value;
        var confirmPassword = document.getElementById("repwd").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<?php
require_once("footer.php");
?>
</div>
</body>

