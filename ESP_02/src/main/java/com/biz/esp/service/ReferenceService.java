package com.biz.esp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.ReferenceDTO;
import com.biz.esp.persistence.ReferenceDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ReferenceService {

	@Autowired
	SqlSession sqlSession;
	
	ReferenceDao refDao;
	
	@Autowired
	public void getRefDao() {
		this.refDao = sqlSession.getMapper(ReferenceDao.class);
	}
	// DB를 리스트 통째로 가져오기
	public List<ReferenceDTO> selectAll(long now){
		Map map = new HashMap();
		map.put("now", now);
		List<ReferenceDTO> rList = refDao.selectAll(map);
		
		return rList;
	}
	// PK로 가져오기
	public ReferenceDTO getSeq(long d_seq) {

		ReferenceDTO rDTO = refDao.findById(d_seq);
		return rDTO;
	}
	public int insert(ReferenceDTO referenceDTO) {

		ReferenceDTO rDTO = referenceDTO;
		// 제목과 내용이 NOT NULL이라 기본 값을 넣는 코드
		if(rDTO.getD_title().isEmpty()) {
	         rDTO.setD_title("기본 제목 형식");
	      }
		if(rDTO.getD_content().isEmpty()) {
		   rDTO.setD_content("기본 내용 형식");
		}
	      
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		
		String dateD = sd.format(date);
		st.format(date);

		int intSeq = refDao.findMaxDseq() + 1;
		long d_seq = Long.valueOf(intSeq);
		log.debug("시퀀스 값은 : " + d_seq);
		rDTO.setD_seq(d_seq);
		rDTO.setD_date(dateD);
		rDTO.setD_writer("관리자");
		
		return refDao.insert(referenceDTO);
	}
	public int update(ReferenceDTO referenceDTO) {
		// TODO Auto-generated method stub
		return refDao.update(referenceDTO);
	}
	
	public int delete(long d_seq) {
		// TODO Auto-generated method stub
		return refDao.delete(d_seq);
	}
	public List<ReferenceDTO> selectAllSearch(String searchField, String search) {

		ReferenceDTO referenceDTO = ReferenceDTO.builder()
								.d_title(search)
								.d_content(search)
								.build();
		return refDao.findByAll(referenceDTO);
	}
	public List<ReferenceDTO> selectTitle(String search) {
		ReferenceDTO referenceDTO = ReferenceDTO.builder()
								.d_title(search)
								.build();
		return refDao.findByTitle(referenceDTO);
	}
	public List<ReferenceDTO> selectContent(String search) {
		ReferenceDTO referenceDTO = ReferenceDTO.builder()
								.d_content(search)
								.build();
		return refDao.findByContent(referenceDTO);
	}
	public List<ReferenceDTO> selectFiveList() {

		return refDao.selectFiveList();
	}
	public long totalCount() {
		return refDao.refTotalCount();
	}
}
