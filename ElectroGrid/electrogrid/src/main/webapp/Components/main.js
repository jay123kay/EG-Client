$(document).ready(function() 
{ 
 $("#alertSuccess").hide(); 
 $("#alertError").hide(); 
}); 
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
        // Clear status msges-------------
        $("#alertSuccess").text("");
        $("#alertSuccess").hide();
        $("#alertError").text("");
        $("#alertError").hide();

        // Form validation----------------
        var status = validateItemForm();
        // If not valid-------------------
        if (status != true) {
            $("#alertError").text(status);
            $("#alertError").show();
            return;
        }
        // If valid----------------------- 
        // Generate the card and append
        var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "http://localhost:8080/crud/webapi/powerplants/insertion", 
 type : type, 
 data : $("#formItem").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemSaveComplete(response.responseText, status); 
 } 
 }); 
});

         
    
// REMOVE==========================================
$(document).on("click", ".remove", function(event) 
{ 
 $(this).closest(".powerplant").remove(); 
 
 $("#alertSuccess").text("Removed successfully."); 
 $("#alertSuccess").show(); 
}); 

// CLIENT-MODEL=================================================================

    function validateItemForm() 
{
// ID
if ($("#txtId").val().trim() == "") 
 { 
 return "Insert power plant id."; 
 } 	 
// NAME
if ($("#txtName").val().trim() == "") 
 { 
 return "Insert power plant name."; 
 } 
 // TYPE
if ($("#txtType").val().trim() == "") 
 { 
 return "Insert power plant Type."; 
 } 
// ADDRESS
if ($("#txtAddress").val().trim() == "") 
 { 
 return "Insert power plant address."; 
 } 
// CAPACITY
if ($("#txtCapacity").val().trim() == "") 
 { 
 return "Insert power plant capacity."; 
 } 
return true; 
}

function getPowerPlantCard(id, name, address) 
{ 

var powerplant = ""; 
 powerplant += "<div class=\"powerplant card bg-light m-2\" style=\"max-width: 10rem; float: left;\">"; 
 powerplant += "<div class=\"card-body\">"; 
 powerplant += id + " " + name + ","; 
 powerplant += "<br>";
 powerplant += address; 
 powerplant += "</div>"; 
 powerplant += "<input type=\"button\" value=\"Remove\" class=\"btn btn-danger remove\">"; 
 powerplant += "</div>"; 
 
return powerplant; 
}


