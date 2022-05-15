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
        var status = validatePowerPlantForm();
        // If not valid-------------------
        if (status != true) {
            $("#alertError").text(status);
            $("#alertError").show();
            return;
        }
        // If valid----------------------- 
       var type = ($("#hidPowerPlantIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "PowerPlantsAPI", 
 type : type, 
 data : $("#formPowerPlant").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemSaveComplete(response.responseText, status); 
 } 
 }); 
});
function onItemSaveComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 }

 }
   // UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidPowerPlantIDSave").val($(this).data("id"));
 $("#name").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#type").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#address").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#capacity").val($(this).closest("tr").find('td:eq(4)').text()); 

});       
    
// REMOVE==========================================
$(document).on("click", ".btnRemove", function(event) 
{ 
 $.ajax( 
 { 
 url : "PowerPlantsAPI", 
 type : "DELETE", 
 data : "id=" + $(this).data("id"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onPowerPlantDeleteComplete(response.responseText, status); 
 } 
 }); 
});
// CLIENT-MODEL=================================================================

    function validatePowerPlantForm() 
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
 return "Insert power plant type."; 
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

/*function getPowerPlantCard(id, name, address) 
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
*/

