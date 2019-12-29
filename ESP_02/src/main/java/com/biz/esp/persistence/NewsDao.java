package com.biz.esp.persistence;

import java.util.List;
import java.util.Map;

import com.biz.esp.domain.NewsDTO;

public interface NewsDao {
	public List<NewsDTO> selectFiveList();
	public List<NewsDTO> selectAll(Map map);
	
	public int findMaxNseq();
	public NewsDTO findById(long n_seq);
	public List<NewsDTO> findByAll(NewsDTO newsDTO);
	public List<NewsDTO> findByTitle(NewsDTO newsDTO);
	public List<NewsDTO> findByContent(NewsDTO newsDTO);
	
	public int update(NewsDTO newsDTO);
	public int insert(NewsDTO newsDTO);
	public int delete(long n_seq);
	public long newsTotalCount();
}
