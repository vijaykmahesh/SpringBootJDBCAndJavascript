package com.register.springbootjdbc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.register.springbootjdbc.DAO.RegistrationDAO;
import com.register.springbootjdbc.entity.Login;
import com.register.springbootjdbc.entity.Registration;

@Service
public class UserService {
	@Autowired
	private RegistrationDAO eDAO;

	public int add(Registration registration) {
		return eDAO.save(registration);
	}

	public List<Registration> findAll() {
		return eDAO.findAll();
	}

	public String userVerify(Login log) {

		String logPassword = log.getPassword();
		String logEmail = log.getEmail();
		String signPassword = eDAO.getSignupPassword(log.getEmail());
		String signEmail = eDAO.getSignupEmail(log.getPassword());
		if (logEmail != null && logPassword != null) {
			if (signPassword.equals(logPassword) && signEmail.equals(logEmail)) {
				String message = "successfully logged in";
				return message;
			}
		} else {
			String invalidMessage = "check your password";
			return invalidMessage;
		}

		return signEmail;

	}

	public String userUpdate(Registration registration) {

		return eDAO.userUpdateDAO(registration);
	}
}