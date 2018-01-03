package com.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.Mobile;
import com.test.repository.MobileMongoRepository;
import com.test.repository.MobileSearchRepository;


@Controller
public class MobileController {

	@Autowired
	MobileMongoRepository mobRepository;
	
	@Autowired
	MobileSearchRepository mobSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("mobileList", mobRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/addMobile", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Mobile mobile) {
		mobRepository.save(mobile);
		return "redirect:home";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("mobileList", mobSearchRepository.searchMobile(search));
		model.addAttribute("search", search);
		return "home";
	}
	
}
