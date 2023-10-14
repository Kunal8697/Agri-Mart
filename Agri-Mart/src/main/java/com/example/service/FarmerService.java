package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Farmer;

@Service
public interface FarmerService {

	List<Farmer> getAllProducts(int regId);
	List<Farmer> getAllProducts();
	
	void deleteProductById(int productId);
	
	List<Farmer> viewProductById(int productId);
	
	Farmer getProductById(int productId);

	void bidUpdate(Farmer farmer);

	void saveUpdate(Farmer farmer);

	List<Farmer> getAllFarmers();
	
	
	void updateProductById(int productId);
	void updateProductById(Farmer farmer);
	void updateProductStatus(int productId);
	
	
	
	



	

	
	
	
	
	
//	public List<Farmer> getProductById(int productd) ;
//	
//	public	void updateBid(int productId,double highestBid,String winnerId) ;
//	
//	public List<Farmer> getStatusChange();
	
}
