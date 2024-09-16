package com.demoProject.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demoProject.demo.entiry.Company;
import com.demoProject.demo.entiry.Login;
import com.demoProject.demo.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	public Login saveLogin(Login login) {
		return loginRepository.save(login);
		
	}
	
	
	public List<Login> getAllLogin(String uname){
		return loginRepository.findByUsername(uname);
	}
	
	public void deleteUser(Long id) {
	loginRepository.deleteById(id);

   }

	public Login updateLogin(Long id, Login loginDetails) {
        Login existingLogin = loginRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found with id: " + id));
        existingLogin.setUsername(loginDetails.getUsername());
        existingLogin.setPassword(loginDetails.getPassword());
        existingLogin.setFirstName(loginDetails.getFirstName());
        existingLogin.setLastname(loginDetails.getLastName());
        return loginRepository.save(existingLogin);
    }
	

}
