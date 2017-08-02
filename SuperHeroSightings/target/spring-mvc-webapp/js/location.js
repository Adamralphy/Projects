$(document).ready(function (){

$('#editLocation').hide();
$('#deleteLocation').hide();

$('#one').on('click', function() {
$('#one').addClass('active');
$('#addLocation').show();
$('#editLocation').hide();
$('#deleteLocation').hide();
$('#two').removeClass('active');
$('#three').removeClass('active');
});

$('#two').on('click', function() {
  $('#two').addClass('active');
  $('#one').removeClass('active');
  $('#three').removeClass('active');
  $('#editLocation').show();
  $('#addLocation').hide();
  $('#deleteLocation').hide();
});

$('#three').on('click', function() {
  $('#three').addClass('active');
  $('#one').removeClass('active');
  $('#two').removeClass('active');
  $('#deleteLocation').show();
  $('#addLocation').hide();
  $('#editLocation').hide();
});

$('#locationSelect').change(function() {
  var id = $('#locationSelect').val();
  $('#locationID').val(id);
  $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/SuperHeroSightings/location/' + id,
      success: function(data, status) {
            $('#edit-name').val(data.locationName);
            $('#edit-description').val(data.lDescription);
            $('#edit-address').val(data.address);
            $('#edit-latitude').val(data.latitude);
            $('#edit-longitude').val(data.longitude);
        },
        error: function() {
        }
  });
})




});
