package com.example.democontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.MemberProfileConfiguration;

public class ProfileController {
	@Autowired
	MemberProfileConfiguration memberProfileConfiguration;
	
	
	@RequestMapping("/profile")
	public String getConfig(Model model) {
		model.addAttribute("model", memberProfileConfiguration.getDefaultModel());
		model.addAttribute("min", memberProfileConfiguration.getMinRentPeriod());
		return "mprofile";

	}
	

}
