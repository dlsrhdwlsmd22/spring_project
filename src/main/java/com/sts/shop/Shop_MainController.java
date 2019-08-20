package com.sts.shop;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Shop_MainController {
	@RequestMapping(value="/main.do", method = RequestMethod.GET)
	public String join(Model model, HttpSession httpSession) {
		return "shop/main"; 
	}
	
	@RequestMapping(value="/chatclient.do", method = RequestMethod.GET)
	public String chatclient(Model model, HttpSession httpSession) {
		return "shop/chatclient"; 
	}
	
	@RequestMapping(value="/brokerclient.do", method = RequestMethod.GET)
	public String brokerclient(Model model, HttpSession httpSession) {
		return "shop/brokerclient"; 
	}
}

