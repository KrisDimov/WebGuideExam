function showPassword() {
	var checkBox = document.getElementById('password-visibility');
	var password = document.getElementById('password');
	if (checkBox.checked == true) {
		password.type='text';
	} else {
		password.type='password';
	}
}

function changeActivePageColor() {
	var url = window.location.pathname;
	if (url.indexOf('/') == url.lastIndexOf('/')) {
		document.getElementById('home').className='current';
	} else {
		var currentPage = url.substring(url.lastIndexOf('/')+1, url.length);
		document.getElementById(currentPage).className='current';
	}
}
