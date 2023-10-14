package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.RegisterRepository;
@Service
public class RegisterServiceImple implements RegisterService {
	 @Autowired
	    private RegisterRepository registerRepository; 
   
	 public  void deleteRegisterById(int id) {
	  
	  this.registerRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	
}