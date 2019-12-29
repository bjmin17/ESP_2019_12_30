package com.biz.esp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.AreaDTO;
import com.biz.esp.persistence.AreaDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AreaService {
	
	@Autowired
	SqlSession sqlSession;
	
	AreaDao areaDao;
	
	
	@Autowired
	public void getAreaMapper() {
		areaDao = sqlSession.getMapper(AreaDao.class);
	}

	public List<AreaDTO> getSeoulContent(int startIndex) {
		// TODO Auto-generated method stub
	
		System.out.println("sql에서 startindex:"+startIndex);
		 
		 List<AreaDTO> areaList = areaDao.selectSeoulContent(startIndex);
		
		
		
		return areaList;
	}

	public List<AreaDTO> getAreaContent(int startIndex, String pa_acode) {
		// TODO Auto-generated method stub
		
		
		 List<AreaDTO> areaList = areaDao.selectAreaContent(startIndex, pa_acode);
		
		return areaList;
	}

	public AreaDTO viewAreaContent(String pa_acode) {
		// TODO Auto-generated method stub
		
		AreaDTO areaDTO = areaDao.selectAreaView(pa_acode);
		
		return areaDTO;
	}

	public List<AreaDTO> getAreaSearchContent(int startindex, String pa_acode, String searchVal) {
		// TODO Auto-generated method stub
		
		
		System.out.println("sql전 검색어:" + searchVal);
		System.out.println("sql전 코드:" + pa_acode);
		
		List<AreaDTO> areaList= areaDao.selectAreaSearchContent(startindex, pa_acode, searchVal);
		
		
		System.out.println("sql후 검색어:" + searchVal);
		System.out.println("sql후 코드:" + pa_acode);
		
		
		System.out.println(areaList.toString());
		
		return areaList;
	}

	public String sideWorkDisName(String pa_acode) {
		// TODO Auto-generated method stub
		
		String disName = null;
		
		if(pa_acode.contains("ASE")) {
					
					disName = "seoul";
					
					
				}else if(pa_acode.contains("AIC")) {
					
					disName = "incheon";
					
				}else if(pa_acode.contains("ABU")) {
					
					disName = "busan";
					
				}else if(pa_acode.contains("ADJ")) {
					
					disName = "daejeon";
					
				}else if(pa_acode.contains("AGJ")) {
					
					disName = "gwangju";
					
				}else if(pa_acode.contains("AUS")) {
					
					disName = "ulsan";
					
				}else if(pa_acode.contains("ADG")) {
					
					disName = "daegu";
					
				}else if(pa_acode.contains("AGG")) {
					
					disName = "gyeonggi";
					
				}else if(pa_acode.contains("AGW")) {
					
					disName = "gangwon";
				
				}else if(pa_acode.contains("ACN")) {
					
					disName = "chungbuk";
					
				}else if(pa_acode.contains("ACS")) {
					
					disName = "chungnam";
					
				}else if(pa_acode.contains("AJN")) {
					
					disName = "jeonbuk";
					
				}else if(pa_acode.contains("AJS")) {
					
					disName = "jeonnam";
					
				}else if(pa_acode.contains("AGN")) {
					
					disName = "gyeongbuk";
					
				}else if(pa_acode.contains("AGS")) {
					
					disName = "gyeongnam";
				
				}else if(pa_acode.contains("AJJ")) {
					
					disName = "jeju";
			
				}
				
				
				return disName;
			}

	public int sideWorkDisSideSlideSW(String pa_acode) {
		// TODO Auto-generated method stub
		
		int disSideSlideSW = 0;
		
		
		
if(pa_acode.contains("ASE")) {
			
			
			disSideSlideSW = 1;
			
		}else if(pa_acode.contains("AIC")) {
			
		
			disSideSlideSW = 1;
		}else if(pa_acode.contains("ABU")) {
			
		
			disSideSlideSW = 1;
		}else if(pa_acode.contains("ADJ")) {
			
		
			disSideSlideSW = 1;
		}else if(pa_acode.contains("AGJ")) {
			
		
			disSideSlideSW = 1;
		}else if(pa_acode.contains("AUS")) {
			
			
			disSideSlideSW = 1;
		}else if(pa_acode.contains("ADG")) {
			
	
			disSideSlideSW = 1;
		}else if(pa_acode.contains("AGG")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AGW")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("ACN")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("ACS")) {
			
	
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AJN")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AJS")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AGN")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AGS")) {
			
		
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AJJ")) {
			
		
			disSideSlideSW = 2;
		}
		
		
		
		return disSideSlideSW;
	}

	public List<AreaDTO> getAreaWriteContent(String pa_acode) {		//해당코드 지역게시전체
		// TODO Auto-generated method stub
		
		List<AreaDTO> areaList = new ArrayList<AreaDTO>();
		
		areaList = areaDao.selectAllByCode(pa_acode);
		
		
		
		return areaList;
	}

	public String getAreaMaxCode(String pa_acode) {
		// TODO Auto-generated method stub
		
		pa_acode = areaDao.selectMaxCode(pa_acode);
		return pa_acode;
	}

	

	public int insertAreaPolicy(AreaDTO areaDTO) {
		// TODO Auto-generated method stub
		
		int ret = areaDao.insert(areaDTO);
		return ret;
	}

}
