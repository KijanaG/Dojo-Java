package com.garrett.ninjaGold;

import java.util.Date;
import java.util.ArrayList;
//import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ninjaGold {
	protected static ArrayList<String> activities = new ArrayList<String>();
	@RequestMapping("/Gold")
	public String gold(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		} else {
			int count = (int) session.getAttribute("gold");
			model.addAttribute("gold", count);
		}
		ArrayList<String> newList = new ArrayList<String>();
		if(activities.size() > 0) {
			for(int i = activities.size()-1; i >=0;i--) {
				newList.add(activities.get(i));
			}
		}
		model.addAttribute("list", newList);
		return "gold.jsp";
	}
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String addGold(@RequestParam(value="location") int num, HttpSession session) {
		int rand;
		String activity;
		if(num == 0) {
			rand = (int) Math.floor(Math.random()*11)+10;
			activity = "You entered a farm and earned "+rand+" gold. ("+ new Date()+")";
		} else if(num == 1) {
			rand = (int) Math.floor(Math.random()*6)+5;
			activity = "You entered a cave and earned "+rand+" gold. ("+ new Date()+")";
		} else if(num == 2) {
			rand = (int) Math.floor(Math.random()*4)+2;
			activity = "You entered a house and earned "+rand+" gold. ("+ new Date()+")";
		} else {
			int sign = (int) Math.floor(Math.random()*2);
			System.out.println(sign);
			rand = (int) Math.floor(Math.random()*51);
			activity = "You entered a casino and earned "+rand+" gold. ("+ new Date()+")";
			if(sign == 0) {
				rand *= -1;
				activity = "You entered a farm and lost "+rand+" gold...Ouch. ("+ new Date()+")";
			}
		}
		int total = (int) session.getAttribute("gold");
		total += rand;
		session.setAttribute("gold", total);
		System.out.println("Random "+rand);
		activities.add(activity);
		return "redirect:/Gold";
	}
}
