$(document).ready(function() {
	$("#lisanupp").click(function(event) {
		if($("#nimi").val() == '' || $("#kohad").val() == "" || $("#tund").val() == "" 
			|| $("#minut").val() == "" || $("#aadress").val() == "" ||) {
		alert("Sündmust ei lisatud. Osad väljad on täitmata");
		event.preventDefault();
		} else {
			alert("Sündmus lisatud. (kellaaeg ja kuupäev ikka veel vigased");
		}
	});
});