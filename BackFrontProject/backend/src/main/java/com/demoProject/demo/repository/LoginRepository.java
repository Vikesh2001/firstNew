package com.demoProject.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoProject.demo.entiry.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

	List<Login> findByUsername(String email);

}
