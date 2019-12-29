package com.biz.esp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.OpinionDTO;
import com.biz.esp.persistence.OpinionDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OpinionService {
	
	@Autowired
	SqlSession sqlSession;
	
	OpinionDao oDao;
	
	@Autowired
	public void getODao() {
		this.oDao = sqlSession.getMapper(OpinionDao.class);
	}
	
	public int insert(OpinionDTO opinionDTO) {
		return oDao.insert(opinionDTO);
	}
}
