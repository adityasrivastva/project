$(function(){
	//solving the active menu problem
	switch(menu){
		case 'About Us':
			$('#about').addClass('active');		//id in navbar as a selector
			break;
		case 'Contact Us':
			$('#contact').addClass('active');		//id in navbar as a selector
			break;
		
		default:
			$('#home').addClass('active');	
			break;
	}
	
	
});
