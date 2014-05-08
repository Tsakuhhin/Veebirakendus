    $.get('paevlugemine', function(data) {
    	$('#my_events').html(data);
    });