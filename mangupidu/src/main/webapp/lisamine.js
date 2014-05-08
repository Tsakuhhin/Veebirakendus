$(document).ready(function() {
	$("#lisanupp").click(function(event) {
		if($("#nimi").val() == "" || $("#kohad").val() == "" || $("#aadress").val() == "" || $("#tund").val() == "" 
			|| $("#minut").val() == "") {
			alert("Sündmust ei lisatud. Osad väljad on täitmata");
			event.preventDefault();
		} else {
			alert("Sündmus lisatud");
		}
	});
});