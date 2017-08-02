$(document).ready(function (){

$('#editOrg').hide();
$('#deleteOrg').hide();

$('#one').on('click', function() {
$('#one').addClass('active');
$('#addOrg').show();
$('#editOrg').hide();
$('#deleteOrg').hide();
$('#two').removeClass('active');
$('#three').removeClass('active');
});

$('#two').on('click', function() {
  $('#two').addClass('active');
  $('#one').removeClass('active');
  $('#three').removeClass('active');
  $('#editOrg').show();
  $('#addOrg').hide();
  $('#deleteOrg').hide();
});

$('#three').on('click', function() {
  $('#three').addClass('active');
  $('#one').removeClass('active');
  $('#two').removeClass('active');
  $('#deleteOrg').show();
  $('#addOrg').hide();
  $('#editOrg').hide();
});

$('#orgSelect').change(function() {
  var id = $('#orgSelect').val();
  $('#orgID').val(id);
  $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/SuperHeroSightings/organization/' + id,
      success: function(data, status) {
            $('#edit-name').val(data.orgName);
            $('#edit-description').val(data.oDescription);
            $('#edit-address').val(data.address);
            $('#edit-phoneNumber').val(data.phoneNumber);
        },
        error: function() {
        }
  });
})




});
