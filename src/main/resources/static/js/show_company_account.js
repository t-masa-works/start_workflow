    
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
	});
});
