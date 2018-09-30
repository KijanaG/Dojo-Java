//package com.garrett.authentication.controllers;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.garrett.authentication.models.User;
//import com.garrett.authentication.services.UserService;
//import com.garrett.authentication.validator.UserValidator;
//
//@Controller
//public class UserController {
//	private final UserService userService;
//	private final UserValidator userValidator;
//	
//	public UserController(UserService uS, UserValidator uV) {
//		this.userService = uS;
//		this.userValidator = uV;
//	}
//	
//	@GetMapping("/registration")
//	public String registerForm(@ModelAttribute("user") User user) {
//		return "logreg/logreg.jsp";
//	}
//	
//	@GetMapping("/login")
//	public String login(@ModelAttribute("user") User user) {
//		return "logreg/logreg.jsp";
//	}
//	
//	@PostMapping("/registration")
//	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//		userValidator.validate(user, result);
//		if(result.hasErrors()) {
//			return "logreg/logreg.jsp";
//		} else {
//			User u = userService.registerUser(user);
//			session.setAttribute("id", u.getId());
//			return "redirect:/home";
//		}
//	}
//
//	@PostMapping("/login")
//	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes red) {
//        if(userService.authenticationUser(email, password)) {
//        	User u = userService.findByEmail(email);
//        	session.setAttribute("id", u.getId());
//        	return "redirect:/home";
//        } else {
//        	red.addFlashAttribute("error", "Could not be logged in.");
//        	return "redirect:/login";
//        }
//	}
//	
//	@GetMapping("/home")
//	public String home(HttpSession session, Model model) {
//		System.out.println(session.getAttribute("id"));
//		Long id;
//		if(session.getAttribute("id") != null) {
//			id = (Long) session.getAttribute("id");
//		} else {
//			return "redirect:/login";
//		}
//		User u = userService.findUserById(id);
//		model.addAttribute("user", u);
//		return "logreg/homePage.jsp";
//	}
//	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.setAttribute("id", null);
//		return "redirect:/login";
//	}
//}
