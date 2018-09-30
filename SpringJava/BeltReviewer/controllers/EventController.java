package com.garrett.belt.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.garrett.belt.models.Event;
import com.garrett.belt.models.Message;
import com.garrett.belt.models.User;
import com.garrett.belt.services.BeltService;

@Controller
public class EventController {
	private final BeltService beltService;
	
	public EventController(BeltService beltService) {
		this.beltService = beltService;
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		Long id;
		if(session.getAttribute("id") != null) {
			id = (Long) session.getAttribute("id");
		} else {
			return "redirect:/login";
		}
		User u = beltService.findUserById(id);
		model.addAttribute("user", u);
		HashMap<Event, Integer> inState = beltService.inStateEvents(id);
		HashMap<Event, Integer> outOfState = beltService.outOfStateEvents(id);
		model.addAttribute("inState", inState);
		model.addAttribute("outOfState", outOfState);
		return "events/dashboard.jsp";
	}
	
	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		System.out.println("HELLOOO");
		if(result.hasErrors()) {
			System.out.println(result);
			return "redirect:/home";
		} else {
			System.out.println("POOOM");
			Long userId = (Long) session.getAttribute("id");
			User user = beltService.findUserById(userId);
			Event e = beltService.createEvent(event);
			Long id = e.getId();
			return "redirect:/event/"+id;
		}
	}
	
	@GetMapping("/event/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("message") Message message) {
		Event e = beltService.getEvent(id);
		model.addAttribute("event", e);
		List<Message> messages = beltService.allMessages(id);
		model.addAttribute("messages", messages);
		if(session.getAttribute("id") == null) {
			return "redirect:/login";
		}
		Long userID = (Long) session.getAttribute("id");
		User u = beltService.findUserById(userID);
		List<User> attendees = e.getAttendees();
		if(!attendees.contains(u) && e.getCreator().equals(u)) {
			beltService.joinEvent(u, e.getId());
		}
		model.addAttribute("user_id", userID);
		return "events/eventPage.jsp";
	}
	
	@PostMapping("/addMessage/{event_id}")
	public String createMessage(@Valid @ModelAttribute("message") Message message, BindingResult result, @PathVariable("event_id") Long id) {
		if(result.hasErrors()) {
			return "redirect:/event/"+id;
		} else {
			beltService.createMessage(message);
			return "redirect:/event/"+id;
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("event") Event event) {
		Event e = beltService.getEvent(id);
		model.addAttribute("event", e);
		Long user_id = (Long) session.getAttribute("id");
		model.addAttribute("id", user_id);
		return "events/update.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(@ModelAttribute("event") Event event, BindingResult result, HttpSession session, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			System.out.println("HELLO");
			return "redirect:/edit/"+id;
		} else {
			Event e = beltService.updateEvent(event);
			Long eventId = e.getId();
			return "redirect:/event/"+eventId;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		beltService.deleteEvent(id);
		return "redirect:/home";
	}
	
	@PostMapping("/join/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("id");
		User user = beltService.findUserById(userId);
		beltService.joinEvent(user, id);
		return "redirect:/home";
	}
	@PostMapping("/unjoin/{id}")
	public String unJoinEvent(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("id");
		User user = beltService.findUserById(userId);
		beltService.unJoinEvent(user, id);
		return "redirect:/home";
	}

}
