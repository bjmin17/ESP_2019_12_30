package com.biz.esp.persistence;

import java.util.List;

import com.biz.esp.domain.TargetVO;

public interface TargetDao {
	
	
	

	public List<TargetVO> selectYoungAll();

	public TargetVO selectContentByTCode(String pt_tcode);

	public List<TargetVO> selectWomenAll();

	public List<TargetVO> selectMiddleAll();

	public List<TargetVO> selectDisableAll();

	public List<TargetVO> selectForeignAll();

	

}
