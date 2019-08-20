package com.sts.shop;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sts.dao.Shop_MemberService;

@Controller
@RequestMapping("/mem")
public class Shop_MemberController {

	@Autowired Shop_MemberService mDAO;
	
	//로그인
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login(Model model, HttpSession httpSession) {
		return "shop/login"; 
	}
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession httpSession) {
		Map<String, Object> rmap = mDAO.selectMemberLogin(map);
		if(rmap != null) {
			httpSession.setAttribute("S_ID", rmap.get("MEM_ID"));
			httpSession.setAttribute("S_NA", rmap.get("MEM_NAME"));
			return "redirect:/main.do"; 
		}
		else {
			System.out.println("로그인 실패");
			return "redirect:login.do"; 
		}
	}
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/main.do"; 
	}
	
	
	
	//회원가입
	@RequestMapping(value="/join.do", method = RequestMethod.GET)
	public String join(Model model, HttpSession httpSession) {
		return "shop/join"; 
	}
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, Object> map) {
		System.out.println( map.get("mem_grade") );
		return "redirect:/main.do"; 
	}
	
	//회원목록
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String list(Model model, HttpSession httpSession) {
		List<Map<String, Object>> list = mDAO.selectMemberList();
		model.addAttribute("list", list);
		return "shop/list"; 
	}
}
