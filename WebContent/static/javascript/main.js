function showPassword() {
	var checkBox = document.getElementById('password-visibility');
	var password = document.getElementById('password');
	if (checkBox.checked == true) {
		password.type='text';
	} else {
		password.type='password';
	}
}