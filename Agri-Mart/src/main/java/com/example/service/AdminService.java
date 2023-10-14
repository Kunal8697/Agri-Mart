package com.example.service;

import java.util.List;

import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Farmer;
import com.example.entity.Register;

public interface AdminService extends JpaRepository<Register,Integer> {

	
	

	
	//List<Register> getFarmersByRegId(int regId);

	//List<Register> getFarmersById(int regId);


}
