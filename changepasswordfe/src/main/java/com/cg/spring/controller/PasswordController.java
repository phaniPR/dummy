package com.cg.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasswordController {
	RedirectAttributes attributes;

	@RequestMapping("/changepassword/{mail}/{current}/{newpass}")
	public ModelAndView changePassword(@PathVariable String mail, @PathVariable String current,
			@PathVariable String newpass) {
		RestTemplate rt = new RestTemplate();
		String p = rt.getForObject(
				"http://localhost:7070/change?email=" + mail + "&password=" + current + "&nPassword=" + newpass,
				String.class);
		/*
		 * attributes.addFlashAttribute("Success", "Password changed successfully");
		 * attributes.addFlashAttribute(
		 * "passwordError","You have entered wrong current password");
		 * attributes.addFlashAttribute("InvalidEmail", "Email Id doesnt exists");
		 */
		return new ModelAndView("display", "cust", p);
	}

	@RequestMapping("/")
	public String loginPage() {
		return "ui";
	}

}
