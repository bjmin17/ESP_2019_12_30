package com.biz.esp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.PaginationDTO;
import com.biz.esp.persistence.AreaDao;
import com.biz.esp.persistence.PaginationDao;

@Service
public class PaginationService {
	
	@Autowired
	SqlSession sqlSession;
	
	PaginationDao paginationDao;
	AreaDao areaDao;
	
	@Autowired
	public void getAreaMapper() {
		areaDao = sqlSession.getMapper(AreaDao.class);
	}
	
	

	public int getSeoulListCnt() {
		// TODO Auto-generated method stub
		int seoulListCnt = areaDao.selectSeoulListCnt();
		return seoulListCnt;
	}



	public PaginationDTO startWork(int listCnt, int curPage) {
		// TODO Auto-generated method stub
		
		PaginationDTO paginationDTO = new PaginationDTO();
		
		paginationDTO.setCurPage(curPage);	// 총 게시물 수와 현재 페이지를 Controller로부터 받다옴
		paginationDTO.setListCnt(listCnt);
		
		paginationDTO = this.setPageCnt(paginationDTO);	// 총 페이지 수
		paginationDTO =this.setRangeCnt(paginationDTO);	// 총 블럭 수
		
		paginationDTO = this.rangeSetting(paginationDTO);			// curPage를 기준으로 현재 블럭을 구해주는 메소드
		paginationDTO = this.setStartIndex(paginationDTO);	// DB질의 위한 startIndex설정
		return paginationDTO;
	}



	private PaginationDTO setStartIndex(PaginationDTO paginationDTO) {
		// TODO Auto-generated method stub
		
		paginationDTO.setStartIndex((paginationDTO.getCurPage()-1)*paginationDTO.getPageSize());
		return paginationDTO;
	}



	private PaginationDTO setRangeCnt(PaginationDTO paginationDTO) {
		// TODO Auto-generated method stub
		
		paginationDTO.setRangeCnt((int)Math.ceil(paginationDTO.getPageCnt()*1.0/paginationDTO.getRangeSize()));
		return paginationDTO;
	}



	private PaginationDTO setPageCnt(PaginationDTO paginationDTO) {
		// TODO Auto-generated method stub
		
		paginationDTO.setPageCnt((int)Math.ceil(paginationDTO.getListCnt()*1.0/paginationDTO.getPageSize()));
		return paginationDTO;
	}



	private PaginationDTO rangeSetting(PaginationDTO paginationDTO) {
		// TODO Auto-generated method stub
		
		paginationDTO = this.setCurRange(paginationDTO);
		paginationDTO.setStartPage((paginationDTO.getCurRange()-1) * paginationDTO.getRangeSize() + 1);
		paginationDTO.setEndPage(paginationDTO.getStartPage() + paginationDTO.getRangeSize() - 1);
		
		
		if(paginationDTO.getEndPage() > paginationDTO.getPageCnt()) {
			paginationDTO.setEndPage(paginationDTO.getPageCnt());
		}
		
		
		paginationDTO.setPrevPage(paginationDTO.getCurPage()-1);
		paginationDTO.setNextPage(paginationDTO.getCurPage()+1);
		
		
		return paginationDTO;
	}



	private PaginationDTO setCurRange(PaginationDTO paginationDTO) {
		// TODO Auto-generated method stub
		
		paginationDTO.setCurRange((int)((paginationDTO.getCurPage()-1)/paginationDTO.getRangeSize()) + 1);
		return paginationDTO;
	}



	public int getAreaListCnt(String pa_acode) {
		int areaListCnt = areaDao.selectAreaListCnt(pa_acode);
		return areaListCnt;
	}



	public int getAreaSearchListCnt(String pa_acode, String searchVal) {
		int listCnt = areaDao.selectAreaSearchListCnt(pa_acode, searchVal);
		// TODO Auto-generated method stub
		return listCnt;
	}



	

}
