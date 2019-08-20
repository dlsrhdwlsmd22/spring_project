package com.sts.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sts.dao.MemberService;
import com.sts.vo.Member;

@Controller
public class MemberController {
	//DAO 객체 생성
	@Autowired
	private MemberService mDAO;
	
	
	@RequestMapping(value="/memberimg.do",method = RequestMethod.GET)
	public ResponseEntity<byte[]> memberimg(@RequestParam("id") String id){
		try {
			Member vo = mDAO.selectMemberImg( id ); 
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.MULTIPART_FORM_DATA);
			//byte[]을 이미지로 변환해서 전달함.
			return new ResponseEntity<byte[]>(vo.getMem_img(), header, HttpStatus.OK);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.GET)
	public ModelAndView join(Model model, HttpSession httpSession) {
		//view파일명, 명칭, view에서 값을 보관할 vo
		return new ModelAndView( "join", "cmd", new Member() ); 
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public String join(@ModelAttribute("cmd") Member mem, 
			MultipartHttpServletRequest request) {
		try {
			MultipartFile file = request.getFile("mem_img1");
			mem.setMem_img( file.getBytes() ); //mem_img1 => mem_img
			System.out.println(file.getOriginalFilename());

			mDAO.insertMemberOne(mem);
			return "redirect:join.do"; 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:join.do";
		}
	}
	
	
	
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login(Model model, HttpSession httpSession) {
		return "login"; 
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String update(Model model, HttpSession httpSession) {
		return "login"; 
	}
	
	@RequestMapping(value="/del.do", method = RequestMethod.GET)
	public String del(Model model, HttpSession httpSession) {
		return "login"; 
	}
		
}
