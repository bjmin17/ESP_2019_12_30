package com.biz.esp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.NewsDTO;
import com.biz.esp.persistence.NewsDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewsService {

	@Autowired
	SqlSession sqlSession;
	
	NewsDao newsDao;
	
	@Autowired
	public void getNewsDao() {
		this.newsDao = sqlSession.getMapper(NewsDao.class);
	}
	
	public List<NewsDTO> selectAll(long now){
		Map map = new HashMap();
		map.put("now", now);
		
		List<NewsDTO> nList = newsDao.selectAll(map);
		
		return nList;
	}
	
	// 기본값으로 데이터를 가져오기
	public NewsDTO getSeq(long n_seq) {

		NewsDTO nDTO = newsDao.findById(n_seq);
		return nDTO;
	}
	
	// 시퀀스 최대 값 가져오기
	public int maxNSeq() {
		return newsDao.findMaxNseq();
	}
	
	// 등록
	public int insert(NewsDTO newsDTO) {
		NewsDTO nDTO = newsDTO;
		
		// 제목이 NOT NULL이라서 넣은 기본 값
		if(nDTO.getN_title().isEmpty()) {
	         nDTO.setN_title("기본 제목 형식");
	      }
		if(nDTO.getN_content().isEmpty()) {
		   nDTO.setN_content("기본 내용 형식");
		}

		// 날짜 자동 등록 위해 생성
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		
		String dateD = sd.format(date);
		st.format(date);

		int intSeq = newsDao.findMaxNseq() + 1;
		long n_seq = Long.valueOf(intSeq);
		log.debug("시퀀스 값은 : " + n_seq);
		nDTO.setN_seq(n_seq);
		nDTO.setN_date(dateD);
		nDTO.setN_writer("관리자");
		return newsDao.insert(nDTO);
		
	}
	
	// 수정
	public int update(NewsDTO newsDTO) {
		// TODO Auto-generated method stub
		return newsDao.update(newsDTO);
	}
	
	// 삭제
	public int delete(long n_seq) {
		// TODO Auto-generated method stub
		return newsDao.delete(n_seq);
	}
	
	// 제목 + 내용(전체)으로 검색
	public List<NewsDTO> selectAllSearch(String searchField, String search) {

		NewsDTO newsDTO = NewsDTO.builder()
								.n_title(search)
								.n_content(search)
								.build();
		return newsDao.findByAll(newsDTO);
	}
	
	// 제목으로만 검색
	public List<NewsDTO> selectTitle(String search) {
		NewsDTO newsDTO = NewsDTO.builder()
								.n_title(search)
								.build();
		return newsDao.findByTitle(newsDTO);
	}
	
	// 내용으로 검색
	public List<NewsDTO> selectContent(String search) {
		NewsDTO newsDTO = NewsDTO.builder()
								.n_content(search)
								.build();
		return newsDao.findByContent(newsDTO);
	}

	// 메인페이지 탭 메뉴에서 5개씩 보이기 위해서
	public List<NewsDTO> selectFiveList() {
		
		return newsDao.selectFiveList();
	}

	public long totalCount() {
		return newsDao.newsTotalCount();
	}

	
}
