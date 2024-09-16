package com.demoProject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoProject.demo.entiry.Company;
import com.demoProject.demo.entiry.Login;
import com.demoProject.demo.service.LoginService;

@CrossOrigin("http://localhost:8080/")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/sign")
	public Login saveLogin(@RequestBody Login login) {
		System.out.println("-=-=-=----fdfdfdf-----------------"+login);
		return loginService.saveLogin(login);
	}
	
	@GetMapping("/log")
    public List<Login> getAllLogin(@RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password) {
		System.out.println("-=-=-=---------------------");
        return loginService.getAllLogin(username);
        
    }
	
	@DeleteMapping("/{id}")
	public void deleteLogin(@PathVariable("id") Long id) {
		loginService.deleteUser(id);
	}
		
	@PutMapping("/update/{id}")
    public Login updateLogin(@PathVariable("id") Long id, @RequestBody Login login) {
        return loginService.updateLogin(id, login);
    }

}
