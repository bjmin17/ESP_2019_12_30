package com.biz.esp.persistence;

import java.util.List;
import java.util.Map;

import com.biz.esp.domain.ReferenceDTO;

public interface ReferenceDao {

	public List<ReferenceDTO> selectFiveList();
	public List<ReferenceDTO> selectAll(Map map);

	public int findMaxDseq();
	public ReferenceDTO findById(long d_seq);
	
	public List<ReferenceDTO> findByCategory(String m_cat);
	public List<ReferenceDTO> findByAll(ReferenceDTO referenceDTO);
	public List<ReferenceDTO> findByTitle(ReferenceDTO referenceDTO);
	public List<ReferenceDTO> findByContent(ReferenceDTO referenceDTO);
	
	public int update(ReferenceDTO referenceDTO);
	public int insert(ReferenceDTO referenceDTO);
	public int delete(long d_seq);
	public long refTotalCount();
}
