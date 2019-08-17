package com.sts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sts.dao.MemberService;
import com.sts.vo.Member;

@Controller
public class AdminController {

	//DAO 객체 생성
	@Autowired
	private MemberService mDAO;
	
	//127.0.0.1:8080/web/admin.do    ?menu=1
	@RequestMapping(value="/admin.do", method = RequestMethod.GET)
	public String admin(@RequestParam(value="menu", 
			defaultValue="0", required = false) int no, Model model) {
		if(no == 0) { //menu가 입력되지 않았다면 2번 메뉴로 강제 이동 시킴.
			return "redirect:admin.do?menu=2";
		}
		else if(no == 1) {
			List<Member> list = mDAO.selectMemberList();
			model.addAttribute("list", list);
		}
		return "admin";
	}
}
