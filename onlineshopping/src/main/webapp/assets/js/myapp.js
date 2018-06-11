$(function() {
	// solving the active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active'); // id in navbar as a selector
		break;
	case 'Contact Us':
		$('#contact').addClass('active'); // id in navbar as a selector
		break;
	case 'All Products':
		$('#listProducts').addClass('active'); // id in navbar as a selector
		break;

	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// Code for jquery dataTable
	// 1. create a dataset
	var products = [
		
						['1', 'ABC'],
						['2', 'XYZ'],
						['3', 'PQR'],
						['4', 'MNO'],
						['5', 'CFG'],
						['6', 'HIj'],
						['7', 'LMP'],
						['8', 'BLR']
					];
	//For jquery element use $table to rap around jquery elements
	//Fetch table by Id selector of jquery i.e. #
	var $table = $('#productListTable');
	
	//execute the below code only where we have this table
	// This is only for view products 
	if ($table.length) {
		//console.log('Inside the table')
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']],
			pageLength:5,
			data: products
		});
	}
	

});
