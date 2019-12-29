package com.biz.esp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.esp.domain.TargetVO;
import com.biz.esp.service.TargetService;

@RequestMapping(value="/esp")
@Controller
public class OBJController {
	
	@Autowired
	TargetService targetService;
	
//	청년 정책 메인
	@RequestMapping(value="/object", method=RequestMethod.GET)
	public String object(Model model) {
		
		
		model.addAttribute("sideColorBold", "young");
		
		List<TargetVO> targetList = targetService.getYoungAll();
		
		model.addAttribute("TARGETLIST", targetList);
		return "/object/object_main";
	}
	

// 청년 추가고용 장려금 지원사업 페이지
	
	@RequestMapping(value="/object/ym1", method=RequestMethod.GET)
	public String objectToYm1(Model model, String pt_tcode) {
		
		TargetVO targetVO = targetService.getContentByTCode(pt_tcode);
		model.addAttribute("sideColorBold", "young");
		model.addAttribute("TARGETVO", targetVO);
		return "/object/object_ym1";
	}



	


	//여성 정책 메인
	@RequestMapping(value="/object/fmmain", method=RequestMethod.GET)
	public String objectFMMain(Model model) {
		
		model.addAttribute("sideColorBold", "female");
		List<TargetVO> targetList = targetService.getWomenAll();
		model.addAttribute("TARGETLIST", targetList);
		return "/object/object_fmmain";
	}
	
	
	
	//여성정책세부페이지
	@RequestMapping(value="/object/wm1", method=RequestMethod.GET)
	public String objectToWm1(Model model, String pt_tcode) {
		
		TargetVO targetVO = targetService.getContentByTCode(pt_tcode);
		model.addAttribute("sideColorBold", "female");
		model.addAttribute("TARGETVO", targetVO);
		return "/object/object_ym1";
	}
	
	
	
	
	//중장년 정책 메인
	@RequestMapping(value="/object/mdmain", method=RequestMethod.GET)
	public String objectMDMain(Model model) {
			
		model.addAttribute("sideColorBold", "middle");
		List<TargetVO> targetList = targetService.getMiddleAll();
		model.addAttribute("TARGETLIST", targetList);
		return "/object/object_mdmain";
	}
	
	
	//중장년정책세부페이지
		@RequestMapping(value="/object/mm1", method=RequestMethod.GET)
		public String objectToMm1(Model model, String pt_tcode) {
			
			TargetVO targetVO = targetService.getContentByTCode(pt_tcode);
			model.addAttribute("sideColorBold", "middle");
			model.addAttribute("TARGETVO", targetVO);
			return "/object/object_ym1";
		}
	
	
	//장애인 정책 메인
	@RequestMapping(value="/object/damain", method=RequestMethod.GET)
	public String objectDAMain(Model model) {
		
		model.addAttribute("sideColorBold", "disable");
		List<TargetVO> targetList = targetService.getDisableAll();
		model.addAttribute("TARGETLIST", targetList);
		return "/object/object_damain";
	}
	
	
	//장애인정책세부페이지
			@RequestMapping(value="/object/dm1", method=RequestMethod.GET)
			public String objectToDm1(Model model, String pt_tcode) {
				
				TargetVO targetVO = targetService.getContentByTCode(pt_tcode);
				model.addAttribute("sideColorBold", "disable");
				model.addAttribute("TARGETVO", targetVO);
				return "/object/object_ym1";
			}
	
	
	//외국인 정책 메인
	@RequestMapping(value="/object/frmain", method=RequestMethod.GET)
	public String objectFRMain(Model model) {
		
		model.addAttribute("sideColorBold", "foreign");
		List<TargetVO> targetList = targetService.getForeignAll();
		model.addAttribute("TARGETLIST", targetList);
		return "/object/object_frmain";
	}
	
	
	//외국인정책세부페이지
	@RequestMapping(value="/object/fm1", method=RequestMethod.GET)
	public String objectToFm1(Model model, String pt_tcode) {
		
		TargetVO targetVO = targetService.getContentByTCode(pt_tcode);
		model.addAttribute("sideColorBold", "foreign");
		model.addAttribute("TARGETVO", targetVO);
		return "/object/object_ym1";
	}
	
	
	
	
	
	
	
}
