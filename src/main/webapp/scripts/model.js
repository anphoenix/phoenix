var model = {

	CONFIGURATION_BASE_URL : "apis/persons",
	
	getAllPersons : function(ID, onSuccess, onError) {
		var url = this.CONFIGURATION_BASE_URL;
		$.ajax({
			url : url,
			type : 'GET',
			contentType : 'application/json',
			success : function(responseText) {
				console.debug(responseText);
				onSuccess(responseText);
			},
			error : onError
		});
	},
	
	getPersonByID : function(ID, onSuccess, onError) {
		var url = this.CONFIGURATION_BASE_URL + "/" + ID;
		$.ajax({
			url : url,
			type : 'GET',
			contentType : 'application/json',
			success : function(responseText) {
				console.debug(responseText);
				onSuccess(responseText);
			},
			error : onError
		});
	}
};