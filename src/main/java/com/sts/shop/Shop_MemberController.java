package com.sts.shop;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sts.dao.Shop_MemberService;
import com.sts.vo.Shop_Member;

@Controller
@RequestMapping("/shop")
public class Shop_MemberController {
	
	@Autowired
	private Shop_MemberService SmDAO;
	
	@ModelAttribute
	@RequestMapping(value="/join.do", method = RequestMethod.GET)
	public String join(@ModelAttribute Shop_Member Shop_member, HttpSession httpSession) {
		System.out.println("connect!~~~~~~~~~~~~~~~~~~~~~~~");
		return "shop/join"; 
	}
	
	//<input type ="text" name="aa2" value="23">
	//map.put("aa2","23");
	
	
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public String join(@ModelAttribute Shop_Member Shop_member) {
		SmDAO.insertMemberOne(Shop_member);
		System.out.println("sign up!~~~~~~~~~~~~~~~~~~~~~~");
		return "shop/main"; 
	}
}
