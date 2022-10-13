    
$(document).ready(function(){
	var grid=$("#grid-data").bootgrid({
		navigation:2,
		columnSelection:false,
		ajax:true,
		url:"/show_company_account",
		formatters: {
			"commands": function(column, row)
			{
				return "<button class=\"btn btn-xs btn-default ajax-link command-run1\" data-row-id=\"" + row.id+ "\">detail</button>";
			}
		}
	}).on("loaded.rs.jquery.bootgrid", function()
	{
		grid.find(".command-run1").on("click", function(e)
		{
			var taskid=$(this).data("row-id");
			$.post("/show_company_account",{},function(data){
				var obj = data;
				$("#id").val(obj.id);
				$("#company_name").val(obj.company_name);
				$("#bank_name").val(obj.bank_name);
				$("#account").val(obj.account);
				$("#account_number").val(obj.account_number);
			});
			$("#manager").show();
		});
	});
});
	  
function getLocalTime(nS) {  
 return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/,' ');  
}
