package com.garrett.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Count {
	@RequestMapping("/counter")
	public String homeCount(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			model.addAttribute("count", 0);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count", count);
		}
		return "index.jsp";
	}
	@RequestMapping("")
	public String countCount(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		return "other.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count = 0;
		session.setAttribute("count", count);
		return "redirect:/counter";
	}
}
