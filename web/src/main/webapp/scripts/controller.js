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

        if (data.c) {
            if (data.p) {
                ("#person_region").text(data.p + ", " + data.c);
            } else {
                ("#person_region").text(data.c);
            }
        } else {
            if (data.p) {
                ("#person_region").text(data.p);
            } else {
                ("#person_region").text(" ");

            }
        }

        (data.frc) ? $("#friend_count").text(data.frc) :$("#friend_count").text(" ");
        (data.foc) ? $("#follow_count").text(data.foc): $("#follow_count").text(" ");
        (data.s) ? $("#status_count").text(data.s) :$("#status_count").text(" ");
        (data.d) ? $("#person_discription").text(data.d) : $("#person_discription").text(" ");

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