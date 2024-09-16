package com.demoProject.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoProject.demo.ApiResponse;
import com.demoProject.demo.entiry.Company;
import com.demoProject.demo.service.CompanyService;
@CrossOrigin("http://localhost:8080/")
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	
	@Autowired
	private CompanyService companyService;
	
	
	@GetMapping("/list")
    public List<Company> getAllCompany() {
		 System.out.println("=-=-=-===============--");
        return companyService.getAllCompany();
       
        
    }
	
	 @GetMapping("/{itemName}")
	    public List<Company> getCompanyById(@PathVariable("itemName") String itemName) {
	        return companyService.getCompaniesByItemName(itemName);
	    }
	
	@GetMapping("/ItemName/{itemName}")
			public ResponseEntity<Object> getCompaniesByItemName(@PathVariable("technology") String itemName) {
		        List<Company> companies = companyService.getCompaniesByItemName(itemName);
		        if (companies.isEmpty()) {
		            ApiResponse response = new ApiResponse("Requested data not found");
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		        }
		        
		        return ResponseEntity.ok(companies);
		    }
	

	@PostMapping
	public Company saveCompany(@RequestBody Company company) throws Exception {
	    return companyService.saveCompany(company);
	}

	
//	@PutMapping("/{id}")
//    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
//        try {
//            // Retrieve the existing company
//            Company company = companyService.getCompanyById(id).orElseThrow(() -> new RuntimeException("Company not found"));
//
//            // Update fields
//            company.setBrandName(companyDetails.getBrandName());
//            company.setItemColor(companyDetails.getItemColor());
//            company.setItemName(companyDetails.getItemName());
//            company.setItemPrice(companyDetails.getItemPrice());
//            company.setItemRating(companyDetails.getItemRating());
//            company.setItemSize(companyDetails.getItemSize());
//
//            // Handle image URL if provided
//            if (companyDetails.getImageUrl() != null && !companyDetails.getImageUrl().isEmpty()) {
//                companyService.updateImageFromUrl(company, companyDetails.getImageUrl());
//            }
//
//            // Save updated company
//            Company updatedCompany = companyService.saveCompany(company);
//            return ResponseEntity.ok(updatedCompany);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }

	 @DeleteMapping("/{id}")
	 public  ResponseEntity<ApiResponse> deleteEntity(@PathVariable("id") Long id) {
		 ApiResponse response = new ApiResponse("Entity successfully deleted");
		 companyService.deleteCompany(id);
		 return ResponseEntity.status(HttpStatus.OK).body(response);
	 }
	 
//	 @DeleteMapping("/{id}")
//	    public ResponseEntity<ApiResponse> deleteCompany(@PathVariable("id") Long id) {
//	        boolean exists = companyService.existsById(id);
//	        if (!exists) {
//	            ApiResponse response = new ApiResponse("Entity not found");
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//	        }
//	        
//	        companyService.deleteCompany(id);
//	        ApiResponse response = new ApiResponse("Entity successfully deleted");
//	        return ResponseEntity.status(HttpStatus.OK).body(response);
//	    }

	
	

}
