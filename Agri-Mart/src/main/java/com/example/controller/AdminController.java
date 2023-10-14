package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.AdminUser;
import com.example.entity.Bidding;
import com.example.entity.Farmer;
import com.example.entity.Register;
import com.example.repository.AdminUserRepository;
import com.example.repository.BiddingRepository;
import com.example.repository.FarmerRepository;
import com.example.repository.RegisterRepository;

import com.example.service.RegisterService;

@Controller
public class AdminController {
	 
	@Autowired
	    private AdminUserRepository adminUserRepository;
	 @Autowired
	    private BiddingRepository biddingRepository;
	 @Autowired
		private RegisterService registerService;
	  @Autowired
	    private RegisterRepository registerRepository; 
	  @Autowired
		private FarmerRepository farmRepository;




    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "adminLogin"; // Return the name of the HTML template (adminLogin.html)
    }
    
    
    @GetMapping("/admin/dashboard")
    public String showAdminDashboard() {	
        return "adminDashboard"; // Return the name of the HTML template (adminDashboard.html)
    }
    
    
    @GetMapping("/admin/dashboard/biddinglog")
    public String showBiddingLog(Model model) {
        List<Bidding> biddinglog = biddingRepository.findAll();
        model.addAttribute("biddinglog", biddinglog);
        return "biddingLog"; // Return the name of the HTML template
    
    }
   
    

    @GetMapping("/admin/dashboard/showFarmers")
    public String showFarmers(Model model) {
        List<Register> farmers = registerRepository.findByType("farmer"); 
        model.addAttribute("farmers", farmers);
        return "showFarmers"; // Return the view name
    }

    
    
    @GetMapping("/admin/dashboard/showbuyers")
    public String showBuyers(Model model) {
        List<Register> buyers = registerRepository.findByType("buyer");
        model.addAttribute("buyers", buyers);
        return "showbuyers"; // Return the view name
    }
      

    @GetMapping("/admin/dashboard/productlist")
    public String showProductList(Model model) {
        List<Farmer> products = farmRepository.findAll(); 
        model.addAttribute("products", products);
        return "ProductList"; // Return the view name
    }

    
    
    
    @PostMapping("/admin/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        AdminUser adminUser = adminUserRepository.findByUsername(username);
        
        if (adminUser != null && adminUser.getPassword().equals(password)) {
            // Admin user authenticated
            // Handle the authentication logic and redirect to appropriate page
            return "redirect:/admin/dashboard"; // Return the name of the HTML template for admin dashboard
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "adminLogin";
        }
    }
    
    
    
    @GetMapping("/admin/dashboard/showUser/deleteUser/{id}")
	public String deleteRegister(Model model, @PathVariable(value = "id") int id) {
		try{
			System.out.println(id);
			registerService.deleteRegisterById(id);
			System.out.println(id);
			return "redirect:/admin/dashboard/showFarmers";
		} catch (Exception e) {
			return "redirect:error";
		}
	}
    
    
    
    
    
    
}
