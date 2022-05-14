<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Power Plant details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/main.js"></script>
 <script type="text/javascript">
 $(document).on('submit', '#form',  function(e){
     e.preventDefault();
     $.ajax({
         type: 'POST',
         url: "http://localhost:8080/crud/webapi/powerplants/insertion",
         data: new FormData(this),
         dataType: 'json',
         contentType: false,
         processData:false,//this is a must
         success: function(response){ 
             //statements on success
         }
     });
 });
</script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-8">
 
 <h1 class="m-3">Power Plant Details</h1>
 
 <form id="formPowerPlant">
 
 <!-- ID -->
 <div class="input-group input-group-sm mb-3">
 <div class="input-group-prepend">
 <span class="input-group-text" id="lblId">ID: </span>
 </div>
 <input type="text" id="txtId" name="txtId">
 </div>
 
 <!-- NAME -->
 <div class="input-group input-group-sm mb-3">
 <div class="input-group-prepend">
 <span class="input-group-text" id="lblName">Name: </span>
 </div>
 <input type="text" id="txtName" name="txtName">
 </div>
 
 <!-- TYPE -->
 <div class="input-group input-group-sm mb-3">
 <div class="input-group-prepend">
 <span class="input-group-text" id="lblType">Type: </span>
 </div>
 <input type="text" id="txtType" name="txtType">
 </div>
 
 <!-- ADDRESS -->
 <div class="input-group input-group-sm mb-3">
 <div class="input-group-prepend">
 <span class="input-group-text" id="lblAddress">Address: </span>
 </div>
 <input type="text" id="txtAddress" name="txtAddress">
 </div>
 
 <!-- CAPACITY -->
 <div class="input-group input-group-sm mb-3">
 <div class="input-group-prepend">
 <span class="input-group-text" id="lblCapacity">Capacity: </span>
 </div>
 <input type="text" id="txtCapacity" name="txtCapacity">
 </div>
 
 <div id="alertSuccess" class="alert alert-success"></div>
 <div id="alertError" class="alert alert-danger"></div>
<input type="button" id="btnSave" value="Save" class="btn btn-primary">
</form>
</div>
</div>
 
<br>
 
<div class="row">
<div class="col-12" id="colPowerPlants">
 
</div>
</div>
</div>
</body>
</html>