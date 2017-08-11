$(function(){
	//solving the active menu problem
	switch(menu){
		case 'About Us':
			$('#about').addClass('active');
			break;
			
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
			
		case 'All Products':
			$('#viewProducts').addClass('active');
			break;
			
		default:
		if(menu == "Home") break;
		$('#viewProducts').addClass('active');	
		$('#a_'+menu).addClass('active');
		break;
	}

	//code for datatable
	
	var $table = $("#productListTable");
	//execute the below code only where we have this table
	if($table.length){
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		
		
		$table.DataTable({
			lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'ALL']],
			pageLength: 5,
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns:[
			         {
			        	 data: 'code',
			        	 mRender: function(data, type, row){
			        		 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "dataTableImage"/>';
			        	 }
			         },
			         {
			        	 data: 'name' 
			         },
			         {
			        	 data: 'brand'
			         },
			         {
			        	 data: 'unitPrice',
			        	 mRender: function(data, type, row){
			        		 return '&#8377;' + data
			        	 }
			         },
			         {
			        	 data: 'quantity'
			         },
			         {
			        	 data: 'id',
			        	 bSortable: false,
			        	 mRender: function(data, type, row){
			        		 var str = '';
			        		 str += '<a href = "'+window.contextRoot+'/show/'+data+'/product" class = "btn btn-primary"><span class = "glypicon glyphicon-eye-open"></span></a>&#160;';
			        		 str += '<a href = "'+window.contextRoot+'/cart/add/'+data+'/product" class = "btn btn-success"><span class = "glypicon glyphicon-shopping-cart"></span></a>';
			        		 return str;
			        	 }
			         }
			        ]
			
		});
	}
});