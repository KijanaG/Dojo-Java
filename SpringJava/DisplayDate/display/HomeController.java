package com.garrett.display;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		DateFormat dayOfWeek = new SimpleDateFormat("EEEEE");
		DateFormat dayOfMonth = new SimpleDateFormat("dd");
		DateFormat month = new SimpleDateFormat("MMMM");
		DateFormat year = new SimpleDateFormat("yyyy");
		String strDay = dayOfWeek.format(date);
		String strDMonth = dayOfMonth.format(date);
		String strMonth = month.format(date);
		String strYear = year.format(date);
		model.addAttribute("day",strDay);
		model.addAttribute("dayOfMonth",strDMonth);
		model.addAttribute("month",strMonth);
		model.addAttribute("year",strYear);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		DateFormat hours = new SimpleDateFormat("kk");
		String strHours = hours.format(date);
		int h = Integer.parseInt(strHours);
		DateFormat time = new SimpleDateFormat("KK:mm ");
		String strTime = time.format(date);
		if(h >= 12) {
			model.addAttribute("time", strTime+" PM");
		} else {
			model.addAttribute("time", strTime+" AM");
		}
		return "time.jsp";
	}
}
