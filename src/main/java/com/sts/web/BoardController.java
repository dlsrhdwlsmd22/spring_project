package com.sts.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sts.dao.BoardService;

@Controller
public class BoardController {

	//DAO 객체 생성
	@Autowired
	private BoardService bDAO;
	
	//127.0.0.1:8080/web/board.do
	@RequestMapping(value="/board.do", method = RequestMethod.GET)
	public String boardlist(Model model, HttpSession httpSession) {
		//세션에 BRD_HIT_CHECK에 1을 넣음
		httpSession.setAttribute("BRD_HIT_CHECK", 1);
		//DB에서 목록을 받아옴.
		List<Map<String, Object>> list = bDAO.selectBoardList();
		//jsp로 값 전달함.
		model.addAttribute("list", list);
		//board.jsp를 표시.
		return "board"; 
	}
	
	
	//127.0.0.1:8080/web/boardc.do
	@RequestMapping(value="/boardc.do", method = RequestMethod.GET)
	public String boardconent(@RequestParam("no") int no, Model model, 
			HttpSession httpSession) {
		//세션에서 값 꺼내기
		int chk = (Integer)httpSession.getAttribute("BRD_HIT_CHECK");
		if(chk == 1) {
			//조회수 1증가 시키기
			bDAO.updateBoardHit(no);
			httpSession.setAttribute("BRD_HIT_CHECK", 0);
			
			//httpSession.invalidate(); => 현재 세션을 완전히 지움
		}
		
		//게시물 1개 가져오기
		Map<String, Object> map = bDAO.selectBoardOne(no);
		model.addAttribute("map",map);
		
		//이전글, 다음글
		int prev = bDAO.selectBoardPrev(no);
		int next = bDAO.selectBoardNext(no);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		return "boardc";
	}
	
	//127.0.0.1:8080/web/boardw.do
	@RequestMapping(value="/boardw.do", method = RequestMethod.GET)
	public String boardwrite() {
		return "boardw";
	}
	
	@RequestMapping(value="/boardw.do", method = RequestMethod.POST)
	public String boardwrite(
			@RequestParam("title") String a,
			@RequestParam("content") String b,
			@RequestParam("writer") String c) {
		//insert, update, delete  => INT(0 또는 1), select,
		//DB에 추가함. : DAO로 전달함. -> DAO가 mapper로 전달함 -> mapper SQL문을 수행
 		
		//Map 또는 VO 사용
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("TI", a);
		map.put("CO", b);
		map.put("WR", c);
		
		int ret = bDAO.insertBoardOne( map );
		return "redirect:board.do"; //board.jsp
	}
	
	
	@RequestMapping(value="/boarde.do", method = RequestMethod.GET)
	public String boardedit(@RequestParam("no") int no, Model model) {
		Map<String, Object> map = bDAO.selectBoardOne(no);
		model.addAttribute("map", map);
		return "boarde";
	}
	
	@RequestMapping(value="/boarde.do", method = RequestMethod.POST)
	public String boardedit(@RequestParam HashMap<String, Object> map) {
		bDAO.updateBoardOne(map);
		return "redirect:boardc.do?no="+map.get("no");
	}

}
