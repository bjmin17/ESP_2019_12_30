package com.biz.esp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biz.esp.domain.AreaDTO;
import com.biz.esp.domain.PaginationDTO;
import com.biz.esp.service.AreaService;
import com.biz.esp.service.PaginationService;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;

@Slf4j
@RequestMapping(value = "/esp")
@Controller
public class AREAController {

	@Autowired
	PaginationService paginationService;

	@Autowired
	AreaService areaService;

//	지역별 정책 메인
	@RequestMapping(value = "/area", method = RequestMethod.GET)
	public String area() {

		return "/area/area";
	}
	
	
	//지역 정책 등록 진입
	@RequestMapping(value="/area/inputarea", method = RequestMethod.GET)
	public String inputArea() {
		
		return "/area/areaWrite";
	}
	
	
	
	// 정책 등록 후 새ㅔ부 정책 내용보기로 이동
	
	@RequestMapping(value="/area/areapolinput", method=RequestMethod.GET)
	public String areaPolInput(String pa_acode, String pa_title, String pa_btarget, String pa_binfo,
			String pa_bpurpose, String pa_parti, String pa_contact, RedirectAttributes redirect) {
		
		AreaDTO areaDTO = new AreaDTO(0, pa_acode, pa_title, pa_bpurpose, pa_btarget, pa_binfo, pa_parti, pa_contact);
		int ret = areaService.insertAreaPolicy(areaDTO);
		
		//RedirectAttributes redirect = null;
		
		redirect.addAttribute("pa_acode", pa_acode);
		return "redirect:/esp/area/view";
	}
	
	
	//ajax 요청, ㅋㅗ드max값 반환
	@ResponseBody
	@RequestMapping(value="/area/areawritecodemax", method=RequestMethod.GET)
	public String areaWriteCodeMax(String pa_acode){
		
		System.out.println("max작업 자바로 넘어간 코드출력::::::::::::::"+ pa_acode);
		
		pa_acode = pa_acode.substring(0,3);

		pa_acode = areaService.getAreaMaxCode(pa_acode);		// 해당 코드의 지역게시물 전체 가졍오기

		
		System.out.println("컨트롤러 최대값 코드"+pa_acode);
		
		String fixPa_Acode = pa_acode.substring(0, 3); //ASE저장
		
		String fixPa_Acode2 = pa_acode.substring(3); // 0000
		
		 int fixPa_AcodeInt = Integer.valueOf(fixPa_Acode2)+1; // 0001
		
		 pa_acode = String.format("%s%04d", fixPa_Acode, fixPa_AcodeInt);
	
		return pa_acode;
	}
	
	
	
	//ajax의 리스트 반환 요청, 지역코드로 지역 게시물 리스트 가자ㅕ오기
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value="/area/areawritesearch", method=RequestMethod.GET)
	public JSONArray areaWriteSearch(String pa_acode){
		
		System.out.println("코드출력::::::::::::::"+ pa_acode);
		
		//int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 지역의 총 게시글 수 구해오기

		//PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaWriteContent(pa_acode);		// 해당 코드의 지역게시물 전체 가졍오기

		
		JSONArray areaJsonArray = new JSONArray();
		
		areaJsonArray.addAll(areaList);
		System.out.println("리스트출력::::::::::::::"+ areaJsonArray);
	
		return areaJsonArray;
	}
	
	
	// 지역별 정책 검색
	@RequestMapping(value = "/area/searchArea", method = RequestMethod.GET)
	public String areaSearch(Model model, @RequestParam(defaultValue = "1", required = false) int curPage
			, String searchVal, String pa_acode) {

		
		System.out.println("넘어온 pa_acode:" + pa_acode);
		
		
		pa_acode = pa_acode.substring(0,3);    // 지역코드 자르기 'ase'
		
		 //String searchVal2 = searchVal.toUpperCase();
		
		
		System.out.println("자른" + pa_acode);
		
		int seoulListCnt = paginationService.getAreaSearchListCnt(pa_acode, searchVal); // 지역+검색내용 총 게시글 수 구해오기
		
		
		System.out.println("지역검색리스트개수:"+seoulListCnt);

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaSearchContent(paginationDTO.getStartIndex() + 1, pa_acode, searchVal);
		
		
		
		
		
		
		String disName = areaService.sideWorkDisName(pa_acode);
		int disSideSlideSW = areaService.sideWorkDisSideSlideSW(pa_acode);
		
		

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		model.addAttribute("disSideSlideSW", disSideSlideSW);
		model.addAttribute("sideColorBold", disName);
		model.addAttribute("SEARCHVAL", searchVal);
		model.addAttribute("PA_ACODE", pa_acode);
		
		return "/area/areaSeoul";
	}	
	
	
	
	
//	지역별 정책 세부 보기
	@RequestMapping(value = "/area/view", method = RequestMethod.GET)
	public String areaView(@RequestParam("pa_acode") String pa_acode, Model model) {
		
		AreaDTO areaDTO = areaService.viewAreaContent(pa_acode);
		
		
		String disName = areaService.sideWorkDisName(pa_acode);
		int disSideSlideSW = areaService.sideWorkDisSideSlideSW(pa_acode);
		
		
		model.addAttribute("AREADTO", areaDTO);
		model.addAttribute("sideColorBold", disName);
		model.addAttribute("disSideSlideSW", disSideSlideSW);

		return "/area/areaview";
	}

//	서울특별시의 정책
	@RequestMapping(value = "/area/seoul", method = RequestMethod.GET)
	public String areaToSeoul(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		int seoulListCnt = paginationService.getSeoulListCnt(); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getSeoulContent(paginationDTO.getStartIndex() + 1);

		
		
		String pa_acode = "ASE0000";
		
		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "seoul");
		model.addAttribute("PA_ACODE", pa_acode);

		return "/area/areaSeoul";
	}
	
	
//	인천광역시의 정책
	@RequestMapping(value = "/area/incheon", method = RequestMethod.GET)
	public String areaToIncheon(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "AIC";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "incheon");
		
		pa_acode = "AIC0000";
		
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaSeoul";
	}	
	
	
	
	
	
	//	부산광역시의 정책
	@RequestMapping(value = "/area/busan", method = RequestMethod.GET)
	public String areaToBusan(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		
		String pa_acode = "ABU";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "busan");
		
		pa_acode = "ABU0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaSeoul";
	}	
	
	
	
//	대전광역시의 정책
	@RequestMapping(value = "/area/daejeon", method = RequestMethod.GET)
	public String areaToDaejeon(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "ADJ";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "daejeon");
		
		pa_acode = "ADJ0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaSeoul";
	}	
	
	
	
//	광주광역시의 정책
	@RequestMapping(value = "/area/gwangju", method = RequestMethod.GET)
	public String areaToGwangju(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "AGJ";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "gwangju");
		pa_acode = "AGJ0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaSeoul";
	}	
	
	
	
	
//	울산광역시의 정책
	@RequestMapping(value = "/area/ulsan", method = RequestMethod.GET)
	public String areaToUlsan(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "AUS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "ulsan");
		pa_acode = "AUS0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaSeoul";
	}	
	
	
	
	
	
	
//	대구광역시의 정책
	@RequestMapping(value = "/area/daegu", method = RequestMethod.GET)
	public String areaToDaegu(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "ADG";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "daegu");
		pa_acode = "ADG0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaSeoul";
	}	
	
	
	
	


//	경기도의 정책
	@RequestMapping(value = "/area/gyeonggi", method = RequestMethod.GET)
	public String areaToGyeonggi(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGG";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gyeonggi");
		pa_acode = "AGG0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
	
//	강원도의 정책
	@RequestMapping(value = "/area/gangwon", method = RequestMethod.GET)
	public String areaToGangwon(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGW";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gangwon");
		pa_acode = "AGW0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
	
	
//	충청북도의 정책
	@RequestMapping(value = "/area/chungbuk", method = RequestMethod.GET)
	public String areaToChungbuk(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "ACN";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "chungbuk");
		pa_acode = "ACN0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
	
//	충청남도의 정책
	@RequestMapping(value = "/area/chungnam", method = RequestMethod.GET)
	public String areaToChungnam(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "ACS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "chungnam");
		pa_acode = "ACS0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
//	전라북도의 정책
	@RequestMapping(value = "/area/jeonbuk", method = RequestMethod.GET)
	public String areaToJeonbuk(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AJN";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "jeonbuk");
		pa_acode = "AJN0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
	
	
//	전라남도의 정책
	@RequestMapping(value = "/area/jeonnam", method = RequestMethod.GET)
	public String areaToJeonnam(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AJS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "jeonnam");
		pa_acode = "AJS0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
//	경상북도의 정책
	@RequestMapping(value = "/area/gyeongbuk", method = RequestMethod.GET)
	public String areaToGyeongbuk(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGN";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gyeongbuk");
		pa_acode = "AGN0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}
	
	
	
	
	
	
	
//	경상남도의 정책
	@RequestMapping(value = "/area/gyeongnam", method = RequestMethod.GET)
	public String areaToGyeongnam(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gyeongnam");
		pa_acode = "AGS0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";	
	}
	
	
	
	
	
//	제주도의 정책
	@RequestMapping(value = "/area/jeju", method = RequestMethod.GET)
	public String areaToJeju(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AJJ";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "jeju");
		pa_acode = "AJJ0000";
		model.addAttribute("PA_ACODE", pa_acode);
		return "/area/areaGyeonggi";
	}

}
