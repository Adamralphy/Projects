$(document).ready(function (){

$('#editSighting').hide();
$('#deleteSighting').hide();

$('#one').on('click', function() {
$('#one').addClass('active');
$('#addSighting').show();
$('#editSighting').hide();
$('#deleteSighting').hide();
$('#two').removeClass('active');
$('#three').removeClass('active');
});

$('#two').on('click', function() {
  $('#two').addClass('active');
  $('#one').removeClass('active');
  $('#three').removeClass('active');
  $('#editSighting').show();
  $('#addSighting').hide();
  $('#deleteSighting').hide();
});

$('#three').on('click', function() {
  $('#three').addClass('active');
  $('#one').removeClass('active');
  $('#two').removeClass('active');
  $('#deleteSighting').show();
  $('#addSighting').hide();
  $('#editSighting').hide();
});

$('#sightingSelect').change(function() {
  var id = $('#sightingSelect').val();
  $('#sightingID').val(id);
  $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/SuperHeroSightings/sighting/' + id,
      success: function(data, status) {
            $('#edit-hero').val(data.hero.heroName);
            $('#edit-location').val(data.location.locationName);
        },
        error: function() {
        }
  });
})




});
