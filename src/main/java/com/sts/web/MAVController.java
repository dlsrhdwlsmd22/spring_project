package com.sts.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sts.vo.MavVO;

@Controller
public class MAVController {
	
	@RequestMapping(value="/mav_select.do", method = RequestMethod.GET)
	public String select(Locale locale, Model model) {
		List<String> selectItem = new ArrayList<String>();
		selectItem.add("java");
		selectItem.add("c");
		selectItem.add("nodejs");
		selectItem.add("react");
		selectItem.add("oracle");
		
		MavVO vo = new MavVO();
		vo.setId("aaaa");
		vo.setLang("nodejs");
		
		model.addAttribute("vo", vo);
		model.addAttribute("select_list", selectItem);
		
		return "mav_select";
	}
	
	@RequestMapping(value="/mav_select.do", method = RequestMethod.POST)
	public String select(@ModelAttribute("vo") MavVO vo) {
		System.out.println(vo.toString());
		return "redirect:mav_select.do";
	}
}
