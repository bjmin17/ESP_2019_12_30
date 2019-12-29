package com.biz.esp.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.esp.domain.AreaDTO;

public interface AreaDao {

	int selectSeoulListCnt();

	List<AreaDTO> selectSeoulContent(int startIndex);

	int selectAreaListCnt(String pa_acode);

	List<AreaDTO> selectAreaContent(@Param("startIndex") int startIndex, @Param("pa_acode")String pa_acode);

	AreaDTO selectAreaView(String pa_acode);

	int selectAreaSearchListCnt(@Param("pa_acode") String pa_acode, @Param("searchVal") String searchVal);

	List<AreaDTO> selectAreaSearchContent(@Param("startIndex") int startIndex,
			@Param("pa_acode")String pa_acode, @Param("searchVal") String searchVal);

	List<AreaDTO> selectAllByCode(String pa_acode);

	String selectMaxCode(String pa_acode);

	

	int insert(AreaDTO areaDTO);

	

}
