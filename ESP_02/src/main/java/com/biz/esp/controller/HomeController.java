package com.biz.esp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.esp.domain.NewsDTO;
import com.biz.esp.domain.ReferenceDTO;
import com.biz.esp.service.NewsService;
import com.biz.esp.service.ReferenceService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	ReferenceService rService;
	
	@Autowired
	NewsService nService;
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/esp/list";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<ReferenceDTO> refList ;
			refList = rService.selectFiveList();
		List<NewsDTO> newsList;
			newsList = nService.selectFiveList();
			
		model.addAttribute("RLIST",refList);
		model.addAttribute("NLIST",newsList);
		
		return "home";
	}
	
}
