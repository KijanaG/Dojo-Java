package com.garrett.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCode {
	@RequestMapping("/")
	public String crackTheCode() {
		return "index.jsp";
	}
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String theCode(@RequestParam(value="code") String code, RedirectAttributes red) {
		if(code.equals("bushido")) {
			return "code.jsp";
		} else {
			red.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
}
