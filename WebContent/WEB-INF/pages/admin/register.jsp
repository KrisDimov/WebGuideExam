<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>

	<c:if test="${not registerForm.valid()}">
		<div class='error'>Please enter data in all fields</div>
	</c:if>

	<div class='form-container'>
		<form method='post'>
			<div class='form-row'>
				<label class='required'>name</label>
				<input type='text' value='${registerForm.name}' placeholder='John Dow' name='name' />
			</div>
			<div class='form-row'>
				<label class='required'>email</label>
				<input type='email' value='${registerForm.email}' placeholder='example@mail.com' name='email' />
			</div>
			<div class='form-row'>
				<label class='required'>password</label>
				<input type='password' id='password' placeholder='Enter your password' name='password' />
			</div>
			<div class='form-row password-visibility'>
				<input type='checkbox' id='password-visibility' onclick='showPassword()'>
				<label for='checkbox'>Show password</label>
			</div>
			<div class='form-row'>
				<button type='submit' name='submit'>Register</button>
			</div>
		</form>
	</div>

</structure:template>