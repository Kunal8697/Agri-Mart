package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.AdminUser;

import com.example.entity.Register;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
	
	AdminUser findByUsername(String username);
	
}
