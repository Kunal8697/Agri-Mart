package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Farmer;
import com.example.repository.FarmerRepository;
@Service
public class FarmerServiceImple implements FarmerService{
	@Autowired
	private FarmerRepository farmerRepo;

	public List<Farmer> getAllProducts(int regId) {
		
		return farmerRepo.findAllById(regId) ;
	}
	
	
	
	public List<Farmer> getAllProducts() {
		
		return farmerRepo.findAll() ;
	}
	
	
	
	public List<Farmer> getAllFarmers() {
	        return farmerRepo.findAll();}

	@Override
	public void deleteProductById(int productId) {
		this.farmerRepo.deleteById(productId);
		
	}

	@Override
	public List<Farmer> viewProductById(int productId) {
		
		return this.farmerRepo.getProductBy(productId);
	}

	@Override
	public void bidUpdate(Farmer farmer) {
		this.farmerRepo.save(farmer);
		
	}

	@Override
	public Farmer getProductById(int productId) {
	  
	   return this.farmerRepo.getById(productId);
	}

	@Override
	public void saveUpdate(Farmer farmer) {
		this.farmerRepo.save(farmer);
	}

	
	

	@Override
	public void updateProductById(Farmer farmer) {
		this.farmerRepo.save(farmer);
	}



	 public void updateProductStatus(int productId) {
	        Farmer farmer = farmerRepo.findByProductId(productId);
	        if (farmer != null && farmer.getStatus().equals("unsold")) {
	        	farmer.setStatus("sold");
	            farmerRepo.save(farmer);
	        }
	    }



	@Override
	public void updateProductById(int productId) {
		// TODO Auto-generated method stub
		
	}
	



	 
	

//	@Override
//	public  Farmer getProductById(int productId) {
//		
//		 return this.farmerRepo.save(productId);
//	}
//
//	@Override
//	public void saveBidding(Farmer farmer) {
//		// TODO Auto-generated method stub
//		
//	}

	
	
	
	
	

//	@Override
//	public List<Farmer> getProductById(int productId) {
//		
//		return farmerRepo.getProductByPId(productId);
//	}
//
//	@Override
//	public void updateBid(int productId, double highestBid, String winnerId) {
//		
//		this.farmerRepo.updateHighestBidPrice(productId,highestBid,winnerId);
//	}
//
//	@Override
//	public List<Farmer> getStatusChange() {
//		
//		return farmerRepo.getStatusChange(false);
//				
//	}

	
}

