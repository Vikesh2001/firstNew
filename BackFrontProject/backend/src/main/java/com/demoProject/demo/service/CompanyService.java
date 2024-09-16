package com.demoProject.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoProject.demo.entiry.Company;
import com.demoProject.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getAllCompany(){
		return companyRepository.findAll();
	}
	
	
	 public void updateImageFromUrl(Company company, String imageUrl) throws Exception {
	        try {
	            URL url = new URL(imageUrl);
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            try (InputStream inputStream = url.openStream()) {
	                IOUtils.copy(inputStream, outputStream);
	            }
	            company.setImage(outputStream.toByteArray());
	        } catch (MalformedURLException e) {
	            throw new IllegalArgumentException("Invalid URL: " + imageUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to download image from URL: " + imageUrl, e);
	        }
	    }
	 
	 
	 
	public List<Company> getCompaniesByItemName(String itemName) {
        return companyRepository.findByItemName(itemName);
    }
	
//	public Company saveCompany(Company company) {
//		return companyRepository.save(company);
//		
//	}
	public Company saveCompany(Company company) throws Exception {
        if (company.getImage() == null || company.getImage().length == 0) {
            // Ensure that imageUrl is not null and not empty
            if (company.getImageUrl() != null && !company.getImageUrl().isEmpty()) {
                try {
                    URL url = new URL(company.getImageUrl());
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    try (InputStream inputStream = url.openStream()) {
                        IOUtils.copy(inputStream, outputStream);
                    }
                    company.setImage(outputStream.toByteArray());
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException("Invalid URL: " + company.getImageUrl(), e);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to download image from URL: " + company.getImageUrl(), e);
                }
            } else {
                throw new IllegalArgumentException("Image URL is null or empty");
            }
        }
        // Save the company entity
        return companyRepository.save(company);
    }
	
	
	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
		
	}

}
