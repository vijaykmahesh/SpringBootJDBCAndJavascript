package com.register.springbootjdbc.DAO;

import java.util.List;

import com.register.springbootjdbc.entity.Login;
import com.register.springbootjdbc.entity.Registration;

public interface RegistrationDAO {
	
	public int save(Registration e);
	public List<Registration> findAll();
	public String getSignupPassword(String email);
	public String getSignupEmail(String password);
	public String userUpdateDAO(Registration registration);
//	public List<Registration> getEmployeeById(int id);
	}