package com.garrett.belt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.garrett.belt.models.User;
import com.garrett.belt.services.BeltService;
import com.garrett.belt.validator.UserValidator;

@Controller
public class LoginController {
	private final BeltService userService;
	private final UserValidator userValidator;
	
	public LoginController(BeltService uS, UserValidator uV) {
		this.userService = uS;
		this.userValidator = uV;
	}

	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
		session.setAttribute("id", null);
		return "logreg/logreg.jsp";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("user") User user, HttpSession session) {
		session.setAttribute("id", null);
		return "logreg/logreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes red) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "logreg/logreg.jsp";
		} else {
			if(userService.findByEmail(user.getEmail()) == null) {
				User u = userService.registerUser(user);
				session.setAttribute("id", u.getId());
				return "redirect:/home";
			} else {
				red.addFlashAttribute("email", "Email already exists.");
				return "redirect:/login";
			}
		}
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes red) {
        if(userService.authenticationUser(email, password)) {
        	User u = userService.findByEmail(email);
        	session.setAttribute("id", u.getId());
        	return "redirect:/home";
        } else {
        	red.addFlashAttribute("error", "Could not be logged in.");
        	return "redirect:/login";
        }
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		return "redirect:/login";
	}
}
