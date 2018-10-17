package com.esther.displaydate;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateTimeController {
	
	@RequestMapping("/")
	public String index() {
//	Date date = new Date();
//	System.out.println("Today's date is: "+date.toString());
	
 
    return "index.jsp";
    }
	
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		Format day = new SimpleDateFormat("EEEE");
		String d = day.format(new Date());
		
		Format month = new SimpleDateFormat("MMMM");
		String m = month.format(new Date());
		
		Format date = new SimpleDateFormat("d");
		String dt = date.format(new Date());
		
		Format year = new SimpleDateFormat("yyyy");
		String y = year.format(new Date());
		
		model.addAttribute("day", d);
		model.addAttribute("month", m);
		model.addAttribute("date", dt);
		model.addAttribute("year", y);
		
		return "date.jsp";
		
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		Format time = new SimpleDateFormat("hh:mm a");
		String t = time.format(new Date());
		
		model.addAttribute("time", t);
		
		return "time.jsp";
	}



}
