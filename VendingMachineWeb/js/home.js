$(document).ready(function () {
  $.ajax ({
      type: 'GET',
      url: 'http://localhost:8080/items',
      success: function (data, status) {
          $.each(data, function (index, item) {
              var id = item.id;
              var name = item.name;
              var price = item.price;
              var quantity = item.quantity;

              var candyId = 'item' + id;
              var candyName = "candy-name" + id;
              var candyPrice = "candy-price" + id;
              var candyQ = 'candy-q' + id;
              $('#' + candyId).append(id);
              $('#' + candyName).append(name);
              $('#' + candyPrice).append('<br/>' + '<br/>' + '<br/>' + '$' + price.toFixed(2));
              $('#' + candyQ).append('<br/>' + '<br/>' + '<br/>' + '<br/>' + 'Quantity left: ' + quantity);

              // $('#one').on('hover',
              // function() {
              //     $(this).css('box-shadow','10px 10px 5px #888');
              // }, function() {
              //$(this).css('box-shadow', 'none');
              // });

              $('#div' + id).on('click', function() {
                $('#message').val('');
              })

              $('#div' + id).on('click', function(){
                $('#item-box').val(item.id);
                $('#change').val('');
              });
          });

      },
      error: function() {
          $('#errorMessages')
              .append($('<li>')
              .attr({class: 'list-group-item list-group-item-danger'})
              .text('Error calling web service.  Please try again later.'));
      }
  });


$('#add-dollar').on('click', function() {

})

  $('#add-dollar').click(function(event) {
    amount+=1;
    $('#total-in').val(amount.toFixed(2));
  });
  $('#add-quarter').click(function(event) {
    amount+=.25;
    $('#total-in').val(amount.toFixed(2));
  });
  $('#add-dime').click(function(event) {
    amount+=.1;
    $('#total-in').val(amount.toFixed(2));
  });
  $('#add-nickel').click(function(event) {
    amount+=.05;
    $('#total-in').val(amount.toFixed(2));
  });

  $('#make-purchase').click(function(event) {
    vend();

    //amount = 0;
  });

  $('#change-return').click(function(event) {
    returnChange(amount);
    amount = 0;
    $('#total-in').val('');
    $('#message').val('');
    $('#item-box').val('');
  });
});
var amount = 0;

function vend() {
var id = document.getElementById('item-box').value;
$.ajax({
  type:'GET',
  url:'http://localhost:8080/money/' + amount + '/item/' + id,
  success: function(data) {
    var quarters = data.quarters;
    var dimes = data.dimes;
    var nickels = data.nickels;
    var pennies = data.pennies;
    $('#change').val(quarters + 'Quarters ' + dimes + 'Dimes ' + nickels + 'Nickels ' + pennies + 'Pennies ');
    $('#total-in').val('');
    amount = 0;
    $('#message').val('Thank You!');
  },
  error: function(data) {
var a = JSON.parse(data.responseText);
    $('#message').val(a.message);
  }
});
}

function returnChange(amount) {
    // for (; sum.compareTo(oneHunnit) == 1 || sum.compareTo(oneHunnit) == 0; sum = sum.subtract(oneHunnit)) {
    //     dollarCoin++;
    // }
    var quarters = 0;
    var dimes = 0;
    var nickels = 0 ;
    var pennies = 0;
    amount*=100;

    for (; amount>=25; amount-=25) {
        quarters++;
    }
    for (; amount>=10; amount-=10) {
        dimes++;
    }
    for (; amount>=5; amount-=5) {
        nickels++;
    }
    for(; amount>=1; amount-=1){
      pennies++;
    }
    $('#change').val(quarters + 'Quarters ' + dimes + 'Dimes ' + nickels + 'Nickels ' + pennies + 'Pennies ');
}
