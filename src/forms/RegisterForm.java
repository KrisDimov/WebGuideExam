package forms;

import javax.servlet.http.HttpServletRequest;

import util.StringValidation;

public class RegisterForm {

	private String name;
	private String email;
	private String password;
	private boolean validationCheck;
	
	public RegisterForm() {
		this.validationCheck = true;
	}
	
	public boolean isValidationCheck() {
		return validationCheck;
	}

	public void setValidationCheck(boolean validationCheck) {
		this.validationCheck = validationCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static RegisterForm fromRequest(HttpServletRequest request) {
		RegisterForm form = new RegisterForm();
		form.setValidationCheck(false);
		form.setName(request.getParameter("name"));
		form.setEmail(request.getParameter("email"));
		form.setPassword(request.getParameter("password"));
		return form;
	}
	
	public boolean valid() {
		if (isValidationCheck()) {
			return true;
		}
		
		if (StringValidation.isEmpty(name)) {
			return false;
		}
		if (StringValidation.isEmpty(email)) {
			return false;
		}
		if (StringValidation.isEmpty(password)) {
			return false;
		}
		return true;
	}
	
}
