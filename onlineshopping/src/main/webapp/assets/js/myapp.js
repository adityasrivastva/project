$(function(){
	//solving the active menu problem
	switch(menu){
		case 'About Us':
			$('#about').addClass('active');		//id in navbar as a selector
			break;
		case 'Contact Us':
			$('#contact').addClass('active');		//id in navbar as a selector
			break;
		case 'All Products':
			$('#listProducts').addClass('active');		//id in navbar as a selector
			break;
		
		default: 
			if (menu == 'Home') 
				break;
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
	
});
