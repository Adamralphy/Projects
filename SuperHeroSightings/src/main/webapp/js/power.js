$(document).ready(function (){

$('#editPower').hide();
$('#deletePower').hide();

$('#one').on('click', function() {
$('#one').addClass('active');
$('#addPower').show();
$('#editPower').hide();
$('#deletePower').hide();
$('#two').removeClass('active');
$('#three').removeClass('active');
});

$('#two').on('click', function() {
  $('#two').addClass('active');
  $('#one').removeClass('active');
  $('#three').removeClass('active');
  $('#editPower').show();
  $('#addPower').hide();
  $('#deletePower').hide();
});

$('#three').on('click', function() {
  $('#three').addClass('active');
  $('#one').removeClass('active');
  $('#two').removeClass('active');
  $('#deletePower').show();
  $('#addPower').hide();
  $('#editPower').hide();
});

$('#powerSelect').change(function() {
  var id = $('#powerSelect').val();
  $('#powerID').val(id);
  $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/SuperHeroSightings/power/' + id,
      success: function(data, status) {
            $('#edit-description').val(data.pDescription);
        },
        error: function() {
        }
  });
})




});
