package com.biz.esp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.esp.domain.NewsDTO;
import com.biz.esp.domain.PageDTO;
import com.biz.esp.service.NewsService;
import com.biz.esp.service.PageService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("newsDTO")
@RequestMapping(value="/news")
@Slf4j
@Controller
public class NewsController {


	@Autowired
	NewsService nService;
	
	@Autowired
	PageService pService;
	
	@ModelAttribute("newsDTO")
	public NewsDTO makeNewsDTO() {
		NewsDTO newsDTO = new NewsDTO();
		return newsDTO;
	}
	// searchField는 카테고리로 전체, 제목, 내용으로 검색할 때 사용하는 부분
	@RequestMapping(value="/nlist",method=RequestMethod.GET)
	public String getNList(@RequestParam(value = "currentPageNo", required = false, defaultValue = "1") long currentPageNo, String searchField, String search, Model model) {
		log.debug("서치필드 값 : "+searchField);
		List<NewsDTO> newsList ;
		if(searchField.equalsIgnoreCase("allList")) {
			// 서비스에서 allList일 때 작동할거 만들어주기
			newsList = nService.selectAllSearch(searchField, search);
		} else if(searchField.equalsIgnoreCase("title")) {
			// 제목으로만 검색했을 때
			newsList = nService.selectTitle(search);
		} else if(searchField.equalsIgnoreCase("content")) {
			// 내용으로 검색했을 때
			newsList = nService.selectContent(search);
		} else if(search.trim() == null || search.isEmpty()) {
			newsList = nService.selectAll(currentPageNo);
		} else {
			newsList = nService.selectAllSearch(searchField, search);
		}
		
		long totalCount = nService.totalCount();
		PageDTO pageDTO = pService.makePagination(totalCount, currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("NLIST",newsList);
		return "/news/n-list";
	}
	
	// 소식페이지 세부내용 보기
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String nview(@RequestParam("id") String n_seq, @ModelAttribute("newsDTO") NewsDTO newsDTO, Model model) {

		long r_seq = 0;
		try {
			r_seq = Long.valueOf(n_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// memoDTO를 try 밖으로 보낸 이유는 저 안에서 오류나면 서비스에서 오류난걸 알 수 없음
		newsDTO = nService.getSeq(r_seq);
		model.addAttribute("nDTO",newsDTO);

		
		return "/news/n-view";

	}
	
	// 소식페이지 등록 부분
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("newsDTO") NewsDTO newsDTO, Model model) {

		model.addAttribute("nDTO",newsDTO);
		return "/news/n-input";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("newsDTO") NewsDTO newsDTO, String search, Model model, SessionStatus sStatus) {

		int ret = nService.insert(newsDTO);
		sStatus.setComplete();
		return "redirect:/news/nlist?searchField=&search=";
	}
	
	// 소식페이지 업데이트
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id,  @ModelAttribute("newsDTO") NewsDTO newsDTO,Model model) {
		
		long n_seq = 0;

		try {
			n_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		newsDTO = nService.getSeq(n_seq);
		model.addAttribute("newsDTO",newsDTO);
		
		return "/news/n-input";
	}
	
	// 소식페이지 업데이트, 포스트
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("newsDTO") NewsDTO newsDTO, Model model, SessionStatus sStatus) {
		
		int ret = nService.update(newsDTO);
		sStatus.setComplete();
		return "redirect:/news/nlist?searchField=&search=";
	}
	
	// 소식페이지 삭제
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	// public String delete(long m_seq) {	
	public String delete(@ModelAttribute NewsDTO newsDTO) {
		int ret = nService.delete(newsDTO.getN_seq());
		return "redirect:/news/nlist?searchField=&search=";
	}
}
