package com.example.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Farmer;
import com.example.entity.Register;

import antlr.collections.List;



public interface RegisterRepository extends JpaRepository<Register, Integer> {
	
	@Query("select u from Register u where u.username = :username")
	public Register getRegisterByRegisterName(@Param("username") String username);
	
	@Query("select u from Register u where u.username = :username")
	public Register getUserByUserName(@Param("username") String username);
	
	@Query("select u from Register u where u.id = :id")
	public Register getRegisterByRegisterId(@Param("id") int id);	
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("update Register u set u.password = :password where u.username=:username"
	 * ) public int updatePass(@Param(value = "username") String
	 * username,@Param(value = "password") String password);
	 */

	@Query("SELECT r FROM Register r WHERE r.type = 'buyer'")
    List findBuyers();

	@Query("SELECT r FROM Register r WHERE r.type = 'farmer'")
    List findFarmer();
	
	@Query(value="select * from  Register r where r.id=?1", nativeQuery =true)
	List getRegisterBy(int id);
	
	public java.util.List<Register> findByType(String string);
}
