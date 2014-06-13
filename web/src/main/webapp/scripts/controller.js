var controller = {

	_init : function() {
		controller._initView();

	},
	_initView : function() {
		object = controller.GetRequestParameter();
		id = object["personid"];
		controller.showPersonInfoByID(id);
	},
	
	GetRequestParameter:function() // get personID from url
	{ 
		var url = location.search; 
	    var theRequest = new Object();
		if (url.indexOf("?") != -1) 
		{
			var str = url.substr(1);
			    strs = str.split("&");
			    for(var i = 0; i < strs.length; i ++) {
			         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
			      }
	    }
			return theRequest;
	},
	
	onSuccessGetPersonInfo : function(data)
	{
        (data.g) ? $("#person_gender").text(data.g) : $("#person_gender").text(" ");
        (data.c) ? $("#person_region").text(data.c) : $("#person_region").text(" ");
        (data.constellation) ? $("#person_constellation").text(data.constellation) :$("#person_constellation").text(" ");
        (data.education) ? $("#person_education").text(data.education): $("#person_education").text(" ");
        (data.institutions) ? $("#person_institution").text(data.institutions) :$("#person_institution").text(" ");
        (data.company) ? $("#person_company").text(data.company) : $("#person_company").text(" ");
        (data.position) ? $("#person_position").text(data.position) : $("#person_position").text(" ");
        (data.income) ? $("#person_income").text(data.income):$("#person_income").text(" ");
		
	},
	onErrorGetPersonInfo : function()
	{
		
	},
	showPersonInfoByID : function(ID)
	{
		model.getPersonByID(ID, controller.onSuccessGetPersonInfo, controller.onErrorGetPersonInfo);
	},
};
$(function() {
	controller._init();
});