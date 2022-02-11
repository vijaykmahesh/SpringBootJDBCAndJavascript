package com.register.springbootjdbc.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.register.springbootjdbc.entity.Login;
import com.register.springbootjdbc.entity.Registration;
import com.register.springbootjdbc.service.UserService;
@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {
	@Autowired
	private UserService service;
	@PostMapping("/registration")
	public String save(@RequestBody Registration registration) {
		return service.add(registration)+" Registration(s) saved successfully";
	}
	@GetMapping("/retrieve")
	public List<Registration> findAll() {
		return  service.findAll();
	}
	@PostMapping("/verify")
	public String userLogin (@RequestBody Login log) throws Exception {
		return service.userVerify(log);
	}

	@PostMapping("/update")
	public String update(@RequestBody Registration registration){
		return service.userUpdate(registration);
	}		
}