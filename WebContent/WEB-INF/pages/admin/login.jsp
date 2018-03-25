<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>

	<c:if test="${requirement}">
		<div class='error'>You have to be logged in to
			access this page</div>
	</c:if>
	<c:if test="${error}">
		<div class='error'>Invalid email/password. Try again.</div>
	</c:if>

	<div class='form-container'>
		<form action='/WebGuideExam/login' method='post'>
			<div class='form-row'>
				<label class='required'>username</label>
				<input type='text' placeholder='Enter your email' name='username' />
			</div>
			<div class='form-row'>
				<label class='required'>password</label>
				<input type='password' id='password' placeholder='Enter your pasword' name='password' />
			</div>
			<div class='form-row password-visibility'>
				<input type='checkbox' id='password-visibility' onclick='showPassword()'>
				<label for='checkbox'>Show password</label>
			</div>
			<div class='form-row'>
				<button type='submit' name='submit'>Login</button>
			</div>
			<div class='create-an-account'>
				<a href='/WebGuideExam/register'>Create an account</a>
			</div>
		</form>
	</div>

</structure:template>