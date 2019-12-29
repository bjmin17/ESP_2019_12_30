package com.biz.esp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.esp.domain.OpinionDTO;
import com.biz.esp.service.OpinionService;

@Controller
public class ESPController {

	@Autowired
	OpinionService oService;
	
//	사이트 소개 페이지
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public String intro(Model model) {
		
		return "/intro";
	}
//	이용약관 페이지
	@RequestMapping(value="/infouse", method=RequestMethod.GET)
	public String infouse(Model model) {
		
		return "/infouse/infouse";
	}
	
//	개인정보처리방침 페이지
	@RequestMapping(value="/privacy", method=RequestMethod.GET)
	public String privacy(Model model) {
		
		return "/infouse/privacy";
	}
	
//	개선의견 페이지
	@RequestMapping(value="/opinion", method=RequestMethod.GET)
	public String opinion(OpinionDTO opinionDTO, Model model) {
		
		model.addAttribute("oDTO", opinionDTO);
		return "/infouse/opinion";
	}
	
//	개선의견 페이지 등록
	@RequestMapping(value="/opinion", method=RequestMethod.POST)
	public String opinion(OpinionDTO opinionDTO, String strSeq, Model model) {
		
		OpinionDTO oDTO = opinionDTO;
		
		if(oDTO.getO_title().isEmpty()) {
	         oDTO.setO_title("기본 제목 형식");
	      }
	      if(oDTO.getO_email().isEmpty()) {
	         oDTO.setO_email("기본 제목 형식");
	      }
	      if(oDTO.getO_content().isEmpty()) {
	         oDTO.setO_content("기본 내용 형식");
	      }
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		
		String dateD = sd.format(date);
		st.format(date);

		oDTO.setO_date(dateD);
		int ret = oService.insert(oDTO);
		return "redirect:/opinion";
	}
	
}

