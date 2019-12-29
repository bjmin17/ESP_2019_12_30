package com.biz.esp.persistence;

import com.biz.esp.domain.UserDTO;

public interface UserDao {
	
	
	public int userInsert(UserDTO userDTO);

	public UserDTO findById(String u_id);
	
	
}
