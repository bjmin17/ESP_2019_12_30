package com.biz.esp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.esp.domain.PageDTO;
import com.biz.esp.domain.ReferenceDTO;
import com.biz.esp.persistence.ReferenceDao;
import com.biz.esp.service.PageService;
import com.biz.esp.service.ReferenceService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("referenceDTO")
@Slf4j
@RequestMapping(value="/reference")
@Controller
public class ReferenceController {

	@Autowired
	ReferenceService rService;
	
	@Autowired
	PageService pService;
	
	
	
	@ModelAttribute("referenceDTO")
	public ReferenceDTO makeRefDTO() {
		ReferenceDTO referenceDTO = new ReferenceDTO();
		return referenceDTO;
	}
	
	// searchField는 카테고리로 전체, 제목, 내용으로 검색할 때 사용하는 부분
	@RequestMapping(value="/rlist",method=RequestMethod.GET)
	public String getRList(@RequestParam(value = "currentPageNo", required = false, defaultValue = "1") long currentPageNo, String searchField, String search, Model model) {
		log.debug("서치필드 값 : "+searchField);
		List<ReferenceDTO> refList ;
		if(searchField.equalsIgnoreCase("allList")) {
			// 서비스에서 allList일 때 작동할거 만들어주기
			refList = rService.selectAllSearch(searchField, search);
		} else if(searchField.equalsIgnoreCase("title")) {
			// 제목으로만 검색했을 때
			refList = rService.selectTitle(search);
		} else if(searchField.equalsIgnoreCase("content")) {
			// 내용으로 검색했을 때
			refList = rService.selectContent(search);
		} else if(search.trim() == null || search.isEmpty()) {
			refList = rService.selectAll(currentPageNo);
		} else {
			refList = rService.selectAllSearch(searchField, search);
		}
		
		long totalCount = rService.totalCount();
		PageDTO pageDTO = pService.makePagination(totalCount, currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("RLIST",refList);
		return "/reference/r-list";
	}
//	정책자료실 세부내용 페이지
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String rview(@RequestParam("id") String d_seq, @ModelAttribute("referenceDTO") ReferenceDTO referenceDTO, Model model, SessionStatus sStatus) {

		long r_seq = 0;
		try {
			r_seq = Long.valueOf(d_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// memoDTO를 try 밖으로 보낸 이유는 저 안에서 오류나면 서비스에서 오류난걸 알 수 없음
		referenceDTO = rService.getSeq(r_seq);
		model.addAttribute("rDTO",referenceDTO);

		sStatus.setComplete();
		return "/reference/r-view";

	}
	
//	정책자료실 등록
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("referenceDTO") ReferenceDTO referenceDTO, Model model) {

		model.addAttribute("rDTO",referenceDTO);
		return "/reference/r-input";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("referenceDTO") ReferenceDTO referenceDTO, String search, Model model, SessionStatus sStatus) {

		int ret = rService.insert(referenceDTO);
		sStatus.setComplete();
		return "redirect:/reference/rlist?searchField=&search=";
	}
	
//	정책자료실 업데이트
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id,  @ModelAttribute("referenceDTO") ReferenceDTO referenceDTO,Model model) {
		
		long m_seq = 0;

		try {
			m_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		referenceDTO = rService.getSeq(m_seq);
		model.addAttribute("referenceDTO",referenceDTO);
		
		return "/reference/r-input";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("referenceDTO") ReferenceDTO referenceDTO, Model model, SessionStatus sStatus) {
		
		int ret = rService.update(referenceDTO);
		sStatus.setComplete();
		return "redirect:/reference/rlist?searchField=&search=";
	}

//	정책자료실 삭제
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	// public String delete(long m_seq) {	
	public String delete(@ModelAttribute ReferenceDTO referenceDTO) {
		int ret = rService.delete(referenceDTO.getD_seq());
		return "redirect:/reference/rlist?searchField=&search=";
	}
}
