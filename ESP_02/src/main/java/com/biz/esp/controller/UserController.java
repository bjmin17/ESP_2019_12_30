package com.biz.esp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.esp.domain.UserDTO;
import com.biz.esp.service.UserService;

@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	@Autowired
	UserService uService;
	
	@RequestMapping(value="personal_info_agree", method=RequestMethod.GET)
	public String join_personal(Model model) {
		
		return "user/personal_info_agree";
	}
	
	@RequestMapping(value = "join",method=RequestMethod.GET)
	public String join(Model model) {
		
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);
		
		return "user/insert";
	}
	
	@RequestMapping(value = "join",method=RequestMethod.POST)
	public String join(@ModelAttribute("userDTO") @Valid UserDTO userDTO,BindingResult bResult,Model model) {
		
		if(bResult.hasErrors()) {
			return "user/insert";
		}else {
			int ret = uService.userJoin(userDTO);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "idcheck",method=RequestMethod.GET)
	public String userIdCheck(String u_id, Model model) {
		boolean idYes = uService.userIdCheck(u_id);
		model.addAttribute("ID_YES", idYes);
		model.addAttribute("u_id", u_id);
		
		return "user/idcheck";
	}
	
	
	
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Model model,HttpSession httpSession) {
		
		UserDTO userDTO 
			= (UserDTO)httpSession.getAttribute("userDTO");
		model.addAttribute("userDTO",userDTO);
		return "user/insert";
	}
}
