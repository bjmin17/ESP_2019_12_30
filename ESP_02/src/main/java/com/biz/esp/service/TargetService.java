package com.biz.esp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.TargetVO;
import com.biz.esp.persistence.TargetDao;

@Service
public class TargetService {
	
	@Autowired
	SqlSession sqlSession;
	
	TargetDao targetDao;
	
	
	@Autowired
	public void getTargetMapper() {
		targetDao = sqlSession.getMapper(TargetDao.class);
	}
	

	public List<TargetVO> getYoungAll() {
		// TODO Auto-generated method stub
		
		List<TargetVO> targetList = targetDao.selectYoungAll();
		
		return targetList;
	}


	public TargetVO getContentByTCode(String pt_tcode) {
		// TODO Auto-generated method stub
		
		TargetVO targetVO = targetDao.selectContentByTCode(pt_tcode);
		return targetVO;
	}


	public List<TargetVO> getWomenAll() {

		List<TargetVO> targetList = targetDao.selectWomenAll();
		
		return targetList;
		
		
	}


	public List<TargetVO> getMiddleAll() {
		// TODO Auto-generated method stub
List<TargetVO> targetList = targetDao.selectMiddleAll();
		
		return targetList;
	}


	public List<TargetVO> getDisableAll() {
List<TargetVO> targetList = targetDao.selectDisableAll();
		
		return targetList;
	}


	public List<TargetVO> getForeignAll() {
		// TODO Auto-generated method stub
List<TargetVO> targetList = targetDao.selectForeignAll();
		
		return targetList;
	}


	
	
	

}
