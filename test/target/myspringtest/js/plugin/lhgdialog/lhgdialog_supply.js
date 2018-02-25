
function Mdialog(objData){
	if(!objData)return;
	if(objData.content && objData.content.indexOf("#")){
		objData.content = $("<div></div>").append($(objData.content).clone()).html();
	}
	$.dialog(objData);
}