$(document).ready(function (){

$('#editHero').hide();
$('#deleteHero').hide();

$('#one').on('click', function() {
$('#one').addClass('active');
$('#addHero').show();
$('#editHero').hide();
$('#deleteHero').hide();
$('#two').removeClass('active');
$('#three').removeClass('active');
});

$('#two').on('click', function() {
  $('#two').addClass('active');
  $('#one').removeClass('active');
  $('#three').removeClass('active');
  $('#editHero').show();
  $('#addHero').hide();
  $('#deleteHero').hide();
});

$('#three').on('click', function() {
  $('#three').addClass('active');
  $('#one').removeClass('active');
  $('#two').removeClass('active');
  $('#deleteHero').show();
  $('#addHero').hide();
  $('#editHero').hide();
});

$('#heroSelect').change(function() {
  var id = $('#heroSelect').val();
  $('#heroID').val(id);
  $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/SuperHeroSightings/hero/' + id,
      success: function(data, status) {
            $('#edit-name').val(data.heroName);
            $('#edit-description').val(data.hDescription);
            $('#edit-isGoodHero').val(data.isGoodHero);
        },
        error: function() {
        }
  });
})



});
