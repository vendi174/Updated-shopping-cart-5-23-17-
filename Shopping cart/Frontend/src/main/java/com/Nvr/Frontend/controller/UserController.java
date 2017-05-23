package com.Nvr.Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.Nvr.Backend.dao.*;
import com.Nvr.Backend.model.*;
import java.util.List;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	UserDAO userDao;
	@Autowired
	User user;

	@RequestMapping("/Register")
	public String register(Model m) {
		
		User user=new User();
		m.addAttribute("user", user);
		
		return "Register";
	}

	@RequestMapping("/UserHome")
	public String showUserHome(Model m) {
		List<Product> list = productDAO.showProduct();
		m.addAttribute("prodlist", list);
		return "UserHome";
	}

	@RequestMapping(value = "/ProductDesc/{prodid}", method = RequestMethod.GET)
	public String showProductDesc(@PathVariable("prodid") int prodid, Model m) {
		Product prod = productDAO.getProduct(prodid);
		m.addAttribute("prodinfo", prod);
		return "ProductDesc";
	}

	@RequestMapping(value = "/addUser")
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult result, Model m) {
		
		System.out.println("add user");
		if (result.hasErrors()) {
			return "Register";
		}
		userDao.insertUser(user);
		return "RegistrationSuccess";
	}

}
