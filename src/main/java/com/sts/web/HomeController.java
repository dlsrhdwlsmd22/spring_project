package com.sts.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sts.exception.PageNotFoundException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}

	//127.0.0.1:8080/web/board1.do
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String page(@PathVariable("page") String page) {
		if(page.equals("home")) { //home.do
			return "home";
		}
		else {
			throw new PageNotFoundException(); //오류처리함.
		}
	}
	
	@ExceptionHandler(PageNotFoundException.class)
	public String pageNotFound() {
		return "page404";
	}
}
