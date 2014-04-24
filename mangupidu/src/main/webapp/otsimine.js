$(document).ready(function() {
	$("#otsinupp").click(function(event) {
		if($("#nimi").val() == "" || $("#kohad").val() == "" || $("#aadress").val() == "" || $("#tund").val() == "" 
			|| $("#minut").val() == "") {
			alert("Sobivaid sündmusi ei leitud.");
			event.preventDefault();
		} else {
			alert("Leitud sündmused.");
		}
	});
});